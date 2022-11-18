package application;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Display_Stock_Controller  implements Initializable{
	
	Connection connection;
	
	
	 @FXML
	    private TableView<Get_STock_Table> stock_table;
	    
	    @FXML
	    private TableColumn<Get_STock_Table,String> stock_item_column;

	    @FXML
	    private TableColumn<Get_STock_Table,String> quantity_column;

	    @FXML
	    private TableColumn<Get_STock_Table,String> measure_column;
	    
	    
	    @FXML
		public ObservableList<Get_STock_Table> stock_list=FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			connection=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","Hamza","Vitalacedemy2");
			setTable();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void setTable() throws SQLException{
		
		 Statement search_stmt=(Statement) connection.createStatement();
		    ResultSet result=search_stmt.executeQuery("SELECT * FROM stocks");
		   

				while(result.next()){
					
					
					stock_list.add(new Get_STock_Table(result.getString("stock_type"), Integer.toString(result.getInt("stock_quantity")), result.getString("stock_measure")));
				}
		set_table();
	}
	
	   public void set_table(){
		   stock_item_column.setCellValueFactory(new PropertyValueFactory<Get_STock_Table,String>("stock_name"));
		   quantity_column.setCellValueFactory(new PropertyValueFactory<Get_STock_Table,String>("quantity_stock"));
		   measure_column.setCellValueFactory(new PropertyValueFactory<Get_STock_Table,String>("measure_stock"));
		   stock_table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		   stock_table.setItems(stock_list);
	    }
	
	

	

}
