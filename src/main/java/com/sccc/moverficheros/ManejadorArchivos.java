package com.sccc.moverficheros;

/**
 *
 * @author Legolas
 */
import static com.sccc.moverficheros.Rutas.PATH_DESTINO_JARS;
import java.util.List;

public class ManejadorArchivos {

    public static String getSringsPlanConfig() throws Exception {
        List<String> rutaArchivo = CopiarFicheros.getFilesNames(PATH_DESTINO_JARS);
        StringBuilder planConfig = new StringBuilder("<plan id=\"semillero-scc\" reloadable=\"true\">");
        for (String string : rutaArchivo) {
            planConfig.append("\n")
                    .append("<plugin name=\"" + string + "\" path=\"../../SEM/plugins/" + string + "\"/>");
        }
        planConfig.append("\n").append("</plan>");
        return planConfig.toString();
    }
}
