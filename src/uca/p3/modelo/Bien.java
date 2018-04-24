package uca.p3.modelo;

/**
 *
 * @author Carlos Gonzalez
 */
public class Bien {

    private String descripcion;
    private int vidaUtil;
    private double valorContable;
    private double valorRescate;

    public Bien(String desc, int util, double contable, double rescate) {
        this.descripcion = desc;
        this.vidaUtil = util;
        this.valorContable = contable;
        this.valorRescate = rescate;

    }

    //metodos 
    public String getDescripcion() {
        return descripcion;
    }

    public int getVidaUtil() {

        return vidaUtil;
    }

    public double getValorContable() {
        return valorContable;
    }

    public double getValorRescate() {
        return valorRescate;
    }

    public void setDescripcion(String nDes) {
        descripcion = nDes;
    }

    public void setVidaUtil(int nUtil) {

        vidaUtil = nUtil;
    }

    public void setVidaContable(double nContable) {
        valorContable = nContable;
    }

    public void setVidaRescate(double nRescate) {
        valorRescate = nRescate;
    }

    public double sumar() {
        int e;
        double suma = 0.00;
        double i = 0.00;
        for (e = 1; e <= vidaUtil; e++) {
            i++;
            suma = suma + i;
        }
        return suma;
    }

    public double[] valor() {
        int e;
        double i = (double) vidaUtil + 1;
        double valor[] = new double[vidaUtil];
        for (e = 0; e < vidaUtil; e++) {
            i--;
            valor[e] = i;
        }
        return valor;
    }

    public double[] costo() {
        int e;
        double cost = valorContable - valorRescate;

        double costos[] = new double[vidaUtil];
        for (e = 0; e < vidaUtil; e++) {
            costos[e] = cost;

        }
        return costos;
    }

    public double[] tasa() {
        int e;

        double sum = sumar();
        double val[] = valor();
        double tasa[] = new double[vidaUtil];
        for (e = 0; e < vidaUtil; e++) {

            tasa[e] = val[e] / sum;

        }
        return tasa;
    }

    public double[] gastos() {
        int e;
        double costo;
        costo = valorContable - valorRescate;
        double gastos[] = new double[vidaUtil];
        for (e = 0; e < vidaUtil; e++) {

            gastos[e] = tasa()[e] * costo;

        }
        return gastos;
    }

    public double[] acumulado() {
        int e;
        double acu = 0.00;
        double acumulado[] = new double[vidaUtil];
        for (e = 0; e < vidaUtil; e++) {
            acu = acu + gastos()[e];
            acumulado[e] = acu;

        }
        return acumulado;
    }

    public double[] valorContable() {
        int e;

        double valorCont[] = new double[vidaUtil];
        for (e = 0; e < vidaUtil; e++) {

            valorCont[e] = this.valorContable - acumulado()[e];

        }
        return valorCont;
    }

    public double[] Contable() {
        int e;
        int i = -1;
        double Contable[] = new double[vidaUtil];
        Contable[0] = valorContable;
        for (e = 1; e < vidaUtil; e++) {
            i++;
            Contable[e] = valorContable()[i];

        }
        return Contable;
    }

    public String[][] Interfaz() {

        double vC[] = Contable();
        double cos[] = costo();
        double tas[] = tasa();
        double gas[] = gastos();
        double acu[] = acumulado();
        double vCF[] = valorContable();

        int f;
        String tabla[][] = new String[vidaUtil][6];
        for (f = 0; f < vidaUtil; f++) {
            tabla[f][0] = vC[f] + "";
            tabla[f][1] = cos[f] + "";
            tabla[f][2] = tas[f] + "";
            tabla[f][3] = gas[f] + "";
            tabla[f][4] = acu[f] + "";
            tabla[f][5] = vCF[f] + "";
        }
        return tabla;
    }

}
