package generic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
    static void printCollection(Collection<Object> c) {
        for (Object e : c) {
            System.out.println(e);
        }
    }

    static void printCollection2(Collection<? extends Number> c) {
        for (Number e : c) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();
        c.add("hi");
        printCollection(Collections.singleton(c));

        Collection<Double> c2 = new ArrayList<>();
        c2.add(123.3d);
        printCollection2(c2);

        Collection<Integer> c3 = new LinkedList<>();
        c3.add(111);
        printCollection2(c3);
    }
}
