public class DataReader {
    public void monthReader() {
        ScanMonths.scanningMonth("January", "resources/m.202101.csv");
        ScanMonths.scanningMonth("February", "resources/m.202102.csv");
        ScanMonths.scanningMonth("March", "resources/m.202103.csv");

    }

    public void yearReader() {

        ScanYears.scanningYear("2021", "resources/y.2021.csv");
    }

    public static String nameOfMonths(Integer monthNumb) {  // присваиваем месяцам имена вместо цифр
        String[] nameOfMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return nameOfMonths[monthNumb-1];
    }
}

