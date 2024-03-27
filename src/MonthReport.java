import java.util.HashMap;

public class MonthReport {

    void mReport() {
        for (String monthAll : ScanMonths.dataToMonth.keySet()) {
            System.out.println();
            System.out.println("Месяц  " + monthAll);
            Double maxProfitCost = 0.0; // объявил переменные для товара с большим ждохода
            String maxProfitName = "";
            String maxWasteName = "";   // объявил переменные для товара с большей тратой
            Double maxWasteCost = 0.0;
            HashMap<String, HashMap<String, Double>> cur = MonthData.fullMonth.get(monthAll);
            for (String itemsName : cur.keySet()) {
                HashMap<String, Double> allSpend = cur.get(itemsName);
                for (String arrived : allSpend.keySet()) {
                    Double value = allSpend.get(arrived);
                    if (arrived.equalsIgnoreCase("false")) {
                        Double temporaryPriceMax = Math.max(value, maxProfitCost);
                        if (value > maxProfitCost) {
                            maxProfitName = itemsName;
                            maxProfitCost = temporaryPriceMax;
                        }
                    } else {
                        Double temporaryPriceMin = Math.max(value, maxWasteCost);
                        if (value > maxWasteCost) {
                            maxWasteName = itemsName;
                            maxWasteCost = temporaryPriceMin;
                        }
                    }
                }
            }
            System.out.println("Самый прибыльный товар <<<" + maxProfitName + ">>>  стоимость:  " + maxProfitCost);
            //System.out.println("");
            System.out.println("Самая большая трата <<<" + maxWasteName + ">>>  стоимость:  " + maxWasteCost);
            System.out.println(); // для отступа
        }
    }
}
