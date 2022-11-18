package application;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class Add_Stock_Seperate_Controller  implements Initializable{


	Connection connection;
	@FXML
    private JFXTextField stock_quantity_text;
	
	@FXML 
	AnchorPane yellow_pane;
	
	private int number;
	@FXML
    private Text invalid,measure_text;
	
	@FXML
	private JFXButton add_stock_btn;
	
	@FXML
    private JFXComboBox<String> stock_item_combo;
	
	 ObservableList<String> weight_list=FXCollections.observableArrayList("Kilogram","Numbers");
	
    ObservableList<String> stock_item_list=FXCollections.observableArrayList();


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			connection=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","Hamza","Vitalacedemy2");
			set_combo_stock();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

    	//set_combobox_values();
		// TODO Auto-generated method stub
		
	}
	
//	@FXML
//	public void show_add_stock_item() throws IOException{
//		
//		AnchorPane pane =FXMLLoader.load(getClass().getResource("Add_Stock_Item.fxml"));
//		yellow_pane.getChildren().setAll(pane);
//	}
	
	
	
	public void check_selection() throws SQLException{
		
		 Statement st=(Statement) connection.createStatement();
		    ResultSet s=st.executeQuery("SELECT * FROM stocks where stock_type='"+ stock_item_combo.getValue()+"'");
		   
			while(s.next()){
				
				measure_text.setText(s.getString("stock_measure"));
			
			}
			st.close();
				}
	
		
	
	
	 @FXML
		public void set_combo_stock() throws SQLException{
			

		   // c_level= course_l.getValue();
		    
		    Statement st=(Statement) connection.createStatement();
		    ResultSet s=st.executeQuery("SELECT * FROM stocks");
		   
			while(s.next()){
				
				
				stock_item_list.add(s.getString("stock_type"));
				
				
				stock_item_combo.setItems(stock_item_list);
				
			}
			st.close();
				}
	 
	 @FXML
		public void check_number() {
		 
		  System.out.println("hamza");
		  
		  try{
			  
			  int stock=Integer.parseInt(stock_quantity_text.getText());
			  invalid.setText("");
			  add_stock_btn.setDisable(false);


		  }
		  catch(NumberFormatException e){
			  add_stock_btn.setDisable(true);
			  invalid.setText("Invalid Quantity");
			  
		  }

		

		  System.out.println(""+stock_quantity_text.getText());


}
	 

	 @FXML
		public void add_stock() throws SQLException{
		 
		 if(measure_text.getText().equals("Number")){
			// Integer.parseInt(stock_quantity_text.getText());
			 number=  Integer.parseInt(stock_quantity_text.getText());
			 
		 }
		 
		 else{
			 
			
			 number=Integer.parseInt(stock_quantity_text.getText())*1000;
			 
		 }
		
			 
		 
		 PreparedStatement stmt=(PreparedStatement) connection.prepareStatement("UPDATE stocks SET stock_quantity=stock_quantity+? WHERE stock_type=?");		 
		stmt.setInt(1,number);
 		stmt.setString(2,stock_item_combo.getValue());
 		stmt.executeUpdate();
 	    stmt.close();
 	    Alert confirm=new Alert(AlertType.CONFIRMATION);
 		confirm.setContentText("Stock is added");
 		confirm.showAndWait();
  System.out.println(""+stock_item_combo.getValue());
		 
		

	

}
	 

}
