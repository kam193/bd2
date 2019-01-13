package data_structure;

public class Komis {
    int ID;
    String Nazwa;
    String Ulica;
    String Nr_Domu;
    String Miasto;
    String Kod_Pocztowy;
    String Telefon;

    public Komis(int ID, String nazwa, String ulica, String nr_Domu, String miasto, String kod_Pocztowy, String telefon) {
        this.ID = ID;
        Nazwa = nazwa;
        Ulica = ulica;
        Nr_Domu = nr_Domu;
        Miasto = miasto;
        Kod_Pocztowy = kod_Pocztowy;
        Telefon = telefon;
    }

    @Override
    public String toString() {
        String result = String.format("%d, '%s', '%s', '%s', '%s', '%s', '%s'",
                ID, Nazwa, Ulica, Nr_Domu, Miasto, Kod_Pocztowy, Telefon);
        return result;
    }
}
