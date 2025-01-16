public class Balsa extends Thread {
    private int idBalsa;
    private  final int capacidadBalsa = 6; // Capacidad constante
    private static Tunel tunel;

   

	public Balsa(int idBalsa) {
		super();
		this.idBalsa = idBalsa;
	}



	@Override
    public void run() {
		while (tunel.rescatar(idBalsa, capacidadBalsa)) {
            
        }
    }
}
