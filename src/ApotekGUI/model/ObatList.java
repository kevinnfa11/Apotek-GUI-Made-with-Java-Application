package ApotekGUI.model;
import ApotekGUI.model.Obat;
import ApotekGUI.model.SimpleObat;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ObatList {
    private ObservableList<Obat> list;
    
    public ObatList(){
        list = FXCollections.observableArrayList();
    }
    
    public ObservableList<Obat> get() {
        return list;
    }
    
    public void setFromArray(SimpleObat[] array){
        list = FXCollections.observableArrayList();
        
        for(SimpleObat so : array){
            list.add(new Obat(so.getSNamaObat(), so.getSJenisPenyakit(), so.getSJenisObat(),
                    so.getSTanggal(),so.getSHarga()));
        }
    }
    
    public void loadXMLFile(){
        try {
            XStream xs = new XStream(new StaxDriver());
            FileInputStream in = new FileInputStream("obat.xml");
            String s = "";
            int c = in.read();
            while (c != -1) {
                s += (char) c;
                c = in.read();
            }
               SimpleObat[] array = (SimpleObat[]) xs.fromXML(s);
                this.setFromArray(array);
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
   
    
    public SimpleObat[] getArray(){
        SimpleObat[] array = new SimpleObat[list.size()];
        for(int i = 0; i < list.size(); i++ ){
            String namaobat = list.get(i).getNamaObat();
            String jenispenyakit = list.get(i).getJenisPenyakit();
            String jenisobat = list.get(i).getJenisObat();
            String tanggal = list.get(i).getTanggal();
            float harga = list.get(i).getHarga();
            array[i] = new SimpleObat(namaobat, jenispenyakit, jenisobat, tanggal, harga);
        }
        return array;
    }
    
    public void saveXMLFile(){
        SimpleObat[] array = this.getArray();
        XStream xs = new XStream(new StaxDriver());
        String xml = xs.toXML (array);
       //String xml = xs.toXML (list);
        try{
            FileOutputStream output = new FileOutputStream("obat.xml");
            byte[] bytes = xml.getBytes();
            output.write(bytes);
            output.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
    
    

