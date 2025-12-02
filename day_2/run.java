package day_2;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class run {
    
    public static void main(String[] args) {
        Scanner s = null;
        long total = 0;
        ArrayList<Tuple<Long, Long>> positions = new ArrayList<>();
        try {
            s = new Scanner(new File("day_2/data.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[] line = s.nextLine().split(",");
        for(String order : line) {
            String[] parts = order.split("-");
            positions.add(new Tuple<Long, Long>(Long.parseLong(parts[0]), Long.parseLong(parts[1])));
        }
        for(Tuple<Long, Long> pos : positions) {
            for(long i = pos.x; i <= pos.y; i++) {
                String number = Long.toString(i);
                if(number.length() % 2 != 0) {
                    continue;
                } else {
                    String first = number.substring(0, number.length()/2);
                    String second = number.substring(number.length()/2, number.length());
                    if (first.equals(second)) {
                        total += i;           
                    }
                }
            }
        }
        long total2 = 0;
        boolean noMatch = false;
        for(Tuple<Long, Long> pos : positions) {
            for(long i = pos.x; i <= pos.y; i++) {
                String number = Long.toString(i);
                int length = number.length();
                for(int j = 1; j <= length/2; j++ ) {
                    if(number.substring(0,j).equals(number.substring(j,j*2)) && (length % j) == 0) {
                        for(int k = j; k < length-j; k= k+j) {
                            if(!number.substring(k, k + j).equals(number.substring(k + j, k + j*2))) {
                                noMatch = true;
                                break;
                            }
                        }
                        if(!noMatch) {
                            total2 += i;
                            break;
                        }
                    }
                    noMatch = false;
                }
            }
        }
        System.out.println("Solution is: " + total);
        System.out.println("Solution is: " + total2);
    }
    }


