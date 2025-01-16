
public class Entrada {

	public static void main(String[] args) {
		/*
		 * Tenemos a unos pobres náufragos esperando ser rescatados por 3 balsas,
		 *  pero el hueco es muy estrecho y sólo una de ellas puede acceder a la vez a la zona donde están.
		 *  Tienes que decidir qué capacidad tiene cada balsa
		 y cuántos náufragos hay en la isla a rescatar.*/
		
        Tunel tunel = new Tunel(50); // Objeto túnel con 50 naúfragos
		
        Balsa balsa1 = new Balsa(1);    
        Balsa balsa2 = new Balsa(2);
        Balsa balsa3 = new Balsa (3);
     // Crear hilos para simular las balsas rescatando
        
        balsa1.start();
        balsa2.start();
        balsa3.start();

		try {
			balsa1.join();
			balsa2.join();
			balsa3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

        
	}

}
