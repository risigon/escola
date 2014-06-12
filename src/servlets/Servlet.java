package servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.JPAUtils;
import entidades.Carro;
import entidades.Categoria;



@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManager em = JPAUtils.criarManager();
		
		Categoria cat1 = new Categoria();
		Categoria cat2 = new Categoria();
		cat1.setNome("Hatch");
		cat2.setNome("Sedan");
		
		Carro c1 = new Carro();
		c1.setAno(1990);
		c1.setMarca("GM");
		c1.setModelo("Kadett");
		c1.setPlaca("ICQ-1234");
		
		Carro c2 = new Carro();
		c2.setAno(2010);
		c2.setMarca("Ford");
		c2.setModelo("Focus");
		c2.setPlaca("ICQ-1234");
		
		Carro c3 = new Carro();
		c3.setAno(2012);
		c3.setMarca("GM");
		c3.setModelo("Cruze");
		c3.setPlaca("ICQ-1234");
		
		c1.setCategoria(cat1);
		c2.setCategoria(cat1);
		c3.setCategoria(cat2);
		cat1.setCarros(c1);
		cat1.setCarros(c2);
		cat2.setCarros(c3);
		
		em.getTransaction().begin();
		//em.persist(c1);
		//em.persist(c2);
		//em.persist(c3);
		em.getTransaction().commit();
		
		listarcarroid(7);
		
		//excluircatid(1);
		
		//excluircarrocat(3);

	}
	
	protected void listarcarroid(int id){
				
		EntityManager em = JPAUtils.criarManager();
				
		Query q1 = em.createQuery("select c from Carro c where id=:idcar");
		q1.setParameter("idcar", id);
		Integer catid = q1.getFirstResult();
				
		Query query = em.createQuery("select c from Carro c");
		List<Carro> c = query.getResultList();
		
		int idcat=0;
		String catnome="";
		for(Carro carro: c){
			if(carro.getId()==id){
				//idcat=carro.getCategoria().getId();
				catnome = carro.getCategoria().getNome();
				System.out.println("idCategoria = "+idcat);
			}
		}
						
		for(Carro cars: c){
			//if(cars.getCategoria().getId()==idcat){
			if(cars.getCategoria().getNome().equals(catnome)){
			System.out.println("Id = "+cars.getId()+"NomeCat = "+catnome+"Modelo = "+cars.getModelo()+"\n");
			}
		}
				
		
	}
	
	protected void excluircatid(int idcat){
		
		EntityManager em = JPAUtils.criarManager();
		
		Categoria cat = em.find(Categoria.class, idcat);
		
		try{
			 em.getTransaction().begin();
			 em.remove(cat);
			 em.getTransaction().commit();
			 } catch(Exception e){
			 em.getTransaction().rollback();	 
			 }finally{
			 em.close();	 
			 }
		
	}
	
	protected void excluircarrocat(int idcar){
		
		EntityManager em = JPAUtils.criarManager();
		
		Carro car = em.find(Carro.class, idcar);
				
		int idcat=car.getCategoria().getId();
		
		Categoria cat = em.find(Categoria.class, idcat);
		
		try{
			 em.getTransaction().begin();
			 em.remove(car);
			 em.remove(cat);
			 em.getTransaction().commit();
			 } catch(Exception e){
			 em.getTransaction().rollback();	 
			 }finally{
			 em.close();	 
			 }
	}
}
