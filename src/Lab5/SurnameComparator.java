package Lab5;

import Lab5.packageLab5.Uchenik;

import java.util.Comparator;

public class SurnameComparator implements Comparator<Uchenik> {
    @Override
    public int compare(Uchenik o1, Uchenik o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
