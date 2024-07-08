package ch18.sec02.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample {
    public static void main(String[] args){
        try (OutputStream os = new FileOutputStream("C:/Temp/test2.db")){
            byte[] array = { 10, 20, 30 };
//            배열을 통째로 해당 경로의 파일에 넣어줌
            os.write(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

