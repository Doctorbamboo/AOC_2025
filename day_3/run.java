package day_3;

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class run {

    public static void replace(int[] number, int index, int value, int current) {
        for(int t = current; t > index; t--) {
            if(number[t] < value) {
                int previous = number[t];
                number[t] = value;
                replace(number,index-1,previous,t-1);
                //break;
            }
        }
    }
    public static void check(int[] number) {
        for(int i = 1; i < number.length -2; i++) {
            if(number[i] < number[i+1]) {
                for(int j = i; j <number.length -1; j++) {
                    number[j] = number[j+1];
                }
                number[number.length -1] = 0;
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner s = null;
        int total = 0;
        try {
             s = new Scanner(new File("day_3/data.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // while(s.hasNextLine()) {
        //     String line = s.nextLine();
        //     Integer first = 0;
        //     Integer second = 0;
        //     int i = 0;
        //     for(char c : line.toCharArray()) {
        //         i++;
        //         if(Character.getNumericValue(c) > first && i != line.length()) {
        //             first = Character.getNumericValue(c);
        //             second = 0;
        //         } else if (Character.getNumericValue(c) > second) {
        //             second = Character.getNumericValue(c);
        //         }
        //     }
        //     // System.out.println(line + " " + first + second);
        //     total = total + first*10 + second;
        // }

        double total2 = 0;
        while(s.hasNextLine()) {
            double voltage = 0;
            String line = s.nextLine();
            int k = 0;
            boolean used = false;
            int[] number = new int[12];
            for(char c : line.toCharArray()) {

                k++;
            
                for(int i = 0; i< 12; i++) {
                    int digit = number[i];
                    if(Character.getNumericValue(c) > digit && line.length() - k > 10) { //should maybe be 11
                        number[i] = Character.getNumericValue(c);
                        for(int j = i+1; j < 10; j++) {
                            number[j] = 0;
                        }
                        used = true;
                        break;
                    } else if (number[i] == 0) {
                        number[i] = Character.getNumericValue(c);
                        used = true;
                        break;
                    }
                    used = false;
                } 
                int left = 10 -(line.length() - k);
                if(!used && left >= 0) {
                    check(number);
                    if(number[11] == 0) {
                        number[11] = Character.getNumericValue(c);
                        continue;
                    }
                    for(int i = 11; i > left; i--) {
                        if(number[i] < Character.getNumericValue(c) ) {
                            int previous = number[i];
                            number[i] = Character.getNumericValue(c);
                            replace(number,left-1,previous,i-1);
                            if(i != 11) {
                                number[i+1] = 0;
                            }
                        }
                    } 


                }
        }
        int i = 0;
        System.out.println(Arrays.toString(number));
        for(int digit: number) {
            voltage = voltage + digit * Math.pow(10,11-i);
            i++;
        }
        total2 = total2 + voltage;
        }
        long total3 = (long) total2 ;



        System.out.println("Solution2 is: " + total3);
        System.out.println("Solution2 is: " + total2);
        }
    }

