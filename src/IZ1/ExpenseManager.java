package IZ1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public abstract class ExpenseManager {
    public static HashMap<String, Double> readPlan(String path) throws IOException,
            NumberFormatException {
        HashMap<String, Double> plan = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] s = line.split("\\s+");
                plan.put(s[0], Double.valueOf(s[1]));
            }
        }
        if (plan.size() > 5) throw new IllegalArgumentException("Слишком много данных в файле");
        if (plan.size() < 5) throw new IllegalArgumentException("Недостаточно данных в файле");
        return plan;
    }

    public static ArrayList<Expenses> readExpenses(String path) throws IOException,
            NumberFormatException {
        ArrayList<Expenses> expenses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\s+");
                try {
                    expenses.add(new Expenses(data));
                } catch (IllegalArgumentException e) {
                    System.err.println("Ошибка при чтении строки");
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }
        return expenses;
    }

    public static void statistic(HashMap<String, Double> plan, ArrayList<Expenses> expenses) {
        System.out.println("Тип расходов\tЗапланированая трата\tРеальная трата\tПроцент выполнения плана");
        for (String expenseType : plan.keySet()) {
            System.out.printf("%-25s%-17.2f%-20.2f%s\n", expenseType, plan.get(expenseType),
                    getActualExpense(expenseType, expenses), percentage(plan.get(expenseType), getActualExpense(expenseType, expenses)));
            if (isVailedStatic(plan, expenseType, expenses)) {
                System.out.printf("Все траты за категорию '%s' (в убывающем порядке): %s\n", expenseType, sortCost(expenses, expenseType));
            }
        }
    }

    private static String sortCost(ArrayList<Expenses> expenses, String expenseType) {
        List<String> sortedProducts = expenses.stream()
                .filter(e -> e.getExpenseType().equals(expenseType))
                .sorted(Comparator.comparingDouble(Expenses::getCost))
                .map(Expenses::getProductOrService).toList();

        return String.join(", ", sortedProducts);
    }

    private static boolean isVailedStatic(HashMap<String, Double> plan, String expenseType, ArrayList<Expenses> expenses) {
        return ((plan.get(expenseType) - getActualExpense(expenseType, expenses)) < 0);
    }

    private static double getActualExpense(String expenseType, ArrayList<Expenses> expenses) {
        return expenses.stream().filter(type -> type.getExpenseType().equals(expenseType))
                .mapToDouble(Expenses::getCost).sum();
    }

    private static String percentage(double plan, double actual) {
        if (plan == actual) return "100%";
        if (plan - actual < 0) return "план не выполнен смотрите статистику ниже";
        return (actual / plan) * 100 + "%";
    }
}
