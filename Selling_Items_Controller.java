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
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;

public class Selling_Items_Controller implements Initializable{
	
	Connection connection;
	
	String[] items = {"Fillet Burger", "Supreme Burger", "MegaMix Burger","Wings","Chicken Pieces","Latte","Cappuccino"};
	int fillet,supreme,mega,wings,chicken,latte,cap;
	
	@FXML
    private PieChart items_chart;
	
	ObservableList<javafx.scene.chart.PieChart.Data> list;
	 PieChart.Data slice[];
	
	
	XYChart.Series set1;
	
	@FXML
    private BarChart<?, ?> sales_barchart;
	
	   @FXML
	    private CategoryAxis month_bottom;

	    @FXML
	    private NumberAxis pounds_left;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		// TODO Auto-generated method stub
		
		try {
			connection=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","Hamza","Vitalacedemy2");

			set_list();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	
	public void showna(){
    	sales_barchart.setVisible(false);

		items_chart.setVisible(true);
		//list.clear();
		
	
		
	 list=FXCollections.observableArrayList(
				
				new PieChart.Data("Fillet Burger", fillet),
				new PieChart.Data("Supreme Burger", supreme),
				new PieChart.Data("MegaMix Burger", mega),

				new PieChart.Data("Wings", wings),
				new PieChart.Data("Chicken Pieces",chicken ),
				new PieChart.Data("Latte", latte),
				new PieChart.Data("Cappuccino",cap )


				
				);
		items_chart.setData(list);


	}
	
	public void emp() throws SQLException{
		list.clear();
		set_list();

		
	}
	
	public void set_list() throws SQLException{ 
		
		

		
		
			Statement search_fillet=(Statement) connection.createStatement();
			Statement search_sup=(Statement) connection.createStatement();
			Statement search_wings=(Statement) connection.createStatement();
			Statement search_chick=(Statement) connection.createStatement();
			Statement search_latte=(Statement) connection.createStatement();
			Statement search_cup=(Statement) connection.createStatement();

	    ResultSet result_fillet=search_fillet.executeQuery("SELECT COUNT(*) AS total FROM menu_order where product_name='Fillet Burger'");
	   
			while(result_fillet.next()){
				fillet=result_fillet.getInt("total");
				
		}
			
	
	    ResultSet result_sup=search_sup.executeQuery("SELECT COUNT(*) AS total FROM menu_order where product_name='Supreme Burger'");
	   

			while(result_sup.next()){
				supreme=result_sup.getInt("total");
		
		}
			
			
			 ResultSet result_wings=search_wings.executeQuery("SELECT COUNT(*) AS total FROM menu_order where product_name='Wings'");
			   

				while(result_wings.next()){
					wings=result_wings.getInt("total");
				}
				
				
				 ResultSet result_chick=search_chick.executeQuery("SELECT COUNT(*) AS total FROM menu_order where product_name='Chicken'");
				   

					while(result_chick.next()){
						chicken=result_chick.getInt("total");
					}
					
					 ResultSet result_latte=search_latte.executeQuery("SELECT COUNT(*) AS total FROM menu_order where product_name='Latte'");
					   

						while(result_latte.next()){
							latte=result_latte.getInt("total");
						}
						
						
						 ResultSet result_cap=search_cup.executeQuery("SELECT COUNT(*) AS total FROM menu_order where product_name='Cappuccino'");
						   

							while(result_cap.next()){
								cap=result_cap.getInt("total");
							}
							
							showna();
	}
	

    
    public void show_bar() {
    	
    	items_chart.setVisible(false);
    	
    	sales_barchart.setVisible(true);

    	
      set1=new XYChart.Series<>();

		
		set1.getData().add(new XYChart.Data("Fillet Burger",fillet));
		
		set1.getData().add(new XYChart.Data("Supreme Burger",supreme));
		set1.getData().add(new XYChart.Data("MegaMix Burger",mega));

		set1.getData().add(new XYChart.Data("Wings",wings));
		set1.getData().add(new XYChart.Data("Chicken Pieces",chicken));
		set1.getData().add(new XYChart.Data("Latte",latte));
		set1.getData().add(new XYChart.Data("Cappicino",cap));


		sales_barchart.setLegendVisible(false);

		sales_barchart.setData(FXCollections.observableArrayList(set1));
	//	sales_barchart.getData().add(set1);
		
		Node n = sales_barchart.lookup(".data0.chart-bar");
	    n.setStyle("-fx-bar-fill: red");
	    n = sales_barchart.lookup(".data1.chart-bar");
	    n.setStyle("-fx-bar-fill: blue");
	    n = sales_barchart.lookup(".data2.chart-bar");
	    n.setStyle("-fx-bar-fill: green");
	    n = sales_barchart.lookup(".data3.chart-bar");
	    n.setStyle("-fx-bar-fill: orange");

    }

	

}
