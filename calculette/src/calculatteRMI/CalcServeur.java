package calculatteRMI;

import java.rmi.*;
import java.rmi.server.*;

public class CalcServeur extends UnicastRemoteObject implements CalcInterface {
    public CalcServeur() throws RemoteException {
        super();
    }

    public int addition(int x, int y) throws RemoteException {
        return x + y;
    }

    public int soustraction(int x, int y) throws RemoteException {
        return x - y;
    }

    public int multiplication(int x, int y) throws RemoteException {
        return x * y;
    }

    public int division(int x, int y) throws RemoteException {
        if (y == 0) {
            throw new RemoteException("Division par zéro !");
        }
        return x / y;
    }

    public static void main(String args[]) {
        try {
            CalcServeur serveur = new CalcServeur();
            Naming.rebind("CalcServeur", serveur);
            System.out.println("Serveur prêt !");
        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
    }
}
