package CollectionAPI;

//Array List & Linked List Example
import com.ant.fileHandle.Item;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        //HashSet Practice
        Collection<String> fruits = new HashSet<>();

        fruits.add("Organge");
        fruits.add("Apple");
        fruits.add("Mango");

        System.out.println(fruits.contains("apple"));
        System.out.println(fruits);

        fruits.clear();
        System.out.println(fruits);

        //LinkedList Practice
        Collection<Integer> values = new LinkedList<>();
        values.add(1);
        values.add(2);
        values.add(3);

        System.out.println(values);
        System.out.println(values.stream().count());
        System.out.println(values.stream().sorted());

        //Set
        Collection<Set<Integer>> name = new LinkedList<>();
        HashSet<Integer> e = new HashSet<>(Arrays.asList(1, 2));

        name.add(e);
        System.out.println(name);

        //TreeSet
        Collection<String > naming = new TreeSet<>();
        naming.add("Cora");
        naming.add("Brdin");
        naming.add("Suko");
        System.out.println(naming);

        System.out.println(naming.iterator().next().toLowerCase());

        //Iterator
       //Collection<Integer> numbers = new ArrayList<>();
       Collection<Integer> numbers = new LinkedList<>();
       numbers.add(10);
       numbers.add(20);
       numbers.add(30);
       numbers.add(40);
       numbers.add(50);
       System.out.println(numbers);
       Iterator<Integer> iterator = numbers.iterator();

       while (iterator.hasNext()) {
           System.out.println(iterator.next());
       }
    }
}
