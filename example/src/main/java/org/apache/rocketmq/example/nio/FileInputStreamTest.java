package org.apache.rocketmq.example.nio;

import io.netty.buffer.ByteBuf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;

/**
 * @Auther: penghaozhong
 * @Date: 2019-06-17 11:27
 */
public class FileInputStreamTest {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/jackypeng/Documents/mryt/09.git/life/study/rocketmq/NOTICE");
            FileInputStream fileInputStream = new FileInputStream(file);

            byte[] b=new byte[(int) file.length()];
            while (fileInputStream.read(b) != -1) {
                System.out.println("--------");
                System.out.println(new String(b));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
