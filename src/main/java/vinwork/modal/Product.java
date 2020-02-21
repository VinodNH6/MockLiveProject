package vinwork.modal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

//@JsonIgnoreProperties(ignoreUnknown = false)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product {	
	@JsonProperty("pid")
    private Integer pid;
	
	@JsonProperty("name")
    private String name;
	
	@JsonProperty("price")
    private Double price;
	
	@JsonProperty("stock")
    private Integer stock;
    
    public Product () {       
    }
    
    public Product (Integer pid, String name, Double price, Integer stock) {
        this.pid = pid;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
 
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Double getPrice() {
        return price;
    }


    public void setPrice(Double price) {
        this.price = price;
    }


    public Integer getStock() {
        return stock;
    }


    public void setStock(Integer stock) {
        this.stock = stock;
    }


    public Integer getPid() {
        return pid;
    }

    
    public void setPid(Integer pid) {
        this.pid = pid;
    }   
}
