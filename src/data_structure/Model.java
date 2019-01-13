package data_structure;

public class Model {
    String Model;
    String Marka;
    int Ilosc_drzwi;
    int Masa;
    int Naped;

    public Model(String Model, String Marka, int Ilosc_drzwi, int Masa, int Naped) {
        this.Model = Model;
        this.Marka = Marka;
        this.Ilosc_drzwi = Ilosc_drzwi;
        this.Masa = Masa;
        this.Naped = Naped;
    }

    @Override
    public String toString(){
        String result = String.format("'%s', '%s', %d, %d, %d",
                Model, Marka, Ilosc_drzwi, Masa, Naped);
        return result;
    }
}
