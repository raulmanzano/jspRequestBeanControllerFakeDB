package es.manzano.ejemplo.jspjdbc.business;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.manzano.ejemplo.jspjdbc.model.Primaria;

public class BusinessDelegate {	
	private static final Logger logger = LoggerFactory.getLogger(BusinessDelegate.class);
	
	  private static BusinessDelegate single_instance = null;  
	  public static BusinessDelegate getInstance() 
	    { 
	        if (single_instance == null) 
	            single_instance = new BusinessDelegate(); 	  
	        return single_instance; 
	    }
	  
		private TreeMap<Integer,Primaria> almacen= null;
		private int contador=0;
	  
	//privado para que no se pueda instanciar
	  private BusinessDelegate(){
			this.almacen = new TreeMap<Integer,Primaria>();		
			this.almacen.put(1,(new Primaria(1,"unoC1","unoC2","unoC3")));
			this.almacen.put(2,(new Primaria(2,"dosC1","dosC2","dosC3")));
			this.almacen.put(3,(new Primaria(3,"tresC1","tresC2","tresC3")));
			contador=3;	
	    }
	  
	 /*Operciones basicas*/
	public List<Primaria> getAllPrimaria() {
		//logger.info("getAllPrimaria()");		
		return new ArrayList<Primaria>(almacen.values());
	}
	
	public void insertarPrimaria(Primaria parametro) {
		//logger.info("insertarPrimaria()");
		contador++;
		parametro.setId(contador);
		almacen.put(parametro.getId(),parametro);
	}

	public Primaria getById(Integer parameter) {
		return almacen.get(parameter);
	}

	public void delete(Integer parameter) {
		almacen.remove(parameter);		
	}

	public void updatePrimaria(Primaria primaria) {
		almacen.remove(primaria.getId());
		almacen.put(primaria.getId(),primaria);

	}

}
