package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		//instanciação Client
		System.out.println("Enter client's data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth (dd/mm/yyyy): ");
		Date birth = sdf.parse(sc.nextLine());
		Client client = new Client(name, email, birth);
		
		//instanciação Order
		System.out.println("Enter order's data:");
		System.out.print("Status as ( " + OrderStatus.tostring
				+ "):");
		//String status = sc.nextLine();
		int nStatus = sc.nextInt();
		String status = getStatus(nStatus);
		Order order = new Order (new Date(), OrderStatus.valueOf(status), client);
		
		//Instanciação OrderItem/Product e atribuição na lista do Order
		System.out.print("How many items?: ");
		int n = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			sc.nextLine();
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String pName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Product quantity: ");
			int quantity = sc.nextInt();
			Product product = new Product(name, price);
			OrderItem item = new OrderItem (quantity, product);
			order.addItem(item);	
		}
		
		System.out.println(order.summary());
		
	sc.close();
	}

public static String getStatus(int n) {
	switch (n) {
	case 1: return "PENDING_PAYMENT";
	case 2: return "PROCESSING"; 
	case 3: return "SHIPPED";
	case 4: return "DELIVERED"; 
	default: return "PENDING_PAYMENT"; }
	}
}

