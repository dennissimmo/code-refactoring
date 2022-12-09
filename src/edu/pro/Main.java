package edu.pro;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Worker> fullTimeWorkers = initFullTimeWorkersList();
        List<Worker> partTimeWorkers = initPartTimeWorkersList();

        List<Worker> allWorkers = Stream.concat(fullTimeWorkers.stream(), partTimeWorkers.stream())
                .collect(Collectors.toList());

        int totalSalary = SalaryUtil.getTotalSalary(allWorkers);
        double averageSalary = SalaryUtil.getAverageSalary(allWorkers);
        // Get min max salary
        MinMax salariesRange = SalaryUtil.getMinMaxSalary(allWorkers);

        String output = buildOutput(totalSalary, averageSalary, salariesRange);
        System.out.println(output);
    }

    private static String buildOutput(int totalSalary, double averageSalary, MinMax salariesRange) {
        String output;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Total salary: ");
        stringBuilder.append(totalSalary);
        stringBuilder.append("\n");
        stringBuilder.append("Average salary: ");
        stringBuilder.append(String.format("%.2f", averageSalary));
        stringBuilder.append("\n");
        stringBuilder.append("Min salary: ");
        stringBuilder.append(salariesRange.getMin());
        stringBuilder.append("\n");
        stringBuilder.append("Max salary: ");
        stringBuilder.append(salariesRange.getMax());
        stringBuilder.append("\n");
        output = stringBuilder.toString();
        return output;
    }

    private static List<Worker> initPartTimeWorkersList() {
        Worker george = new PartTimeWorker("george", 8, 100);
        Worker ringo = new PartTimeWorker("ringo", 8, 111);

        List<Worker> parTimeWorkers = new ArrayList<>();
        parTimeWorkers.add(george);
        parTimeWorkers.add(ringo);
        return parTimeWorkers;
    }

    private static List<Worker> initFullTimeWorkersList() {
        Worker john = new FullTimeWorker("john",1200);
        Worker paul = new FullTimeWorker("paul",1500);

        List<Worker> fullTimeWorkers = new ArrayList<>();
        fullTimeWorkers.add(john);
        fullTimeWorkers.add(paul);
        return fullTimeWorkers;
    }

}
