
import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

/*
 * Created by Jeremy on 12/1/2016.
 */
public class DB {


    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";        //Configure the driver needed
    private static final String DB_CONNECTION_URL = "jdbc:mysql://localhost:3306/java_api?autoReconnect=true&useSSL=false";
    private static final String USER = "myrlin";
    private static final String PASSWORD = "password";


    DB() {

        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("loaded JDBC_DRIVER class");
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Can't instantiate driver class; check you have drives and classpath configured correctly?");
            cnfe.printStackTrace();
            System.exit(-1);  //No driver? Need to fix before anything else will work. So quit the program
        }
    }


    Vector<Level1> fetchLevel1Records(String searchName) {

        Vector<Level1> level1Records = new Vector<>();

//        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
//             Statement statement = conn.createStatement()) {

         try {

            Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
            Statement statement = conn.createStatement();

            java.sql.PreparedStatement sstmt = conn.prepareStatement("SELECT * FROM package WHERE name LIKE ?");

            sstmt.setString(1, searchName);

            ResultSet rsAll = sstmt.executeQuery();

            System.out.println("Executed query... ");

            while (rsAll.next()) {
                String id = rsAll.getString("package_ID");
                String name = rsAll.getString("name");
                String description = rsAll.getString("description");

                Level1 record = new Level1(id, name, description);
                level1Records.add(record);

                System.out.println("package_ID = " + id);
                System.out.println("Name = " + name);
                System.out.println("Description = " + description);
            }

            rsAll.close();
            statement.close();
            conn.close();

            return level1Records;    //If there's no data, this will be empty

        } catch (SQLException se) {
            se.printStackTrace();
            return null;  //since we have to return something.
        }
    }


}

