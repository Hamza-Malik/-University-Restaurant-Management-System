package application;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTabPane;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Customer_Function_Controller implements Initializable{
	
	Connection connection;
	
	public ObservableList<Get_STock_Table> customer_list=FXCollections.observableArrayList();
	
	public ObservableList<Get_STock_Table> selected_customer_list=FXCollections.observableArrayList();
	
	public ObservableList<Get_STock_Table> selected_order_list=FXCollections.observableArrayList();


	
	 @FXML
		public  ObservableList<Get_STock_Table> selected_items=FXCollections.observableArrayList();
		
		public  ObservableList<Get_STock_Table> selected_order=FXCollections.observableArrayList();

	
	 @FXML
	    private Tab history_tab,customer_order_tab,order_details_tab;
	 
	 @FXML
	    private JFXTabPane main_tab;
	
	
	@FXML
    private TableColumn<Get_STock_Table,String> customer_id_column,customerorder_id_column,order_id_column,date_column;
    @FXML
    private TableColumn<Get_STock_Table,String> customer_name_column;

    @FXML
    private TableColumn<Get_STock_Table,String> quantity_column;
    
    @FXML
    private TableView<Get_STock_Table> customer_table,order_history_table;




	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		history_tab.setDisable(true);
	//	order_history_table.setDisable(true);

		try {
			connection=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","Hamza","Vitalacedemy2");
			setlist();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@FXML
	public void show_selected_order(ActionEvent event ) throws IOException, SQLException{
		
//if(order_history_table.getSelectionModel().getSelectedItems().isEmpty()){
//	
//	Alert error_edit_module=new Alert(AlertType.ERROR);
//	error_edit_module.setContentText("No Order Selected");
//	error_edit_module.showAndWait();
//}
//else{
//	
//	order_history_table.getItems().clear();
//
//	
//	SingleSelectionModel<Tab> selected_Tab = main_tab.getSelectionModel();
//    main_tab.getTabs();
//    selected_Tab.select(2);		
//    order_history_table.setDisable(false);
//    
//
//    selected_order=order_history_table.getSelectionModel().getSelectedItems();
////    	
//    	for( Get_STock_Table select_order: selected_order){
//    		System.out.println("The Order id of selected module is "+select_order.getQuantity_stock());
//    		
//    		 Statement search_stmt_3=(Statement) connection.createStatement();
//    		 Statement search_stmt_4=(Statement) connection.createStatement();
//
//
//    		    ResultSet result=search_stmt_3.executeQuery("SELECT * FROM orders where order_id="+Integer.parseInt(select_order.getStock_name())+" and order_status='Completed'");
//    		   
//
//    				if(result.next()){
//    					
//    	    		    ResultSet result_menu=search_stmt_3.executeQuery("SELECT * FROM menu_order where order_id='"+result.getString("order_id")+"' and status='Completed'");
//
//    					
//    		    		//System.out.println("The Module id of selected module is "+select_customer.getStock_name());
//
//    					
//    				//	String[] da=result.getDate("date_time").toString().split(" ");
//    					
//    				//
//    					//selected_customer_list.add(new Get_STock_Table(result.getString("recieve_status"),result.getString("order_id"),da[0]));
//
//    			
//    					
//    					
//    				}
//
//    	}
//    	
//    	set_table_history();
//}

	}
	
	@FXML
	public void show_history_page(ActionEvent event ) throws IOException, SQLException{
		
if(customer_table.getSelectionModel().getSelectedItems().isEmpty()){
	
	Alert error_edit_module=new Alert(AlertType.ERROR);
	error_edit_module.setContentText("No Order Selected");
	error_edit_module.showAndWait();
}
else{
	
	order_history_table.getItems().clear();

	
	SingleSelectionModel<Tab> selected_Tab = main_tab.getSelectionModel();
    main_tab.getTabs();
    selected_Tab.select(1);		
    history_tab.setDisable(false);
    

    	selected_items=customer_table.getSelectionModel().getSelectedItems();
//    	
    	for( Get_STock_Table select_customer: selected_items){
    		System.out.println("The Module id of selected module is "+select_customer.getStock_name());
    		
    		 Statement search_stmt_2=(Statement) connection.createStatement();

    		    ResultSet result=search_stmt_2.executeQuery("SELECT * FROM orders where customer_id='"+select_customer.getStock_name()+"' and order_status='Completed'");
    		   

    				while(result.next()){
    		    		System.out.println("The Module id of selected module is "+select_customer.getStock_name());

    					
    					String[] da=result.getDate("date_time").toString().split(" ");
    					
    				
    					selected_customer_list.add(new Get_STock_Table(result.getString("recieve_status"),result.getString("order_id"),da[0]));

    			
    					
    					
    				}

    	}
    	
    	set_table_history();
}

	}
	
	public void go_home(ActionEvent event) throws IOException{
		
		
        ((Node)event.getSource()).getScene().getWindow().hide();

		
		Stage primaryStage=new Stage();
		FXMLLoader loader=new FXMLLoader();
		Pane root =FXMLLoader.load(getClass().getResource("Main_Menu.fxml")); 
		//Admin_Function ad_f=(Admin_Function)loader.getController();
		Scene scene2 = new Scene(root);
		primaryStage.setScene(scene2);
		primaryStage.show();
	}
	
	 @FXML
		public void check_number() {
		 
		  System.out.println("hamza");
		


}
	
	
	public void setlist() throws SQLException{
		
		 Statement search_stmt=(Statement) connection.createStatement();
		 Statement search_cust_orders=(Statement) connection.createStatement();

		    ResultSet result=search_stmt.executeQuery("SELECT * FROM customers");
		   

				while(result.next()){
					
				    ResultSet result_orders=search_cust_orders.executeQuery("SELECT COUNT(*) AS num FROM orders where customer_id='"+result.getString("student_customerid") +"' and order_status='Completed'");

					while(result_orders.next()){
						customer_list.add(new Get_STock_Table(Integer.toString(result.getInt("student_customerid")),result.getString("name"),Integer.toString(result_orders.getInt("num"))));

					}
					
					//id,name,number
				}
		set_table();
	}
	
	  public void set_table(){
		  customer_id_column.setCellValueFactory(new PropertyValueFactory<Get_STock_Table,String>("stock_name"));
		  customer_name_column.setCellValueFactory(new PropertyValueFactory<Get_STock_Table,String>("quantity_stock"));
		  quantity_column.setCellValueFactory(new PropertyValueFactory<Get_STock_Table,String>("measure_stock"));
		  customer_table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		  customer_table.setItems(customer_list);
	    }
	  
	  
	  public void set_table_history(){
		  
		 
		  customerorder_id_column.setCellValueFactory(new PropertyValueFactory<Get_STock_Table,String>("stock_name"));
		  order_id_column.setCellValueFactory(new PropertyValueFactory<Get_STock_Table,String>("quantity_stock"));
		  date_column.setCellValueFactory(new PropertyValueFactory<Get_STock_Table,String>("measure_stock"));
		  order_history_table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		  order_history_table.setItems(selected_customer_list);
	    }
	
	
	

	

}
