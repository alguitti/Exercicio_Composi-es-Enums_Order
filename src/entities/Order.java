package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import entities.enums.OrderStatus;

public class Order {
	public static SimpleDateFormat sdf = 
			new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	public static SimpleDateFormat sdf2 = 
			new SimpleDateFormat("dd/MM/yyyy");
	private Date moment;
	private OrderStatus status;
	//composições
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	
public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
}


public Date getMoment() {
	return moment;
}


public void setMoment(Date moment) {
	this.moment = moment;
}


public OrderStatus getStatus() {
	return status;
}


public void setStatus(OrderStatus status) {
	this.status = status;
}


public Client getClient() {
	return client;
}


public void setClient(Client client) {
	this.client = client;
}


public List<OrderItem> getItems() {
	return items;
}
	
public void addItem(OrderItem item) {
	items.add(item);
}

public void removeItem(OrderItem item) {
	items.remove(item);
}

public double total() {
	double sum = 0.0;
	for (OrderItem o : items) {
		sum += o.subTotal();
	}
	return sum;
}

public String summary() {
	StringBuilder sb = new StringBuilder();
	sb.append("ORDER SUMMARY: \nOrder Moment: ");
	sb.append(sdf.format(moment) + "\nOrder Status: ");
	sb.append(getStatus() + "\nClient: ");
	sb.append(client.getName() + "(");
	sb.append(sdf2.format(client.getBirthDate()) + ") -");
	sb.append(client.getEmail() + "\n");
	sb.append("Order Items: \n");
	for (OrderItem o : items) {
		sb.append(o.getProduct().getName() + ", Quantity: ");
		sb.append(o.getQuantity() + ", Subtotal: ");
		sb.append(o.subTotal() + "\n");
	}
	sb.append("Total price: $" + String.format("%.2f",total()) + "\n");
	return sb.toString();
}

}
