package CollectionAPI;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Comparator1 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(new Person("Robert", 22),
                                            new Person("Jodin", 23),
                                            new Person("Holin", 18));

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.compare(o1.age, o2.age);
            }
        });
        System.out.println(people);
    }

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return String.format("Name : %s, Age : %d", name, age);
        }

    }
}
