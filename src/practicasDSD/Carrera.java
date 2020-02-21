package practicasDSD;


import java.util.ArrayList;

public class Carrera extends Thread
{
	public ArrayList <Bicicleta> bicicletas;
	protected Tipo tipo;
	
	public void addBicicletas (ArrayList<Bicicleta> bicicletas)
	{
		this.bicicletas = bicicletas;
	}
	
	public Carrera(Tipo tipo) 
	{
		this.tipo = tipo;
	}
	
	
	@Override
	public void run()
	{
		
	}
	
	
	
	
		
}
