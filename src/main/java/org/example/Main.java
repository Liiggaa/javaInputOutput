package org.example;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Write a program to find the longest and shortest word in a file

        findLongestWord();

        // Sort text(a-z), before copy to new file, and save that file in different location

        sortText();

        // Get input from terminal with scanner and add to txt file

        getAndAddText();


    }


    public static void sortText() {
        BufferedReader in = null;
        BufferedWriter out = null;

        int c; // character, unicode value for each char as read file
        StringBuilder str = new StringBuilder(); // create temporary string


        List<String> strList = new ArrayList<>();
        try {
            in = new BufferedReader(new FileReader("src/main/java/org/example/Files/file1.txt"));
            out = new BufferedWriter(new FileWriter("src/main/java/org/example/file2.txt"));

            while ((c = in.read()) != -1) { // read every single char in file
                //check for each word
                while ((char) c != ' ' && c != -1) { // do another wile loop, run as long as there is a new character, that is not a space, and there is no end of the file
                    str.append((char) c); // append the char c, cast char
                    c = in.read(); // moving on to next char

                }
                strList.add(str.toString());
                str.setLength(0);
            }

            Collections.sort(strList);

            for (String string : strList) {

                out.write(string + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private static void getAndAddText() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nEnter your name: ");
        String name = scanner.nextLine();
        System.out.println("Name: " + name);

        System.out.println("\nEnter your age: ");
        String age = scanner.nextLine();
        System.out.println("Age: " + age);

        System.out.println("\nEnter your gender: ");
        String gender = scanner.nextLine();
        System.out.println("Gender: " + gender);

        System.out.println("\nEnter your profession: ");
        String profession = scanner.nextLine();
        System.out.println("Profession: " + profession);


        FileOutputStream out = null;


        try {
            out = new FileOutputStream("src/main/java/org/example/Files/userData.txt");


            String userData = "USER DATA:";
            byte[] byteUserData = userData.getBytes();
            out.write(byteUserData);

            String userName = "\nNAME: ";
            byte[] byteUserName = userName.getBytes();
            out.write(byteUserName);

            byte[] byteName = name.getBytes();
            out.write(byteName);

            String userAge = "\nAGE: ";
            byte[] byteUserAge = userAge.getBytes();
            out.write(byteUserAge);

            byte[] byteAge = age.getBytes();
            out.write(byteAge);

            String userGender = "\nGENDER: ";
            byte[] byteUserGender = userGender.getBytes();
            out.write(byteUserGender);

            byte[] byteGender = gender.getBytes();
            out.write(byteGender);

            String userProfession = "\nPROFESSION: ";
            byte[] byteUserProfession = userProfession.getBytes();
            out.write(byteUserProfession);

            byte[] byteProfession = profession.getBytes();
            out.write(byteProfession);


        } catch (IOException e) {
            e.printStackTrace();
        } finally { // after all operations is done
            if (out != null) {
                try {
                    out.close(); // close stream
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


// Track the Strings
// Use FileReader, begin to read each character
// Check for spaces, when find space, it means find end of word (\s - for space)
// Keep recording characters until find space
// Check the length, if it's longer, than stored as longest;
// Set temp.String empty again and keep searching
    public static void findLongestWord() {

        FileReader in = null;

        try {
            in = new FileReader("src/main/java/org/example/Files/file3.txt");
            int c;
            String longest = "";
            String shortest = "";

            StringBuilder temp = new StringBuilder();
            while ((c = in.read()) != -1) {
                while ((char) c != ' ' && c != -1) {
                    temp.append((char) c);
                    c = in.read();
                }

                if (longest.isEmpty() || temp.length() >= longest.length()) {
                    longest = temp.toString();
                } else if (shortest.isEmpty() || temp.length() <= shortest.length()) {
                    shortest = temp.toString();
//                    if (temp.length() == shortest.length()) {
//                        System.out.println(shortest);
                    }

                temp.setLength(0); // clear temp, when find one word
            }

            System.out.println("\nLast founded longest word: " + longest);
            System.out.println("Last founded shortest word: " + shortest);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

