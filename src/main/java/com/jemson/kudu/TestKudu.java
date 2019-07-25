package com.jemson.kudu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.kudu.ColumnSchema;
import org.apache.kudu.Schema;
import org.apache.kudu.Type;
import org.apache.kudu.client.CreateTableOptions;
import org.apache.kudu.client.Delete;
import org.apache.kudu.client.DeleteTableResponse;
import org.apache.kudu.client.Insert;
import org.apache.kudu.client.KuduClient;
import org.apache.kudu.client.KuduException;
import org.apache.kudu.client.KuduScanner;
import org.apache.kudu.client.KuduScanner.KuduScannerBuilder;
import org.apache.kudu.client.KuduSession;
import org.apache.kudu.client.KuduTable;
import org.apache.kudu.client.ListTablesResponse;
import org.apache.kudu.client.PartialRow;
import org.apache.kudu.client.RowResult;
import org.apache.kudu.client.RowResultIterator;
import org.apache.kudu.client.SessionConfiguration.FlushMode;
import org.apache.kudu.client.Update;
import org.apache.kudu.client.Upsert;

public class TestKudu {

	public static void main(String[] args) throws Exception {
		TestKudu testKudu = new TestKudu();
		
		
		//具体操作
		testKudu.findData();
		

		System.out.println("执行完毕！");
	}
	
	//查找数据
	public void findData() throws KuduException {
		KuduClient kuduClient = new KuduClient.KuduClientBuilder("r71").defaultAdminOperationTimeoutMs(5 * 1000).build();
		KuduTable table = kuduClient.openTable("k_person");
		
		KuduScannerBuilder scannerBuilder = kuduClient.newScannerBuilder(table);
		
		KuduScanner scanner = scannerBuilder.build();
		
		while(scanner.hasMoreRows()) {
			RowResultIterator iterator = scanner.nextRows();
			System.out.println("本次迭代的行数为:" + iterator.getNumRows());
			while(iterator.hasNext()) {
				RowResult rowResult = iterator.next();
				System.out.print("id="+ rowResult.getInt("id") + " ");
				System.out.print("name="+ rowResult.getString("name") + " ");
				
				System.out.println();
				
				/** 列名  列类型
				Schema schema = rowResult.getSchema();
				int columnCount = schema.getColumnCount(); //有多少列
				for(int i=0; i<columnCount; i++) {
					ColumnSchema columnSchema = schema.getColumnByIndex(i);
					String name = columnSchema.getName();
					String type = columnSchema.getType().getName();
					System.out.println(name + "--" + type); // id--int32 name--string
				}
				*/
			}
			
			
		}
		
		
		kuduClient.close();
		
	}
	
	
	//更新插入数据
	public void upsertData() throws KuduException {
		KuduClient kuduClient = new KuduClient.KuduClientBuilder("r71").defaultAdminOperationTimeoutMs(5 * 1000).build();
		KuduTable table = kuduClient.openTable("k_person");
		Upsert upsert = table.newUpsert();
		PartialRow row = upsert.getRow();
		row.addInt("id", 11);
		row.addString("name", "景甜我爱你1314");
		
		KuduSession session = kuduClient.newSession();
		session.apply(upsert);
		
		kuduClient.close();
		
	}
	
	
	//更新数据
	public void updateData() throws KuduException {
		KuduClient kuduClient = new KuduClient.KuduClientBuilder("r71").defaultAdminOperationTimeoutMs(5 * 1000).build();
		KuduTable table = kuduClient.openTable("k_person");
		Update newUpdate = table.newUpdate();
		PartialRow row = newUpdate.getRow();
		row.addInt("id", 2);
		row.addString("name", "景甜我爱你");
		
		KuduSession session = kuduClient.newSession();
		session.apply(newUpdate);
		
		kuduClient.close();
		
	}
	
	
	//删除数据
	public void delData() throws KuduException {
		KuduClient kuduClient = new KuduClient.KuduClientBuilder("r71").defaultAdminOperationTimeoutMs(5 * 1000).build();
		KuduTable table = kuduClient.openTable("k_person");
		Delete delete = table.newDelete();
		PartialRow row = delete.getRow();
		row.addInt("id", 1);
		
		KuduSession session = kuduClient.newSession();
		session.apply(delete);
		
		kuduClient.close();
		
	}
	
	//插入数据
	public void insertData() throws KuduException {
		KuduClient kuduClient = new KuduClient.KuduClientBuilder("r71").defaultAdminOperationTimeoutMs(5 * 1000).build();
		KuduTable table = kuduClient.openTable("k_person");
		/* 单行
		Insert insert = table.newInsert();
		PartialRow row = insert.getRow();
		row.addInt("id", 1);
		row.addString("name", "jemson");
		//System.out.println(row);
		
		KuduSession session = kuduClient.newSession();
		session.apply(insert);
		*/
		
		KuduSession session = kuduClient.newSession();
		 // 采取Flush方式 手动刷新
        session.setFlushMode(FlushMode.MANUAL_FLUSH);
        session.setMutationBufferSpace(3000);
        for (int i = 1; i <= 10; i++) {
            Insert insert = table.newInsert();
            // 设置字段内容
            PartialRow row = insert.getRow();
            row.addInt("id", i);
            row.addString("name", "touch 景甜 "+i);
           
            session.flush();
            session.apply(insert);
        }
		
		
		
		kuduClient.close();
	}

	
	
	
	
	//删除表
	public void delTable() throws KuduException {
		KuduClient kuduClient = new KuduClient.KuduClientBuilder("r71").defaultAdminOperationTimeoutMs(5 * 1000).build();
		DeleteTableResponse response = kuduClient.deleteTable("k_person");
		
		kuduClient.close();
	}
	
	
	//查询有哪些表
	public void listTable() throws KuduException {
		KuduClient kuduClient = new KuduClient.KuduClientBuilder("r71").defaultAdminOperationTimeoutMs(5 * 1000).build();
		ListTablesResponse tablesResponse = kuduClient.getTablesList();
		List<String> tables = tablesResponse.getTablesList();
		System.out.println("kudu所有表为:");
		for(String table : tables) {
			System.out.println(table);
		}
		kuduClient.close();
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
		String tablename = "k_person";
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

		System.out.println("创建kudu表k_person完毕！");
	}

}
