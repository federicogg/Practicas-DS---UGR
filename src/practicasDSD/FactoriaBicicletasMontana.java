package practicasDSD;

public class FactoriaBicicletasMontana implements FactoriaAbstracta{
	
	public Bicicleta crearBicicleta()
	{
		BicicletaMontana bicicletaMontana = new BicicletaMontana();
		return bicicletaMontana;
	}

}
