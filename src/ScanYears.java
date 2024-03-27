import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class ScanYears {
    public static HashMap<String, YearData> dataToYear = new HashMap<>();

    public static void scanningYear(String year, String path) {
        String content = readFileContentsOrNull(path);
        if (content == null) {
            return;
        }
        String[] lines = content.split("\r?\n");
        YearData yearData = new YearData(year, dataToYear.size() + 1);
        for (int i = 1; i < lines.length; i++) {
            String[] parts = lines[i].split(",");
            Boolean isExpense = Boolean.valueOf(parts[2]);
            Integer month = Integer.parseInt(parts[0]);
            Double money = Double.parseDouble(parts[1]);
            yearData.addMonthOfSpending(month, String.valueOf(isExpense), money);
        }
        dataToYear.put(year, yearData);

    }

    private static String readFileContentsOrNull(String path) {
        try {
            return Files.readString(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно, файл не находится в нужной директории.");
            return null;
        }
    }
}

