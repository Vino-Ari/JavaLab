package IZ2;

import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Car> cars = ManagerCar.readCar("");
            ManagerCar.printstatistic(cars);
            ManagerCar.writtestatistic(cars, "");
        } catch (IOException e) {
            System.err.println("\"Ошибка ввода-вывода при обработке файла.\n" + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
