package model;

public class Producto {

	private String nombre;
	private String descripcion;
	private Double peso;
	private Integer stock;

	public Producto(String nombre, String descripcion, Double peso, Integer stock) {
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.peso = peso;
		this.stock = stock;
	}

	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [getNombre()=" + getNombre() + ", getDescripcion()=" + getDescripcion() + ", getPeso()="
				+ getPeso() + ", getStock()=" + getStock() + "]";
	}

}
