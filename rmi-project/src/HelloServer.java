import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class HelloServer implements Hello {

	public static void main(String[] args) {
		try {
			HelloServer server = new HelloServer();
			//Exporta o server para o stub ("apendice ou toco") do RMI na porta 0
			Hello stub = (Hello) UnicastRemoteObject.exportObject(server, 0);
			
			Registry registry = LocateRegistry.getRegistry();
			// Registra a stub no RMI para que ela seja obtida pelos clientes
			registry.bind("Servidor", stub);
			
			System.out.println("Servidor inicializado com sucesso.");
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}

	public double calcHipotenusa(double co, double ca) throws RemoteException {
		System.out.println("Executando metodo neste host, calculo da hipotenusa...");
		
		       
		//Cálculo da hipotenusa 
		double hipotenusa= Math.sqrt((co*co)+(ca*ca)); 

		//Retorna o valor da hipotenusa
		return hipotenusa; 
	}

}