package s_gestion_usuarios.servidor;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import org.omg.CosNaming.NamingContextExt;

import s_gestion_usuarios.sop_corba.*;
import s_seguimiento_usuarios.sop_corba.AsistenciaDTO;
import s_seguimiento_usuarios.sop_corba.KeyValPrSmDTO;
import s_gestion_usuarios.sop_corba.UsuarioDTO;
import s_gestion_usuarios.sop_corba.UsuarioDTOHolder;
import s_seguimiento_usuarios.sop_corba.ValoracionDTO;
import s_seguimiento_usuarios.sop_corba.GestionAsistenciaInt;
import s_seguimiento_usuarios.sop_corba.GestionAsistenciaIntHelper;
import s_seguimiento_usuarios.sop_corba.GestionAsistenciaIntOperations;
import s_seguimiento_usuarios.sop_corba.GestionProgramaFisicoUsuarioInt;
import s_seguimiento_usuarios.sop_corba.GestionProgramaFisicoUsuarioIntHelper;
import s_seguimiento_usuarios.sop_corba.GestionProgramaFisicoUsuarioIntOperations;


public class GestionUsuarioImpl extends GestionUsuariosIntPOA{

    private static final String ARCHIVO_USUARIOS = "usuarios.txt";
    private ArrayList<UsuarioDTO> usuarios;
    private ArrayList<UsuarioDTO> usuariosF;
    private AdmCllbckInt objCllBck;
    private GestionAsistenciaIntOperations objReferenciaRemotaA;
    private GestionProgramaFisicoUsuarioIntOperations objReferenciaRemotaP;
    private GestionAsistenciaInt ReferenciaRemotaA;
    private GestionProgramaFisicoUsuarioInt ReferenciaRemotaP;

    @Override
    public boolean registrarUsuario(UsuarioDTO objUsuario) {
        System.out.println("==========================================================");
        System.out.println("\tRegistro de usuarios");
        System.out.println("==========================================================");

        objCllBck.notificar(objUsuario.nombreCompleto, objUsuario.id);
        
        usuarios.add(objUsuario);
        
        System.out.println("-----------Usuario registrado----------- \n \t identificación: " + objUsuario.id + ",\n \t  nombres: " + objUsuario.nombreCompleto);
        
        return true;
    }

    @Override
    public boolean consultarUsuario(int id, UsuarioDTOHolder objUsuario) {
        System.out.println("==========================================================");
        System.out.println("\tConsulta de usuarios");
        System.out.println("==========================================================");

        try {

            FileInputStream ficheroEntrada = new FileInputStream(ARCHIVO_USUARIOS);
            ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada); 

            usuarios.add((UsuarioDTO)objetoEntrada.readObject());
            objetoEntrada.close();

            for(UsuarioDTO tmpUsuarioDTO : usuarios){
                if(tmpUsuarioDTO.id == id){
                    objUsuario.value = tmpUsuarioDTO;
                    return true;
                }
            }
            
        } catch (Exception e) {
            System.err.println("Error -> " + e.getMessage());
            return false;
        }
        return false;
    }

    @Override
    public void registrarCallback(AdmCllbckInt objCllbck) {
        this.objCllBck=objCllbck;
        
    }

    @Override
    public UsuarioDTO[] listaUsuariosF() {
        UsuarioDTO[] retorno = null;
        try {

            FileInputStream ficheroEntrada = new FileInputStream(ARCHIVO_USUARIOS);
            ObjectInputStream objetoEntrada = new ObjectInputStream(ficheroEntrada); 

            usuarios.add((UsuarioDTO)objetoEntrada.readObject());
            objetoEntrada.close();
            System.out.println("tamaño:    "+usuarios.size());
            for(UsuarioDTO tmpUsuarioDTO : usuarios){
                    System.out.println(tmpUsuarioDTO.isValorado());
                
            }
            System.out.println("FIN PRIMER FOR;     ");
            for(UsuarioDTO tmpUsuarioDTO : usuarios){
                if(!tmpUsuarioDTO.isValorado()){
                    usuariosF.add(tmpUsuarioDTO);
                    System.out.println("1   +     1");
                }   
            }
            
        } catch (Exception e) {
            System.err.println("Error -> " + e);
        }

        retorno = (UsuarioDTO[]) usuariosF.toArray();
        return retorno;
    }

    public void consultarReferenciaRemotaA(NamingContextExt nce, String servicio){
		//GestionNotificaciones ref;
		try{
		this.ReferenciaRemotaA = GestionAsistenciaIntHelper.narrow(nce.resolve_str(servicio));
		System.out.println("Obtenido el manejador sobre el servidor de objetos: " + ReferenciaRemotaA);
		}catch(Exception ex){
		System.out.println("Error: "+ex.getMessage());
		}  	
	}
    public void consultarReferenciaRemotaP(NamingContextExt nce, String servicio){
		//GestionNotificaciones ref;
		try{
		this.ReferenciaRemotaP = GestionProgramaFisicoUsuarioIntHelper.narrow(nce.resolve_str(servicio));
		System.out.println("Obtenido el manejador sobre el servidor de objetos: " + ReferenciaRemotaP);
		}catch(Exception ex){
		System.out.println("Error: "+ex.getMessage());
		}  	
	}
    
    @Override
    public void registrarPlanFisico(UsuarioDTO objUsuario, KeyValPrSmDTO[] planFisicoCompleto) {
        objReferenciaRemotaP.registrarPlanFisico(objUsuario, planFisicoCompleto);
        
    }

    @Override
    public KeyValPrSmDTO[] consultarProgramaCompleto(int id) {
        return objReferenciaRemotaP.consultarProgramaCompleto(id);
    }

    @Override
    public void registrarValoracion(UsuarioDTO objUsuario, ValoracionDTO objValoracion) {
        objReferenciaRemotaP.registrarValoracion(objUsuario, objValoracion);
        
    }

    @Override
    public ValoracionDTO consultarValoracion(int objUsuario) {
        return objReferenciaRemotaP.consultarValoracion(objUsuario);
    }

    @Override
    public int registrarAsistencia(AsistenciaDTO objAsistencia) {
        return objReferenciaRemotaA.registrarAsistencia(objAsistencia);
    }

    @Override
    public AsistenciaDTO[] consultarAsistenciasUsuario(int id) {
        return objReferenciaRemotaA.consultarAsistenciasUsuario(id);

    }
    
}
