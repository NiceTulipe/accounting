import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class ScanMonths {
    public static HashMap<String, MonthData> dataToMonth = new HashMap<>();

    public static void scanningMonth(String month, String path) {
        String content = readFileContentsOrNull(path);
        if (content == null) {
            return;
        }
            String[] lines = content.split("\r?\n");
            MonthData monthData = new MonthData(month, dataToMonth.size() + 1);
            for (int i = 1; i < lines.length; i++) {
                String[] parts = lines[i].split(",");
                String nameItem = parts[0];
                Boolean isExpense = Boolean.valueOf(parts[1]);
                Integer quantity = Integer.parseInt(parts[2]);
                Double sumOfOne = Double.parseDouble(parts[3]);
                Double spendingMoney = quantity * sumOfOne;
                monthData.addSpending(nameItem, String.valueOf(isExpense), spendingMoney);
            }
            dataToMonth.put(month, monthData);
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
