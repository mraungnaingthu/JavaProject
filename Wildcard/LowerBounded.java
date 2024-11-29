package Wildcard;

import java.util.ArrayList;
import java.util.List;

public class LowerBounded {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        List<Number> numberList = new ArrayList<>();
        List<Object> objectList = new ArrayList<>();

        addIntegers(integerList);  // Works because Integer is exactly Integer
        addIntegers(numberList);   // Works because Number is a superclass of Integer
        addIntegers(objectList);   // Works because Object is a superclass of Integer

        System.out.println(integerList); // Output: [1, 2, 3]
        System.out.println(numberList);  // Output: [1, 2, 3]
        System.out.println(objectList);  // Output: [1, 2, 3]
    }

    public static void addIntegers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
    }
}
