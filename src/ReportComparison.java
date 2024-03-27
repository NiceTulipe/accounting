import java.util.HashMap;

public class ReportComparison {

    public void rComparison() {

        for (Integer month : YearData.monthOfSpending.keySet()) {  // номер месяца
            String nameMonth = DataReader.nameOfMonths(month); // преобразуем номер в название месяцев
            HashMap<String, Double> yArrived = YearData.monthOfSpending.get(month);
            MonthData mData = ScanMonths.dataToMonth.get(nameMonth);
            Double sumSpendMonth = 0.0; // вводим переменные для фиксации расходов доходов за месяц
            Double sumIncomeMonth = 0.0;
            Double sumSpendYear = 0.0; // вводим переменные для фиксации расходов доходов за год
            Double sumIncomeYear = 0.0;
            for (String itemName : mData.allDataWithItems.keySet()) {
                HashMap<String, Double> mapArrived = mData.allDataWithItems.get(itemName);
                for (String arrived : mapArrived.keySet()) {    // длимнными путями приходим к нужной мапе с хранением части суммы и " + " или " - "
                    if (arrived.equalsIgnoreCase("true")) {   // расщипление  данных на доход и расход
                        sumSpendMonth += mapArrived.get(arrived);
                        sumSpendYear = yArrived.get(arrived);
                    } else {
                        sumIncomeMonth += mapArrived.get(arrived);
                        sumIncomeYear = yArrived.get(arrived);
                    }
                }
            }
           /*System.out.println(sumSpendMonth);             Для проверки обрабатываемых данных
            System.out.println(sumIncomeMonth);
            System.out.println(sumSpendYear);
            System.out.println(sumIncomeYear); */
            boolean comparsionIncome = Math.abs(sumIncomeYear - sumIncomeMonth) < 0.01; // тип Double иначе не сравнивается  ;)
            boolean comparsionSpend = Math.abs(sumSpendYear - sumSpendMonth) < 0.01;
            if ( comparsionIncome && comparsionSpend)
            {
                System.out.println("Операция сравнение за месяц <<" + nameMonth + ">> успешно завершена, расхождений не обнаружено");
            } else {
                System.out.println("Обнаружены ошибки в <<" + nameMonth +">>");
            }
        }


    }
}
