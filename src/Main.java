
import java.util.Scanner;

public class Main {

    public static void main(String[] args) { // проблемы  с пушем
        DataReader readerForData = new DataReader();
        Scanner scanner = new Scanner(System.in);
        ReportComparison reports = new ReportComparison();
        MonthReport rportMonth = new MonthReport();
        YearReport rportYear = new YearReport();

        while (true) {
            printMenu();
            String command = scanner.nextLine();

            if (command.equalsIgnoreCase("1")) {
                readerForData.monthReader();
                System.out.println("Месячные отчеты загружены");
            } else if (command.equalsIgnoreCase("2")) {
                readerForData.yearReader();
                System.out.println("Годовые отчеты загружены");
            } else if (command.equalsIgnoreCase("3")) {
                if (MonthData.fullMonth.size() == 0 || YearData.monthOfSpending.size() == 0) {
                    System.out.println("Отчет за месяц или год не были загружены");
                } else {
                    reports.rComparison();
                }
            } else if (command.equalsIgnoreCase("4")) {
                if (MonthData.fullMonth.size() == 0) {
                    System.out.println("Отчет за месяц не был загружен");
                } else {
                    rportMonth.mReport();
                }
            } else if (command.equalsIgnoreCase("5")) {
                if (YearData.monthOfSpending.size() == 0) {
                    System.out.println("Отчет за год не был загружен");
                } else {
                    rportYear.yReport();
                }
            } else if (command.equalsIgnoreCase("EXIT")) {
                System.out.println("Выход");
                break;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("EXIT - Выход");
    }
}
