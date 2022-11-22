package me.sunstorm.prog2.lesson12.service.provider;

import me.sunstorm.prog2.lesson12.domain.SalaryInformation;
import me.sunstorm.prog2.lesson12.service.csv.SalaryCsvReader;
import me.sunstorm.prog2.lesson12.service.csv.SalaryCsvReaderImpl;

import java.nio.file.Path;
import java.util.List;
import java.util.ServiceLoader;

public class SalaryListProvider implements ServiceLoader.Provider<List<SalaryInformation>> {

    private final SalaryCsvReader reader = new SalaryCsvReaderImpl(Path.of("src/main/resources/salary.csv"));

    @Override
    public Class<? extends List<SalaryInformation>> type() {
        return null;
    }

    @Override
    public List<SalaryInformation> get() {
        return reader.readSalariesFromCSV();
    }
}
