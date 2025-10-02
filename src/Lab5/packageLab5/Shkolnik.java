package Lab5.packageLab5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shkolnik extends Uchenik {
    private boolean participatedInRegionalOlympiad;     // Участвовал в областной олимпиаде
    private boolean firstPlaceAtSchoolOlympiad;         // Первое место в школьной олимпиаде
    private boolean prizeWinnerInCityOlympiad;          // Призёр городской олимпиады
    private ArrayList<String> subject = new ArrayList<>(List.of(new String[]{"математика", "русский язык",
            "история", "английский язык", "биология", "физика"}));
    private int numerSchool;

    public Shkolnik() {
        super();
        this.getAssessments().put("Математика", 2);
        this.getAssessments().put("Русский язык", 2);
        this.getAssessments().put("История", 2);
        this.getAssessments().put("Английский язык", 2);
        this.getAssessments().put("Биология", 2);
        this.getAssessments().put("Физика", 2);
        this.participatedInRegionalOlympiad = false;
        this.firstPlaceAtSchoolOlympiad = false;
        this.prizeWinnerInCityOlympiad = false;
        this.numerSchool = 1;
    }

    public Shkolnik(String name, String surname, String gender, int age, int numerSchool) {
        super(name, surname, gender, age);
        this.getAssessments().put("Математика", 2);
        this.getAssessments().put("Русский язык", 2);
        this.getAssessments().put("История", 2);
        this.getAssessments().put("Английский язык", 2);
        this.getAssessments().put("Биология", 2);
        this.getAssessments().put("Физика", 2);
        this.participatedInRegionalOlympiad = false;
        this.firstPlaceAtSchoolOlympiad = false;
        this.prizeWinnerInCityOlympiad = false;
        this.numerSchool = numerSchool;

    }

    public Shkolnik(String name, String surname, String gender, int age, int numberSchool, HashMap<String, Integer> assessments
            , boolean participatedInRegionalOlympiad, boolean firstPlaceAtSchoolOlympiad
            , boolean prizeWinnerInCityOlympiad) {
        super(name, surname, gender, age);
        this.participatedInRegionalOlympiad = participatedInRegionalOlympiad;
        this.firstPlaceAtSchoolOlympiad = firstPlaceAtSchoolOlympiad;
        this.prizeWinnerInCityOlympiad = prizeWinnerInCityOlympiad;
        setAssessments(assessments);
        this.numerSchool = numberSchool;
    }

    public void setNumberSchool(int numerSchool) {
        if (numerSchool < 0) throw new IllegalArgumentException("Номер школы не может быть отрицательным");
        this.numerSchool = numerSchool;
    }

    public int getNubmerSchool() {
        return numerSchool;
    }

    public void setAssessments(HashMap<String, Integer> assessments) {
        for (Map.Entry<String, Integer> assessment : assessments.entrySet()) {
            if (!subject.contains(assessment.getKey().toLowerCase()))
                throw new IllegalArgumentException("Такого предмета нет");
            setAssessments(assessment.getKey(), assessment.getValue());
        }
    }

    public void setParticipatedInRegionalOlympiad(boolean participatedInRegionalOlympiad) {
        this.participatedInRegionalOlympiad = participatedInRegionalOlympiad;
    }

    public void setFirstPlaceAtSchoolOlympiad(boolean firstPlaceAtSchoolOlympiad) {
        this.firstPlaceAtSchoolOlympiad = firstPlaceAtSchoolOlympiad;
    }

    public void setPrizeWinnerInCityOlympiad(boolean prizeWinnerInCityOlympiad) {
        this.prizeWinnerInCityOlympiad = prizeWinnerInCityOlympiad;
    }

    public boolean isParticipatedInRegionalOlympiad() {
        return participatedInRegionalOlympiad;
    }

    public boolean isFirstPlaceAtSchoolOlympiad() {
        return firstPlaceAtSchoolOlympiad;
    }

    public boolean isPrizeWinnerInCityOlympiad() {
        return prizeWinnerInCityOlympiad;
    }
    public static ArrayList<Shkolnik> SpecialScholarshipRecipients(ArrayList<Shkolnik> shkolniks) {
        ArrayList<Shkolnik> result = new ArrayList<>();
        for (Shkolnik shkolnik : shkolniks) {
            if (!(shkolnik.getAssessments().get("Математика") == 5 && shkolnik.getAssessments().get("Русский язык") == 5 &&
                    shkolnik.getAssessments().get("История") == 5 && shkolnik.getAssessments().get("Английский язык") == 5 &&
                    shkolnik.getAssessments().get("Биология") >= 4 && shkolnik.getAssessments().get("Физика") >= 4))
                continue;
            if (!(shkolnik.isParticipatedInRegionalOlympiad()
                    || shkolnik.isFirstPlaceAtSchoolOlympiad() || shkolnik.isPrizeWinnerInCityOlympiad())) continue;
            result.add(shkolnik);
        }
        return result;
    }

    public static void printGirlsWithFirstPlace(ArrayList<Shkolnik> shkolniks) {
        shkolniks.removeIf(shkolnik -> (shkolnik.getGender().equals("m") || !(shkolnik.isParticipatedInRegionalOlympiad()
                || shkolnik.isFirstPlaceAtSchoolOlympiad() || shkolnik.isPrizeWinnerInCityOlympiad())));
        System.out.println(shkolniks.toString());
    }

    @Override
    public String toString() {
        return "\n[Школьник] " + super.toString() +
                "\nНомер школы: " + numerSchool +
                "\nУчаствовал в областной олимпиаде: " + participatedInRegionalOlympiad +
                "\nИмеются первые места в школьной олимпиаде: " + firstPlaceAtSchoolOlympiad +
                "\nЯвляется призёром городской олимпиады: " + prizeWinnerInCityOlympiad + "\n";
    }
}
