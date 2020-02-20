package practicasDSD;

import java.util.Random;


public abstract class Bicicleta extends Thread
{
	protected int id;
	protected int kilometros_recorridos;
	protected Boolean en_carrera;
	protected Tipo tipo;
	
	//Constructor
	Bicicleta (int id, Tipo tipo)
	{
		this.id = id;
		this.kilometros_recorridos = 0;
		this.en_carrera = false;
		this.tipo = tipo;
		
	}
	
	public void setEn_carrera (Boolean en_carrera) 
	{
		this.en_carrera = en_carrera;
	}
	
	
	
	
	
	//Comenzar la hebra ('que la bicicleta empiece a avanzar')
	@Override
	public void run()
	{
		try 
		{
			while (en_carrera)
			{
				Thread.sleep((long) (Math.random()*1000));
				kilometros_recorridos++;
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
			
	
	}

}