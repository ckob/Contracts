import org.joda.time.DateTime;
import java.util.HashSet;

public class Person {

    private int dni;
    private String name;
    private HashSet<Contract> contracts;

    public Person() {
        // TODO: 3/15/16
    }
    public Person(int dni) {
        // TODO: 3/15/16
    }
    public Person(int dni, String name) {
        this.dni=dni;
        this.name=name;
        contracts= new HashSet<>();
    }
    public int workedTime() { /* Entenc que son les dates de tots els contractes, no només fins a dia d'avui*/
        int tmp=0;
        for(Contract c:contracts) {
            tmp+=c.duration();
        }
        return tmp;

    }
    public int nCompanies() {
        HashSet<Company> tmp = new HashSet<>();
        for (Contract c:contracts) {
            tmp.add(c.getCompany());
        }
        return tmp.size();
    }
    public boolean signContract(Contract contract) {
        for (Contract c: contracts) {
            if (c.getCompany().equals(contract.getCompany())) { // Només comprovem si les dates es sobreposen en cas de que sigui la mateixa empresa
                DateTime thisIni = JodaDT.parseDDMMYYYY(c.getInitialDate());
                DateTime thisFi = JodaDT.parseDDMMYYYY(c.getEndDate());
                DateTime nouIni = JodaDT.parseDDMMYYYY(contract.getInitialDate());
                DateTime nouFi = JodaDT.parseDDMMYYYY(contract.getEndDate());
                if (JodaDT.isInInterval(nouIni,thisIni,thisFi) || JodaDT.isInInterval(nouFi, thisIni,thisFi)) {
                    return false;
                }
            }
        }
        contracts.add(contract);
        return true;
    }

    @Override
    public int hashCode() {
        return dni;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return dni == person.dni;
    }
    public static void main(String[] args) {
        Company company1 = new Company(123456, "Indra", "Informatica");

        Contract[] c = new Contract[5];
        c[0] = new Contract(1, "01/02/2015", "02/04/2015");
        c[1] = new Contract(2, "02/01/2015", "01/03/2015"); // Error de dates
        c[2] = new Contract(3, "01/04/2015", "01/06/2015"); // Error de dates
        c[3] = new Contract(4, "03/04/2015", "05/08/2015");
        c[4] = new Contract(5, "05/09/2015", "05/09/2016");

        for (Contract i: c)
            i.setCompany(company1);

        Company company2 = new Company(874564, "Accenture", "Informatica");
        Contract contract = new Contract(6, "15/01/2017", "15/05/2017");

        Person p = new Person(456789123, "Lauro");

        for (Contract i: c)
            System.out.println(p.signContract(i));

        System.out.println("Nº de contractes de "+p.name + ": " +p.contracts.size());
        System.out.println("Total dies de treball dels contractes de " + p.name +": " +p.workedTime());
        System.out.println("Nº de companyies de "+p.name+": "+p.nCompanies());
    }
}
