/*
 * Created by Jeremy on 12/2/2016.
 */
public class Level2 {


    private String id;
    private String type;
    private String name;
    private String summary;
    private String package_fk;


    Level2(String id, String type, String name, String summary, String package_fk) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.summary = summary;
        this.package_fk = package_fk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPackage_fk() {
        return package_fk;
    }

    public void setPackage_fk(String package_fk) {
        this.package_fk = package_fk;
    }

}
