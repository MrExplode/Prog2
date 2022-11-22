package me.sunstorm.prog2.lesson12.service.csv;

import me.sunstorm.prog2.lesson12.domain.SalaryInformation;

import java.util.List;

public interface SalaryCsvReader {

    List<SalaryInformation> readSalariesFromCSV();
    void writeSalaryInformationToFile(List<SalaryInformation> salaryInformationList);
    void writeSalaryInformationToFile(SalaryInformation salaryInformation);
}
