package ApotekGUI.model;

public class SimpleObat {
    private String snamaobat,sjenispenyakit,sjenisobat,stanggal;
    private float sharga;
    
    public SimpleObat (String snamaobat, String sjenispenyakit, String sjenisobat,String stanggal, float sharga){
        this.snamaobat = snamaobat;
        this.sjenispenyakit = sjenispenyakit;
        this.sjenisobat = sjenisobat;
        this.stanggal = stanggal;
        this.sharga = sharga;
    }
    
    public void setSNamaObat(String snamaobat) {
        this.snamaobat = snamaobat;
    }
    
    public void setSJenisPenyakit(String sjenispenyakit) {
        this.sjenispenyakit = sjenispenyakit;
    }
    
    public void setSJenisObat(String sjenisobat) {
        this.sjenisobat = sjenisobat;
    }
    
    public void setSTanggal(String stanggal) {
        this.stanggal = stanggal;
    }
    
    public void setSHarga(float sharga) {
        this.sharga = sharga;
    }

    public String getSNamaObat(){
        return snamaobat;
    }
    
    public String getSJenisPenyakit(){
        return sjenispenyakit;
    }
    
    public String getSJenisObat(){
        return sjenisobat;
    }

    public String getSTanggal(){
        return stanggal;
    }
    
    public float getSHarga(){
        return sharga;
    }
}
