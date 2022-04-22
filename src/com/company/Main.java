package com.company;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите текст");
        String ip =in.nextLine();
        Pattern pattern = Pattern.compile("(\\s|^)(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}");
        Matcher m = pattern.matcher(ip);
        try{
            FileWriter f = new FileWriter("ips.txt");
            while (m.find()){
                System.out.println(m.group());
                //f.write(m.group() + "\n");
                System.out.println("IP записан");
                f.flush();
            }
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
