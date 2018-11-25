import java.sql.*;

public class JDBC1 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://192.168.1.124:3306/test";
        String user = "root";
        String pass = "";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url,user,pass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT id, firstName, lastName, email FROM employee");

            while (rs.next()) {
                int id = rs.getInt("id");
                String fn = rs.getString("firstName");
                String ln = rs.getString("lastName");
                String email = rs.getString("email");

                System.out.println(id + "," + fn + "," + ln + "," + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(conn != null && !conn.isClosed()) {
                    conn.close();
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
