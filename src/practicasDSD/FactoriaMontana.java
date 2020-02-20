package practicasDSD;

public class FactoriaMontana implements FactoriaAbstracta
{
	
	public Bicicleta crearBicicleta(int id)
	{
		BicicletaMontana bicicletaMontana = new BicicletaMontana(id);
		return bicicletaMontana;
	}
	
	public Carrera crearCarrera()
	{
		CarreraMontana carreraMontana = new CarreraMontana();
		return carreraMontana;
	}

}
