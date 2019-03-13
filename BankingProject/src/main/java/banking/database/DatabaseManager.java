package banking.database;

import banking.credits.Credit;
import banking.deposits.Deposit;
import banking.users.User;

import java.sql.*;

public class DatabaseManager {

    public static void main(String args[]) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://P5164.svdomain1.softvision.ro:3306/bankingapp", "user", "user");

//here sonoo is database name, root is username and password
            Statement stmt = con.createStatement();
//           / ResultSet rs =
//                    stmt.executeQuery("SELECT * FROM users;");
                   stmt.execute("INSERT INTO payments (creditID, ,dateOfBirth, ssn, phone)" +
                            " VALUES('Human', 'Popescu', '1990-01-01', 123456712, 0700000000);");
//            while (rs.next())
//                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  "
//                        + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6));
//               rs.first();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        createPaymentsTable();

    }

    public static void createUsersTable() {
        String usersTable = "CREATE TABLE tabel(" + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "firstName VARCHAR(20),"
                + "lastName VARCHAR (20),"
                + "dateOfBirth DATE,"
                + "ssn INT(9),"
                + "phone INT(10));";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://P5164.svdomain1.softvision.ro:3306/bankingapp", "user", "user");

            Statement stmt = con.createStatement();
            boolean rs = stmt.execute(usersTable);
            System.out.println("Return created table: " + rs);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String createCreditsTable() {
        String credits = "CREATE TABLE Credits("
                + "creditID INT  NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                + "type VARCHAR(30),"
                + "interestRate INT,"
                + "startDate DATE,"
                + "value INT,"
                + "mortgage BOOLEAN,"
                + "id"
                + "term INT(2))";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://P5164.svdomain1.softvision.ro:3306/bankingapp", "user", "user");

            Statement stmt = con.createStatement();
            boolean rs = stmt.execute(credits);
            System.out.println("Return created table: " + rs);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return credits;
    }


    public static String insertUsers(User user) {
        String users = "INSERT INTO users(" +
                "firstName, lastName, dateOfBirth, ssn, phone)" +
                "VALUES (%s,%s, %s, %s, %s)";
        return String.format(users, user.getFirstName(), user.getLastName(), user.getDateOfBirth(), user.getSsn(), user.getPhone());
    }

    public static void createDepositsTable() {
        String usersTable = "CREATE TABLE deposits("
                + "depositId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "depositType VARCHAR(20),"
                + "interestRate DOUBLE,"
                + "startDate DATE,"
                + "term INT(9),"
                + "id INT(10),"
                + "FOREIGN KEY(id) REFERENCES users (id));";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://P5164.svdomain1.softvision.ro:3306/bankingapp", "user", "user");

            Statement stmt = con.createStatement();
            boolean rs = stmt.execute(usersTable);
            System.out.println("Return created table: " + rs);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createPaymentsTable() {
        String paymentsTable = "CREATE TABLE payments("
                + "paymentId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "creditID INT(10),"
                + "FOREIGN KEY(creditID) REFERENCES credits (creditID),"
                + "depositID INT(10),"
                + "FOREIGN KEY(depositID) REFERENCES deposits (depositId),"
                + "id INT(10)"
                + ");";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://P5164.svdomain1.softvision.ro:3306/bankingapp", "user", "user");

            Statement stmt = con.createStatement();
            boolean rs = stmt.execute(paymentsTable);
            System.out.println("Return created table: " + rs);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String insertCredits(Credit credit) {
        String credits = "INSERT INTO Credits(" +
                "creditID, type, interestRate, startDate, value, mortgage, term)" +
                "VALUES(%s, %s, %s, %s, %s, %s, %s)";
        return String.format(credits, credit.getCreditName(), credit.getType(), credit.getInterestRate(), credit.getStartDate(), credit.getCreditValue(), credit.isMortgage(), credit.getDuration());
    }

    public static String insertDeposits(Deposit deposit) {
        String deposits = "INSERT INTO Deposits(" +
                "depositID, depositType, interestRate, startDate, term)" +
                "VALUES(%s, %s, %s, %s, %s))";
        return String.format(deposits, deposit.getDepositName(), deposit.getType(), deposit.getInterestRate(), deposit.getStartDate(), deposit.isDepositTerm());
    }



}


