package com.jemson.kudu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.kudu.ColumnSchema;
import org.apache.kudu.Schema;
import org.apache.kudu.Type;
import org.apache.kudu.client.CreateTableOptions;
import org.apache.kudu.client.KuduClient;
import org.apache.kudu.client.KuduException;

public class TestKudu {

	public static void main(String[] args) throws Exception {
		TestKudu testKudu = new TestKudu();
		testKudu.createTable();
		

		System.out.println("执行完毕！");
	}

	//创建表
	public void createTable() throws KuduException {
		// 创建客户端
		// KuduClient kuduClient = new KuduClient.KuduClientBuilder("r71").defaultAdminOperationTimeoutMs(5*1000).build();
		KuduClient kuduClient = new KuduClient.KuduClientBuilder("r71:7051").defaultAdminOperationTimeoutMs(5 * 1000).build();
		// 打印连接信息
		System.out.println(kuduClient);

		// 创建kudu表要准备的信息
		// 1 . 表名
		String tablename = "k_person2";
		// 2.schema 里面包含字段信息
		List<ColumnSchema> columns = new ArrayList<ColumnSchema>();
		columns.add(new ColumnSchema.ColumnSchemaBuilder("id", Type.INT32).key(true).build()); // 主键(一部分)
		columns.add(new ColumnSchema.ColumnSchemaBuilder("name", Type.STRING).build());
		Schema schema = new Schema(columns);
		// 3.相关选项 副本，分区，分桶等信息
		CreateTableOptions options = new CreateTableOptions();
		options.setNumReplicas(1); // 设置副本数
		options.addHashPartitions(Arrays.asList("id"), 2); // 分区必须要设置

		// 通过客户端创建表
		kuduClient.createTable(tablename, schema, options);

		// 关闭客户端
		kuduClient.close();

		System.out.println("创建kudu表k_person2完毕！");
	}

}
