package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.Node;


public class LoginController  {

	
	@FXML
	public void shownexts3(ActionEvent event ) throws IOException{
		
       ((Node)event.getSource()).getScene().getWindow().hide();

		
		Stage primaryStage=new Stage();
		FXMLLoader loader=new FXMLLoader();
		Pane root =FXMLLoader.load(getClass().getResource("FunctionsPage.fxml")); 
		//Admin_Function ad_f=(Admin_Function)loader.getController();
		Scene scene2 = new Scene(root);
		primaryStage.setScene(scene2);
		primaryStage.show();


			}
}
