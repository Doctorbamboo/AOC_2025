package day_3;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class run {

    public static void main(String[] args) {
        Scanner s = null;
        int total = 0;
        try {
             s = new Scanner(new File("day_3/data.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while(s.hasNextLine()) {
            String line = s.nextLine();
            Integer first = 0;
            Integer second = 0;
            int i = 0;
            for(char c : line.toCharArray()) {
                i++;
                if(Character.getNumericValue(c) > first && i != line.length()) {
                    first = Character.getNumericValue(c);
                    second = 0;
                } else if (Character.getNumericValue(c) > second) {
                    second = Character.getNumericValue(c);
                }
            }
            // System.out.println(line + " " + first + second);
            total = total + first*10 + second;
        }

        int total2 = 0;
        while(s.hasNextLine()) {
            String line = s.nextLine();
            int[] counts = new int[10];
            for(char c : line.toCharArray()) {
        }

        System.out.println("Solution2 is: " + total2);
        }
    }
}
