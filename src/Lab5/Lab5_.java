package Lab5;

import Lab5.packageLab5.Shkolnik;
import Lab5.packageLab5.Student;
import Lab5.packageLab5.Uchenik;

import java.util.*;

public class Lab5_ {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Shkolnik> shkolniks = new ArrayList<>();
//        for (int i = 0; i < 2; i++) {
//            students.add(creatStudentLab(i));
//        }
//        for (int i = 0; i < 2; i++) {
//            shkolniks.add(creatShkolnikLab(i));
//        }
        while (true) {//ручной ввод
            System.out.println("Введите кого хотите создать?\nШкольник\nСтудент");
            String result = scanner.next();
            if (result.equalsIgnoreCase("Школьник")) shkolniks.add(creatShkolnik(scanner));
            if (result.equalsIgnoreCase("Студент")) students.add(creatStudent(scanner));
            if (result.equalsIgnoreCase("выход")) break;
        }
        scanner.close();
        System.out.println(students.toString());
//        Shkolnik.printGirlsWithFirstPlace(shkolniks);
//        Student.printStudentsWithCourseworkGrades(students);
//        Uchenik.printSpecialScholarshipRecipients(shkolniks, students);
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
        return new Student("Student" + String.valueOf(count), "Surname" + String.valueOf(count), "-", random.nextInt(18, 30), assessmentsStudents, termPapersStudents);
    }

    public static Student creatStudent(Scanner scanner) {
        Student student = new Student();
        boolean valid = false;
        //Имя
        while (!valid) {
            try {
                System.out.println("Введите Имя:");
                student.setName(scanner.next());
                valid = true;
            } catch (IllegalArgumentException e) {
                scanner.nextLine();
                System.err.println(e.getMessage());
            }
        }
        valid = false;
        //Фамилия
        while (!valid) {
            try {
                System.out.println("Введите Фамилию:");
                student.setSurname(scanner.next());
                valid = true;
            } catch (IllegalArgumentException e) {
                scanner.nextLine();
                System.err.println(e.getMessage());
            }
        }
        valid = false;
        //Возраст
        while (!valid) {
            try {
                System.out.println("Введите возраст:");
                student.setAge(scanner.nextInt());
                valid = true;
            } catch (IllegalArgumentException e) {
                scanner.nextLine();
                System.err.println(e.getMessage());
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.err.println("Введите число");
            }
        }
        System.out.println("Введите гендр:");
        student.setGender(scanner.next());
        valid = false;
        // оценки
        while (!valid) {
            System.out.println("Хотите заполнить информацию об успеваемости?\nДа\nНет");
            String result = scanner.next();
            if (result.equalsIgnoreCase("да")) {
                for (Map.Entry<String, Integer> assessments : student.getAssessments().entrySet()) {
                    valid = false;
                    while (!valid) {
                        try {
                            System.out.printf("Введите оценку за %s:\n", assessments.getKey());
                            int score = scanner.nextInt();
                            student.setAssessments(assessments.getKey(), score);
                            valid = true;
                        } catch (IllegalArgumentException e) {
                            scanner.nextLine();
                            System.err.println(e.getMessage());
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.err.println("Введите число");
                        }
                    }
                }
            } else if (result.equalsIgnoreCase("нет")) break;
            else {
                System.err.println("Такого варианта ответа нет");
            }
        }
        valid = false;
        // курсовые
        while (!valid) {
            System.out.println("Хотите заполнить информацию об успеваемости по курсовым работам?\nДа\nНет");
            String result = scanner.next();
            if (result.equalsIgnoreCase("нет"))
                return student;
            if (result.equalsIgnoreCase("да")) {
                for (Map.Entry<String, Integer> assessments : student.getTermPapers().entrySet()) {
                    boolean valid1 = false;
                    while (!valid1) {
                        try {
                            System.out.printf("Введите оценку за %s:\n", assessments.getKey());
                            int score = scanner.nextInt();
                            student.setTermPapers(assessments.getKey(), score);
                            valid1 = true;
                        } catch (IllegalArgumentException e) {
                            scanner.nextLine();
                            System.err.println(e.getMessage());
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.err.println("Введите число");
                        }
                    }
                }
            } else System.err.println("Такого варианта ответа нет");
            valid = true;
        }
        return student;
    }

    public static Shkolnik creatShkolnik(Scanner scanner) {
        Shkolnik shkolnik = new Shkolnik();
        boolean valid = false;
        //Имя
        while (!valid) {
            try {
                System.out.println("Введите Имя:");
                shkolnik.setName(scanner.next());
                valid = true;
            } catch (IllegalArgumentException e) {
                scanner.nextLine();
                System.err.println(e.getMessage());
            }
        }
        valid = false;
        //Фамилия
        while (!valid) {
            try {
                System.out.println("Введите Фамилию:");
                shkolnik.setSurname(scanner.next());
                valid = true;
            } catch (IllegalArgumentException e) {
                scanner.nextLine();
                System.err.println(e.getMessage());
            }
        }
        valid = false;
        //Возраст
        while (!valid) {
            try {
                System.out.println("Введите возраст:");
                shkolnik.setAge(scanner.nextInt());
                valid = true;
            } catch (IllegalArgumentException e) {
                scanner.nextLine();
                System.err.println(e.getMessage());
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.err.println("Введите число");
            }
        }
        System.out.println("Введите гендр:");
        shkolnik.setGender(scanner.next());
        valid = false;
        // оценки
        while (!valid) {
            System.out.println("Хотите заполнить информацию об успеваемости?\nДа\nНет");
            String result = scanner.next();
            if (result.equalsIgnoreCase("да")) {
                for (Map.Entry<String, Integer> assessments : shkolnik.getAssessments().entrySet()) {
                    valid = false;
                    while (!valid) {
                        try {
                            System.out.printf("Введите оценку за %s:\n", assessments.getKey());
                            int score = scanner.nextInt();
                            shkolnik.setAssessments(assessments.getKey(), score);
                            valid = true;
                        } catch (IllegalArgumentException e) {
                            scanner.nextLine();
                            System.err.println(e.getMessage());
                        } catch (InputMismatchException e) {
                            scanner.nextLine();
                            System.err.println("Введите число");
                        }
                    }
                }
            } else if (result.equalsIgnoreCase("нет")) break;
            else {
                System.err.println("Такого варианта ответа нет");
            }
        }
        valid = false;
        //достижения
        while (!valid) {
            System.out.println("Хотите заполнить информацию о достижениях?\nДа\nНет");
            String result = scanner.next();
            if (result.equalsIgnoreCase("нет"))
                return shkolnik;
            if (result.equalsIgnoreCase("да")) {
                shkolnik.setParticipatedInRegionalOlympiad(isHave("Вы участвовали в областной олимпиаде?", scanner));
                shkolnik.setFirstPlaceAtSchoolOlympiad(isHave("У вас есть первые места в школьной олимпиаде?", scanner));
                shkolnik.setPrizeWinnerInCityOlympiad(isHave("Вы призёр городской олимпиады?", scanner));
                valid = true;
            } else System.err.println("Такого варианта ответа нет");
        }
        return shkolnik;
    }

    public static boolean isHave(String text, Scanner scanner) {
        while (true) {
            System.out.println(text);
            String result = scanner.next();
            if (result.equalsIgnoreCase("да")) return true;
            if (result.equalsIgnoreCase("нет")) return false;
            else System.err.println("Такого варианта ответа нет");
        }
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
        return new Shkolnik("Shkolnik" + String.valueOf(count), " ", "-", random.nextInt(7, 19), assessmentsShkolnik, participatedInRegionalOlympiad
                , firstPlaceAtSchoolOlympiad, prizeWinnerInCityOlympiad);
    }
}
