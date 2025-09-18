package Lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Lab7_2 {
    public static void main(String[] args) {
        Random random = new Random();
        ArrayList<Double> arrayList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            arrayList.add(random.nextDouble(-15, 16));
        }
        System.out.println(arrayList);
        arrayList.sort(Collections.reverseOrder());
        System.out.println(arrayList);
        System.out.println(arrayList.contains(0.00) ? "Нулевые элементы есть" : "Нулевых элементов нет");
        arrayList.add(arrayList.size() / 2, (arrayList.getFirst() + arrayList.getLast()) / 2);
        System.out.println(arrayList);
    }

}
