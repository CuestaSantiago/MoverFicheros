package com.sccc.moverficheros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Legolas
 */
public class CopiarFicheros {

    public static void directoryOrFile(File sourceLocation, File targetLocation) throws IOException {
        if (sourceLocation.isDirectory()) {
            //Es directorio.
            copyDirectory(sourceLocation, targetLocation);
        } else {
            //Es archivo.
            copyFile(sourceLocation, targetLocation);
        }
    }

    public static void copy(File sourceLocation, File targetLocation) throws IOException {
        directoryOrFile(sourceLocation, targetLocation);
    }

    public static void copy(String sSourceLocation, String stargetLocation) throws IOException {
        File sourceLocation = new File(sSourceLocation);
        File targetLocation = new File(stargetLocation);
        directoryOrFile(sourceLocation, targetLocation);
    }

    private static void copyDirectory(File source, File target) throws IOException {
        if (!target.exists()) {
            //No existe directorio destino, lo crea.
            target.mkdir();
        }
        for (String f : source.list()) {
            //Copia archivos de directorio fuente a destino.
            copy(new File(source, f), new File(target, f));
        }
    }

    private static void copyFile(File source, File target) throws IOException {
        try (
                InputStream in = new FileInputStream(source);
                OutputStream out = new FileOutputStream(target)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
        }
    }

    public static void moverArchivo(String origen, String destino) throws IOException {
        File destinationFolder = new File(destino);
        File sourceFolder = new File(origen);
        if (!destinationFolder.exists()) {
            destinationFolder.getParentFile().mkdirs();
        }
        // Check weather source exists and it is folder.
        if (sourceFolder.exists() && sourceFolder.isDirectory()) {
            // Get list of the files and iterate over them
            File[] listOfFiles = sourceFolder.listFiles();

            if (listOfFiles != null) {
                for (File child : listOfFiles) {
                    // Move files to destination folder
                    if (child.getName().contains(".jar")) {
                        //child.renameTo(new File(destinationFolder + "\\" + child.getName()));
                        String path = child.getCanonicalPath();
                        // System.out.println(path);
                        copy(path, destino.concat("\\").concat(child.getName()));
                    }
                }
                // Add if you want to delete the source folder 
                sourceFolder.delete();
            }
        } else {
            System.out.println(sourceFolder + "  Folder does not exists");
        }
    }

    public static void deleteDirectory(String ruta) {
        List<String> nombres = getFilesNames(ruta);
        if (nombres == null || nombres.size() == 0) {
            System.out.println("no hay archivos: " + ruta);
        } else {
            for (String nombre : nombres) {
                String path = ruta.concat("\\").concat(nombre);
                File fichero = new File(path);
                if (!fichero.delete()) {
                    System.out.println("archivo no fue eliminado: " + path);
                }
            }
        }
    }

    public static List<String> getFilesNames(String ruta) {
        List<String> nombre = new ArrayList<>();
        File carpeta = new File(ruta);
        String[] listado = carpeta.list();
        if (listado == null || listado.length == 0) {
            System.out.println("No hay elementos dentro de la carpeta actual");
            return null;
        } else {
            nombre = Arrays.asList(listado);
        }
        return nombre;
    }

}
