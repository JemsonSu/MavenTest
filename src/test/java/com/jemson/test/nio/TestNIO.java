package com.jemson.test.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

import org.junit.Test;

/**
 * 测试nio nio - new io 缓冲区 Buffer
 * 
 * @author xian
 *
 */
public class TestNIO {

	public static void main(String[] args) {
//		ByteBuffer
//		CharBuffer
//		ShortBuffer
//		IntBuffer
//		LongBuffer
//		FloatBuffer
//		DoubleBuffer

	}

	@Test
	public void test1() {
		// 分配一个缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		System.out.println(buffer.mark()); // java.nio.HeapByteBuffer[pos=6 lim=1024 cap=1024]
		System.out.println(buffer.position());
		System.out.println(buffer.limit());
		System.out.println(buffer.capacity());
		System.out.println("-------------");
		buffer.put("jemson".getBytes());
		System.out.println(buffer.mark());  //标记位置   reset恢复到标记位置

		System.out.println("---------------------");
		// filp()读模式
		buffer.flip();
		System.out.println(buffer.mark());

		byte[] buf = new byte[buffer.limit()];
		buffer.get(buf);
		System.out.println(new String(buf));
		System.out.println(buffer.mark());

		System.out.println("-----------");
		buffer.rewind(); // 回带 恢复 可再读一次
		System.out.println(buffer.mark());

		buffer.clear(); // 清空缓冲区 但里面还是有数据的
		System.out.println(buffer.mark());

	}

	
	@Test
	public void test2() {
		// 分配一个缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		buffer.put("jemson".getBytes());
		System.out.println(buffer.position());
		buffer.flip();
		System.out.println(buffer.position());
		byte[] buf = new byte[2];
		char char1 = buffer.getChar();
		System.out.println(char1);
	}

	//直接缓冲区-物理内存  更快
	//非直接缓冲区-jvm里面的内存
}
