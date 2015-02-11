package edu.uniandes.ecos;

import edu.uniandes.ecos.dto.vector;
import java.util.LinkedList;

/**
 * Hello world!
 *
 */
public class App {

    public static LinkedList<vector> vector = new LinkedList<vector>();
    public static Double sumatoriaX = 0.0;
    public static Double sumatoriaY = 0.0;
    public static Double sumXCuadrado = 0.0;
    public static Double sumYCuadrado = 0.0;
    public static Double sumXporY = 0.0;
    public static Double B1 = 0.0;
    public static Double B0 = 0.0;
    public static Double R = 0.0;
    public static Double R2 = 0.0;
    public static Double YK = 0.0;
    public static Double XK = 0.0;

    public static void main(String[] args) {
//        llenarListas();
//        calcularValores();
//        calcularB1();
//        caluclarB0();
//        caluclarR();
//        caluclarRcuadrado();
//        calcularYK();
//        System.out.println("Hello World!");
    }
    
    public void cargarDatosPantalla(String lista){
        System.out.println(lista);
        String[] datos = lista.split("|");
        for (String dato : datos) {
            String [] valor = dato.split(",");
            vector.add(new vector(Double.parseDouble(valor[0]), Double.parseDouble(valor[1])));
        }        
        XK = 386.0;
        
        calcularValores();
        calcularB1();
        caluclarB0();
        caluclarR();
        caluclarRcuadrado();
        calcularYK();
    }
    
    public static void calcularYK(){
        YK = B0 +  (B1*XK);
    }
    
    public static void calcularValores() {
        for (vector vector1 : vector) {
            sumatoriaX += vector1.getX();
            sumXCuadrado += (vector1.getX() * vector1.getX());
            sumatoriaY += vector1.getY();
            sumYCuadrado += (vector1.getY() * vector1.getY());
            sumXporY += (vector1.getY() * vector1.getX());
        }
    }

    public static void caluclarR() {
        Double temp1 = 0.0;
        Double temp2 = 0.0;
        Double temp3 = 0.0;
        Double temp4 = 0.0;
        Double temp5 = 0.0;
        
        temp1 = vector.size() * sumXporY;
        temp2 = temp1 - (sumatoriaX*sumatoriaY);
        
        temp3 = ((vector.size() * sumXCuadrado) - (sumatoriaX * sumatoriaX));
        temp4 = ((vector.size()*sumYCuadrado)-(sumatoriaY*sumatoriaY));
        temp5 = temp3 * temp4;
        R = temp2 / Math.sqrt(temp5);
    }

    public static void caluclarB0() {
        B0 = (sumatoriaY / vector.size()) - (B1 * (sumatoriaX/ vector.size()));  
    }

    public static void caluclarRcuadrado() {
       R2 = R * R;
    }

    public static void calcularB1() {

        Double temp1 = 0.0;
        Double temp2 = 0.0;
        Double temp3 = 0.0;
        Double temp4 = 0.0;

        temp1 = vector.size() * (sumatoriaX / vector.size()) * (sumatoriaY / vector.size());
        temp2 = sumXporY - temp1;
        temp3 = (vector.size()) * ((sumatoriaX / vector.size()) * (sumatoriaX / vector.size()));
        temp4 = sumXCuadrado - temp3;
        B1 = temp2 / temp4;
    }

    public static void llenarListas() {
        vector.add(new vector(130.0, 186.0));
        vector.add(new vector(650.0, 699.0));
        vector.add(new vector(99.0, 132.0));
        vector.add(new vector(150.0, 272.0));
        vector.add(new vector(128.0, 291.0));
        vector.add(new vector(302.0, 331.0));
        vector.add(new vector(95.0, 199.0));
        vector.add(new vector(945.0, 1890.0));
        vector.add(new vector(368.0, 788.0));
        vector.add(new vector(961.0, 1601.0));
        XK = 386.0;
    }

    public static Double getB1() {
        return B1;
    }

    public static void setB1(Double B1) {
        App.B1 = B1;
    }

    public static Double getB0() {
        return B0;
    }

    public static void setB0(Double B0) {
        App.B0 = B0;
    }

    public static Double getR() {
        return R;
    }

    public static void setR(Double R) {
        App.R = R;
    }

    public static Double getR2() {
        return R2;
    }

    public static void setR2(Double R2) {
        App.R2 = R2;
    }

    public static Double getYK() {
        return YK;
    }

    public static void setYK(Double YK) {
        App.YK = YK;
    }

    public static Double getXK() {
        return XK;
    }

    public static void setXK(Double XK) {
        App.XK = XK;
    }
    
    
}
