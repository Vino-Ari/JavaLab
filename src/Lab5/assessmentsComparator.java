package Lab5;

import Lab5.packageLab5.Shkolnik;
import Lab5.packageLab5.Uchenik;

import java.util.Comparator;

public class assessmentsComparator implements Comparator<Uchenik> {
    @Override
    public int compare(Uchenik o1, Uchenik o2) {
        return -Double.compare(o1.getAcademicPerformance(),o2.getAcademicPerformance());
    }

}
