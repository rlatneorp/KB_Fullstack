package ch18.sec03.exam02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("C:/Temp/test2.db")){

            byte[] data = new byte[100];

            while (true) {
//                최대 배열의 개수만큼 읽음(100Byte)
                int num = is.read(data);
                if (num == -1) break; // 파일 끝 도달

                for (int i = 0; i < num; i++) {
                    System.out.println(data[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
