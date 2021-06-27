    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ApotekGUI.view;

import ApotekGUII.ApotekGUI;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acer
 */
public class LoginController implements Initializable {
    
    @FXML
    private TextField username;
    
    @FXML
    private PasswordField password;
    
    @FXML
    private void HandleLoginButton (ActionEvent event) throws IOException{
    String nama, pw;
        nama = username.getText();
        pw = password.getText();
      
        FXMLLoader loader = new  FXMLLoader(ApotekGUI.class.getResource("/ApotekGUI/view/Tampilanawal.fxml"));
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
