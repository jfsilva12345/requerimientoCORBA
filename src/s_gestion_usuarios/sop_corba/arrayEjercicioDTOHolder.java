package s_gestion_usuarios.sop_corba;


/**
* s_gestion_usuarios/sop_corba/arrayEjercicioDTOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./gusuarios.idl
* lunes 7 de marzo de 2022 12:17:04 PM COT
*/

public final class arrayEjercicioDTOHolder implements org.omg.CORBA.portable.Streamable
{
  public s_gestion_usuarios.sop_corba.EjercicioDTO value[] = null;

  public arrayEjercicioDTOHolder ()
  {
  }

  public arrayEjercicioDTOHolder (s_gestion_usuarios.sop_corba.EjercicioDTO[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = s_gestion_usuarios.sop_corba.arrayEjercicioDTOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    s_gestion_usuarios.sop_corba.arrayEjercicioDTOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return s_gestion_usuarios.sop_corba.arrayEjercicioDTOHelper.type ();
  }

}
