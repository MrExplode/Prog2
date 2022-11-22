package me.sunstorm.prog2.lesson12;

import me.sunstorm.prog2.lesson12.domain.SalaryInformation;
import me.sunstorm.prog2.lesson12.service.SalaryService;
import me.sunstorm.prog2.lesson12.service.provider.SalaryListProvider;

import java.util.*;
import java.util.stream.Collectors;

public class SalaryServiceImpl implements SalaryService {
    private final List<SalaryInformation> data;

    public SalaryServiceImpl() {
        data = new SalaryListProvider().get();
    }

    @Override
    public String findDepartmentNameWithHighestBaseSalaryForMales() {
        return data.stream()
                .filter(s -> s.getGender() == 'M')
                .max(Comparator.comparingDouble(SalaryInformation::getBaseSalary))
                .orElseThrow()
                .getDepartmentName();
    }

    @Override
    public List<SalaryInformation> findSalaryInformationForTheGivenGenderInTheGivenDepartment(String department, char gender) {
        return data.stream()
                .filter(s -> s.getDepartment().equals(department) && s.getGender() == gender)
                .toList();
    }

    @Override
    public Map<String, Double> calculateAverageSalaryForDepartments() {
        return data.stream()
                .collect(Collectors.groupingBy(SalaryInformation::getDepartment, Collectors.averagingDouble(SalaryInformation::getBaseSalary)));
    }

    @Override
    public String findTheNameOfTheDepartmentThatPaysTheMostForAdministration() {
        return data.stream()
                .filter(s -> s.getDivision().contains("Administration"))
                .collect(Collectors.groupingBy(SalaryInformation::getDepartment, Collectors.summarizingDouble(SalaryInformation::getBaseSalary)))
                .entrySet()
                .stream()
                .max(Comparator.comparingDouble(e -> e.getValue().getSum()))
                .get()
                .getKey();
    }

    @Override
    public SalaryInformation findHighestBaseSalary() {
        return data.stream()
                .max(Comparator.comparingDouble(SalaryInformation::getBaseSalary))
                .orElse(null);
    }

    @Override
    public Map<Character, Double> getHighestSalaryForGenders() {
        Map<Character, Double> result = new HashMap<>();
        result.put('M', data.stream().filter(s -> s.getGender() == 'M').max(Comparator.comparingDouble(SalaryInformation::getBaseSalary)).get().getBaseSalary());
        result.put('F', data.stream().filter(s -> s.getGender() == 'F').max(Comparator.comparingDouble(SalaryInformation::getBaseSalary)).get().getBaseSalary());
        return result;
    }

    @Override
    public String findDivisionWithHighestSalaryInCaseOfPolice() {
        return data.stream()
                .filter(s -> s.getDepartmentName().contains("Police"))
                .max(Comparator.comparingDouble(SalaryInformation::getBaseSalary))
                .get()
                .getDivision();
    }

    @Override
    public String findDepartmentNameWithHighestSalaryInCaseOfAdministrations() {
        return data.stream()
                .filter(s -> s.getDivision().contains("Administration"))
                .max(Comparator.comparingDouble(SalaryInformation::getBaseSalary))
                .get()
                .getDepartmentName();
    }
}
