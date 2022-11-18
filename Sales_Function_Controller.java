package application;

import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Sales_Function_Controller implements Initializable{
	
	Connection connection;
	float price=0;
	float arr[];
	float jan=0,feb=0,mar=0,apr=0,may=0,june=0;
	
	
	@FXML
	AnchorPane yellow_pane;
	
    @FXML
    private BarChart<?, ?> sales_barchart;

    @FXML
    private CategoryAxis month_bottom;

    @FXML
    private NumberAxis pounds_left;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			connection=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant","Hamza","Vitalacedemy2");
			//set_combo_stock();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
//		XYChart.Series set1=new XYChart.Series<>();
//		
//		set1.getData().add(new XYChart.Data("January",15));
//		
//		set1.getData().add(new XYChart.Data("Febrauray",25));
//		set1.getData().add(new XYChart.Data("March",5));
//		set1.getData().add(new XYChart.Data("April",20));
//		set1.getData().add(new XYChart.Data("May",60));
//		set1.getData().add(new XYChart.Data("June",55));
//		set1.getData().add(new XYChart.Data("July",95));
//		set1.getData().add(new XYChart.Data("August",45));
//		set1.getData().add(new XYChart.Data("September",35));
//		set1.getData().add(new XYChart.Data("October",67));
//		set1.getData().add(new XYChart.Data("November",24));
//		set1.getData().add(new XYChart.Data("December",25));
//		
//		//String 
//
//		
//		sales_barchart.getData().add(set1);
//		
//		Node n = sales_barchart.lookup(".data0.chart-bar");
//	    n.setStyle("-fx-bar-fill: red");
//	    n = sales_barchart.lookup(".data1.chart-bar");
//	    n.setStyle("-fx-bar-fill: blue");
//	    n = sales_barchart.lookup(".data2.chart-bar");
//	    n.setStyle("-fx-bar-fill: green");
//	    n = sales_barchart.lookup(".data3.chart-bar");
//	    n.setStyle("-fx-bar-fill: orange");
	    try {
			gett();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	

	}
	
	public void gett() throws SQLException{
		String da[];
		 String j;
		// arr[1]=1;
		
	    Statement st=(Statement) connection.createStatement();
	    
	   
	    	
	    ResultSet s=st.executeQuery("SELECT * FROM orders where order_status='Completed' ");
	    
	 
	   
		while(s.next()){
		//	System.out.println(" Price "+price);
			da=s.getDate("date_time").toString().split("-");
			
			if(da[1].equals("01")){
				jan=jan+s.getFloat("price");
				
			}
			else if(da[1].equals("02")){
				feb=feb+s.getFloat("price");
				
			}
			
			else if(da[1].equals("03")){
				mar=mar+s.getFloat("price");
				
			}
			
			else if (da[1].equals("04")){
				apr=apr+s.getFloat("price");
				
			}
			else if(da[1].equals("05")){
				may=may+s.getFloat("price");
				
			}
			
			else if(da[1].equals("06")){
				june=june+s.getFloat("price");
				
			}

			
		//	if(s.getDate("date_time").toString().split("-").equals(j)){
		//	if(da[1].equals(j)){
				//System.out.println(" Price "+price);
//				arr[i]=arr[i]+s.getFloat("price");
//				
//				price=price+s.getFloat("price");
//
//			
//		//	da=s.getDate("date_time").toString().split("-");
//			
//		//	System.out.println(" Date"+da[1]);
//			
//			
//			
//			//measure_text.setText(s.getString("stock_measure"));
		
			
//		}
	    }
		st.close();
		check_price();
		
		//System.out.println(" Price "+price);
	}
	
	public void check_price() {
		
	XYChart.Series set1=new XYChart.Series<>();
		
		set1.getData().add(new XYChart.Data("January",jan));
		
		set1.getData().add(new XYChart.Data("Febrauray",feb));
		set1.getData().add(new XYChart.Data("March",mar));
		set1.getData().add(new XYChart.Data("April",apr));
		set1.getData().add(new XYChart.Data("May",may));
		set1.getData().add(new XYChart.Data("June",june));
		set1.getData().add(new XYChart.Data("July",0));
		set1.getData().add(new XYChart.Data("August",0));
		set1.getData().add(new XYChart.Data("September",0));
		set1.getData().add(new XYChart.Data("October",0));
		set1.getData().add(new XYChart.Data("November",0));
		set1.getData().add(new XYChart.Data("December",0));
		
		//String 
		sales_barchart.setLegendVisible(false);

		
		sales_barchart.getData().add(set1);
		
		Node n = sales_barchart.lookup(".data0.chart-bar");
	    n.setStyle("-fx-bar-fill: red");
	    n = sales_barchart.lookup(".data1.chart-bar");
	    n.setStyle("-fx-bar-fill: blue");
	    n = sales_barchart.lookup(".data2.chart-bar");
	    n.setStyle("-fx-bar-fill: green");
	    n = sales_barchart.lookup(".data3.chart-bar");
	    n.setStyle("-fx-bar-fill: orange");
		 


}
	public void show_sales() throws IOException {
		 
		AnchorPane pane =FXMLLoader.load(getClass().getResource("Monthly_Sales.fxml"));
		yellow_pane.getChildren().setAll(pane);
	 


}
	
	
		public void show_selling_items() throws IOException {
		 
			AnchorPane pane =FXMLLoader.load(getClass().getResource("Selling_Items.fxml"));
			yellow_pane.getChildren().setAll(pane);
		 


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


}
