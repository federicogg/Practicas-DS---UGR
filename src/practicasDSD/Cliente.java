package practicasDSD;


import java.util.ArrayList;
import java.util.Random;


public class Cliente extends Thread
{

	public static void main (String[] args)
	{
		//Creamos dos factorias cada uno de un tipo diferente de subproducto
		FactoriaAbstracta factoriaCarretera = new FactoriaCarretera();
		FactoriaAbstracta factoriaMontana = new FactoriaMontana();
	 
		//Preparamos la carrera
		//Creamos un número aleatorio N (entre 10 y 40) para crear el número de bicicletas en las carreras
		int n = getRandomNumberInRange(10, 40);
		
		//creamos los arrays para cada carrera de bicicletas
		ArrayList<Bicicleta> bicicletasMontana = new ArrayList<>();
		ArrayList<Bicicleta> bicicletasCarretera = new ArrayList<>();
		
		//creamos las carreras
		Carrera carreraMontana = factoriaMontana.crearCarrera();
		Carrera carreraCarretera = factoriaCarretera.crearCarrera();
		
		for (int i=0; i<n; i++)
		{
			bicicletasCarretera.add(factoriaCarretera.crearBicicleta(i));
			bicicletasMontana.add(factoriaMontana.crearBicicleta(i));
		}


		//Empezamos las dos carreras
		carreraMontana.empezarCarrera(bicicletasMontana);
		carreraCarretera.empezarCarrera(bicicletasCarretera);
		
		
		//Hasta que no acaben las dos
		while (!carreraMontana.getAcabada() || !carreraCarretera.getAcabada())
		{
			try {
				Thread.sleep(2000);
				//carreraCarretera.mostrarInformacion();
			//	carreraMontana.mostrarInformacion();
				Thread.sleep(2000);
				System.out.println("test");
				System.out.print("\033[H\033[2J");
                System.out.flush();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//carreraCarretera.mostrarFinalizada();
		//carreraMontana.mostrarFinalizada();

	}
	
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("el maximo debe de ser mayor que el mínimo");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
