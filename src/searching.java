//Import Scanner to accept user inputs
import java.util.Scanner;
//Import Arrays to copy and sort arrays
import java.util.Arrays;

public class searching {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        //Create an integer array to store the 10 numbers entered by the user
        int[] numbers = new int[10];

        System.out.println("Enter 10 numbers:");
        // use for loop to collect 10 integers and store them in the array
        for(int i = 0; i < 10; i++){
            System.out.print("Enter number" + " " + (i + 1) + ": ");
            numbers[i] = input.nextInt();
        }
        //Display the search menu repeatedly until the user chooses exit
        int choice;

        do{
            System.out.println("\n===== SEARCH MENU =====");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();
            //check whether the user selected linear search
            if(choice == 1){
                System.out.print("Enter number to search: ");
                int target = input.nextInt();

                /*
                  Initialize the comparison counter and set position to -1
                  to indicate that the target has not yet been found
                 */
                int comparisons = 0;
                int position = -1;

                // Traverse the original array, checking each element against the target
                for(int i = 0; i < numbers.length; i++){
                    //Increment counter for every comparison performed
                    comparisons++;

                    //check whether the current array element matches the target
                    if(numbers[i] == target){
                        //store the index where the target was found
                        position = i;
                        break;
                    }
                }
                //Display the search result and total number of comparisons
                if(position != -1){
                    System.out.println("Number found at position: " + (position + 1));
                }else{
                    System.out.println("Number not found.");
                }
                System.out.println("Comparisons: " + comparisons);
            }else if(choice == 2){
                System.out.print("Enter number to search: ");
                int target = input.nextInt();

                //Create a copy of the original array to preserve its order
                int[] sortedNumbers = Arrays.copyOf(numbers, numbers.length);
                //sort copied array because binary search requires sorted data
                Arrays.sort(sortedNumbers);

                // Initialize the search boundaries
                int low = 0;
                int high = sortedNumbers.length - 1;

                /*
                  Initialize the comparison counter and set position to -1
                  to indicate that the target has not yet been found
                 */
                int comparisons = 0;
                int position = -1;

                //Perform Binary search while the search range is valid
                while(low <= high){
                    //calculate the middle index of the current search range
                    int mid = (low + high) / 2;
                    //Increment counter for every comparison performed
                    comparisons++;

                    //Check whether the middle element matches the target
                    if(sortedNumbers[mid] == target){
                        //store the index where the target was found
                        position = mid;
                        break;
                    //If target is smaller, continue searching the left half
                    }else if (target < sortedNumbers[mid]) {
                        high = mid - 1;
                    //Otherwise, continue searching the right half
                    }else{
                        low = mid + 1;
                    }
                }
                //Display the search result and total number of comparisons
                if(position != -1){
                    System.out.println("Number found at position: " + (position + 1));
                }else{
                    System.out.println("Number not found");
                }
                System.out.println("Comparisons: " + comparisons);
            }else if (choice == 3) {
                System.out.println("Exiting search program...");
            }else{
                System.out.println("404: Menu options not found! Try again.");
            }
        } while (choice != 3);

        //close the scanner to release the input resources
        input.close();
    }
}
