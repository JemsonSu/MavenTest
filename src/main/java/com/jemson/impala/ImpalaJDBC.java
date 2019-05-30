package com.jemson.impala;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class ImpalaJDBC {
	
	public static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	public static void main(String[] args) throws Exception {
		
		String driver = "com.cloudera.impala.jdbc41.Driver";
		String url = "jdbc:impala://156.234.98.50:21050"; // 查看连接机器端口netstat -tnlpu | grep 21050
		Class.forName(driver);

		String [] genders = {"male","female"};
		
		
		String cityJson = IOUtils.toString(new FileInputStream("./conf/province_city.json"), "utf-8");
		String nameJson = IOUtils.toString(new FileInputStream("./conf/name.json"), "utf-8");
		

		Connection con = DriverManager.getConnection(url);
		
		int id = getId(con)+1; //最大id加1就不重复
		
		con.setAutoCommit(false); // 关闭自动提交
		String sql = "INSERT INTO db1.person (id,name,age,gender,province,city) VALUES(?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		//开始计数
		long start = System.currentTimeMillis();
		
		//给定插入数据量  每次插入数据量
		int count = id+100000*10000;
		for(int i=id; i<=count; i++) { //后面程序修改i=count插入后的数+1就不会冲突了
			ps.setInt(1, i);
			ps.setString(2, getName(nameJson));
			ps.setInt(3, (int) (Math.random() * 120));
			ps.setString(4, genders[(int) (Math.random() * 2)]); // male / female
			String province = getProvince();
			ps.setString(5, province);
			ps.setString(6, getCity(province, cityJson));
			//添加到批处理中
			ps.addBatch();
			
			//每2000条执行一次批处理操作
			if(i%2000==0) {
				ps.executeBatch();
				con.commit();
				System.out.println(dtf.format(LocalDateTime.now()) + "  目前入db1.person数据量为:"+i); 
			}
			
		}
		
		
		//不够2000条批处理的一并提交
		ps.executeBatch();
		con.commit();
		con.setAutoCommit(true); 
		System.out.println(dtf.format(LocalDateTime.now()) + " 目前入db1.person数据量为:"+count); 
		
		
		//结束计数
		long end = System.currentTimeMillis();
		//计算耗时
		System.out.println(dtf.format(LocalDateTime.now()) + " 总耗时"+ ( (end-start)/1000 ) +"秒！即"+ ( (end-start)/1000/60 ) +"分钟");
		


		//关闭资源
		ps.close();
		con.close();

		System.out.println("执行完毕！");
	}
	
	/**
	 * 随机获取一个name
	 * @return
	 * @throws Exception
	 */
	public static String getName(String nameJson) throws Exception {
		JSONObject jsonObject = JSON.parseObject(nameJson);
		String names = jsonObject.getString("names"); 
		JSONArray namesJsonArray = JSON.parseArray(names);
		int namesJsonArraySize = namesJsonArray.size();
		String name = namesJsonArray.getString((int) (Math.random() * namesJsonArraySize)); //随机 获取其中一个名字
		return name;
	}
	
	/**
	 * 随机获取一个省份
	 * @return
	 */
	public static String getProvince() {
		String[] provinces = { "北京市", "天津市", "上海市", "重庆市", "河北省", "山西省", "辽宁省", "吉林省", "黑龙江省", "江苏省", "浙江省", "安徽省",
				"福建省", "江西省", "山东省", "河南省", "湖北省", "湖南省", "广东省", "海南省", "四川省", "贵州省", "云南省", "陕西省", "甘肃省", "青海省", "台湾省",
				"内蒙古自治区", "广西壮族自治区", "西藏自治区", "宁夏回族自治区", "新疆维吾尔自治区", "香港特别行政区", "澳门特别行政区" }; // 34个元素
		String province = provinces[(int) (Math.random() * 34)];
		//System.out.println("--"+province+"--"); //随机获取一个省份
		return province;
	}
	
	/**
	 * 根据任意省份获取它任意一个城市
	 * @param province
	 * @return
	 */
	public static String getCity(String province, String cityJson) {
		JSONObject cityJsonObject = JSON.parseObject(cityJson);
		String cityJsonArray = cityJsonObject.getString(province);
		JSONArray jsonArray = JSON.parseArray(cityJsonArray);
		int size = jsonArray.size();
		String city = jsonArray.getString((int) (Math.random() * size)); //随机 获取其中一个城市
		//System.out.println(city); 
		return city;
	}
	
	/**
	 * 获取db1.person目前最大id
	 * @return
	 * @throws Exception 
	 */
	public static int getId(Connection con) throws Exception {
		int id = 1;
		PreparedStatement ps = con.prepareStatement("select max(id) from db1.person");
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			int i = rs.getInt(1);
			System.out.println(dtf.format(LocalDateTime.now()) + " 获取db1.person目前最大id为:"+i);
			if(i>1) {
				id=i;
			}
		}
		ps.close();
		//System.out.println("id="+id);
		return id;
	}
	
	
	@Test
	public void test() throws Exception {
		String nameJson = IOUtils.toString(new FileInputStream("./conf/name.json"), "utf-8");
		
		for(int i=1; i<=100; i++) {
			System.out.println(getName(nameJson));
		}
	}

}
