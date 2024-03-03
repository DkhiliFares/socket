package calculatteRMI;

import java.rmi.*;

public class CalcClient {
    public static void main(String[] args) {
        try {
            CalcInterface calc = (CalcInterface) Naming.lookup("rmi://localhost/CalcServeur");

            while (true) {
                System.out.println("1. Addition");
                System.out.println("2. Soustraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Quitter");

                int choix = Integer.parseInt(System.console().readLine("Choix : "));

                if (choix == 5)
                    break;

                int x = Integer.parseInt(System.console().readLine("Entrez le premier nombre : "));
                int y = Integer.parseInt(System.console().readLine("Entrez le deuxième nombre : "));

                switch (choix) {
                    case 1:
                        System.out.println("Résultat : " + calc.addition(x, y));
                        break;
                    case 2:
                        System.out.println("Résultat : " + calc.soustraction(x, y));
                        break;
                    case 3:
                        System.out.println("Résultat : " + calc.multiplication(x, y));
                        break;
                    case 4:
                        try {
                            System.out.println("Résultat : " + calc.division(x, y));
                        } catch (RemoteException e) {
                            System.out.println("Erreur : " + e.getMessage());
                        }
                        break;
                    default:
                        System.out.println("Choix invalide");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Erreur : " + e);
        }
    }
}
