import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class run {
    
    public static void main(String[] args) {
        Scanner s = null;
        int current = 50;
        int change, before;
        double passedTimes, passedBefore;
        passedTimes = 0;
        int count = 0;
        ArrayList<String> orders = new ArrayList<>();
        try {
            s = new Scanner(new File("1/data.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while(s.hasNextLine()) {
            orders.add(s.nextLine());
        }
        s.close();
        for(String order : orders) {
            before = current;
            passedBefore = passedTimes;
            if(order.startsWith("L")) {
                change = -1 * Integer.parseInt(order.substring(1));
            } else {
                change = Integer.parseInt(order.substring(1));
            }
            current += change;
            if(current < 0 && before != 0) {
                passedTimes++;
            }
            passedTimes += Math.abs(Math.floor(current/100));
            current = current%100;
            if(current < 0) {
                current += 100;
            } 
            if(current == 0) {
                count++;
                if(passedBefore < passedTimes) {
                    passedTimes--;
                }
            }
        }
        System.out.println("This is solution to first: " + count);
        System.out.println("Solution to second is: " + (passedTimes + count));

    }
}
