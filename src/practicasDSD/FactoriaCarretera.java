package practicasDSD;

public class FactoriaCarretera implements FactoriaAbstracta{

	public Bicicleta crearBicicleta()
	{
		BicicletaCarrera bicicletaCarrera = new BicicletaCarrera();
		return bicicletaCarrera;
	}

}
