package banco;

public class CuentaCorriente extends Cuenta {
    private float sobregiro;
    public CuentaCorriente(float saldo, int consignaciones, int retiros, float tasaAnual, float comision, float sobregiro){
        super(saldo,consignaciones,retiros,tasaAnual,comision);
        this.sobregiro=0;
    }

    @Override
    public void retirar(float cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad; 
        } else {
            float faltante = cantidad - saldo;
            saldo = 0;
            sobregiro += faltante;
        }
        retiros++;
    }
    @Override
    public void consignar(float cantidad) {
        if (sobregiro > 0) {
            if (cantidad <= sobregiro) {
                sobregiro -= cantidad; 
            } else {
                float resto = cantidad - sobregiro;
                sobregiro = 0;
                saldo += resto;
            }
        } else {
            saldo += cantidad;
        }
        consignaciones++;
    }
    @Override
    public void extractoMensual() {
        super.extractoMensual();
    }

    @Override
    public void imprimir() {
        System.out.println("---- Cuenta Corriente ----");
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión mensual: " + comision);
        System.out.println("Transacciones: " + (consignaciones + retiros));
        System.out.println("Sobregiro: " + sobregiro);
    }
}
    

