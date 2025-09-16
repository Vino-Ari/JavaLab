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
    }

    public Shkolnik(String name, String gender, int age) {
        super(name, gender, age);
        this.getAssessments().put("Математика", 2);
        this.getAssessments().put("Русский язык", 2);
        this.getAssessments().put("История", 2);
        this.getAssessments().put("Английский язык", 2);
        this.getAssessments().put("Биология", 2);
        this.getAssessments().put("Физика", 2);
        this.participatedInRegionalOlympiad = false;
        this.firstPlaceAtSchoolOlympiad = false;
        this.prizeWinnerInCityOlympiad = false;
    }

    public Shkolnik(String name, String gender, int age, HashMap<String, Integer> assessments
            , boolean participatedInRegionalOlympiad, boolean firstPlaceAtSchoolOlympiad
            , boolean prizeWinnerInCityOlympiad) {
        super(name, gender, age);
        this.participatedInRegionalOlympiad = participatedInRegionalOlympiad;
        this.firstPlaceAtSchoolOlympiad = firstPlaceAtSchoolOlympiad;
        this.prizeWinnerInCityOlympiad = prizeWinnerInCityOlympiad;
        setAssessments(assessments);
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

    @Override
    public String toString() {
        return super.toString() +
                "\nУчаствовал в областной олимпиаде: " + participatedInRegionalOlympiad +
                "\n Имеются первые места в школьной олимпиаде: " + firstPlaceAtSchoolOlympiad +
                "\n Является призёром городской олимпиады: " + prizeWinnerInCityOlympiad+"\n";
    }
}
