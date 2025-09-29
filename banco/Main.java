package banco;

public class Main {
    public static void main(String[]args){
        CuentaAhorros cuenta = new CuentaAhorros(15000, 0, 0, 012, 0, false);
   
        cuenta.consignar(10000);
        cuenta.consignar(70000);

        cuenta.retirar(2000);
        cuenta.retirar(5000);
        cuenta.retirar(15000);
        cuenta.retirar(5000);

        cuenta.extractoMensual();

        cuenta.imprimir();
   
    }

}
