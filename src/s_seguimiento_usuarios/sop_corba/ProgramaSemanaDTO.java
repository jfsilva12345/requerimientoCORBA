package s_seguimiento_usuarios.sop_corba;


/**
* s_seguimiento_usuarios/sop_corba/ProgramaSemanaDTO.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./susuarios.idl
* lunes 7 de marzo de 2022 12:16:48 PM COT
*/

public final class ProgramaSemanaDTO implements org.omg.CORBA.portable.IDLEntity
{
  public int id = (int)0;
  public s_seguimiento_usuarios.sop_corba.KeyValEjDTO plan[] = null;

  public ProgramaSemanaDTO ()
  {
  } // ctor

  public ProgramaSemanaDTO (int _id, s_seguimiento_usuarios.sop_corba.KeyValEjDTO[] _plan)
  {
    id = _id;
    plan = _plan;
  } // ctor

} // class ProgramaSemanaDTO
