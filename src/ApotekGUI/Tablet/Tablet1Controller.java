/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApotekGUI.Tablet;

import ApotekGUII.ApotekGUI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class Tablet1Controller implements Initializable {
                 public void next(ActionEvent event) throws IOException {               
                FXMLLoader loader = new  FXMLLoader(ApotekGUI.class.getResource("/ApotekGUI/Tablet/Tablet2.fxml"));
                Parent Menu = loader.load();
                Scene MenuScene = new Scene(Menu);
        
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                window.setScene(MenuScene);
                window.show(); 
                   }
                   
                public void obatHyper(ActionEvent event) throws IOException {               
                FXMLLoader loader = new  FXMLLoader(ApotekGUI.class.getResource("/ApotekGUI/view/Tampilanawal.fxml"));
                Parent Menu = loader.load();
                Scene MenuScene = new Scene(Menu);
        
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                window.setScene(MenuScene);
                window.show();
}
                
 
    public void statistikadata(ActionEvent event) throws IOException {               
        FXMLLoader loader = new  FXMLLoader(ApotekGUI.class.getResource("/ApotekGUI/view/StatistikaObat.fxml"));
        Parent Menu = loader.load();
        Scene MenuScene = new Scene(Menu);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(MenuScene);
        window.show();
}
    

    public void tambahdata(ActionEvent event) throws IOException {               
    FXMLLoader loader = new  FXMLLoader(ApotekGUI.class.getResource("/ApotekGUI/view/TambahDataObat.fxml"));
       Parent Menu = loader.load();
       Scene MenuScene = new Scene(Menu);
        
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(MenuScene);
        window.show();
}
                
        

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
