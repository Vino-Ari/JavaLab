package IZ1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        try {
            HashMap<String, Double> plan = ExpenseManager.readPlan("");
            ArrayList<Expenses> expenses = ExpenseManager.readExpenses("");
            ExpenseManager.statistic(plan, expenses);
        } catch (IOException e) {
            System.err.println("Ошибка ввода-вывода при чтении файла:" + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Некорректный формат данных в файле. " + e.getMessage() + " Проверьте правильность числового формата значений.");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage() + "\nПроверьте данные файла");
        } catch (Exception e) {
            System.err.println("Непредвиденная ошибка: " + e.getMessage() + ". Попробуйте перезапустить программу или обратитесь к разработчику.");
        }

    }
}
