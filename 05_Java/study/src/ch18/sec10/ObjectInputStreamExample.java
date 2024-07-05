package ch18.sec10;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Arrays;

public class ObjectInputStreamExample {
    public static void main(String[] args) throws Exception {

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/temp/object.data"))) {
            Member m2 = (Member) ois.readObject();
            Product p2 = (Product) ois.readObject();
            int[] arr2 = {1,2,3};

            ois.close();

            System.out.println(m2);
            System.out.println(p2);
            System.out.println(Arrays.toString(arr2));

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
