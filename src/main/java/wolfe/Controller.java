package wolfe;

import java.util.Vector;

/* Java API GUI (part 2 of 2 applications)
 * see also JavaAPILoader (part 1 of 2)
 * Created by Jeremy on 12/1/2016.
 *
 *  Framework based loosely on "Elevations" by Clara
 *
 *  This wolfe.Controller is the main starting point for the Java API GUI application.
 *  This app utilizes the java_api database that contains data scrapped from
 *  the downloaded Java SE 8 API documentation.
 *
 *  See the following Oracle link for a detailed description of the API structure and format:
 *  https://docs.oracle.com/javase/8/docs/api/help-doc.html
 *  The database is modelled based on the API structure.
 *
 *
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

        db = new DB();
        gui = new API_GUI();

        // populate Level 1 table when opening Window for the first time
        String testTemp = "%util%";
        Vector<Level1> allData = db.fetchLevel1Records(testTemp);
        gui.initializeTable(allData);

        System.out.println("finally at the end");
    }

}
