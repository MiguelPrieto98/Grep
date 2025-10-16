package es.etg.psp.mangel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Lanzador {

    private static final String[] LINEAS_PSP = {
        "Me gusta PSP y java",
        "PSP se programa en java",
        "es un módulo de DAM",
        "y se programa de forma concurrente en PSP",
        "PSP es programación. pero en una constante"
    };

    
    private static final String[] COMANDO = {"grep", "-i", "psp"};
    private static final String MENSAJE="Proceso hijo terminó con código: ";
    private static final String ERROR ="Error esperando al proceso hijo: ";

    public static void main(String[] args) throws IOException {
        Process proceso = Runtime.getRuntime().exec(COMANDO);

        // Escribir en la entrada del proceso hijo
        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(proceso.getOutputStream()), true)) {
            for (String linea : LINEAS_PSP) {
                pw.println(linea);
            }
           
            proceso.getOutputStream().close();
        }

      
        try (BufferedReader br = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
            String resultado;
            while ((resultado = br.readLine()) != null) {
                System.out.println("Hijo dice: " + resultado);
            }
        }

        
        try {
            int exitCode = proceso.waitFor();
            System.out.println( MENSAJE+ exitCode);
        } catch (InterruptedException e) {
            System.err.println(ERROR + e.getMessage());
        }
    }
}