package s_gestion_usuarios.sop_corba;


/**
* s_gestion_usuarios/sop_corba/arrayAsistenciaDTOHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./gusuarios.idl
* lunes 7 de marzo de 2022 12:17:04 PM COT
*/

abstract public class arrayAsistenciaDTOHelper
{
  private static String  _id = "IDL:sop_corba/arrayAsistenciaDTO:1.0";

  public static void insert (org.omg.CORBA.Any a, s_seguimiento_usuarios.sop_corba.AsistenciaDTO[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static s_seguimiento_usuarios.sop_corba.AsistenciaDTO[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = s_seguimiento_usuarios.sop_corba.AsistenciaDTOHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (s_gestion_usuarios.sop_corba.arrayAsistenciaDTOHelper.id (), "arrayAsistenciaDTO", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static s_seguimiento_usuarios.sop_corba.AsistenciaDTO[] read (org.omg.CORBA.portable.InputStream istream)
  {
    s_seguimiento_usuarios.sop_corba.AsistenciaDTO value[] = null;
    int _len0 = istream.read_long ();
    value = new s_seguimiento_usuarios.sop_corba.AsistenciaDTO[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = s_seguimiento_usuarios.sop_corba.AsistenciaDTOHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, s_seguimiento_usuarios.sop_corba.AsistenciaDTO[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
    s_seguimiento_usuarios.sop_corba.AsistenciaDTOHelper.write (ostream, value[_i0]);
  }

}
