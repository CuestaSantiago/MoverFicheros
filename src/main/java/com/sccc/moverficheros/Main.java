package com.sccc.moverficheros;

import static com.sccc.moverficheros.Rutas.*;

/**
 *
 * @author Legolas
 */
public class Main {

    public static void main(String[] args) {
        int activar = 1;
        try {
              moverArchivosDesigner();
            if (activar == 1) {
                moverArchivosJars();
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    public static void moverArchivosDesigner() {
        //Realiza la copia.
        try {
            CopiarFicheros.copy(PATH_FUENTE_DESIGNER, PATH_DESTINO_DESIGNER);
            CopiarFicheros.copy(PATH_FUENTE_ETIQUETAS, PATH_DESTINO_ETIQUETAS);
            CopiarFicheros.copy(PATH_FUENTE_ETIQUETASLABELS, PATH_DESTINO_ETIQUETAS);
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    

    public static void moverArchivosJars() {
        try {
            CopiarFicheros.deleteDirectory(PATH_DESTINO_JARS);
            CopiarFicheros.copy(PATH_FUENTE_JARS_DESIGNER, PATH_DESTINO_JARS);
            CopiarFicheros.moverArchivo(PATH_FUENTE_JARS_MAVEN, PATH_DESTINO_JARS);
            //CopiarFicheros.moverArchivo(PATH_FUENTE_JARS_MAVEN_QUERY, PATH_DESTINO_JARS);
            System.out.println("----------------------------");
            System.out.println(ManejadorArchivos.getSringsPlanConfig());
            System.out.println("----------------------------");
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

}
