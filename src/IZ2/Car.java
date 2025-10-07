package IZ2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Car {
    private double price; // Цена автомобиля 2
    private int yearOfManufacture;// Год выпуска автомобиля 5
    private String condition;// Техническое состояние автомобиля 6
    private double mileageInMiles; // Количество миль, пройденных автомобилем 7
    private String color;  // Цвет автомобиля 8

    public Car(ArrayList<String> data) {
        setPrice(Double.parseDouble(data.getFirst()));
        setYearOfManufacture(Integer.parseInt(data.get(1)));
        this.condition = data.get(2);
        setMileageInMiles(Double.parseDouble(data.get(3)));
        this.color = data.getLast();
    }

    //Сетеры
    public void setColor(String color) {
        this.color = color;
    }

    public void setMileageInMiles(double mileageInMiles) {
        if (0 > mileageInMiles) throw new IllegalArgumentException("Пробег не может быть отрицательным");
        this.mileageInMiles = mileageInMiles;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        if (0 > yearOfManufacture) throw new IllegalArgumentException("Год не может быть отрицательным");
        this.yearOfManufacture = yearOfManufacture;
    }

    public void setPrice(double price) {
        if (0 > price) throw new IllegalArgumentException("Цена не может быть отрицательным");
        this.price = price;
    }

    //Геттеры
    public String getColor() {
        return color;
    }

    public double getMileageInMiles() {
        return mileageInMiles;
    }

    public String getCondition() {
        return condition;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public double getPrice() {
        return price;
    }

    public static void printstatistic(ArrayList<Car> cars) {
        TreeSet<Integer> years = cars.stream().map(Car::getYearOfManufacture).
                collect(Collectors.toCollection(TreeSet::new));
        System.out.print("Год    Средняя цена\tМинимальная цена\tМаксимальная цена\t" +
                "Самый часто встречающийся цвет автомобилей\tКоличество автомобилей в состоянии clean vehicle\t" +
                "Количество автомобилей в состоянии salvage insurance\tСредний пробег в километрах\n");
        for (Integer year : years) {
            System.out.printf("%-5d\t%-15.2f\t%-15.2f\t%-30.2f\t%-40s\t%-65d\t%-35d\t%.2f\n", year, getAveragePrice(cars, year),
                    getMinimumPrice(cars, year),
                    getMaximumPrice(cars, year),
                    getMostCommonColor(cars, year),
                    getCleanVehicleCount(cars, year),
                    getSalvageInsuranceCount(cars, year),
                    getAverageMileage(cars, year));
        }

    }

    public static void writtestatistic(ArrayList<Car> cars, String path) {
        TreeSet<Integer> years = cars.stream().map(Car::getYearOfManufacture).
                collect(Collectors.toCollection(TreeSet::new));
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write("Год    Средняя цена\tМинимальная цена\tМаксимальная цена\t" +
                    "Самый часто встречающийся цвет автомобилей\tКоличество автомобилей в состоянии clean vehicle\t" +
                    "Количество автомобилей в состоянии salvage insurance\tСредний пробег в километрах\n");
            for (Integer year : years) {
                String line = String.format("%-5d\t%-15.2f\t%-15.2f\t%-30.2f\t%-40s\t%-65d\t%-35d\t%.2f\n",
                        year, getAveragePrice(cars, year),
                        getMinimumPrice(cars, year),
                        getMaximumPrice(cars, year),
                        getMostCommonColor(cars, year),
                        getCleanVehicleCount(cars, year),
                        getSalvageInsuranceCount(cars, year),
                        getAverageMileage(cars, year));
                writer.write(line);
            }
        } catch (IOException e) {
            System.err.println("\"Ошибка ввода-вывода при обработке файла.\n" + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static double getAveragePrice(ArrayList<Car> cars, int year) {//Средняя цена:
        return cars.stream().filter(car -> car.getYearOfManufacture() == year).mapToDouble(Car::getPrice).average()
                .orElse(0.0);
    }

    private static double getMinimumPrice(ArrayList<Car> cars, int year) {//Минимальная цена:
        return cars.stream().filter(car -> car.getYearOfManufacture() == year).mapToDouble(Car::getPrice).min()
                .orElse(Integer.MIN_VALUE);
    }

    private static double getMaximumPrice(ArrayList<Car> cars, int year) {//Максимальная цена:
        return cars.stream().filter(car -> car.getYearOfManufacture() == year).mapToDouble(Car::getPrice).max()
                .orElse(Integer.MAX_VALUE);
    }

    private static String getMostCommonColor(ArrayList<Car> cars, int year) {
        TreeSet<String> color = cars.stream().filter(car -> car.getYearOfManufacture() == year).
                map(Car::getColor).collect(Collectors.toCollection(TreeSet::new));

        long maxCount = 0;
        String resultColor = "";
        for (String thisColor : color) {
            long curCount = cars.stream().filter(car -> car.getYearOfManufacture() == year && car.getColor().equals(thisColor)).count();
            if (maxCount < curCount) {
                maxCount = curCount;
                resultColor = thisColor;
            }
        }
        return resultColor;
    }

    private static long getCleanVehicleCount(ArrayList<Car> cars, int year) {// Количество автомобилей в состоянии clean vehicle:
        return cars.stream().filter(car -> car.getYearOfManufacture() == year && car.getCondition()
                .equals("clean vehicle")).count();
    }

    private static long getSalvageInsuranceCount(ArrayList<Car> cars, int year) {// Количество автомобилей в состоянии salvage insurance
        return cars.stream().filter(car -> car.getYearOfManufacture() == year && car.getCondition()
                .equals("salvage insurance")).count();
    }

    private static double getAverageMileage(ArrayList<Car> cars, int year) {//Средний пробег в километрах
        return cars.stream().filter(car -> car.getYearOfManufacture() == year).mapToDouble(Car::getMileageInMiles)
                .average().orElse(0.0) * 1.609344;
    }

}

