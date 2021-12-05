import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

class Day2 {
    public static void main(String[] args) {
        int horizontal = 0;
        int depth = 0;
        ArrayList<String> positionList = readFile("positions.txt");
        int[] positions = adjustPosition(positionList);
        System.out.println("Final pos multiplied is: " + (positions[0] * positions[1]));
    }

    private static ArrayList<String> readFile(String fileName) {
        ArrayList<String> positionList = new ArrayList();
        try {
            Scanner kimput = new Scanner(new File(fileName));
            while (kimput.hasNextLine()) {
                positionList.add(kimput.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Det her funka ikke veldig bra homie");
        }
        return positionList;
    }

    private static int[] adjustPosition(ArrayList<String> positionList) {
        int horizontal = 0;
        int depth = 0;
        int aim = 0;
        int[] positions = new int[2];
        for (String position : positionList) {
            String[] positionValues = position.split(" ");
            switch (positionValues[0]) {
                case "forward":
                    horizontal += Integer.parseInt(positionValues[1]);
                    depth += (aim * Integer.parseInt(positionValues[1]));
                    break;
                case "up": 
                    aim -= Integer.parseInt(positionValues[1]);
                    break;
                case "down":
                    aim += Integer.parseInt(positionValues[1]);
                    break;
            }
        }
        positions[0] = horizontal; positions[1] = depth;
        return positions;
    }
}