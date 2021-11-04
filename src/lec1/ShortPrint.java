package lec1;

import java.util.List;

public class ShortPrint {

    String end= " ";

    public ShortPrint(){
        this.end = " ";
    }

    public ShortPrint(String end){
        this.end = end;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public static void print(Object obj){
        System.out.println(obj);
    }
    public static <T> void print(T[] arr){
        String s ="{";
        for(int i=0; i<arr.length;i++)
            if(i == arr.length-1)
                s += arr[i]+"}\n";
            else
                s += arr[i]+", ";
        System.out.print(s);
    }
    public static <T> void print(List<T> list){
        String s="[";
        for(int i=0;i<list.size();i++)
            if(i == list.size()-1)
                s +=list.get(i)+"]\n";
            else
                s += list.get(i)+", ";
        System.out.print(s);
    }
    public static <T> void print(T[][] arr){
        String s="{";
        for (int i = 0; i < arr.length; i++) {
            s += "{";
            for (int j = 0; j < arr[i].length; j++) {
                if(j != arr[i].length-1) s += arr[i][j]+", ";
                else s += arr[i][j]+"";
            }
            if(i != arr.length-1) s += "},\n";
            else s += "}\n";
        }
        s +="}";
        System.out.println(s);
    }
    public static void print(int[] arr){
        String s ="{";
        for(int i=0;i<arr.length;i++)
            if(i == arr.length-1)
                s += arr[i]+"}\n";
            else
                s += arr[i]+", ";
        System.out.print(s);
    }
    public static void print(double[] arr){
        String s ="{";
        for(int i=0;i<arr.length;i++)
            if(i == arr.length-1)
                s += arr[i]+"}\n";
            else
                s += arr[i]+", ";
        System.out.print(s);
    }
    public static void print(boolean[] arr){
        String s ="{";
        for(int i=0;i<arr.length;i++)
            if(i == arr.length-1)
                s += arr[i]+"}\n";
            else
                s += arr[i]+", ";
        System.out.print(s);
    }
    public static void print(char[] arr){
        String s ="{";
        for(int i=0;i<arr.length;i++)
            if(i == arr.length-1)
                s += arr[i]+"}\n";
            else
                s += arr[i]+", ";
        System.out.print(s);
    }
    public static void print(float[] arr){
        String s ="{";
        for(int i=0;i<arr.length;i++)
            if(i == arr.length-1)
                s += arr[i]+"}\n";
            else
                s += arr[i]+", ";
        System.out.print(s);
    }
    public static void print(long[] arr){
        String s ="{";
        for(int i=0;i<arr.length;i++)
            if(i == arr.length-1)
                s += arr[i]+"}\n";
            else
                s += arr[i]+", ";
        System.out.print(s);
    }
    public static void print(byte[] arr){
        String s ="{";
        for(int i=0;i<arr.length;i++)
            if(i == arr.length-1)
                s += arr[i]+"}\n";
            else
                s += arr[i]+", ";
        System.out.print(s);
    }
    // 2d arrays
    public static void print(int[][] arr){
        String s="{";
        for (int i = 0; i < arr.length; i++) {
            s += "{";
            for (int j = 0; j < arr[i].length; j++) {
                if(j != arr[i].length-1) s += arr[i][j]+", ";
                else s += arr[i][j]+"";
            }
            if(i != arr.length-1) s += "},\n";
            else s += "}\n";
        }
        s +="}";
        System.out.println(s);
    }
    public static void print(double[][] arr){
        String s="{";
        for (int i = 0; i < arr.length; i++) {
            s += "{";
            for (int j = 0; j < arr[i].length; j++) {
                if(j != arr[i].length-1) s += arr[i][j]+", ";
                else s += arr[i][j]+"";
            }
            if(i != arr.length-1) s += "},\n";
            else s += "}\n";
        }
        s +="}";
        System.out.println(s);
    }
    public static void print(char[][] arr){
        String s="{";
        for (int i = 0; i < arr.length; i++) {
            s += "{";
            for (int j = 0; j < arr[i].length; j++) {
                if(j != arr[i].length-1) s += arr[i][j]+", ";
                else s += arr[i][j]+"";
            }
            if(i != arr.length-1) s += "},\n";
            else s += "}\n";
        }
        s +="}";
        System.out.println(s);
    }
    public static void print(boolean[][] arr){
        String s="{";
        for (int i = 0; i < arr.length; i++) {
            s += "{";
            for (int j = 0; j < arr[i].length; j++) {
                if(j != arr[i].length-1) s += arr[i][j]+", ";
                else s += arr[i][j]+"";
            }
            if(i != arr.length-1) s += "},\n";
            else s += "}\n";
        }
        s +="}";
        System.out.println(s);
    }
    public static void print(float[][] arr){
        String s="{";
        for (int i = 0; i < arr.length; i++) {
            s += "{";
            for (int j = 0; j < arr[i].length; j++) {
                if(j != arr[i].length-1) s += arr[i][j]+", ";
                else s += arr[i][j]+"";
            }
            if(i != arr.length-1) s += "},\n";
            else s += "}\n";
        }
        s +="}";
        System.out.println(s);
    }
    public static void print(long[][] arr){
        String s="{";
        for (int i = 0; i < arr.length; i++) {
            s += "{";
            for (int j = 0; j < arr[i].length; j++) {
                if(j != arr[i].length-1) s += arr[i][j]+", ";
                else s += arr[i][j]+"";
            }
            if(i != arr.length-1) s += "},\n";
            else s += "}\n";
        }
        s +="}";
        System.out.println(s);
    }
    public static void print(byte[][] arr){
        String s="{";
        for (int i = 0; i < arr.length; i++) {
            s += "{";
            for (int j = 0; j < arr[i].length; j++) {
                if(j != arr[i].length-1) s += arr[i][j]+", ";
                else s += arr[i][j]+"";
            }
            if(i != arr.length-1) s += "},\n";
            else s += "}\n";
        }
        s +="}";
        System.out.println(s);
    }
}
