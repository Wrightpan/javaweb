package dao;


public class Product {
	private int id;
	private String name;
	private double price;
	private String category;
	private int num;
	private String imgurl;
	private String description;
	
	public Product() {
		this.id = 0;
		this.name = "";
		this.price = 0.0;
		this.category = "";
		this.num = 0;
		this.imgurl = "";
		this.description = "";
	}
	
	@Override
	public int hashCode() {
		return this.id;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass())
			return false;

        Product product = (Product) o;

        if (this.id == product.id) {
        	return true;
        }
        return true;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public int getNum() {
		return num;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getImgurl() {
		return imgurl;
	}
	
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
}
