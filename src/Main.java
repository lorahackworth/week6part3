import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("Mr.K");
        listOfStrings.add("2/22/2024");
        listOfStrings.add("CSCI 1660 - Java Fundamentals");

        String file = "classDescription.txt";
        try{
            writeAssignment(listOfStrings, file);
            readFile(listOfStrings, file);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static void writeAssignment(ArrayList<String> assignment, String filename) throws FileNotFoundException{
        try(FileWriter writer = new FileWriter(filename)){
            for(String str : assignment){
                writer.write(str + "\n");
            }
        }catch(FileNotFoundException e){
            throw e; // catch and re-throw
        }catch(IOException e){
            System.err.print("Something went wrong.");
        }
    }

    // this one doesn't try or catch, since it already tries in main
    public static void readFile(ArrayList<String> assignment,String filename){
        //scans for what's in the file, then prints out the contents
        Scanner myReader = new Scanner(filename);
        while (myReader.hasNextLine()) {
            System.out.println(assignment);
        }
        //closes so it's not open forever
        myReader.close();
    }
}