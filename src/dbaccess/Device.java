package dbaccess;

public class Device implements Component
{
	private int id;
	private String name;
	private double price;
	private String type;
	
	public int getId() 
	{
		return id;
	}
	
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public double getPrice() 
	{
		return price;
	}
	
	public void setPrice(double price) 
	{
		this.price = price;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	@Override
	public String data() 
	{
		String results = "";
		results += "<html><br> " + "ID: " + this.id + "   NAME: " + this.name
				+ "   PRICE: " + this.price + "   TYPE: " + this.type +  "<br>";
		return results;
	}
}