package s_gestion_usuarios.servidor;
import java.util.ArrayList;

import s_gestion_usuarios.sop_corba.*;

public class GestionPersonalImpl extends GestionPersonalIntPOA{

    private ArrayList<PersonalDTO> personal;


  
	public GestionPersonalImpl(){
		this.personal = new ArrayList<>();
		String tipoId = "CC";
        int id = 6536;
        String nombrecompleto = "Josefino Eusebio De las Nieves";
        String ocupacion = "Admin";
        String usuario = "admin12345";
        String clave = "12345678";
        PersonalDTO admin = new PersonalDTO(tipoId, id, nombrecompleto, ocupacion, usuario, clave);
        personal.add(admin);
	}

    
    @Override
    public void registrarPersonal(PersonalDTO objPersonal) {
        System.out.println("Entrando a registrar usuario");
		if(personal.size() < 3)
		{            
			personal.add(objPersonal);
			System.out.println("Usuario registrado: \n \t identificación: " + objPersonal.id + ",\n \t  nombres: " + objPersonal.nombreCompleto);
		}
        
    }

    @Override
    public boolean consultarPersonal(int id, PersonalDTOHolder objPersonal) {
        System.out.println("Entrando a consultar usuario");
		boolean respuesta = false;
		int contador = 0;
		PersonalDTO vacio = new PersonalDTO();
		while(contador<personal.size()){
			if(personal.get(contador).id==id){
				vacio=personal.get(contador);
				respuesta = true;
				break;
			}
			contador++;
		}

		objPersonal.value=vacio;
		return respuesta;
    }

    @Override
    public int abrirSesion(CredencialDTO objCredencial) {
        PersonalDTO tmpNotificacion = ocupacionBuscadaCredenciales(objCredencial);
		String ocupacion = tmpNotificacion.ocupacion;
		switch(ocupacion){
			case "Admin":
				return 0;
			case "Personal de acondicionamiento fisico":
                System.out.println("ALGO");
				return 1;
			case "Secretaria":
				return 2;
		}
		return -1;
    }

    public PersonalDTO ocupacionBuscadaCredenciales(CredencialDTO objCredencial){
        if(!usuarioExiste(objCredencial)){
            return null;
        }
        String tmpUsuario=objCredencial.usuario;
        for (PersonalDTO personalDTO : personal) {
            if(personalDTO.usuario.equals(tmpUsuario)){
                PersonalDTO varPersonal=new PersonalDTO(personalDTO.tipo_id, personalDTO.id, personalDTO.nombreCompleto, personalDTO.ocupacion, personalDTO.usuario, personalDTO.clave);
                return varPersonal;
            }
        }
        return null;
    }

    public boolean usuarioExiste(CredencialDTO objCredencial){
        String tmpUsuario=objCredencial.usuario;
        for (PersonalDTO personalDTO : personal) {
            if(personalDTO.usuario.equals(tmpUsuario)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean editarPersonal(int id, PersonalDTO objPersonalNuevosDatos) {
        System.out.println("==================================================");
        System.out.println("\tEdición de personal");
        System.out.println("==================================================");
        int position = -1;
        
        position = IdUsuarioExiste(id);
        System.out.println("esta es la posicion"+position);
        if(position != -1){
            personal.set(position, objPersonalNuevosDatos);
            return true;
        }
        return false;
    }

    public int IdUsuarioExiste(int id){
        int contador = 0;
        for (PersonalDTO tmpPersonal : personal){
            if(tmpPersonal.id == id){
                
                return contador;
            }
            contador ++;
        }
        return -1;
    }

    @Override
    public boolean eliminarPersonal(int id) {
        System.out.println("==================================================");
        System.out.println("\tAdministrador - Consulta de personal");
        System.out.println("==================================================");
        int position = -1;
        position = IdUsuarioExiste(id);
        if(position != -1){
            personal.remove(position);
            return true;
        }
        return false;
    }
    
}