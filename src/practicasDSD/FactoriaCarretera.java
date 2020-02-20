package practicasDSD;

public class FactoriaCarretera implements FactoriaAbstracta
{

	public Bicicleta crearBicicleta(int id)
	{
		BicicletaCarretera bicicletaCarretera = new BicicletaCarretera(id);
		return bicicletaCarretera;
	}
	
	public Carrera crearCarrera()
	{
		CarreraCarretera carreraCarretera = new CarreraCarretera();
		return carreraCarretera;
	}

}
