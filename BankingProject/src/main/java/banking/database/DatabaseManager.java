package banking.database;

import banking.credits.Credit;
import banking.deposits.Deposit;
import banking.payment.Payment;
import banking.users.User;

import java.sql.*;

public class DatabaseManager {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://P5164.svdomain1.softvision.ro:3306/bankingapp", "user", "user");

            Statement stmt = con.createStatement();
//           / ResultSet rs =
//                    stmt.executeQuery("SELECT * FROM users;");
            stmt.execute("INSERT INTO payments (paymentId, id)" +
                    " VALUES(0,3);");
//            while (rs.next())
//                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  "
//                        + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6));
//               rs.first();

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void createUsersTable() {
        String usersTable = "CREATE TABLE IF NOT EXISTS users(" + "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
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
        String credits = "CREATE TABLE IF NOT EXISTS credits("
                + "creditID INT  NOT NULL AUTO_INCREMENT PRIMARY KEY, "
                + "type VARCHAR(30),"
                + "interestRate INT,"
                + "startDate DATE,"
                + "value INT,"
                + "mortgage BOOLEAN,"
                + "id INT,"
                + "term INT(3))";
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

    public static void createDepositsTable() {
        String usersTable = "CREATE TABLE IF NOT EXISTS deposits("
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
        String paymentsTable = "CREATE TABLE IF NOT EXISTS payments("
                + "paymentId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,"
                + "creditID INT(10),"
                + "FOREIGN KEY(creditID) REFERENCES credits (creditID),"
                + "depositID INT(10),"
                + "FOREIGN KEY(depositID) REFERENCES deposits (depositId),"
                + "id INT(10),"
                + "amount DOUBLE"
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

    public static String insertUsers(User user) {
        String users = "INSERT INTO users(" +
                "firstName, lastName, dateOfBirth, ssn, phone)" +
                "VALUES (%s,%s, %s, %s, %s)";
        return String.format(users, user.getFirstName(), user.getLastName(), user.getDateOfBirth(), user.getSsn(), user.getPhone());
    }


    public static String insertCredits(Credit credit) {
        String credits = "INSERT INTO Credits(" +
                "creditID, type, interestRate, startDate, value, mortgage, term)" +
                "VALUES(%s, %s, %s, %s, %s, %s, %s)";
        return String.format(credits, credit.getCreditName(), credit.getType(), credit.getInterestRate(), credit.getStartDate(), credit.getCreditValue(), credit.isMortgage(), credit.getCreditTerm());
    }

    public static String insertDeposits(Deposit deposit) {
        String deposits = "INSERT INTO Deposits(" +
                "depositId, depositType, interestRate, startDate, term, id)" +
                "VALUES(%s, %s, %s, %s, %s))";
        return String.format(deposits, deposit.getDepositName(), deposit.getType(), deposit.getInterestRate(), deposit.getStartDate(), deposit.isDepositTerm(), deposit.getId());
    }

    public static String insertPayments(Payment payment) {
        String payments = "INSERT INTO Payments(" +
                "paymentId, creditID, depositId, id, amount, paymentDate)" +
                "VALUES(%d, %d, %d, %d, %f, %s)";
        return String.format(payments, payment.getPaymentId(), payment.getCreditID(), payment.getDepositId(), payment.getId(), payment.getPaymentAmount(), payment.getPaymentDate());
    }

    public static boolean checkUserExistsInDatabase(int ssn) {
        String query = "SELECT * FROM users WHERE ssn = " + ssn + ";";
        if (String.valueOf(ssn).length() == 9) {
            try {
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://P5164.svdomain1.softvision.ro:3306/bankingapp", "user", "user");

                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                if (rs.isBeforeFirst()) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return true;
        } else return false;
    }

    public static ResultSet returnUserDetails(int ssn) {
        String query = "SELECT * FROM users WHERE ssn = " + ssn + ";";
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://P5164.svdomain1.softvision.ro:3306/bankingapp", "user", "user");

            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if (rs != null) {
                while (rs.next())
                    System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  "
                            + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6));
                rs.first();
            }
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public static ResultSet setCreditObjects(int ssn) {
        String query = "SELECT creditID, type, interestRate, startDate, value, mortgage, credits.id, term FROM credits " +
                "INNER JOIN users " +
                "ON credits.id = users.id " +
                "WHERE users.ssn = " + ssn + ";";
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://P5164.svdomain1.softvision.ro:3306/bankingapp", "user", "user");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            rs.first();
            rs.previous();
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  "
                        + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6)
                        + "  " + rs.getString(7));

            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static ResultSet setDepositObjects(int ssn) {
        String query = "SELECT depositId, depositType,  interestRate, startDate, term, deposits.id FROM deposits " +
                "INNER JOIN users " +
                "ON deposits.id = users.id " +
                "WHERE users.ssn = " + ssn + ";";
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://P5164.svdomain1.softvision.ro:3306/bankingapp", "user", "user");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            rs.first();
            rs.previous();
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  "
                        + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getString(6));

            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static ResultSet setPaymentObjects() {
        String query = "SELECT paymentId, amount,  creditID, depositID, payments.id FROM payments " +
                "INNER JOIN credits " +
                "ON credits.creditID = payments.creditID " +
                ";";
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://P5164.svdomain1.softvision.ro:3306/bankingapp", "user", "user");
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            rs.first();
            rs.previous();
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getDouble(2) + "  "
                        + rs.getInt(3) + "  " + rs.getInt(4) + "  " + rs.getInt(5));

            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    public static ResultSet returnPaymentDetails(int creditID) {
        String query = "SELECT * FROM payments WHERE creditID = " + creditID + ";";
        ResultSet rs = null;
        try {
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://P5164.svdomain1.softvision.ro:3306/bankingapp", "user", "user");

            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if (rs != null) {
                while (rs.next())
                    System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  "
                            + rs.getInt(3) + "  " + rs.getInt(4) + "  " + rs.getDouble(5)
                            + " " + rs.getDate(6));
                rs.first();
            }
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }
}


