
import java.sql.*;
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

        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
             Statement statement = conn.createStatement()) {

            java.sql.PreparedStatement sstmt = conn.prepareStatement("SELECT * FROM package WHERE name LIKE ?");

            searchName = "%" + searchName + "%";

            sstmt.setString(1, searchName);

            ResultSet rsAll = sstmt.executeQuery();

            System.out.println("Executed query... " + searchName);

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


    Vector<Level2> fetchLevel2Records(String searchName) {

        Vector<Level2> level2Records = new Vector<>();


        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
             Statement statement = conn.createStatement()) {

            java.sql.PreparedStatement sstmt = conn.prepareStatement("SELECT * FROM klass WHERE name LIKE ?");

            searchName = "%" + searchName + "%";

            sstmt.setString(1, searchName);

            ResultSet rsAll = sstmt.executeQuery();

            System.out.println("Executed query... " + searchName);

            while (rsAll.next()) {
                String id = rsAll.getString("klass_ID");
                String type = rsAll.getString("type_flag");
                String name = rsAll.getString("name");
                String summary = rsAll.getString("summary");
                String package_fk = rsAll.getString("k_package_ID_fk");


                Level2 record = new Level2(id, type, name, summary, package_fk);
                level2Records.add(record);

                System.out.println("klass_ID = " + id);
                System.out.println("type = " + type);
                System.out.println("Name = " + name);
                System.out.println("Summary = " + summary);
                System.out.println("package_fk = " + package_fk);

            }

            rsAll.close();
            statement.close();
            conn.close();

            return level2Records;    //If there's no data, this will be empty

        } catch (SQLException se) {
            se.printStackTrace();
            return null;  //since we have to return something.
        }
    }


    Vector<Level3> fetchLevel3Records(String searchName) {

        Vector<Level3> level3Records = new Vector<>();


        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
             Statement statement = conn.createStatement()) {

            java.sql.PreparedStatement sstmt = conn.prepareStatement("SELECT * FROM method WHERE name LIKE ?");

            searchName = "%" + searchName + "%";

            sstmt.setString(1, searchName);

            ResultSet rsAll = sstmt.executeQuery();

            System.out.println("Executed query... " + searchName);

            while (rsAll.next()) {
                String id = rsAll.getString("method_ID");
                String modifier = rsAll.getString("modifier");
                String name = rsAll.getString("name");
                String summary = rsAll.getString("summary");
                String detail = rsAll.getString("detail");
                String klass_fk = rsAll.getString("m_klass_ID_fk");


                Level3 record = new Level3(id, modifier, name, summary, detail, klass_fk);
                level3Records.add(record);

                System.out.println("klass_ID = " + id);
                System.out.println("modifier = " + modifier);
                System.out.println("Name = " + name);
                System.out.println("Summary = " + summary);
                System.out.println("Detail = " + detail);
                System.out.println("klass_fk = " + klass_fk);
            }

            rsAll.close();
            statement.close();
            conn.close();

            return level3Records;    //If there's no data, this will be empty

        } catch (SQLException se) {
            se.printStackTrace();
            return null;  //since we have to return something.
        }
    }


    Vector<Combo> fetchComboRecords(String searchName) {

        Vector<Combo> ComboRecords = new Vector<>();


        try (Connection conn = DriverManager.getConnection(DB_CONNECTION_URL, USER, PASSWORD);
             Statement statement = conn.createStatement()) {

            java.sql.PreparedStatement sstmt =
              conn.prepareStatement("SELECT modifier, method.name, method.summary, klass.type_flag, klass.name, " +
                      "package.name FROM method, klass, package " +
                      "WHERE m_klass_ID_fk = klass.klass_ID and k_package_ID_fk = package.package_ID\n" +
                      "and method.summary like ?");

            searchName = "%" + searchName + "%";

            sstmt.setString(1, searchName);

            ResultSet rsAll = sstmt.executeQuery();

            System.out.println("Executed query... " + searchName);

            while (rsAll.next()) {
                String modifier = rsAll.getString("modifier");
                String name = rsAll.getString("method.name");
                String summary = rsAll.getString("method.summary");
                String k_type = rsAll.getString("klass.type_flag");
                String k_name = rsAll.getString("klass.name");
                String p_name = rsAll.getString("package.name");


                Combo record = new Combo(modifier, name, summary, k_type, k_name, p_name);
                ComboRecords.add(record);

                System.out.println("modifier = " + modifier);
                System.out.println("name = " + name);
                System.out.println("summary = " + summary);
                System.out.println("ktype = " + k_type);
                System.out.println("kname = " + k_name);
                System.out.println("pname = " + p_name);
            }

            rsAll.close();
            statement.close();
            conn.close();

            return ComboRecords;    //If there's no data, this will be empty

        } catch (SQLException se) {
            se.printStackTrace();
            return null;  //since we have to return something.
        }
    }




}

