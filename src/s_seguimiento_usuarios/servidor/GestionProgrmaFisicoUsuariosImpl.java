package s_seguimiento_usuarios.servidor;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import s_gestion_usuarios.sop_corba.UsuarioDTO;
import s_seguimiento_usuarios.sop_corba.GestionProgramaFisicoUsuarioIntPOA;
import s_seguimiento_usuarios.sop_corba.KeyValPrSmDTO;
import s_seguimiento_usuarios.sop_corba.ValoracionDTO;

public class GestionProgrmaFisicoUsuariosImpl extends GestionProgramaFisicoUsuarioIntPOA{

    private static final String ARCHIVO_VALORACIONES = "valoraciones.txt";
    private static ArrayList<ValoracionDTO> valoraciones;
    private HashMap<Integer, KeyValPrSmDTO[]> programasFisicos;
   


    @Override
    public void registrarPlanFisico(UsuarioDTO objUsuario, KeyValPrSmDTO[] planFisicoCompleto) {
        System.out.println("==========================================================");
        System.out.println("\tRegistro de programa físico");
        System.out.println("==========================================================");

        programasFisicos.put(objUsuario.id, planFisicoCompleto);
        
    }

    @Override
    public KeyValPrSmDTO[] consultarProgramaCompleto(int id) {
        System.out.println("==========================================================");
        System.out.println("\tConsulta de programa físico");
        System.out.println("==========================================================");

        for (Integer programaUsuario : programasFisicos.keySet()) {
            if (programaUsuario == id){
                return programasFisicos.get(id);
            }
        }
        return null;
    }

    @Override
    public void registrarValoracion(UsuarioDTO objUsuario, ValoracionDTO objValoracion) {
        System.out.println("==========================================================");
        System.out.println("\tRegistro de valoración");
        System.out.println("==========================================================");

        try {
            FileOutputStream ficheroSalida = new FileOutputStream(ARCHIVO_VALORACIONES);
            ObjectOutputStream objetoSalida = new ObjectOutputStream(ficheroSalida);
            objetoSalida.writeObject(objValoracion);

            objetoSalida.close();

            System.out.println("-----------Valoración registrada----------- \n \t Usuario con identificación: " + objUsuario.id + ", ha registrado su valoración: ");

        } catch (Exception e) {
            System.err.println("Error -> " + e.getMessage());
        }
        
    }

    @Override
    public ValoracionDTO consultarValoracion(int objUsuario) {
        System.out.println("==========================================================");
        System.out.println("\tConsulta de valoración");
        System.out.println("==========================================================");

        try {

            FileInputStream ficheroEntrada = new FileInputStream(ARCHIVO_VALORACIONES);
            ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada); 

            valoraciones.add((ValoracionDTO)objetoEntrada.readObject());
            objetoEntrada.close();

            for (ValoracionDTO valoracionDTO : valoraciones) {
                if(valoracionDTO.id == objUsuario){
                    return valoracionDTO;
                }                
            }

            return null;
        } catch (Exception e) {
            System.err.println("Error -> " + e.getMessage());
            return null;
        }
    }
    
}
