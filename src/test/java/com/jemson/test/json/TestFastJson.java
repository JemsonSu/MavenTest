package com.jemson.test.json;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
/**
 * 测试alibaba fastjson
 * @author xian
 *
 */
public class TestFastJson {

	public static void main(String[] args) throws Exception, IOException {
		String str = IOUtils.toString(new FileInputStream("./conf/province_city.json"), "utf-8"); //把json读成一个string
		System.out.println(str);
		
		JSONObject jsonObject = JSON.parseObject(str);
		String s1 = jsonObject.getString("广东省"); //获取广东省
		System.out.println(s1);
		JSONArray jsonArray = JSON.parseArray(s1);
		int size = jsonArray.size();
		for(int i=1; i<=100; i++) {
			String city = jsonArray.getString((int) (Math.random() * size)); //随机 获取其中一个城市
			System.out.println(city); 
		}
		
	}

}
