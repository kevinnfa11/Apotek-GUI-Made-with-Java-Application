/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApotekGUI.Sirup;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Alpha
 */
public class Sirup3Controller implements Initializable {
      @FXML
       public void back (ActionEvent event) throws IOException {
       FXMLLoader loader = new  FXMLLoader(ApotekGUI.class.getResource("/ApotekGUI/Sirup/Sirup2.fxml"));
       Parent Menu = loader.load();
       Scene MenuScene = new Scene(Menu);
        
       Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(MenuScene);
        window.show();
              
       }
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
}
