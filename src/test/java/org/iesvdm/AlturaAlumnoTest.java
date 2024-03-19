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
        AlturaAlumno.modificaAltura(ArrayNuevo, 0, 1.7);
        assertTrue(ArrayNuevo.length==array.length+1);
        assertTrue(ArrayNuevo[0]==1.7);
        assertArrayEquals(array, Arrays.copyOfRange(ArrayNuevo, 0, ArrayNuevo.length-1));
    }
    @Test
    void buscaNombre()
    {
        String [] array = new String[1];
        String nombre="";
        String nombrearray="nombre1";
        array[0]=nombrearray;
        assertTrue(AlturaAlumno.buscaNombre(array, nombre)==-1);
        assertTrue(AlturaAlumno.buscaNombre(array, nombrearray)==0);
    }
    @Test
    void mostrar(){
        String[] arrayNombre = new String[1];
        arrayNombre[0]="Jose";
        Double[] arrayAltura = new Double[1];
        arrayAltura[0]=1.7;
    }
    @Test
    void calculaMaximo(){
        double [] array = {1.55, 1.87, 1.69};
        assertTrue(AlturaAlumno.calculaMaximo(array)[0]==1);
        assertTrue(AlturaAlumno.calculaMaximo(array)[1]==1.87);
    }
    @Test
    void calculaMedia(){
        double[] array = {1.0, 2.0, 3.0, 4.0, 5.0};
        assertTrue(AlturaAlumno.calculaMedia(array)==3.0);
    }
}
