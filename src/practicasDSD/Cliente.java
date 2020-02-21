package practicasDSD;

import javax.swing.*;

import java.awt.BorderLayout;
import java.util.Random;




public class Cliente 
{
	
	
	
	public static void main (String[] args)
	{
		//Creamos dos factorias cada uno de un tipo diferente de subproducto
		FactoriaAbstracta factoriaCarretera = new FactoriaCarretera();
		FactoriaAbstracta factoriaMontana = new FactoriaMontana();
	 
		//Preparamos la carrera
		//Creamos un número aleatorio N (entre 10 y 40) para crear el número de bicicletas en las carreras
		Integer n = getRandomNumberInRange(10, 40);
		
		
			
	
		
		
		
		
		
		

	}
	
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
}
