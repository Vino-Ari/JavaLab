package IZ2;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(""))) {
            while (reader.readLine() != null) {
                ArrayList<String> data = new ArrayList<>();
                for (int i = 0; i < 9; i++) {
                    if (i == 1 || i == 2 || i == 7 || i == 8) {
                        reader.readLine();
                        continue;
                    }
                    data.add(reader.readLine());
                }
                cars.add(new Car(data));
            }
        } catch (IOException e) {
            System.err.println("\"Ошибка ввода-вывода при обработке файла.\n" + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Car.printstatistic((cars));
        String path = "";
        Car.writtestatistic(cars, path);

    }
}
