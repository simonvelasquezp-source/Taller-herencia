 package banco;

public abstract class  Cuenta {
protected float saldo;
protected int consignaciones;
protected int retiros;
protected float tasaAnual;
protected float comision;

public Cuenta(float saldo, int consignaciones, int retiros, float tasaAnual, float comision){
    this.saldo=saldo;
    this.consignaciones=0;
    this.retiros=0;
    this.tasaAnual=tasaAnual;
    this.comision=0;
}
public void consignar(float cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a consignar debe ser positiva.");
        }
        saldo += cantidad;
        consignaciones++;
    }
    public void retirar(float cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a retirar debe ser positiva.");
        }
        if (cantidad > saldo) {
            throw new IllegalArgumentException("Fondos insuficientes.");
        }
        saldo -= cantidad;
        retiros++;
    }
    public void calcularInteresMensual() {
        float interesMensual = saldo * (tasaAnual / 100) / 12;
        saldo += interesMensual;
    }
    public void extractoMensual() {
        saldo -= comision;
        calcularInteresMensual();
        comision = 0;
    }
    public void imprimir() {
        System.out.println("Saldo: " + saldo);
        System.out.println("Consignaciones: " + consignaciones);
        System.out.println("Retiros: " + retiros);
        System.out.println("Tasa anual: " + tasaAnual + "%");
        System.out.println("Comisión mensual: " + comision);
    }

    
}

 
