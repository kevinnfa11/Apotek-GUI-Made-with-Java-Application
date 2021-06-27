package ApotekGUI.view;

import ApotekGUII.ApotekGUI;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ApotekGUI.model.Obat;
import ApotekGUI.model.ObatList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.FloatStringConverter;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;


public class TambahDataObat implements Initializable {
        private ApotekGUI apotekGUI;
        private ObatList obatList;
        
        
        @FXML private TableView<Obat> obatTabel;
        @FXML private TextField snamaobat,sjenispenyakit,stanggal,sharga;
        @FXML private ComboBox  sjenisobat;
        @FXML private TableColumn<Obat, String> namaobat,jenispenyakit, jenisobat,tanggal; 
        @FXML private TableColumn<Obat, Float>harga;
    
        @FXML
        public void HandleStatistika(ActionEvent event) throws IOException {               
        FXMLLoader loader = new  FXMLLoader(ApotekGUI.class.getResource("/ApotekGUI/view/StatistikaObat.fxml"));
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
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                sjenisobat.getItems().add("Tablet");
                sjenisobat.getItems().add("Sirup");
                sjenisobat.getItems().add("Serbuk");
                sjenisobat.getItems().add("Kapsul");
        
        obatList = new ObatList();
        obatList.loadXMLFile();
        obatTabel.setItems(obatList.get());
        
        namaobat.setCellValueFactory(cellData -> cellData.getValue().namaObatProperty());
        jenispenyakit.setCellValueFactory(cellData -> cellData.getValue().jenisPenyakitProperty());
        jenisobat.setCellValueFactory(cellData -> cellData.getValue().jenisObatProperty());
        tanggal.setCellValueFactory(cellData -> cellData.getValue().tanggalProperty());
        harga.setCellValueFactory(cellData -> cellData.getValue().hargaProperty().asObject());
        
        obatTabel.setEditable(true);
        namaobat.setCellFactory(TextFieldTableCell.forTableColumn());
        jenispenyakit.setCellFactory(TextFieldTableCell.forTableColumn());
        jenisobat.setCellFactory(TextFieldTableCell.forTableColumn());
        tanggal.setCellFactory(TextFieldTableCell.forTableColumn());
        harga.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
    }
    
    @FXML
    public void tambahdataButton()
    { 
        Obat obt = new Obat();
        obt.setNamaObat(snamaobat.getText());
        obt.setJenisPenyakit(sjenispenyakit.getText());
        obt.setJenisObat(sjenisobat.getValue().toString());
        obt.setTanggal(stanggal.getText());
        obt.setHarga(Float.parseFloat(sharga.getText()));

        obatTabel.getItems().add(obt);
        obatList.saveXMLFile();
        
        snamaobat.clear();
        sjenispenyakit.clear();
        stanggal.clear();
        sharga.clear();
    }
    
    @FXML
    public void hapusdataButton()
    {
        int pilihan = obatTabel.getSelectionModel().getSelectedIndex();
        
        if(pilihan >= 0){
            obatTabel.getItems().remove(pilihan);
        }
        obatList.saveXMLFile(); 
    }
    
    @FXML
    public void changeHarga(TableColumn.CellEditEvent<Obat, Float> obtEditEvent)
    {
        Obat obt = obatTabel.getSelectionModel().getSelectedItem();
        obt.setHarga(obtEditEvent.getNewValue());
        obatList.saveXMLFile(); 
    }
    
        @FXML
    public void changeNama(TableColumn.CellEditEvent<Obat, String> obtEditEvent)
    {
        Obat obt = obatTabel.getSelectionModel().getSelectedItem();
        obt.setNamaObat(obtEditEvent.getNewValue());
        obatList.saveXMLFile(); 
    }
    
    @FXML
     public void changeJenisPenyakit(TableColumn.CellEditEvent<Obat, String> obtEditEvent)
    {
        Obat obt = obatTabel.getSelectionModel().getSelectedItem();
        obt.setJenisPenyakit(obtEditEvent.getNewValue());
        obatList.saveXMLFile(); 
    }
    
         @FXML
     public void changeTanggal(TableColumn.CellEditEvent<Obat, String> obtEditEvent)
    {
        Obat obt = obatTabel.getSelectionModel().getSelectedItem();
        obt.setTanggal(obtEditEvent.getNewValue());
        obatList.saveXMLFile(); 
    }
    
     
}




            
   
