package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Categoria {

	@Id
	@GeneratedValue
	private int id;
	@Column(unique=false)
	private String nome;
	
	@OneToMany(mappedBy="categoria")
	private List<Carro> carros = new ArrayList<Carro>();
	
	public List<Carro> getCarros() {
		return carros;
	}
	public void setCarros(Carro carros) {
		this.carros.add(carros);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
}
