/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sccc.moverficheros;

/**
 *
 * @author Legolas
 */
public class Rutas {
    private static final String PROJECT_DESIGNER            = "Tienda\\";
    private static final String PROJECT_IMP_DESIGNER        = "lscbw.grouptiendas.customevents.impl\\";
    private static final String PROJECT_QUERY_DESIGNER      = "scccs.customevents.query.impl\\";
    private static final String BASE_URL                    = "E:\\Archivos\\Proceso_Clear_Minds\\Levantamiento_Cliente_Clear_Minds\\";
    private static final String BASE_WORKSPACE              = BASE_URL.concat("WorkSpace\\"+PROJECT_DESIGNER+"build\\cobis\\");
    private static final String BASE_PROJECT                = BASE_URL.concat("Drive\\COBIS_HOME_WEB1\\");
    
    //Directorio fuente.
    public static final String PATH_FUENTE_DESIGNER         = BASE_WORKSPACE.concat("web\\views");
    public static final String PATH_FUENTE_ETIQUETASLABELS  = BASE_WORKSPACE.concat("web\\assets\\languages");
    public static final String PATH_FUENTE_ETIQUETAS        = BASE_URL.concat("Menus_formato");
    public static final String PATH_FUENTE_JARS_DESIGNER    = BASE_WORKSPACE.concat("libs");
    public static final String PATH_FUENTE_JARS_MAVEN       = BASE_URL.concat("respaldo\\"+PROJECT_DESIGNER+PROJECT_IMP_DESIGNER+"target");
    public static final String PATH_FUENTE_JARS_MAVEN_QUERY = BASE_URL.concat("respaldo\\"+PROJECT_DESIGNER+PROJECT_QUERY_DESIGNER+"target");

    //Directorio destino.
    public static final String PATH_DESTINO_DESIGNER        = BASE_PROJECT.concat("cwc\\webapps\\views");
    public static final String PATH_DESTINO_ETIQUETAS       = BASE_PROJECT.concat("cwc\\webapps\\assets\\languages");
    public static final String PATH_DESTINO_JARS            = BASE_PROJECT.concat("SEM\\plugins");

}
