package ch18.sec03.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
    public static void main(String[] args) throws Exception{
        String originFileName = "C:/temp/test.jpg";
        String targetFileName = "C:/temp/test2.jpg";

        try (
                InputStream is = new FileInputStream(originFileName);
                OutputStream os = new FileOutputStream(targetFileName);)
        {
            byte[] data = new byte[1024]; // 배열 버퍼 생성
            while (true) {
                int num = is.read(data); // 최대 배열의 크기인 1024바이트 읽기
                if (num == -1) break;    // 파일을 다 읽으면 while문 종료
//                num만큼 데이터 파일 쓰기
                os.write(data, 0, num);//
            }

            os.flush(); // 내부 버퍼에 있는 바이트 출력하고 비우기
            System.out.println("복사가 잘 되었습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
