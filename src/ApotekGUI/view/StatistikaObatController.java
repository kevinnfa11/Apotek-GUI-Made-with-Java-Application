package ApotekGUI.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import ApotekGUI.model.Obat;
import ApotekGUI.model.ObatList;
import ApotekGUI.model.SimpleObat;
import ApotekGUII.ApotekGUI;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.AnyTypePermission;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ApotekGUI.model.hargaObat;
import java.text.DecimalFormat;
import javafx.scene.chart.PieChart;
import javafx.scene.text.Text;


public class StatistikaObatController implements Initializable{

        @FXML
      private BarChart<String, Float> barChart;
     @FXML Label lbMean;
    @FXML private SimpleObat obat;
    @FXML private ObatList obatList;
    @FXML private ObservableList<Obat> obatData= FXCollections.observableArrayList();
  @FXML PieChart dbPieUsia;
  @FXML Text dbModusHarga,dbMeanHarga,dbMedianHarga,dbNObat;
     
  

        @FXML
        public void HandleTambah(ActionEvent event) throws IOException {               
        FXMLLoader loader = new  FXMLLoader(ApotekGUI.class.getResource("/ApotekGUI/view/TambahDataObat.fxml"));
        Parent Menu = loader.load();
        Scene MenuScene = new Scene(Menu);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(MenuScene);
        window.show();
}    
        @FXML
        public void HandleObat(ActionEvent event) throws IOException {               
        FXMLLoader loader = new  FXMLLoader(ApotekGUI.class.getResource("/ApotekGUI/view/Tampilanawal.fxml"));
        Parent Menu = loader.load();
        Scene MenuScene = new Scene(Menu);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(MenuScene);
        window.show();
}    
            public void setFromArray(SimpleObat[] array){
        obatData = FXCollections.observableArrayList();
        
        for(SimpleObat so : array){
            obatData.add(new Obat(so.getSNamaObat(), so.getSJenisPenyakit(), so.getSJenisObat(),
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
    @FXML
    public void setData(){
        
        obatList.loadXMLFile();
       
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Nama Obat");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Harga Obat");

        XYChart.Series xy = new XYChart.Series<>();
        xy.setName("Data Obat");
        
   
    
        
 }    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
                XYChart.Series<String, Float> series = new XYChart.Series<>();
                ObatList obat = new ObatList();
                Obat obt;
                loadXMLFile();
        for (   Obat array : obatData) {
                series.getData().add(new XYChart.Data<>(array.getNamaObat(), array.getHarga()));
        }
        
    barChart.getData().add(series);
        ObservableList<hargaObat> SimpleObat= FXCollections.observableArrayList();
       Obat min = obatData.stream().min(Comparator.comparing(Obat::getHarga)).orElseThrow(NoSuchElementException::new);
       Obat max = obatData.stream().max(Comparator.comparing(Obat::getHarga)).orElseThrow(NoSuchElementException::new);
       
       float hargaMin = min.getHarga();
       float hargaMax = max.getHarga();
       
       float range = hargaMax-hargaMin;
       double nKelas = 1 + 3.3 * Math.log10(obatData.size());
       nKelas = Math.ceil(nKelas);
       double pKelas = range/nKelas;
       pKelas = Math.ceil(pKelas);
       
       float paKelas = (float) pKelas;
       
       ArrayList<Float> hargaA = new ArrayList();
       ArrayList<Float> hargaB = new ArrayList();
       
       for(float i=hargaMin;i<hargaMax;i+=pKelas){
            hargaA.add(i);
            hargaB.add(i+paKelas-1);
        }     
            for(int i=0;i<hargaA.size();i++){
            hargaObat so = new hargaObat(hargaA.get(i),hargaB.get(i),0);
            SimpleObat.add(so);
        }
             for(int i=0;i<obatData.size();i++){
            for(int j=0;j<hargaA.size();j++){
                if(obatData.get(i).getHarga() >= hargaA.get(j) && obatData.get(i).getHarga() <= hargaB.get(j)){
                    SimpleObat.set(j, new hargaObat(hargaA.get(j),hargaB.get(j),SimpleObat.get(j).getJumlah()+1));
                }
            }
        }
        String rentangHarga;
        for(int i=0;i<SimpleObat.size();i++){
            rentangHarga = "" + SimpleObat.get(i).getHargaA() + " - " + SimpleObat.get(i).getHargaB() + "";
            
        }
        
               ObservableList<PieChart.Data> dataPieHarga = FXCollections.observableArrayList();
        
        DecimalFormat df = new DecimalFormat("###0.00");
        double n, nT, percentSlice; String pieSlice;
        for(int i=0;i<SimpleObat.size();i++){
            n = SimpleObat.get(i).getJumlah();
            nT = SimpleObat.size();
            percentSlice = (100/nT)*n;
            rentangHarga = "" + SimpleObat.get(i).getHargaA() + " - " + SimpleObat.get(i).getHargaB() + "";
            pieSlice = rentangHarga + " Harga (" + df.format(percentSlice) + " %)";
            dataPieHarga.add(new PieChart.Data(pieSlice, SimpleObat.get(i).getJumlah()));
        }

        dbPieUsia.setTitle("Persentase Harga");
        dbPieUsia.setData(dataPieHarga);
        dbPieUsia.setLegendVisible(false);
        
    
        double totalJumlah = 0, totalFrekuensidata = 0;
        double meanHarga, c = obatData.size(), d = SimpleObat.size();
        String medianUs;
        String modusUs;
        int persentilUsNum;
        String persentilUs;
  
          meanHarga = c/d;
        for(int i=0;i<SimpleObat.size();i++){
            totalJumlah += (SimpleObat.get(i).getHargaA() + SimpleObat.get(i).getHargaB()) / 2 * SimpleObat.get(i).getJumlah();
            totalFrekuensidata += SimpleObat.get(i).getJumlah();
        }
        
        meanHarga = totalJumlah/totalFrekuensidata;
        System.out.println(totalJumlah + " " + totalFrekuensidata);
        
        System.out.println(obatData.size() + " " + SimpleObat.size());
        // Media Usia
        float middleHarga = obatData.size()/2;
        
        int i = 0, j = 0;
        while(i < middleHarga){
            i += SimpleObat.get(j).getJumlah();
            j++;
        }
        
        double tb = SimpleObat.get(j-1).getHargaA()-0.5;
        n = obatData.size();
        double fkk = i-SimpleObat.get(j-1).getJumlah();
        double fi = SimpleObat.get(j-1).getJumlah();
        double p = SimpleObat.get(j-1).getHargaB()-SimpleObat.get(j-1).getHargaA()+1;
        
        System.out.println(tb + " " + n + " " + fkk + " " + fi + " " + p + " ");
        
        double median = tb + ((n/2 - fkk) / fi)*p;
        // Modus Usia
        
        double modUS;
        int v = 0;
        for (i=0;i<SimpleObat.size();i++){
            if (v < SimpleObat.get(i).getJumlah()){
                v = (int) SimpleObat.get(i).getJumlah();
            }
        }
        
        for (i=0;i<SimpleObat.size();i++){
            if (v == SimpleObat.get(i).getJumlah()){
                j = i;
            }
        }
        
        double bt = SimpleObat.get(j-1).getHargaA()-0.5;
        double b1= SimpleObat.get(j-1).getJumlah() - SimpleObat.get(j-2).getJumlah();
        double b2= SimpleObat.get(j-1).getJumlah() - SimpleObat.get(j).getJumlah();
        modUS =  bt + (b1/(b1+b2)) * p;       
        
        String harga = df.format(meanHarga);
        String mediAN = df.format(median);
        String moDUS = df.format(modUS);
        
        dbMeanHarga.setText(harga + " Rupiah ");
        dbModusHarga.setText(moDUS + " Rupiah");
        
        dbNObat.setText(Integer.toString(obatData.size()));
    }
    
    
    

        
    }
