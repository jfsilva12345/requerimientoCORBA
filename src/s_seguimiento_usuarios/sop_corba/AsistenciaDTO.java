package s_seguimiento_usuarios.sop_corba;


/**
* s_seguimiento_usuarios/sop_corba/AsistenciaDTO.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./susuarios.idl
* lunes 7 de marzo de 2022 12:16:48 PM COT
*/

public final class AsistenciaDTO implements org.omg.CORBA.portable.IDLEntity
{
  public int id = (int)0;
  public String fechaAsistencia = null;
  public String observacion = null;

  public AsistenciaDTO ()
  {
  } // ctor

  public AsistenciaDTO (int _id, String _fechaAsistencia, String _observacion)
  {
    id = _id;
    fechaAsistencia = _fechaAsistencia;
    observacion = _observacion;
  } // ctor

} // class AsistenciaDTO