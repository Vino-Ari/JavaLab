package Lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Lab7_1 {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            arrayList.add(random.nextInt(-15, 16));
        }
        System.out.println(arrayList);
        System.out.println(Collections.max(arrayList));
        System.out.println(arrayList.lastIndexOf(Collections.max(arrayList)));
        Collections.sort(arrayList);
        System.out.println(arrayList);
        arrayList.removeIf(number -> number < 0);
        System.out.println(arrayList);
    }
}
