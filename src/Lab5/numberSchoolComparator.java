package Lab5;

import Lab5.packageLab5.Shkolnik;


import java.util.Comparator;

public class numberSchoolComparator implements Comparator<Shkolnik> {
    @Override
    public int compare(Shkolnik o1, Shkolnik o2) {
        return o1.getNubmerSchool() - o2.getNubmerSchool();
    }
}
