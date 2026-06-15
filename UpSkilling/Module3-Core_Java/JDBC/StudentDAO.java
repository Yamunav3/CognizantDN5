package JDBC;
import java.sql.*;

public class StudentDAO {

    Connection con;

    public StudentDAO() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test",
                "root",
                "Yamunav3@");
    }

    public void insertStudent(int id, String name)
            throws SQLException {

        String sql =
                "INSERT INTO students(id,name) VALUES(?,?)";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setInt(1, id);
        ps.setString(2, name);

        int rows = ps.executeUpdate();

        System.out.println(rows + " row inserted");
    }

    public void updateStudent(int id, String name)
            throws SQLException {

        String sql =
                "UPDATE students SET name=? WHERE id=?";

        PreparedStatement ps =
                con.prepareStatement(sql);

        ps.setString(1, name);
        ps.setInt(2, id);

        int rows = ps.executeUpdate();

        System.out.println(rows + " row updated");
    }

    public static void main(String[] args)
            throws Exception {

        StudentDAO dao = new StudentDAO();

        dao.insertStudent(103, "Ganga");

        dao.updateStudent(106, "Manga");
    }
}