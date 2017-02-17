
public class Query {
	private String baseQuery;
	private String priceChunk;
	private String categoryChunk;
	private String orderbyChunk;
	private String myQuery;
	
	public Query(){
		setBaseQuery("SELECT ItemID, ItemName, Category, Quantity, Price, Shipping FROM ShoppingCart WHERE (1=1)");
		setPriceChunk("");
		setCategoryChunk("");
		setOrderbyChunk("");
	}
	public String getQuery() {
		return myQuery;
	}
	public void setQuery(String query) {
		this.myQuery = query;
	}
	public String getBaseQuery() {
		return baseQuery;
	}
	public void setBaseQuery(String baseQuery) {
		this.baseQuery = baseQuery;
	}
	public String getPriceChunk() {
		return priceChunk;
	}
	public void setPriceChunk(String priceChunk) {
		this.priceChunk = priceChunk;
	}
	public String getCategoryChunk() {
		return categoryChunk;
	}
	public void setCategoryChunk(String categoryChunk) {
		this.categoryChunk = categoryChunk;
	}
	public String getOrderbyChunk() {
		return orderbyChunk;
	}
	public void setOrderbyChunk(String orderbyChunk) {
		this.orderbyChunk = orderbyChunk;
	}
	
	
	//Constructs the complete query
	public void constructQuery(){
		this.myQuery =  baseQuery + priceChunk + categoryChunk + orderbyChunk;
	}
	
	//Sets the query back to the default
	public void setDefault(){
		setBaseQuery("SELECT ItemID, ItemName, Category, Quantity, Price, Shipping FROM ShoppingCart WHERE (1=1)");
		setPriceChunk("");
		setCategoryChunk("");
		setOrderbyChunk("");
	}
}
