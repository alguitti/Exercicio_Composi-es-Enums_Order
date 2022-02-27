package entities.enums;

public enum OrderStatus {
	PENDING_PAYMENT(1),
	PROCESSING(2),
	SHIPPED(3),
	DELIVERED(4);
	
	private int os;
	
	OrderStatus(int os) {
		this.os = os;
	}
	
	public int getOrderStatusN() {
		return os;
	}
	
	public static final String tostring = "PENDING_PAYMENT = 1 "
			+ "PROCESSING = 2 "
			+ "SHIPPED = 3 "
			+ "DELIVERED = 4";
}
