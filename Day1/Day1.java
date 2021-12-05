import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

class Day1 {
    public static void main(String[] args) {
        Day1 dayOne = new Day1();
        System.out.println("Number of increases: " + 
            dayOne.countIncreases(dayOne.readFileAndPopulate("measurements.txt")));
    }

    private ArrayList<Integer> readFileAndPopulate (String fileName) {
        ArrayList<Integer> measurements = new ArrayList();
        try {
            Scanner kimput = new Scanner(new File(fileName));
            while (kimput.hasNext()) {
                measurements.add(Integer.parseInt(kimput.next()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Det her funka ikke veldig bra homie");
        }
        return measurements;
    }

    private int countIncreases(ArrayList<Integer> measurements) {
        int prev = Integer.MAX_VALUE;
        int count = 0;
        for (Integer measure : measurements) {
            if (measure > prev) {
                count++;
            }
            prev = measure;
        }
        return count;
    }
}