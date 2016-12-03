import java.util.Vector;

/* Java API GUI (part 2 of 2 applications)
 * see also JavaAPILoader (part 1 of 2)
 * Created by Jeremy on 12/1/2016.
 *
 *  Framework based loosely on "Elevations" by Clara
 *
 *  This Controller is the main starting point for the Java API GUI application.
 *  This app utilizes the java_api database that contains data scrapped from
 *  the downloaded Java SE 8 API documentation.
 *
 */

public class Controller {

    static API_GUI gui;
    static DB db;

    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.startApp();

    }

    private void startApp() {

        String testTemp = "%util%";

        db = new DB();
        Vector<Level1> allData = db.fetchLevel1Records(testTemp);   // needs searchName parm

        gui = new API_GUI(allData);
    }

}
