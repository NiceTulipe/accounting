
import java.util.HashMap;


public class MonthData {

    public String month;
    public int order;
    public static HashMap<String, HashMap<String, HashMap<String, Double>>>  fullMonth = new HashMap<>();
    HashMap<String, HashMap<String, Double>>  allDataWithItems = new HashMap<>();
    public MonthData(String month, int order) {
        this.month = month;
        this.order = order;
    }
    public void addSpending(String Item, String isExpense, Double money) {

        HashMap<String, Double> wasteOfMoney = new HashMap<>();
            wasteOfMoney.put(isExpense, money);
        allDataWithItems.put(Item, wasteOfMoney);
        fullMonth.put(month, allDataWithItems);
    }

}




