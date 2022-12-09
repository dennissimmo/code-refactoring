package edu.pro;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SalaryUtil {
    public static int getTotalSalary(List<Worker> workers) {
        int totalSalary = workers.stream().mapToInt(worker -> worker.getSalary()).sum();
        return totalSalary;
    }

    public static MinMax getMinMaxSalary(List<Worker> workers) {
        List<Integer> salaries = workers.stream()
                .mapToInt(worker -> worker.getSalary())
                .boxed()
                .collect(Collectors.toList());
        salaries.sort(Comparator.comparingInt(Integer::intValue));
        MinMax salaryRange = new MinMax(salaries.get(0), salaries.get(salaries.size() - 1));
        return salaryRange;
    }

    public static double getAverageSalary(List<Worker> workers) {
        int totalSalary = getTotalSalary(workers);
        double averageSalary = (double)totalSalary / workers.size();
        return averageSalary;
    }
}
