package Wildcard;

import java.util.Arrays;
import java.util.List;

public class UppderBounded {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3);
        List<String> stringList = Arrays.asList("a", "b", "c");

        printNumbers(integerList);
        printNumbers(doubleList);
        printString(stringList);

    }

    public static void printNumbers(List<? extends Number> list) {

        for (Number number : list) {
            System.out.print(STR."\{number} ");
        }
        System.out.println();
    }

    public static void printString(List<? extends String> list) {

        for (String name : list) {
            System.out.print(STR."\{name} ");
        }
        System.out.println();
    }
}
