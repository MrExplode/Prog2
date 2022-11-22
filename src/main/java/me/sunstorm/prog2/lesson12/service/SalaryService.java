package me.sunstorm.prog2.lesson12.service;

import me.sunstorm.prog2.lesson12.SalaryServiceImpl;
import me.sunstorm.prog2.lesson12.domain.SalaryInformation;

import java.util.List;
import java.util.Map;

public interface SalaryService {

    static SalaryService getService() {
        return new SalaryServiceImpl();
    }

    String findDepartmentNameWithHighestBaseSalaryForMales();
    List<SalaryInformation> findSalaryInformationForTheGivenGenderInTheGivenDepartment(String department, char gender);
    Map<String, Double> calculateAverageSalaryForDepartments();
    String findTheNameOfTheDepartmentThatPaysTheMostForAdministration();
    SalaryInformation findHighestBaseSalary();
    Map<Character, Double> getHighestSalaryForGenders();
    String findDivisionWithHighestSalaryInCaseOfPolice();
    String findDepartmentNameWithHighestSalaryInCaseOfAdministrations();
}
