package data_structure;

public class Transakcja {
    int ID;
    String Data;
    int Cena;
    String Metoda_Platnosci;
    int Klient_ID;
    int Pracownik_ID;
    int Samochod_ID;

    public Transakcja(int ID, String data, int cena, String metoda_Platnosci, int klient_ID, int pracownik_ID, int samochod_ID) {
        this.ID = ID;
        Data = data;
        Cena = cena;
        Metoda_Platnosci = metoda_Platnosci;
        Klient_ID = klient_ID;
        Pracownik_ID = pracownik_ID;
        Samochod_ID = samochod_ID;
    }

    public String toString(){
        String result;
        if (ID < 0)
            result = String.format("NULL, '%s', %d, '%s', %d, %d, %d",
                    Data, Cena, Metoda_Platnosci, Klient_ID, Pracownik_ID, Samochod_ID);
        else
            result = String.format("%d, '%s', %d, '%s', %d, %d, %d",
                    ID, Data, Cena, Metoda_Platnosci, Klient_ID, Pracownik_ID, Samochod_ID);
        return result;
    }
}
