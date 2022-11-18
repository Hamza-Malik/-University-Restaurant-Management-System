package application;
	
import application.Database_Files.databse_connector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent  root =FXMLLoader.load(getClass().getResource("Main_Menu.fxml")); 
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		
		
		}
	}
	
//	public void hanza(){
//		databse_connector data=new databse_connector();
//	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
