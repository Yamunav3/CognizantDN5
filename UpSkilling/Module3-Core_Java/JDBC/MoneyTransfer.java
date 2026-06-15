
import java.sql.*;

public class MoneyTransfer {

    public static void transfer(
            int fromAcc,
            int toAcc,
            double amount)
            throws Exception {

        Connection con =
                DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/test",
                        "root",
                        "Yamunav3@");

        try {

            con.setAutoCommit(false);

            PreparedStatement debit =
                    con.prepareStatement(
                            "UPDATE accounts " +
                            "SET balance=balance-? " +
                            "WHERE acc_no=?");

            debit.setDouble(1, amount);
            debit.setInt(2, fromAcc);

            debit.executeUpdate();

            PreparedStatement credit =
                    con.prepareStatement(
                            "UPDATE accounts " +
                            "SET balance=balance+? " +
                            "WHERE acc_no=?");

            credit.setDouble(1, amount);
            credit.setInt(2, toAcc);

            credit.executeUpdate();

            con.commit();

            System.out.println("Transfer Successful");

        } catch(Exception e) {

            con.rollback();

            System.out.println("Transfer Failed");

        } finally {

            con.close();
        }
    }

    public static void main(String[] args)
            throws Exception {

        transfer(101, 102, 1000);
    }
}