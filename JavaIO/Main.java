package JavaIO;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Aung Naing Thu\\OOP-Projects\\src\\JavaIO\\text");

        Scanner input = new Scanner(file);

        while (input.hasNext()){
            System.out.println(input.nextLine());
        }

        FileWriter fileWriter = new FileWriter("C:\\Users\\Aung Naing Thu\\OOP-Projects\\src\\JavaIO\\text", true);

        fileWriter.append("Oh amazing I appended some text to your book\n");
        fileWriter.flush();

        while (input.hasNext()){
            System.out.println(input.nextLine());
        }
    }
}
