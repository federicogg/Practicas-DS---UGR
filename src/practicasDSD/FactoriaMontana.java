package practicasDSD;

public class FactoriaMontana implements FactoriaAbstracta
{
	
	public Bicicleta crearBicicleta()
	{
		BicicletaMontana bicicletaMontana = new BicicletaMontana();
		return bicicletaMontana;
	}
	
	public Carrera crearCarrera()
	{
		CarreraMontana carreraMontana = new CarreraMontana();
		return carreraMontana;
	}

}
