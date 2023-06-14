
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
* Selection sorting a line of numbers.
*
* @author  Keiden B
* @version 1.0
* @since   2023-05-08
*/

public final class SelectionSort {
    /**
    * Necessary to prevent HideUtilityClass Error.
    *
    * @exception IllegalStateException Utility class
    * @see IllegalStateException
    */
    private SelectionSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
    * The function to sort the array.
    *
    * @param listOfNum The array to sort.
    */
    public static void selectSort(int[] listOfNum) {
        // Starts at index 0, loops through the list
        for (int repeat = 0; repeat < listOfNum.length; repeat++) {
            // Sets the min to the current index
            int min = listOfNum[repeat];
            // Sets the index of the min number
            int mIndex = repeat;
            // Starts at index 1, loops through the list
            for (int term = repeat + 1; term < listOfNum.length; term++) {
                // Sets a new min if the current term is smaller
                if (listOfNum[term] < min) {
                    min = listOfNum[term];
                    mIndex = term;
                }
            }
            // Switching the current number and the min number
            final int hold = listOfNum[repeat];
            listOfNum[repeat] = min;
            listOfNum[mIndex] = hold;
        }
    }

    /**
    * Main lines of code.
    *
    * @param args a placeholder value when making the main function
    * @throws Exception thrown when making scanner for the input file.
    */
    public static void main(String[] args) throws Exception {
        // Making file path and scanner objects.
        final File filePath = new File("./Unit4-03-Input.txt");
        final FileWriter fileOut = new FileWriter("./Unit4-03-Output.txt");
        final Scanner scanIn = new Scanner(filePath);

        System.out.println("\nOrganizing line...\n");
        fileOut.write("\nOrganizing line...\n\n");

        // Repeats for all lines in the text file.
        while (scanIn.hasNextLine()) {
            // Scan the next line
            final String normNum = scanIn.nextLine();
            // Trying to convert the line to an int array
            try {
                final int[] normList = Arrays.stream(normNum.split(" "))
                        .mapToInt(Integer::parseInt).toArray();

                // Printing the unsorted list
                System.out.println("Unsorted list is "
                        + Arrays.toString(normList));
                fileOut.write("Unsorted list is "
                        + Arrays.toString(normList) + "\n");

                // Selection sorting the list
                selectSort(normList);

                // Printing the sorted list
                System.out.println("The sorted list is "
                        + Arrays.toString(normList) + "\n");
                fileOut.write("The sorted list is "
                        + Arrays.toString(normList) + "\n\n");
                // Catching ints / decimals / blank lines
            } catch (NumberFormatException parseError) {
                // Printing the error
                System.out.println("Line contains a decimal/string/blank"
                        + " line. " + parseError + "\n");
                fileOut.write("Line contains a decimal/string/blank line. "
                        + parseError + "\n\n");
            }
        }
        // Closing the scanner and filewriter
        fileOut.close();
        scanIn.close();
    }
}
