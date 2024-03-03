package calculatteRMI;

import java.rmi.*;

public interface CalcInterface extends Remote {
    int addition(int x, int y) throws RemoteException;
    int soustraction(int x, int y) throws RemoteException;
    int multiplication(int x, int y) throws RemoteException;
    int division(int x, int y) throws RemoteException;
}

