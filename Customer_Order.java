package application;

import javafx.beans.property.SimpleStringProperty;

public class Customer_Order {
	
	private  SimpleStringProperty order_item;
	private  SimpleStringProperty order_quantity;
	private   SimpleStringProperty order_price;
	//private final StringProperty module_code;
	private  SimpleStringProperty order_extra;

	public Customer_Order(String order_item,String order_quantity,String order_price,String order_extra) {
		// TODO Auto-generated constructor stub
		
		
		this.order_item=new SimpleStringProperty(order_item);
		this.order_quantity=new SimpleStringProperty(order_quantity);
		this.order_price=new SimpleStringProperty(order_price);
		this.order_extra=new SimpleStringProperty(order_extra);
	}

	public String getOrder_item() {
		return order_item.get();
	}

	public void setOrder_item(SimpleStringProperty order_item) {
		this.order_item = order_item;
	}

	public String getOrder_quantity() {
		return order_quantity.get();
	}

	public void setOrder_quantity(SimpleStringProperty order_quantity) {
		this.order_quantity = order_quantity;
	}

	public String getOrder_price() {
		return order_price.get();
	}

	public void setOrder_price(SimpleStringProperty order_price) {
		this.order_price = order_price;
	}

	public String getOrder_extra() {
		return order_extra.get();
	}

	public void setOrder_extra(SimpleStringProperty order_extra) {
		this.order_extra = order_extra;
	}

}
