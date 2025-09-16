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
        while (true) {//ручной ввод
            System.out.println("Введите кого хотите создать?\nШкольник\nСтудент");
            String result = scanner.next();
            if (result.equalsIgnoreCase("Школьник")) shkolniks.add(creatShkolnik(scanner));
            if (result.equalsIgnoreCase("Студент")) students.add(creatStudent(scanner));
            if (result.equalsIgnoreCase("выход")) break;
        }
//        printGirlsWithFirstPlace(shkolniks);//рандом ввод
//        printStudentsWithCourseworkGrades(students);
        printSpecialScholarshipRecipients(shkolniks, students);
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

    public static void printGirlsWithFirstPlace(ArrayList<Shkolnik> shkolniks) {
        shkolniks.removeIf(shkolnik -> (shkolnik.getGender().equals("m") || !(shkolnik.isParticipatedInRegionalOlympiad()
                || shkolnik.isFirstPlaceAtSchoolOlympiad() || shkolnik.isPrizeWinnerInCityOlympiad())));
        System.out.println(shkolniks.toString());
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
