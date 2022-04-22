package com.company;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите текст");

        String ip =in.nextLine();
        boolean isFind;
        int matches = 0;

        Pattern pattern = Pattern.compile("((^|\\s)(([1-9]?\\d|1\\d\\d|2[0-5][0-5]|2[0-4]\\d)\\.){3}([1-9]?\\d|1\\d\\d|2[0-5][0-5]|2[0-4]\\d))");
        Matcher m = pattern.matcher(ip);
        try( FileWriter f = new FileWriter("ips.txt")){
            do{
                isFind = m.find();
                if (isFind) {
                    f.write(m.group().replace(" ", "") + "\n");
                    System.out.println("IP записан");
                    f.flush();
                    matches++;
                }
                if(!isFind & matches == 0) {
                    System.out.println("Ip адресов не найдено");
                    f.write("IP адресов не найдено :_(");
                }
            }while (isFind);
        }
        catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
