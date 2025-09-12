package Lab3;

public class Bus {
    private final int seatCount;
    private final double seatPrice;
    private int bookedSeats;

    public Bus() {
        this(0, 0.0, 0);
    }

    public Bus(Bus bus) {
        this(bus.seatCount, bus.seatPrice, bus.bookedSeats);
    }

    public Bus(int seatCount, double seatPrice) {
        if (seatCount < 0) throw new IllegalArgumentException("Количество мест должно быть >= 0");
        if (seatPrice < 0) throw new IllegalArgumentException("Цена должна быть >= 0");
        this.seatCount = seatCount;
        this.seatPrice = seatPrice;
        this.bookedSeats = 0;
    }

    public Bus(int seatCount, double seatPrice, int bookedSeats) {
        if (seatCount < 0) throw new IllegalArgumentException("Количество мест должно быть >= 0");
        if (seatPrice < 0) throw new IllegalArgumentException("Цена должна быть >= 0");
        if (bookedSeats < 0 || bookedSeats > seatCount)
            throw new IllegalArgumentException("Количество занятых мест должно быть в диапазоне 0.." + seatCount);
        this.seatCount = seatCount;
        this.seatPrice = seatPrice;
        this.bookedSeats = bookedSeats;
    }

    public int getSeatCount() {
        return seatCount;
    }

    public double getSeatPrice() {
        return seatPrice;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        if (bookedSeats < 0 || bookedSeats > seatCount)
            throw new IllegalArgumentException("Количество занятых мест должно быть в диапазоне 0.." + seatCount);
        this.bookedSeats = bookedSeats;
    }

    public int freeSeats() {
        return Math.max(seatCount - bookedSeats, 0);
    }

    public boolean isEmpty() {
        return bookedSeats == 0;
    }

    public boolean isFull() {
        return bookedSeats == seatCount;
    }

    public double getTotalOccupiedCost() {
        return bookedSeats * seatPrice;
    }

    public static boolean isCostEffective(Bus bus) {
        return bus.getTotalOccupiedCost() > 11000;
    }
}
