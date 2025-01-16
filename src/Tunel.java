public class Tunel {
    private boolean ocupado = false; // Indica si el túnel está ocupado
    private int numNaufragos =50; // Número total de náufragos

    public Tunel(int numNaufragos) {
        this.numNaufragos = numNaufragos;
    }
    

    public synchronized boolean rescatar(int idBalsa, int capacidadBalsa) {
        while (ocupado) { // Si el túnel = true está ocupado y por lo tanto espera
            try {
                wait(); // Espera hasta que el túnel esté libre
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

       
        ocupado = true;//Lo ponemos a true porque está ocupado
        if (numNaufragos > 0) {
            System.out.println("La balsa " + idBalsa + " está rescatando.");
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            numNaufragos -= capacidadBalsa;
            if (numNaufragos > 0) {
                System.out.println("Quedan " + numNaufragos + " náufragos por rescatar.");
            } else {
                System.out.println("¡Todos los náufragos están a salvo!");
            }
        }

        
        ocupado = false;
        notifyAll(); // Notifica a las demás balsas en espera
        return numNaufragos > 0; // Devuelve true si quedan náufragos
    }
}
