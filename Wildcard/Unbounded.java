package Wildcard;

//Unbounded wildcard sample to practice
import java.util.List;

public class Unbounded {
    public static void main(String[] args) {
        List<Integer> intList = List.of(1, 2, 3);
        List<String> strList = List.of("A", "B", "C");

        printList(intList);
        printList(strList);

    }

    public static void printList(List<?> list) {
        for (Object element : list) {
            System.out.println(element);
        }
    }
}
