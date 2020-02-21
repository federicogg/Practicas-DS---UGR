package practicasDSD;



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
	
	public void pararBicicleta () 
	{
		this.en_carrera = false;
	}
	
	
	//Comenzar la hebra ('que la bicicleta empiece a avanzar')
	@Override
	public void run()
	{
		try 
		{
			while (en_carrera)
			{
				Thread.sleep((long) (Math.random()*2000));
				kilometros_recorridos++;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}