package ch18.sec10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ObjectOutputStreamExample {
    public static void main(String[] args) throws Exception {

        Member m1 = new Member("fall", "단풍이");
        Product p1 = new Product("노트북", 1500000);
        int[] arr1 = {1,2,3};

        FileOutputStream fos = new FileOutputStream("C:/temp/object.data");
        ObjectOutputStream oos = new ObjectOutputStream(fos);


        oos.writeObject(m1);
        oos.writeObject(p1);
        IntStream arrStream = Arrays.stream(arr1);
        arrStream.asDoubleStream()
                .forEach(b-> {
                    try {
                        oos.writeObject(b);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        fos.close();
        oos.close();
    }

}
