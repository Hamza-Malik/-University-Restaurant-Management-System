package application;

import javafx.beans.property.SimpleStringProperty;

public class Get_STock_Table {

	private  SimpleStringProperty stock_name;
	private  SimpleStringProperty quantity_stock;
	private   SimpleStringProperty measure_stock;
	public Get_STock_Table(String stock_name, String quantity_stock,
			String measure_stock) {
		this.stock_name = new SimpleStringProperty(stock_name);
		this.quantity_stock = new SimpleStringProperty(quantity_stock);
		this.measure_stock = new SimpleStringProperty(measure_stock);
	}
	public String getStock_name() {
		return stock_name.get();
	}
	public void setStock_name(SimpleStringProperty stock_name) {
		this.stock_name = stock_name;
	}
	public String getQuantity_stock() {
		return quantity_stock.get();
	}
	public void setQuantity_stock(SimpleStringProperty quantity_stock) {
		this.quantity_stock = quantity_stock;
	}
	public String getMeasure_stock() {
		return measure_stock.get();
	}
	public void setMeasure_stock(SimpleStringProperty measure_stock) {
		this.measure_stock = measure_stock;
	}

}
