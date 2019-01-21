package data_structure;

public class Spotkanie {
    int ID = -1;
    String data;
    String komentarz;
    int Klient_ID;
    int Komis_ID;
    int Samochod_VIN;

    public Spotkanie(String data, String komentarz, int Klient_ID, int Komis_ID, int Samochod_VIN) {
        this.data = data;
        this.komentarz = komentarz;
        this.Klient_ID = Klient_ID;
        this.Komis_ID = Komis_ID;
        this.Samochod_VIN = Samochod_VIN;
    }

    public String toString() {
        String result;
        if (ID == -1)
            result = String.format("NULL, '%s', '%s', %d, %d, ",
                    data, komentarz, Klient_ID, Komis_ID);
        else
            result = String.format("%d, '%s', '%s', %d, %d ",
                    ID, data, komentarz, Klient_ID, Komis_ID);

        if (Samochod_VIN > 0)
            result += Integer.toString(Samochod_VIN);
        else
            result += "NULL";

        return result;
    }
}