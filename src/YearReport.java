import java.util.HashMap;

public class YearReport {


    void yReport() {
        for (String yearAll : ScanYears.dataToYear.keySet()) {
            Double profit = 0.0;
            Double spend = 0.0;
            Double cleanProfit = 0.0;           // Чистая прибыль
            Double averageIncome = 0.0;         // Средний доход за все месяцы в году
            Double sumIncome = 0.0;             // Сумма доходов за месяцы
            Double averageSpending = 0.0;       // Средний расход за все месяцы в году
            Double sumSpending = 0.0;           // Сумма расходов за месяцы
            System.out.println("<<" + yearAll + ">>");
            YearData cur = ScanYears.dataToYear.get(yearAll);
            for (Integer monthNumb : cur.monthOfSpending.keySet()) {
                System.out.println();
                String nameMonth = DataReader.nameOfMonths(monthNumb);
                System.out.println("Отчет за " + nameMonth);
                HashMap<String, Double> mapForMoney = cur.monthOfSpending.get(monthNumb);
                for (String arrived : mapForMoney.keySet()) {
                    if (arrived.equalsIgnoreCase("true")) {
                        System.out.print("Траты");
                        spend = mapForMoney.get(arrived);
                        sumSpending += spend;
                    } else {
                        System.out.print("Доход");
                        profit = mapForMoney.get(arrived);
                        sumIncome += profit;
                    }
                    cleanProfit = profit - spend;       // чистая прибыль доходы - расходы
                    System.out.println("  " + mapForMoney.get(arrived));
                }
                System.out.println("Прибыль составила:  <<<" + cleanProfit + ">>>");
            }
            averageIncome = sumIncome / cur.monthOfSpending.size(); // получаем среднее путем деления суммы на размер мапы
            averageSpending = sumSpending / cur.monthOfSpending.size();
        System.out.println("Средний доход за все месяцы в году <<<" + Math.floor(averageIncome)  + ">>>");
            System.out.println("Средний расход за все месяцы в году <<<" + Math.floor(averageSpending) + ">>>");
            System.out.println(); // для отступа
        }
    }
}
