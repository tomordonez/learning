package com.company;


public class Main {
    public static void main(String[] args) {

        String s = null;
        try {
            var sub = s.substring(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Try catch-ing this fastball");
    }

}
