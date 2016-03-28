public class Company {


    private int cif;
    private String name;
    private String sector;

    public Company() {
        // TODO
    }

    public Company(int cif) {
        // TODO
    }

    public Company (int cif, String name, String sector){
        this.cif=cif;
        this.name=name;
        this.sector=sector;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        return cif == company.cif;
    }

    @Override
    public int hashCode() {
        return cif;
    }

    public int getCif() {
        return cif;
    }
}