package org.iesvdm;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
public class AlturaAlumnoTest {
    //Atributos
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @Test

    void añadeNombre(){
        //when
        String[] array = new String[0];
        String nombre = "";
        //do
        String[] ArrayNuevo = AlturaAlumno.añadeNombre(array, nombre);
        //then
        assertTrue(ArrayNuevo[ArrayNuevo.length-1]==nombre);
        assertTrue(ArrayNuevo.length==array.length+1);
        assertArrayEquals(array, Arrays.copyOfRange(ArrayNuevo, 0, array.length));
    }
    @Test
    void añadeAltura(){
        //when
        double[]array=new double[0];
        double alturaPorDefecto = 1.5;
        //do
        double[]ArrayNuevo = AlturaAlumno.añadeAltura(array);
        //then
        assertTrue(ArrayNuevo.length == array.length+1);
        assertTrue(ArrayNuevo[ArrayNuevo.length-1] == alturaPorDefecto);
        assertArrayEquals(array,Arrays.copyOfRange(ArrayNuevo,0, array.length));
    }
    @Test
    void modificaAltura()
    {
        //when
        double[]array = new double[0];
        double[] ArrayNuevo = AlturaAlumno.añadeAltura(array);
        int pos=0;
        //do
        AlturaAlumno.modificaAltura(ArrayNuevo, pos, 1.7);
        //then
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
    void givenNamesAndHeightsWhenMostrarThenPrint(){

        System.setOut(new PrintStream(outputStreamCaptor));
        // when
        String[] arrayNombre = {"Jose"};
        double[] arrayAltura = {1.7};
        //do
        AlturaAlumno.mostrar(arrayNombre, arrayAltura);
        //then
        assertEquals("Jose" + "\t|   " + "1.7\r\n", outputStreamCaptor.toString());
        assertTrue(outputStreamCaptor.toString().contains("Jose"));
    }

    @Test
    void buscaNombre_esta()
    {
        //when
        String [] array = {"Jose"};
        //then
        assertTrue(AlturaAlumno.buscaNombre(array, "Jose")==0);
    }
    @Test
    void buscaNombre_no_esta()
    {
        //when
        String [] array = new String[1];
        array[0]="Jose";
        String nombre_no_esta = "Francisco";
        //do
        int resultado = AlturaAlumno.buscaNombre(array, nombre_no_esta);
        //then
        assertTrue(resultado==-1);
    }
    @Test
    void calculaMaximo(){
        //when
        double [] array = {1.6, 1.87, 1.71};
        //then
        assertTrue(AlturaAlumno.calculaMaximo(array)[0]==1);
        assertTrue(AlturaAlumno.calculaMaximo(array)[1]==1.87);
    }
    @Test
    void calculaMaximoArrayVacio(){
        //when
        double[]array = new double[0];
        double [] resultadoExpected = new double [2];
        //do
        double [] maximo = AlturaAlumno.calculaMaximo(array);
        //then
        assertArrayEquals(maximo, resultadoExpected);
    }
    @Test
    void calculaMedia() {
        //when
        double[] array = {1.71, 1.72, 1.73, 1.74, 1.75};
        //do
        double mediaExpected = AlturaAlumno.calculaMedia(array);
        //then
            assertTrue(mediaExpected == 1.73);
    }
    @Test
    void calculaMediaArrayVacio(){
        //when
        double[] array = new double[0];
        //do
        double mediaExpected = AlturaAlumno.calculaMedia(array);
        //then
        assertTrue(mediaExpected == 0);
    }
}
