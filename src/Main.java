//To generate a file with x number of lines, each line consisting of a unique string that is 100 characters long,
// while keeping the memory usage limited to 10MB, you can use the following Java program:

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int x = 10; // Set the desired number of lines
        int stringLength = 10; // Set the length of each string

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("outputFile.txt"))) {
            Set<String> uniqueStrings = new HashSet<>();
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            int count= 0;
            while (uniqueStrings.size() < x) {
                sb.setLength(0); // Reset StringBuilder
                for (int i = 0; i < stringLength; i++) {
                     char randomChar = (char) (random.nextInt(26) + 'a'); // Generate a random lowercase character
                     sb.append(randomChar);
                }

                String uniqueString = sb.toString();
                if (uniqueStrings.add(uniqueString)) {
                    writer.write(uniqueString);
                    writer.newLine();
                }
            }

            System.out.println("File generated successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while generating the file: " + e.getMessage());
        }
    }
}

    /*This program uses a HashSet to keep track of unique strings.
    It generates random strings of length 100 and checks if the string is already present in the set.
    If it is unique, it is written to the file.

    Please note that generating a file with a large number of lines and each line being unique can be memory-intensive,
    especially if the number of lines is close to the limit. In such cases,
    it may be necessary to allocate more memory or modify the approach to handle the generation in smaller batches.
    */