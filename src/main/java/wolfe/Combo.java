package wolfe;

/*
 * Created by Jeremy on 12/2/2016.
 */
public class Combo {


    private String method_modifier;
    private String method_name;
    private String method_summary;
    private String klass_type;
    private String klass_name;
    private String package_name;


    Combo(String method_modifier, String method_name, String method_summary, String klass_type, String klass_name, String package_name) {
        this.method_modifier = method_modifier;
        this.method_name = method_name;
        this.method_summary = method_summary;
        this.klass_type = klass_type;
        this.klass_name = klass_name;
        this.package_name = package_name;
    }

    public String getMethod_modifier() {
        return method_modifier;
    }

    public void setMethod_modifier(String method_modifier) {
        this.method_modifier = method_modifier;
    }

    public String getMethod_name() {
        return method_name;
    }

    public void setMethod_name(String method_name) {
        this.method_name = method_name;
    }

    public String getMethod_summary() {
        return method_summary;
    }

    public void setMethod_summary(String method_summary) {
        this.method_summary = method_summary;
    }

    public String getKlass_type() {
        return klass_type;
    }

    public void setKlass_type(String klass_type) {
        this.klass_type = klass_type;
    }

    public String getKlass_name() {
        return klass_name;
    }

    public void setKlass_name(String klass_name) {
        this.klass_name = klass_name;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }
}
