package ch18.sec06;

import java.io.*;

public class CharacterConverStreamExample {
    public static void main(String[] args) throws Exception {
        write("문자 변환 스트림을 사용합니다.");
        String data = read();
        System.out.println(data);
    }

    public static void write(String str) throws Exception {
//        해당 경로를 가진 출력 스트림을 만들어줌
        OutputStream os = new FileOutputStream("C:/Temp/test.txt");
//        바이트 스트림을 문자열 스트림으로 사용하기 위해 보조스트림으로 연결해줌
        Writer writer = new OutputStreamWriter(os, "UTF-8");
        writer.write(str);
        writer.flush();
        writer.close();
    }

    public static String read() throws Exception {
//        해당 결로를 가진 바이트 입력 스트림을 만들어줌
        InputStream is = new FileInputStream("C:/Temp/test.txt");
//        바이트 스트림을 문자열 스트림으로 사용하기 위해 보조스트림으로 연결해줌
        Reader reader = new InputStreamReader(is, "UTF-8");
        char[] data = new char[100];
        int num = reader.read(data);
        reader.close();
        String str = new String(data, 0, num);
        return str;
    }
}
