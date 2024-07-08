package ch18.sec02.exam02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteExample2 {
    public static void main(String[] args){
        try (OutputStream os = new FileOutputStream("C:/Temp/test2.db")){
            byte[] array = { 10, 20, 30, 40 ,50 };

//            배열의 일부분만 잘라서 해당 경로의 파일에 저장함
            os.write(array, 1, 3); // 20, 30, 40
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

