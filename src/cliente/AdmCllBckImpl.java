package cliente;

import s_gestion_usuarios.sop_corba.AdmCllbckIntPOA;

public class AdmCllBckImpl extends AdmCllbckIntPOA{

    @Override
    public void notificar(String nombreCompleto, int id) {
        System.out.println("\t NUEVO USUARIO A VALORAR");
        System.out.println("\t Usuario: \n[ "+ nombreCompleto +" ] Identificado con id: [ " + id +" ]" );
        
    }
    
}
