/*
 * Created by Jeremy on 12/2/2016.
 */
public class Level3 {


    private String id;
    private String modifier;
    private String name;
    private String summary;
    private String detail;
    private String klass_fk;


    Level3(String id, String modifier, String name, String summary, String detail, String klass_fk) {
        this.id = id;
        this.modifier = modifier;
        this.name = name;
        this.summary = summary;
        this.detail = detail;
        this.klass_fk = klass_fk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getKlass_fk() {
        return klass_fk;
    }

    public void setPackage_fk(String klass_fk) {
        this.klass_fk = klass_fk;
    }

}
