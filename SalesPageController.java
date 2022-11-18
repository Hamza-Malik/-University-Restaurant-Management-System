package application;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTreeTableView;
import com.mysql.jdbc.Connection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SalesPageController implements Initializable{
	
	Connection connection;
	
	@FXML
	 public AnchorPane main_right_pane;
	
	@FXML
	 public AnchorPane calculator_panel;
	
	@FXML
	 public AnchorPane food_pane;
	
	@FXML
	public JFXTabPane burger_pane;
	
	@FXML
	public JFXTabPane pizza_pane;
	
	@FXML
	public JFXTabPane wrap_pane;
	
	@FXML
	public JFXTabPane side_items_pane;
	
	@FXML
	public JFXTabPane food_category_panel;
	
	@FXML
	public Text text;
	
	    @FXML
	    private TableColumn<Customer_Order,String> item_column;

	    @FXML
	    private TableColumn<Customer_Order,String> quantity_column;

	    @FXML
	    private TableColumn<Customer_Order,String> price_column;

	    @FXML
	    private TableColumn<Customer_Order,String> extra_options_column;
	    
	    @FXML
	    private TableView<Customer_Order> order_table;
	    
	    @FXML
		public ObservableList<Customer_Order> order= FXCollections.observableArrayList();
	
	
	//item_column
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
//		try {
//		connection=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","Hamza","Vitalacedemy2");
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
		
	}
	
//	module_search.add(new Const_Module(result.getString("module_code"), result.getString("module_title"), result.getString("module_start"), result.getString("module_tutor_name")));
//}
	
	@FXML
	public void SetOrderTable(ActionEvent event ) throws IOException{

		order.add(new Customer_Order( "Supreme Burger","1","£ 4.45"," "));
		SetTable();
		
		}
	
	@FXML
	public void SetOrderTable2(ActionEvent event ) throws IOException{

		order.add(new Customer_Order( "Normal Burger","1","£ 4.00"," "));
		SetTable();
		
		
		}
	
	@FXML
	public void SetTable(){
		item_column.setCellValueFactory(new PropertyValueFactory<Customer_Order,String>("order_item"));
		quantity_column.setCellValueFactory(new PropertyValueFactory<Customer_Order,String>("order_quantity"));
		price_column.setCellValueFactory(new PropertyValueFactory<Customer_Order,String>("order_price"));
		extra_options_column.setCellValueFactory(new PropertyValueFactory<Customer_Order,String>("order_extra"));
		order_table.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		order_table.setItems(order);
		
		}


			

	
	 										// To Open Calculator
	@FXML
	public void OpenCalculator(ActionEvent event ) throws IOException{

		food_category_panel.setVisible(false);
		burger_pane.setVisible(false);
		calculator_panel.setVisible(true);


			}
	
	@FXML
	public void PressBack(ActionEvent event ) throws IOException{
		

		calculator_panel.setVisible(false);
		burger_pane.setVisible(true);
		food_category_panel.setVisible(true);


			}
	
	@FXML
	public void PressBurger(ActionEvent event ) throws IOException{
		
	
		burger_pane.setVisible(true);
		pizza_pane.setVisible(false);
		wrap_pane.setVisible(false);

			}
	
	@FXML
	public void PressPizza(ActionEvent event ) throws IOException{
		
	
		burger_pane.setVisible(false);
		pizza_pane.setVisible(true);
		wrap_pane.setVisible(false);

			}
	
	
	@FXML
	public void PressWrap(ActionEvent event ) throws IOException{
		
	
		burger_pane.setVisible(false);
		pizza_pane.setVisible(false);
		wrap_pane.setVisible(true);

			}
	
	@FXML
	public void PressSideItems(ActionEvent event ) throws IOException{
		
	
		burger_pane.setVisible(false);
		pizza_pane.setVisible(false);
		wrap_pane.setVisible(false);
		side_items_pane.setVisible(true);

			}
	
	@FXML
	public void Press0(ActionEvent event ) throws IOException{
		
		text.setText("0");


			}
	
	@FXML
	public void Press1(ActionEvent event ) throws IOException{
		
		text.setText("1");


			}
	
	@FXML
	public void Press2(ActionEvent event ) throws IOException{
		
		text.setText("2");


			}
	
	@FXML
	public void Press3(ActionEvent event ) throws IOException{
		
		text.setText("3");


			}
	
	@FXML
	public void Press4(ActionEvent event ) throws IOException{
		
		text.setText("4");


			}
	
	@FXML
	public void Press5(ActionEvent event ) throws IOException{
		
		text.setText("5");


			}
	
	@FXML
	public void Press6(ActionEvent event ) throws IOException{
		
		text.setText("6");


			}
	
	@FXML
	public void Press7(ActionEvent event ) throws IOException{
		
		text.setText("7");


			}
	
	@FXML
	public void Press8(ActionEvent event ) throws IOException{
		
		text.setText("8");


			}
	
	@FXML
	public void Press9(ActionEvent event ) throws IOException{
		
		text.setText("9");


			}
	
	@FXML
	public void PressDot(ActionEvent event ) throws IOException{
		
		text.setText(".");


			}
	
	@FXML
	public void PressPlus(ActionEvent event ) throws IOException{
		
		text.setText("+");

			}
	
	@FXML
	public void PressPound5(ActionEvent event ) throws IOException{
		
		text.setText("£ 5");

			}
	
	@FXML
	public void PressPound10(ActionEvent event ) throws IOException{
		
		text.setText("£ 10");

			}
	
	@FXML
	public void PressPound20(ActionEvent event ) throws IOException{
		
		text.setText("£ 20");

			}
	
	@FXML
	public void PressPound50(ActionEvent event ) throws IOException{
		
		text.setText("£ 50");

			}

	

}
