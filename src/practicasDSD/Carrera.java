package practicasDSD;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;


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

	public void mostrarInformacion(){
		for(Bicicleta bicicleta : this.bicicletas){
			bicicleta.mostrarInformacion();
		}
	}

	@Override
	public void run()
	{
		System.out.println ("La carrera de tipo " + this.tipo.toString() 
		+" con un numero de " + bicicletas.size()  +  " participantes va a comenzar");
		
		Cronometro cronometroDeCarrera = new Cronometro(6);
		Cronometro cronometroDeTerminar = new Cronometro(Math.random() * 4);
		cronometroDeCarrera.start();
		cronometroDeTerminar.start();
		
		for (Bicicleta bicicleta : bicicletas) {
			bicicleta.start();
			bicicleta.setEnCarrera(true);
		}
		int sizeToRemove1 = (int) (bicicletas.size()*0.1);

		//System.out.println(sizeToRemove);
		boolean temp = true;
		while (!cronometroDeCarrera.getAcabado()) {
			try {
				if (!cronometroDeTerminar.isAlive() && temp) {
					while (sizeToRemove1 > 0) {
						bicicletas.get(sizeToRemove1).interrupt();
						sizeToRemove1--;
					}
					temp = false;

				}
				for (Bicicleta bicicleta : bicicletas) {
					if ((cronometroDeCarrera.pauseOfCronometro())==3||(cronometroDeCarrera.pauseOfCronometro())==6)
						bicicleta.mostrarInformacion();
				}



				// Implementar el remover % de las bicicletas respectivas al tipo de carrera
				//Implementar el dar información sobre la carrera cada 2 o 3 segundos
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		for (Bicicleta bicicleta : bicicletas) {
			bicicleta.pararBicicleta();

		}
		
		
		acabada = true;
		
	}
	
	
	
	
		
}
