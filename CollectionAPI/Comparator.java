package CollectionAPI;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Comparator {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Aung", "Naing", "Thu");

        Collections.sort(names, new java.util.Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        System.out.println(names);
    }
}
