package application;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class Add_Stock_item_Controller implements Initializable{
	
	Connection connection;
	@FXML
    private JFXTextField item_name;
	
	  ObservableList<String> measure=FXCollections.observableArrayList("Kilogram(Kg)","Number");
	@FXML
    private JFXComboBox<String> measure_combo;
	
	   @FXML
	    private AnchorPane yellow_pane;
	   
	   @FXML
	    private Text measure_error,name_error;


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			connection=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","Hamza","Vitalacedemy2");
			//set_combo_stock();
			measure_combo.setItems(measure);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	public void add_item() throws SQLException, IOException{
		
		if(measure_combo.getValue()==null || item_name.getText().isEmpty()){
			name_error.setText("");

			
			name_error.setText("All details must be filled");
			
		}
		
		else{
			name_error.setText("");
			
			PreparedStatement add_stock_stmt=(PreparedStatement) connection.prepareStatement("INSERT INTO stocks(stock_type,stock_quantity,stock_measure)"
    				+ " VALUES(?,?,?)");
			
			add_stock_stmt.setString(1,item_name.getText());
			add_stock_stmt.setInt(2,0);
			add_stock_stmt.setString(3,measure_combo.getValue().toString());
			
			add_stock_stmt.execute();
			add_stock_stmt.close();
			
			Alert confirm=new Alert(AlertType.CONFIRMATION);
	 		confirm.setContentText("Stock Item is added");
	 		confirm.showAndWait();
	 		
	 		AnchorPane pane =FXMLLoader.load(getClass().getResource("Add_Stock_Item.fxml"));
			yellow_pane.getChildren().setAll(pane);

			
		}
		
		
		
	}

	

}
