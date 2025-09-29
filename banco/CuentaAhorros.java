package banco;
public class CuentaAhorros extends Cuenta{
    private boolean cuentaActiva;
    public CuentaAhorros(float saldo, int consignaciones, int retiros, float tasaAnual, float comision, boolean cuentaActiva ){
        super(saldo,consignaciones,retiros,tasaAnual,comision);
        this.cuentaActiva= saldo>= 10000;
    }

private void actualizarEstado(){
    cuentaActiva= saldo>= 10000;
}
@Override
    public void consignar(float cantidad) {
        if (cuentaActiva) {
            super.consignar(cantidad);
        } else {
            System.out.println("La cuenta está inactiva. No se puede consignar.");
        }
        actualizarEstado();
    }

    @Override
    public void retirar(float cantidad) {
        if (cuentaActiva) {
            super.retirar(cantidad);
        } else {
            System.out.println("La cuenta está inactiva. No se puede retirar.");
        }
        actualizarEstado();
    }

    @Override
    public void extractoMensual() {
        if (retiros > 4) {
            comision += (retiros - 4) * 1000;
        }
        super.extractoMensual();
        actualizarEstado();
    }

    @Override
    public void imprimir() {
        System.out.println(" Cuenta de Ahorros");
        System.out.println("Saldo: " + saldo);
        System.out.println("Comisión mensual: " + comision);
        System.out.println("Transacciones: " + (consignaciones + retiros));
        System.out.println("Cuenta activa: " + cuentaActiva);
    }
}

