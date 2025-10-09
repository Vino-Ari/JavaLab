package IZ2;

import java.util.ArrayList;

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
}

