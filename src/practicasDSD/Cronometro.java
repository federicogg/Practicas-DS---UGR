package practicasDSD;

public class Cronometro extends Thread{
	
	Boolean fin;
	double time;
	
	Cronometro(double time) {
		this.fin = false;
		this.time = time;
	}
	
	public Boolean getAcabado ()
	{
		return fin;
	}
	public double pauseOfCronometro(){
		return time;
	}
	@Override
	public void run()
	{
		try {
			Thread.sleep((long) (time * 10000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		this.fin = true;
	}
}
