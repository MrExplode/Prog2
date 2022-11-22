package me.sunstorm.prog2.lesson12.service.csv;

import lombok.AllArgsConstructor;
import me.sunstorm.prog2.lesson12.domain.SalaryInformation;

import java.io.IOError;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class SalaryCsvReaderImpl implements SalaryCsvReader {
    private final Path csvPath;
    @Override
    public List<SalaryInformation> readSalariesFromCSV() {
        try {
            List<String> lines = Files.readAllLines(csvPath);
            List<SalaryInformation> results = new ArrayList<>();
            lines.forEach(l -> {
                if (l.startsWith("Department,Department Name,")) return;
                var data = correctSplit(l, ',');
                 results.add(new SalaryInformation(
                        data.get(0),
                        data.get(1),
                        data.get(2),
                        data.get(3).charAt(0),
                        Double.parseDouble(data.get(4)),
                        data.get(5))
                );
            });
            return results;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeSalaryInformationToFile(List<SalaryInformation> salaryInformationList) {
        throw new UnsupportedOperationException("write operations not supported");
    }

    @Override
    public void writeSalaryInformationToFile(SalaryInformation salaryInformation) {
        throw new UnsupportedOperationException("write operations not supported");
    }

    // don't look up performance on this shit
    private List<String> correctSplit(String line, char separator) {
        boolean inExclude = false;
        var builder = new StringBuilder();
        List<String> result = new ArrayList<>();
        for (char c : line.toCharArray()) {
            if (c == '"') {
                inExclude = !inExclude;
            }
            if (!inExclude && c == separator) {
                result.add(builder.toString());
                builder = new StringBuilder();
            } else {
                builder.append(c);
            }
        }
        result.add(builder.toString());
        return result;
    }
}
