package org.scoula.lib.cli;

import java.util.Scanner;

public class Input {
    static Scanner sc = new Scanner(System.in);

    public static String read(String title){
        System.out.print(title);
        return sc.nextLine();
    }

    public static String read(String title, String defaultValue){
        System.out.print(title);
        String str = sc.nextLine();
        return str == null ? defaultValue : str;
    }

    public static int readInt(String title){
        System.out.print(title);
        return Integer.parseInt(sc.nextLine());
    }

    public static boolean confirm(String title, boolean defaultValue){
        System.out.print(title + "(Y/n)");
        if(defaultValue){
            System.out.println("(Y/n)");
        }
        if(!defaultValue){
            System.out.println("(y/N)");
        }
        if(sc.nextLine().isEmpty()){
            return defaultValue;
        }
        return true;
    }
    public static boolean confirm(String title){
        return confirm(title, true);
    }
}
