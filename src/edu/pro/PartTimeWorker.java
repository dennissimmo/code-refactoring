package edu.pro;

public class PartTimeWorker extends Worker {
    private int rate;
    private int hours;

    public PartTimeWorker(String name, int rate, int hours) {
        super(name);
        this.rate = rate;
        this.hours = hours;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public int getSalary() {
        return this.rate * this.hours;
    }
}
