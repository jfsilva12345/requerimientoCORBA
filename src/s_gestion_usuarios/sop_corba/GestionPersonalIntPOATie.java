package s_gestion_usuarios.sop_corba;


/**
* s_gestion_usuarios/sop_corba/GestionPersonalIntPOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./gusuarios.idl
* lunes 7 de marzo de 2022 12:17:04 PM COT
*/

public class GestionPersonalIntPOATie extends GestionPersonalIntPOA
{

  // Constructors

  public GestionPersonalIntPOATie ( s_gestion_usuarios.sop_corba.GestionPersonalIntOperations delegate ) {
      this._impl = delegate;
  }
  public GestionPersonalIntPOATie ( s_gestion_usuarios.sop_corba.GestionPersonalIntOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public s_gestion_usuarios.sop_corba.GestionPersonalIntOperations _delegate() {
      return this._impl;
  }
  public void _delegate (s_gestion_usuarios.sop_corba.GestionPersonalIntOperations delegate ) {
      this._impl = delegate;
  }
  public org.omg.PortableServer.POA _default_POA() {
      if(_poa != null) {
          return _poa;
      }
      else {
          return super._default_POA();
      }
  }
  public void registrarPersonal (s_gestion_usuarios.sop_corba.PersonalDTO objPersonal)
  {
    _impl.registrarPersonal(objPersonal);
  } // registrarPersonal

  public boolean consultarPersonal (int id, s_gestion_usuarios.sop_corba.PersonalDTOHolder objPersonal)
  {
    return _impl.consultarPersonal(id, objPersonal);
  } // consultarPersonal

  public int abrirSesion (s_gestion_usuarios.sop_corba.CredencialDTO objCredencial)
  {
    return _impl.abrirSesion(objCredencial);
  } // abrirSesion

  public boolean editarPersonal (int id, s_gestion_usuarios.sop_corba.PersonalDTO objPersonalNuevosDatos)
  {
    return _impl.editarPersonal(id, objPersonalNuevosDatos);
  } // editarPersonal

  public boolean eliminarPersonal (int id)
  {
    return _impl.eliminarPersonal(id);
  } // eliminarPersonal

  private s_gestion_usuarios.sop_corba.GestionPersonalIntOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class GestionPersonalIntPOATie
