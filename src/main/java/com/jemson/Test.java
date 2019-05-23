package com.jemson;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/**
 * 项目主要测试类，测试完毕即删除测试内容
 * @author xian
 *
 */
public class Test {

	public static void main(String[] args) throws Exception {
		
		
		boolean b = "{\"_track_id\":2114341071,\"lib\":{\"$lib\":\"Android\",\"$lib_method\":\"code\",\"$lib_version\":\"3.0.5\",\"$lib_detail\":\"com.bigdata.analytics.android.sdk.BigDataAPI$20##run##BigDataAPI.java##2832\",\"$app_version\":\"1.0\"},\"distinct_id\":\"91d01bfd2966b481\",\"_flush_time\":1557972472716,\"time\":1557972457835,\"type\":\"profile_set\",\"properties\":{\"$carrier\":\"本机或本网络\",\"$country\":\"菲律宾\",\"$city\":\"菲律宾\",\"sex\":\"Male\",\"$province\":\"\",\"$ip\":\"180.190.118.6\",\"email\":\"sjw@163.com\",\"age\":18}}".contains("\"type\":\"profile_set\"");
		System.out.println(b);
	}

}
