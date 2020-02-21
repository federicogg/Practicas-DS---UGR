package practicasDSD;


import java.util.ArrayList;

public class Carrera extends Thread
{
	private ArrayList <Bicicleta> bicicletas;
	private Tipo tipo;
	private Boolean acabada;
	
	Carrera(Tipo tipo) 
	{
		this.tipo = tipo;
		this.acabada = false;
	}
	
	public Boolean getAcabada ()
	{
		return acabada;
	}
	
	public void addBicicletas (ArrayList<Bicicleta> bicicletas)
	{
		this.bicicletas = bicicletas;
	}
	
	public void empezarCarrera(ArrayList<Bicicleta> bicicletas)
	{
		if (!bicicletas.isEmpty())
		{
			this.bicicletas = bicicletas;
			this.start();
			
		}else {
			System.out.println("Debe de pasar como argumento un array con bicicletas");
		}
	}
	
	
	
	@Override
	public void run()
	{
		System.out.println ("La carrera de tipo " + this.tipo.toString() 
		+" con un numero de " + bicicletas.size()  +  " participantes va a comenzar");
		
		Cronometro cronometro = new Cronometro();
		cronometro.start();
		
		for (Bicicleta bicicleta : bicicletas) {
			bicicleta.start();
		}
		
		while (!cronometro.getAcabado())
		{
			try {
				//Implementar que se pierdan las bicicletas respectivas al tipo de carrera
				//Implementar el dar información sobre la carrera cada 2 o 3 segundos
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		for (Bicicleta bicicleta : bicicletas) {
			bicicleta.pararBicicleta();
		}
		
		System.out.println ("Las carrera de " + this.tipo.toString() +   " ha terminado");
	}
	
	
	
	
		
}
