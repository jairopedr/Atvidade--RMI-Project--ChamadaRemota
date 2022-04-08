import java.rmi.*;
 
public interface Hello extends Remote {
   public double calcHipotenusa(double ca, double co) throws RemoteException;
}