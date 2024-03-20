package org.iesvdm;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Array;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
public class AlturaAlumnoTest {
    @Test
    void añadeNombre(){
        String[] array = new String[0];
        String nombre = "";
        String[] ArrayNuevo = AlturaAlumno.añadeNombre(array, nombre);
        assertTrue(ArrayNuevo[ArrayNuevo.length-1]==nombre);
        assertTrue(ArrayNuevo.length==array.length+1);
        assertArrayEquals(array, Arrays.copyOfRange(ArrayNuevo, 0, array.length));
    }
    @Test
    void añadeAltura(){
        double[]array=new double[0];
        double[]ArrayNuevo = AlturaAlumno.añadeAltura(array);
        double alturaPorDefecto = 1.5;
        assertTrue(ArrayNuevo.length == array.length+1);
        assertTrue(ArrayNuevo[ArrayNuevo.length-1] == alturaPorDefecto);
        assertArrayEquals(array,Arrays.copyOfRange(ArrayNuevo,0, array.length));
    }
    @Test
    void modificaAltura()
    {
        double[]array = new double[0];
        double[] ArrayNuevo = AlturaAlumno.añadeAltura(array);
        int pos=0;
        AlturaAlumno.modificaAltura(ArrayNuevo, pos, 1.7);
        assertTrue(ArrayNuevo.length==array.length+1);
        assertTrue(ArrayNuevo[0]==1.7);
        assertArrayEquals(array, Arrays.copyOfRange(ArrayNuevo, 0, ArrayNuevo.length-1));
    }
    @Test
    void modificaAlturaFueraRango()
    {
        //when
        double[] array = new double[0];
        double[] ArrayNuevo = Arrays.copyOf(array, array.length);
        int pos = 1;
        //do
        AlturaAlumno.añadeAltura(array);
        AlturaAlumno.modificaAltura(ArrayNuevo, pos, 1.7);
        //then
        assertArrayEquals(array, ArrayNuevo);
    }
    @Test
    void mostrar(){
        String[] arrayNombre = new String[1];
        arrayNombre[0]="Jose";
        Double[] arrayAltura = new Double[1];
        arrayAltura[0]=1.7;
    }
    @Test
    void buscaNombre_esta()
    {
        //when
        String [] array = new String[1];
        String nombre_esta = "Jose";
        //do
        array[0]=nombre_esta;
        //then
        assertTrue(AlturaAlumno.buscaNombre(array, nombre_esta)==0);
    }
    @Test
    void buscaNombre_no_esta()
    {
        //when
        String [] array = new String[1];
        array[0]="Jose";
        String nombre_no_esta = "Francisco";
        //then
        assertTrue(AlturaAlumno.buscaNombre(array, nombre_no_esta)==-1);
    }
    @Test
    void calculaMaximo(){
        //when
        double [] array = new double[3];
        //do
        for(int i=0;i<array.length;i++) {
            AlturaAlumno.añadeAltura(array);
        }
        AlturaAlumno.modificaAltura(array, 0, 1.6);
        AlturaAlumno.modificaAltura(array, 1, 1.87);
        AlturaAlumno.modificaAltura(array, 2, 1.71);
        //then
        assertTrue(AlturaAlumno.calculaMaximo(array)[0]==1);
        assertTrue(AlturaAlumno.calculaMaximo(array)[1]==1.87);
    }
    @Test
    void calculaMaximoArrayVacio(){
        //when
        double [] resultado = {0.0, 0.0};
        double[]vacio = new double[0];
        //then
        assertArrayEquals(AlturaAlumno.calculaMaximo(vacio), resultado);
    }
    @Test
    void calculaMedia() {
        double[] array = {1.71, 1.72, 1.73, 1.74, 1.75};
        assertTrue(AlturaAlumno.calculaMedia(array) == 1.73);
    }
    @Test
    void calculaMediaArrayVacio(){
        //when
        double[] array = new double[0];
        //then
        assertTrue(AlturaAlumno.calculaMedia(array) == 0);
    }
}
