package com.jemson.hadoop;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

/**
 * 高可用连接
 * @author Jemson
 *
 */
public class TestHAHadoop {

	public static void main(String[] args) throws Exception {
	    Configuration conf = new Configuration();
	    conf.set("fs.defaultFS","hdfs://nameservice1"); //放了配置文件就不用在这里配置了
	    conf.set("dfs.nameservices","nameservice1");
	    conf.set("dfs.ha.namenodes.nameservice1","namenode273,namenode492");
	    conf.set("dfs.namenode.rpc-address.nameservice1.namenode273","cdh02.hadoop.com:8020");
	    conf.set("dfs.namenode.rpc-address.nameservice1.namenode492","cdh03.hadoop.com:8020");
	    conf.set("dfs.client.failover.proxy.provider.nameservice1","org.apache.hadoop.hdfs.server.namenode.ha.ConfiguredFailoverProxyProvider");

	    FileSystem fs = FileSystem.newInstance(new URI(""),conf,"sjw"); //最后一个参数是用户名

	    //下载例子
	    fs.copyFromLocalFile(new Path("/user/sjw/event_define/event_define.csv"),new Path("/home"));

	    System.out.println("完毕!!!");

	}

}
