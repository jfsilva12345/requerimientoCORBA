package s_seguimiento_usuarios.servidor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import s_seguimiento_usuarios.sop_corba.AsistenciaDTO;
import s_seguimiento_usuarios.sop_corba.GestionAsistenciaIntPOA;

public class GestionAsistenciasImpl extends GestionAsistenciaIntPOA {

    private static final String ARCHIVO_ASISTENCIAS = "asistencias.txt";

    private static ArrayList<AsistenciaDTO> asistencias = new ArrayList<>();


    @Override
    public int registrarAsistencia(AsistenciaDTO objAsistencia) {
        System.out.println("==========================================================");
        System.out.println("\tRegistro de asistencias");
        System.out.println("==========================================================");

        try {
            FileOutputStream ficheroSalida = new FileOutputStream(ARCHIVO_ASISTENCIAS);
            ObjectOutputStream objetoSalida = new ObjectOutputStream(ficheroSalida);
            objetoSalida.writeObject(objAsistencia);

            objetoSalida.close();

            System.out.println("-----------Asistencia registrada----------- \n \t Usuario con identificación: " + objAsistencia.id + ", asistió: ");
            return 1;
        } catch (Exception e) {
            System.err.println("Error -> " + e.getMessage());
            return -1;
        }
    }


    @Override
    public AsistenciaDTO[] consultarAsistenciasUsuario(int id) {
        System.out.println("==========================================================");
        System.out.println("\tConsulta de asistencias");
        System.out.println("==========================================================");
        AsistenciaDTO[] retorno = null;
        try {

            FileInputStream ficheroEntrada = new FileInputStream(ARCHIVO_ASISTENCIAS);
            ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada); 

            asistencias.add((AsistenciaDTO)objetoEntrada.readObject());
            objetoEntrada.close();

            ArrayList<AsistenciaDTO> tmpAsistencias = new ArrayList<>();
            for(AsistenciaDTO tmpUsuarioDTO : asistencias){
                if(tmpUsuarioDTO.id == id){
                    tmpAsistencias.add(tmpUsuarioDTO);
                }
            }
            retorno = (AsistenciaDTO[]) tmpAsistencias.toArray();
            return retorno;
        } catch (Exception e) {
            System.err.println("Error -> " + e.getMessage());
            return null;
        }
    }

    

    
    
}
