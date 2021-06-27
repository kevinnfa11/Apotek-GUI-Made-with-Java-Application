package ApotekGUI.view;

import ApotekGUII.ApotekGUI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class Tampilanawal implements Initializable {

    @FXML
    public void HandleStatistikaHyperLink(ActionEvent event) throws IOException {               
        FXMLLoader loader = new  FXMLLoader(ApotekGUI.class.getResource("/ApotekGUI/view/StatistikaObat.fxml"));
        Parent Menu = loader.load();
        Scene MenuScene = new Scene(Menu);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(MenuScene);
        window.show();
}
    
    @FXML
    public void HandleTambahDataObat(ActionEvent event) throws IOException {               
    FXMLLoader loader = new  FXMLLoader(ApotekGUI.class.getResource("/ApotekGUI/view/TambahDataObat.fxml"));
       Parent Menu = loader.load();
       Scene MenuScene = new Scene(Menu);
        
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(MenuScene);
        window.show();
}

    public void HandleKapsul(ActionEvent event) throws IOException {               
    FXMLLoader loader = new  FXMLLoader(ApotekGUI.class.getResource("/ApotekGUI/Kapsul/Kapsul1.fxml"));
        Parent Menu = loader.load();
       Scene MenuScene = new Scene(Menu);
        
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(MenuScene);
        window.show();
} 
    
    public void HandleSirup(ActionEvent event) throws IOException {               
    FXMLLoader loader = new  FXMLLoader(ApotekGUI.class.getResource("/ApotekGUI/Sirup/Sirup1.fxml"));
        Parent Menu = loader.load();
       Scene MenuScene = new Scene(Menu);
        
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(MenuScene);
        window.show();
}
    
    public void HandleSerbuk(ActionEvent event) throws IOException {               
    FXMLLoader loader = new  FXMLLoader(ApotekGUI.class.getResource("/ApotekGUI/Serbuk/Serbuk1.fxml"));
        Parent Menu = loader.load();
       Scene MenuScene = new Scene(Menu);
        
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(MenuScene);
        window.show();
}

    public void HandleTablet(ActionEvent event) throws IOException {               
    FXMLLoader loader = new  FXMLLoader(ApotekGUI.class.getResource("/ApotekGUI/Tablet/Tablet1.fxml"));
        Parent Menu = loader.load();
       Scene MenuScene = new Scene(Menu);
        
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(MenuScene);
        window.show();
}
    


    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
}
