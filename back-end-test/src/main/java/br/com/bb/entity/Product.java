package br.com.bb.entity;

public class Product {

	private Integer id;
	private String name;
	private Category category;
	private Double value;
	
	public Product() {
		super();
	}
	
	public Product(Integer id, String name, Category category, Double value) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	
}
