package Lab5.packageLab5;

import Lab5.Lab5_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Uchenik {
    protected String name;
    protected String surname;
    protected String gender;
    protected int age;
    private HashMap<String, Integer> assessments;

    public Uchenik() {
        this("Не задан", "Не задан", "-", 0);
        this.assessments = new HashMap<>();
    }

    public Uchenik(String name, String surname, String gender, int age) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        setAge(age);
        this.assessments = new HashMap<>();
    }

    public void setSurname(String surname) {
        if (surname.equals(surname.toLowerCase()))
            throw new IllegalArgumentException("Фамилия должна начинаться с большой буквы");
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        if (name.equals(name.toLowerCase()))
            throw new IllegalArgumentException("Имя должно начинаться с большой буквы");
        this.name = name;
    }

    public void setAge(int age) {
        if (age < 0) throw new IllegalArgumentException("Возраст не может быть отрицательным");
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public HashMap<String, Integer> getAssessments() {
        return this.assessments;
    }

    public void setAssessments(HashMap<String, Integer> assessments) {
        for (Map.Entry<String, Integer> assessment : assessments.entrySet()) {
            setAssessments(assessment.getKey(), assessment.getValue());
        }
    }

    public void setAssessments(String subjectName, int score) {
        if (score < 2 || score > 5) throw new IllegalArgumentException("Оценка должна быть в диапазоне от 2 до 5");
        this.assessments.put(subjectName, score);
    }

    public static void printSpecialScholarshipRecipients(ArrayList<Shkolnik> shkolniks, ArrayList<Student> students) {
        ArrayList<Uchenik> result = new ArrayList<>();
        for (Student student : students) {
            int sum = 0;
            for (Map.Entry<String, Integer> entry : student.getAssessments().entrySet()) {
                sum += entry.getValue();
            }
            if ((double) sum / 4 < 4.75) continue;
            sum = 0;
            for (Map.Entry<String, Integer> entry : student.getTermPapers().entrySet()) {
                sum += entry.getValue();
            }
            if ((double) sum / 3 != 5.00) continue;
            result.add(student);
        }
        for (Shkolnik shkolnik : shkolniks) {
            if (!(shkolnik.getAssessments().get("Математика") == 5 && shkolnik.getAssessments().get("Русский язык") == 5 &&
                    shkolnik.getAssessments().get("История") == 5 && shkolnik.getAssessments().get("Английский язык") == 5 &&
                    shkolnik.getAssessments().get("Биология") >= 4 && shkolnik.getAssessments().get("Физика") >= 4))
                continue;
            if (!(shkolnik.isParticipatedInRegionalOlympiad()
                    || shkolnik.isFirstPlaceAtSchoolOlympiad() || shkolnik.isPrizeWinnerInCityOlympiad())) continue;
            result.add(shkolnik);
        }
        System.out.println(result.toString());
    }

    @Override
    public String toString() {
        return "Имя: " + this.name +
                "\nПол: " + this.gender +
                "\nВозраст: " + this.age +
                "\n" + assessments.toString();
    }
}
