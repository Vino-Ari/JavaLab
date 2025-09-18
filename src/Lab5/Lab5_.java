package Lab5;

import Lab5.packageLab5.Shkolnik;
import Lab5.packageLab5.Student;
import Lab5.packageLab5.Uchenik;

import java.util.*;

public class Lab5_ {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Shkolnik> shkolniks = new ArrayList<>();
        Student student = creatStudentLab(1);
        for (int i = 0; i < 2; i++) {
            students.add(creatStudentLab(i));
        }
        for (int i = 0; i < 2; i++) {
            shkolniks.add(creatShkolnikLab(i));
        }
//        while (true) {//ручной ввод
//            System.out.println("Введите кого хотите создать?\nШкольник\nСтудент");
//            String result = scanner.next();
//            if (result.equalsIgnoreCase("Школьник")) shkolniks.add(creatShkolnik(scanner));
//            if (result.equalsIgnoreCase("Студент")) students.add(creatStudent(scanner));
//            if (result.equalsIgnoreCase("выход")) break;
//        }

        Shkolnik.printGirlsWithFirstPlace(shkolniks);
        Student.printStudentsWithCourseworkGrades(students);
        Uchenik.printSpecialScholarshipRecipients(shkolniks, students);
    }


    public static Student creatStudentLab(int count) {
        Random random = new Random();
        HashMap<String, Integer> assessmentsStudents = new HashMap<>();
        HashMap<String, Integer> termPapersStudents = new HashMap<>();
        assessmentsStudents.put("Философия", random.nextInt(2, 6));
        assessmentsStudents.put("Математический анализ", random.nextInt(2, 6));
        assessmentsStudents.put("Языки программирования и методы трансляции", random.nextInt(2, 6));
        assessmentsStudents.put("Архитектура компьютеров", random.nextInt(2, 6));
        termPapersStudents.put("Курсовая по \"Архитектура компьютеров\"", random.nextInt(2, 6));
        termPapersStudents.put("Курсовая по \"Дифференциальным уравнениям \"", random.nextInt(2, 6));
        termPapersStudents.put("Курсовая по \"Математическому аналиу\"", random.nextInt(2, 6));
        return new Student("Student" + String.valueOf(count), "-", random.nextInt(18, 30), assessmentsStudents, termPapersStudents);
    }

    public static Student creatStudent(Scanner scanner) {
        System.out.println("Введите через пробел: имя,пол,возраст");
        scanner.nextLine();
        String line = scanner.nextLine();
        String[] dataStudent = line.split("\\s+");
        Student student = new Student(dataStudent[0], dataStudent[1], Integer.parseInt(dataStudent[2]));
        System.out.println("Хотите заполнить информацию об успеваемости?\nДа\nНет");
        String result = scanner.next();
        if (result.equalsIgnoreCase("да")) {
            for (Map.Entry<String, Integer> assessments : student.getAssessments().entrySet()) {
                System.out.printf("Введите оценку за %s:\n", assessments.getKey());
                int score = scanner.nextInt();
                student.setAssessments(assessments.getKey(), score);
            }
        }
        System.out.println("Хотите заполнить информацию об успеваемости по курсовым работам?\nДа\nНет");
        result = scanner.next();
        if (result.equalsIgnoreCase("нет"))
            return student;
        if (result.equalsIgnoreCase("да")) {
            for (Map.Entry<String, Integer> assessments : student.getTermPapers().entrySet()) {
                System.out.printf("Введите оценку за %s:\n", assessments.getKey());
                int score = scanner.nextInt();
                student.setAssessments(assessments.getKey(), score);
            }
        }
        return student;
    }

    public static Shkolnik creatShkolnik(Scanner scanner) {
        System.out.println("Введите через пробел: имя,пол,возраст");
        scanner.nextLine();
        String line = scanner.nextLine();
        String[] dataStudent = line.split("\\s+");
        Shkolnik shkolnik = new Shkolnik(dataStudent[0], dataStudent[1], Integer.parseInt(dataStudent[2]));
        System.out.println("Хотите заполнить информацию об успеваемости?\nДа\nНет");
        String result = scanner.next();
        if (result.equalsIgnoreCase("да")) {
            for (Map.Entry<String, Integer> assessments : shkolnik.getAssessments().entrySet()) {
                System.out.printf("Введите оценку за %s:\n", assessments.getKey());
                int score = scanner.nextInt();
                shkolnik.setAssessments(assessments.getKey(), score);
            }
        }
        System.out.println("Хотите заполнить информацию о достижениях?\nДа\nНет");
        result = scanner.next();
        if (result.equalsIgnoreCase("нет"))
            return shkolnik;
        if (result.equalsIgnoreCase("да")) {
            System.out.println("Вы участвовали в областной олимпиаде?");
            shkolnik.setParticipatedInRegionalOlympiad(scanner.next().equalsIgnoreCase("да"));
            System.out.println("У вас есть первые места в школьной олимпиаде?");
            shkolnik.setFirstPlaceAtSchoolOlympiad(scanner.next().equalsIgnoreCase("да"));
            System.out.println("Вы призёр городской олимпиады?");
            shkolnik.setPrizeWinnerInCityOlympiad(scanner.next().equalsIgnoreCase("да"));
        }
        return shkolnik;
    }

    public static Shkolnik creatShkolnikLab(int count) {
        Random random = new Random();
        HashMap<String, Integer> assessmentsShkolnik = new HashMap<>();
        assessmentsShkolnik.put("Математика", random.nextInt(2, 6));
        assessmentsShkolnik.put("Русский язык", random.nextInt(2, 6));
        assessmentsShkolnik.put("История", random.nextInt(2, 6));
        assessmentsShkolnik.put("Английский язык", random.nextInt(2, 6));
        assessmentsShkolnik.put("Биология", random.nextInt(2, 6));
        assessmentsShkolnik.put("Физика", random.nextInt(2, 6));
        boolean participatedInRegionalOlympiad = (random.nextInt(0, 2) == 1);
        boolean firstPlaceAtSchoolOlympiad = (random.nextInt(0, 2) == 1);
        boolean prizeWinnerInCityOlympiad = (random.nextInt(0, 2) == 1);
        return new Shkolnik("Shkolnik" + String.valueOf(count), "-", random.nextInt(7, 19), assessmentsShkolnik, participatedInRegionalOlympiad
                , firstPlaceAtSchoolOlympiad, prizeWinnerInCityOlympiad);
    }
}
