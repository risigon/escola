package entidades;

import javax.persistence.*;

@Entity
public class Carro {
	
	@Id
	@GeneratedValue
	private int id;
	private String placa;
	private int ano;
	private String modelo;
	private String marca;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="idCategoria",nullable=true)
	private Categoria categoria;

	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
}
