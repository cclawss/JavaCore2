package javacore.StreamAPI.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<Integer>(Arrays.asList(1, 2, 5, 16, -1, -2, 0, 32, 3, 5, 8, 23, 4));
        Iterator<Integer> iterator = intList.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next <=0 || next % 2 != 0) {
                iterator.remove();
            }
        }

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < intList.size()-1; i++) {
                if (intList.get(i) > intList.get(i + 1)) {
                    int temp = intList.get(i);
                    intList.set(i,intList.get(i + 1));
                    intList.set(i+1,temp);
                    isSorted = false;
                }
            }
        }
        intList.forEach(System.out::println);
    }
}