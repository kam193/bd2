package data_structure;

public class Samochod {
    int VIN;
    String Kolor;
    String Status;
    int Przebieg;
    String Silnik;
    int Moc;
    String Skrzynia_biegow;
    String Paliwo;
    float Spalanie;
    String Opis;

    Model model = null;
    Komis komis = null;

    public Samochod(int VIN, String Kolor, String Status, int Przebieg, String Silnik, int Moc,
                    String Skrzynia_biegow, String Paliwo, float Spalanie, String Opis, Model model, Komis komis) {
        this.VIN = VIN;
        this.Kolor = Kolor;
        this.Status = Status;
        this.Przebieg = Przebieg;
        this.Silnik = Silnik;
        this.Moc = Moc;
        this.Skrzynia_biegow = Skrzynia_biegow;
        this.Paliwo = Paliwo;
        this.Spalanie = Spalanie;
        this.Opis = Opis;

        this.model = model;
        this.komis = komis;
    }

    @Override
    public String toString() {
        String result = String.format("%d, '%s', '%s', %d, '%s', %d, '%s', '%s', %f, '%s', %d, '%s', '%s'",
                VIN, Kolor, Status, Przebieg, Silnik, Moc, Skrzynia_biegow, Paliwo, Spalanie, Opis, komis.ID, model.Model, model.Marka);
        return result;
    }
}
