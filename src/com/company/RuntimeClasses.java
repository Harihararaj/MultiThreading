package com.company;

import java.io.IOException;

public class RuntimeClasses {
    public static void main(String[] args){
        try {
            Runtime.getRuntime().exec("notepad");
            Runtime.getRuntime().exec("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println("Total Memory: "+Runtime.getRuntime().totalMemory());
        System.out.println("Free Memory: "+Runtime.getRuntime().freeMemory());
    }
}
