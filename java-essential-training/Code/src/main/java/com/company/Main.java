package com.company;


public class Main {
    public static void main(String[] args) {

        String s = "";
        try {
            var sub = s.substring(1);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Caught NullPointerException");
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Caught something else");
        }
        System.out.println("Try catch-ing this fastball");
    }

}
