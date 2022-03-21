import java.util.Scanner;

public class InputCalculator {
    public static void inputThenPrintSumAndAverage() {
        double avgSum = 0;
        int sum = 0;
        int counter = 0;
        long average = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            boolean isInt = scanner.hasNextInt();
            if (isInt) {
                int value = scanner.nextInt();
                scanner.nextLine();
                counter++;

                if (value == 0) {
                    counter--;
                }
                sum += value;

                avgSum += value;

                average = (long) Math.round(avgSum / counter);


            } else {
                System.out.println("SUM = " + sum + " AVG = " + average);
                scanner.close();
                break;
            }

        }

    }

    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }
}
