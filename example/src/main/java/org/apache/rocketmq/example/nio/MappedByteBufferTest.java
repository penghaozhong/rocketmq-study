package org.apache.rocketmq.example.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Auther: penghaozhong
 * @Date: 2019-06-17 11:27
 */
public class MappedByteBufferTest {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/jackypeng/Documents/mryt/09.git/life/study/rocketmq/LICENSE");
            MappedByteBuffer mappedByteBuffer = new RandomAccessFile(file,"rw").getChannel().map(FileChannel.MapMode.READ_WRITE,0,file.length());

            byte[] ds = new byte[(int) file.length()];
            for (int i = 0; i < file.length(); i++) {
                byte b = mappedByteBuffer.get(i);
                ds[i]=b;
            }

            System.out.println(new String(ds));

            for (int i = 0; i < 100; i++) {

                mappedByteBuffer.put(("我中国" + i).getBytes());
            }

            mappedByteBuffer.force();
            System.out.println("刷入数据了");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
