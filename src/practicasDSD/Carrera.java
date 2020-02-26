package practicasDSD;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


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

	public void mostrarInformacion() {
        System.out.println("The game is over.");
        Bicicleta[] bicicletas1 = bicicletas.toArray((new Bicicleta[bicicletas.size()]));
        int n = bicicletas1.length;
        Bicicleta temp;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (bicicletas1[j - 1].kilometrosRecorridos < bicicletas1[j].kilometrosRecorridos) {
                    temp = bicicletas1[j - 1];
                    bicicletas1[j - 1] = bicicletas1[j];
                    bicicletas1[j] = temp;
                }
            }
        }
        for (Bicicleta bicicleta : bicicletas1) {
            if(bicicleta.successfullyTerminate) {
                System.out.println("Bicicleta no. " + bicicleta.id + " of type " + bicicleta.tipo + " run for " + bicicleta.kilometrosRecorridos);
            }else{
                System.out.println("Bicicleta no. " + bicicleta.id + " of type " + bicicleta.tipo + " did not terminate.");
            }
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

		int sizeToRemove1 = (int) (bicicletas.size()*0.1);
		int sizeToRemove2 = (int) (bicicletas.size()*0.2);

		for (Bicicleta bicicleta : bicicletas) {
			bicicleta.start();
			bicicleta.setEnCarrera(true);
		}

		boolean temp = true;

        long startTime = System.nanoTime();
        long endTime   = 0;
        while (!cronometroDeCarrera.getAcabado()) {
			try {
				if (!cronometroDeTerminar.isAlive() && temp) {
					if(tipo==Tipo.CARRETERA){

					while (sizeToRemove1 > 0) {
						bicicletas.get(sizeToRemove1).interrupt();
						sizeToRemove1--;
					}
					}
					if(tipo==Tipo.MONTANA){
						while (sizeToRemove2 > 0) {
							bicicletas.get(sizeToRemove2).interrupt();
							sizeToRemove2--;
						}
					}
					temp = false;

				}
                Thread.sleep(1000);
				if(((endTime - startTime)/1000000000) % 10 == 0){
				    for (Bicicleta bicicleta : bicicletas) {
					    	bicicleta.mostrarInformacion();
				    }
                    System.out.println("--------------------------------------------");

                }
			} catch (Exception e) {
				e.printStackTrace();
			}
			endTime = System.nanoTime();
		}
		
		
		for (Bicicleta bicicleta : bicicletas) {
			bicicleta.pararBicicleta();

		}
		acabada = true;
	}
}
