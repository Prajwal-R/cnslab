import java.util.*;

public class leaky {

    private static int bucketSize = 0;
    private static int outputRate = 0;
    private static int inputRate = 0;
    private static int remainder = 0;
    
    public static void main(String[] args) {

        int totalLoops = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the no of iterations: ");
        totalLoops = scanner.nextInt();

        System.out.println("Enter the Bucket Size: ");
        bucketSize = scanner.nextInt();

        // System.out.println("Enter the Input Rate: ");
        // inputRate = scanner.nextInt();

        System.out.println("Enter the Output Rate: ");
        outputRate = scanner.nextInt();

        for (int i = 0; i < totalLoops; i++){

            System.out.println("Enter the Input Rate: ");
            inputRate = scanner.nextInt();

            inputRate = inputRate + remainder;
            if(inputRate > bucketSize){
                System.out.println("Data Overflown by: " + (inputRate - bucketSize));
                inputRate = bucketSize;
            }

            remainder = inputRate - outputRate;

            if (remainder < 0) {
                System.out.println("Sorry You entered something wrong");
                System.exit(1);
            }

            System.out.println("Input Rate: " + inputRate + " Remainder: " + remainder);
        }

        if(remainder != 0){
            System.out.println("The Buffer has " + remainder + " data left.");
            remainder = 0;
        }
        scanner.close();
    }
}