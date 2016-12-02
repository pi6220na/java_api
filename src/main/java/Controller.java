import java.util.ArrayList;
import java.util.Vector;

/*
 * Created by Jeremy on 12/1/2016.
 */

public class Controller {

    static APIForm gui;
    static DB db;

    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.startApp();

    }

    private void startApp() {

        String testTemp = "%util%";

        db = new DB();
        Vector<Level1> allData = db.fetchLevel1Records(testTemp);   // needs searchName parm

        gui = new APIForm(allData);
    }


//    ArrayList<Level1> getAllData() {
//        return db.fetchLevel1Records("getThis");
//    }

}
