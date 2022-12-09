package edu.pro;

public class FullTimeWorker extends Worker {
    private int salary;

    public FullTimeWorker(String name, int salary) {
        super(name);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
