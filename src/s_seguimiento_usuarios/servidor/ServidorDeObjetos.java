package s_seguimiento_usuarios.servidor;

import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import s_seguimiento_usuarios.sop_corba.*;

public class ServidorDeObjetos {

  public static void main(String args[]) {
    try{
      // crea e iniciia el ORB
      ORB orb = ORB.init(args, null);

      // obtiene la referencia del rootpoa & activate el POAManager
      POA rootpoa = 
      POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();

      //*** crea el servant y lo registra con el ORB ***
      GestionAsistenciasImpl convref = new GestionAsistenciasImpl();
      //convref.setORB(orb); 
      //*** crea un tie, con el servant como delegado***
      GestionAsistenciaIntPOATie gntie= new GestionAsistenciaIntPOATie(convref);
      
      //*** Obtener la referencia para el tie
      GestionAsistenciaInt reftie=gntie._this(orb);


      GestionProgrmaFisicoUsuariosImpl convrefP = new GestionProgrmaFisicoUsuariosImpl();
      //convref.setORB(orb); 
      //*** crea un tie, con el servant como delegado***
      GestionProgramaFisicoUsuarioIntPOATie gntieP= new GestionProgramaFisicoUsuarioIntPOATie(convrefP);
      
      //*** Obtener la referencia para el tie
      GestionProgramaFisicoUsuarioInt reftieP=gntieP._this(orb);

	  
      // obtiene la base del contexto de nombrado
      org.omg.CORBA.Object objref = orb.resolve_initial_references("NameService");
      // Usa NamingContextExt el cual es parte de la especificacion 
      // Naming Service (INS).
      NamingContextExt ncref = NamingContextExtHelper.narrow(objref);

      NamingContextExt ncrefP = NamingContextExtHelper.narrow(objref);
      System.out.println("Realizar binding de objNotificaciones ...");
      // *** Realiza el binding de la referencia de objeto en el N_S ***
      
      String name = "ObjetoRemotoAsistencia";

      NameComponent path[] = ncref.to_name( name );
      ncref.rebind(path, reftie);

      String nameP = "ObjetoRemotoProgramaFisico";

      NameComponent pathP[] = ncref.to_name( nameP );
      ncref.rebind(pathP, reftieP);

      System.out.println("El Servidor GestionPacientes esta listo y esperando ...");

      // esperan por las invocaciones desde los clientes
      orb.run();
    } 
	
      catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }
	  
      System.out.println("Servidor: Saliendo ...");
	
  }
}