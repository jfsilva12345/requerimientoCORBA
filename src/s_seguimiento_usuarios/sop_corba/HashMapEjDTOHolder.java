package s_seguimiento_usuarios.sop_corba;


/**
* s_seguimiento_usuarios/sop_corba/HashMapEjDTOHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./susuarios.idl
* lunes 7 de marzo de 2022 12:16:48 PM COT
*/

public final class HashMapEjDTOHolder implements org.omg.CORBA.portable.Streamable
{
  public s_seguimiento_usuarios.sop_corba.KeyValEjDTO value[] = null;

  public HashMapEjDTOHolder ()
  {
  }

  public HashMapEjDTOHolder (s_seguimiento_usuarios.sop_corba.KeyValEjDTO[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = s_seguimiento_usuarios.sop_corba.HashMapEjDTOHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    s_seguimiento_usuarios.sop_corba.HashMapEjDTOHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return s_seguimiento_usuarios.sop_corba.HashMapEjDTOHelper.type ();
  }

}
