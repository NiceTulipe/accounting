import java.util.HashMap;


public class YearData {

    public String year;
    public int order;
    public int month;
     public static HashMap<Integer, HashMap<String, Double>> monthOfSpending = new HashMap<>();
    public YearData(String year, int order) {
        this.year = year;
        this.order = order;
    }
    public void addMonthOfSpending(Integer month, String isExpense, Double money ) {
        HashMap<String, Double> wasteOfMoney = new HashMap<>();
        if (monthOfSpending.get(month) != null) {

            monthOfSpending.get(month).put(isExpense, money);
        }
        else {
            wasteOfMoney.put(isExpense, money);
            monthOfSpending.put(month, wasteOfMoney);
        }
    }
}

