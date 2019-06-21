package domain;

public class Paging {
	 
	private int id;
	private String name;
	private double price;
	private String category;
	private int num;
	private String imgurl;
	private String description;
 
    public Paging() {
    	super();
    }

    public Paging(int id,String name,double price, String category,int num,String imgurl,String description) {
    
       this.id = id;
       this.name = name;
       this.price = price;
       this.category = category;
       this.num = num;
       this.imgurl = imgurl;
       this.description = description;
    }
 
    public Integer getId() {
       return id;
    }
 
    public void setId(Integer id) {
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
 
    @Override
    public String toString() {
       return "Paging [id=" + id + ", name=" + name + ", price=" + price + ", num=" + num + ", imgurl=" + imgurl + ", description " + description 
              + "]";
    }
}
