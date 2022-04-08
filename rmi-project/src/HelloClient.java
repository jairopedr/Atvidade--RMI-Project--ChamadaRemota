import java.rmi.registry.*;
import java.util.Scanner;

public class HelloClient {
	public static void main(String[] args) {
		try (Scanner read = new Scanner(System.in)) {
			double co, ca, hipotenusa;
			
			try {
				// Procura o registro do RMI no Servidor
				// Se o servidor estiver em outro host basta substituir pelo seu IP
				Registry registry = LocateRegistry.getRegistry("localhost");

				// Procura a stub do servidor
				Hello stub= (Hello) registry.lookup("Servidor");

				// Chama o método do servidor e imprime a mensagem
				System.out.println("Invocando metodo do servidor");
				
				System.out.println("Digite o valor de cateto oposto : "); 
				co = Double.parseDouble(read.next());
				       
				//valor de C
				System.out.println("Digite o valor do cateto adjacente : ");
				ca = Double.parseDouble(read.next());
				
				hipotenusa = stub.calcHipotenusa(co, ca);
	
				System.out.println("[h²= c² + c²] O valor da Hipotenusa é: " +hipotenusa); 
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} 
	}
}