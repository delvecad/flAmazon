
public class Statement {
	private String baseStatement;
	private int itemID;
	private String itemName;
	private String category;
	private int quantity;
	private double price;
	private double shipping;
	private String myStatement;
	
	public Statement(){
		setBaseStatement("INSERT INTO ShoppingCart (ItemID, ItemName, Category, Quantity, Price, Shipping) VALUES(");
		setItemID(0);
		setItemName("x");
		setCategory("x");
		setQuantity(0);
		setPrice(0);
		setShipping(0);
		setMyStatement(baseStatement +  itemID + ", " + itemName + ", " + category + ", " + quantity + ", " + price + ", " + shipping + ")");
	}

	public String getBaseStatement() {
		return baseStatement;
	}

	public void setBaseStatement(String baseStatement) {
		this.baseStatement = baseStatement;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getShipping() {
		return shipping;
	}

	public void setShipping(double shipping) {
		this.shipping = shipping;
	}

	public String getMyStatement() {
		return myStatement;
	}

	public void setMyStatement(String myStatement) {
		this.myStatement = myStatement;
	}
	
	//Constructs the full INSERT INTO statement
	public void constructStatement(){
		setMyStatement(baseStatement +  itemID + ", " + "\"" + itemName + "\"" + ", " + "\"" + category + "\"" + ", " + quantity + ", " + price + ", " + shipping + ")");
	}
}
