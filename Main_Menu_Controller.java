package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main_Menu_Controller implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void stockfunctions(ActionEvent event) throws IOException{
		((Node)event.getSource()).getScene().getWindow().hide();

		
		Stage primaryStage=new Stage();
		FXMLLoader loader=new FXMLLoader();
		Pane root =FXMLLoader.load(getClass().getResource("Stock_Functions.fxml")); 
		//Admin_Function ad_f=(Admin_Function)loader.getController();
		Scene scene2 = new Scene(root);
		primaryStage.setScene(scene2);
		primaryStage.show();
	}
	
	@FXML
	public void salesfunctions(ActionEvent event) throws IOException{
		((Node)event.getSource()).getScene().getWindow().hide();

		
		Stage primaryStage=new Stage();
		FXMLLoader loader=new FXMLLoader();
		Pane root =FXMLLoader.load(getClass().getResource("Sales_Function.fxml")); 
		//Admin_Function ad_f=(Admin_Function)loader.getController();
		Scene scene2 = new Scene(root);
		primaryStage.setScene(scene2);
		primaryStage.show();
	}
	
	
	@FXML
	public void customersfunctions(ActionEvent event) throws IOException{
		((Node)event.getSource()).getScene().getWindow().hide();

		
		Stage primaryStage=new Stage();
		FXMLLoader loader=new FXMLLoader();
		Pane root =FXMLLoader.load(getClass().getResource("Customer_Functions.fxml")); 
		//Admin_Function ad_f=(Admin_Function)loader.getController();
		Scene scene2 = new Scene(root);
		primaryStage.setScene(scene2);
		primaryStage.show();
	}

	

}
