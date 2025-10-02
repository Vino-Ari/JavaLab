package Lab5.packageLab5;

import Lab5.Lab5_;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Uchenik implements Comparable<Uchenik> {
    protected String name;
    protected String surname;
    protected String gender;
    protected int age;
    protected HashMap<String, Integer> assessments;
    protected double academicPerformance;

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

    public double getAcademicPerformance() {
        int sum = 0;
        for (Integer assessment : this.assessments.values()) {
            sum += assessment;
        }
        return (double) sum / this.assessments.size();
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

    @Override
    public int compareTo(Uchenik o) {
        return this.getAge() - o.getAge();
    }

    @Override
    public String toString() {
        return "\nИмя: " + this.name +
                "\nФамилия: " + this.surname +
                "\nПол: " + this.gender +
                "\nВозраст: " + this.age +
                "\n" + assessments.toString() +
                "\nСр.оценка: " + getAcademicPerformance();
    }
}
