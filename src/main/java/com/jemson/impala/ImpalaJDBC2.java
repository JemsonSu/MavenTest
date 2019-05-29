package com.jemson.impala;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ImpalaJDBC2 {

	public static void main(String[] args) throws Exception {
		String driver = "com.cloudera.impala.jdbc41.Driver";
		String url = "jdbc:impala://156.234.98.50:21050"; // 查看连接机器端口netstat -tnlpu | grep 21050
		Class.forName(driver);

		int age = (int) (Math.random() * 120); // 随机年龄 120以内
		String[] provinces = { "北京市", "天津市", "上海市", "重庆市", "河北省", "山西省", "辽宁省", "吉林省", "黑龙江省", "江苏省", "浙江省", "安徽省",
				"福建省", "江西省", "山东省", "河南省", "湖北省", "湖南省", "广东省", "海南省", "四川省", "贵州省", "云南省", "陕西省", "甘肃省", "青海省", "台湾省",
				"内蒙古自治区", "广西壮族自治区", "西藏自治区", "宁夏回族自治区", "新疆维吾尔自治区", "香港特别行政区", "澳门特别行政区" }; // 34个元素
		System.out.println(provinces[(int) (Math.random() * 34)]); //随机获取一个省份

		Connection con = DriverManager.getConnection(url);
		con.setAutoCommit(false); // 关闭自动提交
		String sql = "INSERT INTO db1.person (id,name,age,gender,province,city) VALUES(?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, 11);
		ps.setString(2, "tom");
		ps.setInt(3, 18);
		ps.setString(4, "male"); // male / female
		ps.setString(5, "广西");
		ps.setString(6, "桂林");

		ps.addBatch();

		ps.setInt(1, 12);
		ps.setString(2, "tom2");
		ps.setInt(3, 19);
		ps.setString(4, "female"); // male / female
		ps.setString(5, "广西");
		ps.setString(6, "南宁");

		ps.addBatch();

		ps.executeBatch();

		System.out.println("执行完毕！");

		con.close();

	}

}
