package IZ1;

public class Expenses {
    private String expenseType; // тип трат
    private String productOrService; // продукт/услуга
    private double cost; // стоимость

    public Expenses(String[] data) {
        this.expenseType = data[0];
        this.productOrService = data[1];
        setCost(Integer.parseInt(data[2]));
    }

    //геттеры
    public String getExpenseType() {
        return expenseType;
    }

    public String getProductOrService() {
        return productOrService;
    }

    public double getCost() {
        return cost;
    }

    //сеттеры
    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public void setProductOrService(String productOrService) {
        this.productOrService = productOrService;
    }

    public void setCost(double cost) {
        if (cost < 0) throw new IllegalArgumentException("Траты не могут быть отрицательными");
        this.cost = cost;
    }
}
