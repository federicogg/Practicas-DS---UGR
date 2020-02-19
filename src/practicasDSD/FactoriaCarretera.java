package practicasDSD;

public class FactoriaCarretera implements FactoriaAbstracta
{

	public Bicicleta crearBicicleta()
	{
		BicicletaCarretera bicicletaCarretera = new BicicletaCarretera();
		return bicicletaCarretera;
	}
	
	public Carrera crearCarrera()
	{
		CarreraCarretera carreraCarretera = new CarreraCarretera();
		return carreraCarretera;
	}

}
