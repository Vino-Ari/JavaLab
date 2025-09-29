package Lab5.packageLab5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Student extends Uchenik {

    private HashMap<String, Integer> termPapers;
    private ArrayList<String> subject = new ArrayList<>(List.of(new String[]{"философия", "математический анализ",
            "языки программирования и методы трансляции", "архитектура компьютеров"}));
    private ArrayList<String> papers = new ArrayList<>(List.of(new String[]{"курсовая по \"архитектура компьютеров\"",
            "курсовая по \"дифференциальным уравнениям \"",
            "курсовая по \"математическому аналиу\""}));

    public Student() {
        super();
        this.termPapers = new HashMap<>();
        this.getAssessments().put("Философия", 2);
        this.getAssessments().put("Математический анализ ", 2);
        this.getAssessments().put("Языки программирования и методы трансляции", 2);
        this.getAssessments().put("Архитектура компьютеров", 2);
        this.termPapers.put("Курсовая по \"Архитектура компьютеров\"", 2);
        this.termPapers.put("Курсовая по \"Дифференциальным уравнениям \"", 2);
        this.termPapers.put("Курсовая по \"Математическому аналиу\"", 2);
    }

    public Student(String name, String surname, String gender, int age) {
        super(name, surname, gender, age);
        this.termPapers = new HashMap<>();
        this.getAssessments().put("Философия", 2);
        this.getAssessments().put("Математический анализ", 2);
        this.getAssessments().put("Языки программирования и методы трансляции", 2);
        this.getAssessments().put("Архитектура компьютеров", 2);
        this.termPapers.put("Курсовая по \"Архитектура компьютеров\"", 2);
        this.termPapers.put("Курсовая по \"Дифференциальным уравнениям \"", 2);
        this.termPapers.put("Курсовая по \"Математическому аналиу\"", 2);
    }

    public Student(String name, String surname, String gender, int age, HashMap<String, Integer> assessments, HashMap<String, Integer> termPapers) {
        super(name, surname, gender, age);
        this.termPapers = new HashMap<>();
        setAssessments(assessments);
        setTermPapers(termPapers);
    }

    public void setTermPapers(HashMap<String, Integer> termPapers) {
        for (Map.Entry<String, Integer> assessments : termPapers.entrySet()) {
            setTermPapers(assessments.getKey(), assessments.getValue());
        }
    }

    public void setTermPapers(String papersName, int score) {
        if (!papers.contains(papersName.toLowerCase())) throw new IllegalArgumentException("Такого предмета нет");
        if (score < 2 || score > 5) throw new IllegalArgumentException("Оценка должна быть в диапазоне от 2 до 5");
        this.termPapers.put(papersName, score);
    }

    public HashMap<String, Integer> getTermPapers() {
        return termPapers;
    }

    public void setAssessments(HashMap<String, Integer> assessments) {
        for (Map.Entry<String, Integer> assessment : assessments.entrySet()) {
            if (!subject.contains(assessment.getKey().toLowerCase()))
                throw new IllegalArgumentException(assessment.getKey() + "Такого предмета нет");
            setAssessments(assessment.getKey(), assessment.getValue());
        }
    }

    public static void printStudentsWithCourseworkGrades(ArrayList<Student> students) {
        for (Student student : students) {
            HashMap<String, Integer> termPapers = student.getTermPapers();
            boolean good = true;
            for (Map.Entry<String, Integer> entry : termPapers.entrySet()) {
                if (entry.getValue() == 2) {
                    good = false;
                    break;
                }
            }
            if (good) System.out.println(student.toString());

        }
    }

    @Override
    public String toString() {
        return "[Школьник] " + super.toString() + "\n" + this.termPapers.toString() + "\n";
    }
}
