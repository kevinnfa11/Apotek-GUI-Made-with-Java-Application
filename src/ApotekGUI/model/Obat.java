package ApotekGUI.model;


import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Obat {
    private StringProperty namaobat,jenispenyakit, jenisobat,tanggal;
    private FloatProperty harga;
    
    public Obat(){
    this("","","","",0);
    }
    

    public Obat(String namaobat, String jenispenyakit, String jenisobat,String tanggal, float harga){
        this.namaobat = new SimpleStringProperty(namaobat);        
        this.jenispenyakit = new SimpleStringProperty(jenispenyakit);
        this.jenisobat = new SimpleStringProperty(jenisobat);
        this.tanggal = new SimpleStringProperty(tanggal);
        this.harga = new SimpleFloatProperty(harga);        
    }
   
    public void setNamaObat(String namaobat) {
        this.namaobat.set(namaobat);
    }
    
    public void setJenisPenyakit(String jenispenyakit) {
        this.jenispenyakit.set(jenispenyakit);
    }
    
    public void setJenisObat(String jenisobat) {
        this.jenisobat.set(jenisobat);
    }
   
    public void setTanggal(String tanggal) {
        this.tanggal.set(tanggal);
    }
    
    public void setHarga(Float harga) {
        this.harga.set(harga);
    } 
    
    public String getNamaObat(){
        return namaobat.get();
    }
    
    public String getJenisPenyakit(){
        return jenispenyakit.get();
    }
    
    public String getJenisObat(){
        return jenisobat.get();
    }
    
    public String getTanggal(){
        return tanggal.get();
    }
    
    public Float getHarga(){
        return this.harga.get();
    }

    public StringProperty namaObatProperty(){
        return namaobat;
    }
    
    public StringProperty jenisPenyakitProperty(){
        return jenispenyakit;
    }
    
    public StringProperty jenisObatProperty(){
        return jenisobat;
    }
    
   public StringProperty tanggalProperty(){
        return tanggal;
    }

   public FloatProperty hargaProperty(){
        return harga;
    }
       
}
