import org.joda.time.DateTime;
import org.joda.time.Duration;

public class Contract {
    private int code;
    private String initialDate;
    private String endDate;
    private Company company;

    public Contract() {
        // TODO: 3/15/16
    }
    public Contract(int code) {
        // TODO: 3/15/16
    }
    public Contract (int code, String initialDate, String endDate){
        this.code=code;
        this.initialDate=initialDate;
        this.endDate=endDate;
    }
    public int duration() {
        DateTime ini = JodaDT.parseDDMMYYYY(initialDate);
        DateTime fi = JodaDT.parseDDMMYYYY(endDate);
        Duration d = new Duration(ini, fi);
        return (int) d.getStandardDays(); // retornar el la duració total del contracte en dies
    }
    @Override
    public int hashCode() {
        return code;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contract contract = (Contract) o;

        return code == contract.code;

    }
    public Company getCompany(){
        return company;
    }
    public String getEndDate() {
        return endDate;
    }
    public String getInitialDate() {
        return initialDate;
    }
    public void setCompany(Company company) {
        this.company = company;
    }

}