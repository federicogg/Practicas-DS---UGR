package practicasDSD;



public abstract class Bicicleta extends Thread
{
	protected int id;
	protected int kilometrosRecorridos;
	protected Boolean enCarrera;
	protected Tipo tipo;
	protected boolean successfullyTerminate;


	public int getBicicletaId(){
		return this.id;
	}

	public int getKilometrosRecorridos(){
		return this.kilometrosRecorridos;
	}

	public Boolean getEnCarrera(){
		return this.enCarrera;
	}

	public void setEnCarrera(Boolean enCarrera){
		this.enCarrera = enCarrera;
	}

	public Tipo getTipo(){
		return this.tipo;
	}
	
	//Constructor
	Bicicleta (int id, Tipo tipo)
	{
		this.id = id;
		this.kilometrosRecorridos = 0;
		this.enCarrera = false;
		this.tipo = tipo;
		this.successfullyTerminate = true;
		
	}
	
	public void pararBicicleta () 
	{
		this.enCarrera = false;
	}

	public void mostrarInformacion(){
		if(this.enCarrera) {
			System.out.println("Bicicleta no. " + this.id + " of type " + this.tipo + " is on " + this.kilometrosRecorridos + " km.");
		}
		else{
			System.out.println("Bicicleta no. " + this.id + " of type " + this.tipo + " is out of the game.");
		}
	}
	
	//Comenzar la hebra ('que la bicicleta empiece a avanzar')
	@Override
	public void run()
	{
		try 
		{
			while (enCarrera)
			{
				Thread.sleep((long) (Math.random()*2000));
				kilometrosRecorridos++;
			}
		}catch (Exception e) {
			this.enCarrera = false;
			this.successfullyTerminate = false;
		}
	}


}