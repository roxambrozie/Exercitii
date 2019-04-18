package demos;

import java.util.List;

public class DataReaders {

    public static void main(String[] args) {
        readCSV();
    }

    public static void readCSV() {
        String filename = "C:\\SDETuniversity\\Files\\UserAccounts.csv";
        List<String[]> records = utilities.CSV.get(filename);
        //Iterating through the list
        for (String[] record : records) {
            for (String field : record) {
                System.out.println(field);

            }
        }
    }

    public static void readXLS() {
        String filename = "C:\\SDETuniversity\\Files\\UserLogin.xls";
        String[][] data = utilities.Excel.get(filename);
        for (String[] record : data) {
            System.out.println("\nNew record: ");
            System.out.println(record[0]);
            System.out.println(record[1]);
            System.out.println(record[2]);
        }
    }

}
