import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kata {
    public static void main(String[] args) {
        File inputFile = new File("./input.txt");
        try {
            Scanner scanner = new Scanner(inputFile);
            Lawn lawn = initializeLawn(scanner);
            processMowers(scanner, lawn);
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Lawn initializeLawn(Scanner scanner) {
        String[] lawnCoordinates = scanner.nextLine().split(" ");
        int lawnWidth = 0;
        try {
            lawnWidth = Integer.parseInt(lawnCoordinates[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid lawn width");
            System.exit(1);
        }
        int lawnHeight = 0;
        try {
            lawnHeight = Integer.parseInt(lawnCoordinates[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid lawn height");
            System.exit(1);
        }
        return new Lawn(lawnWidth, lawnHeight);
    }

    private static void processMowers(Scanner scanner, Lawn lawn) {
        while (scanner.hasNextLine()) {
            Mower mower = initializeMower(scanner, lawn);
            String instructions = getInstructions(scanner);
            mower.move(instructions, lawn);
            System.out.println(mower.getPosition());
        }
    }

    private static Mower initializeMower(Scanner scanner, Lawn lawn) {
        String[] initialPosition = scanner.nextLine().split(" ");
        int mowerX = 0;
        try {
            mowerX = Integer.parseInt(initialPosition[0]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid initial X mower coordinate");
            System.exit(1);
        }
        if (mowerX > lawn.getWidth()) {
            System.out.println("Invalid initial X mower coordinate");
            System.exit(1);
        }
        int mowerY = 0;
        try {
            mowerY = Integer.parseInt(initialPosition[1]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid initial Y mower coordinate");
            System.exit(1);
        }
        if (mowerY > lawn.getHeight()) {
            System.out.println("Invalid initial Y mower coordinate");
            System.exit(1);
        }
        if (initialPosition[2].length() != 1) {
            System.out.println("Invalid mower orientation");
            System.exit(1);
        }
        char mowerOrientation = initialPosition[2].charAt(0);
        if (mowerOrientation != 'N' && mowerOrientation != 'E'
                && mowerOrientation != 'S' && mowerOrientation != 'W') {
            System.out.println("Invalid mower orientation");
            System.exit(1);
        }

        return new Mower(mowerX, mowerY, mowerOrientation);
    }

    public static String getInstructions(Scanner scanner) {
        return scanner.nextLine();
    }

}
