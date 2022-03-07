package s_seguimiento_usuarios.sop_corba;


/**
* s_seguimiento_usuarios/sop_corba/EjercicioDTOHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./susuarios.idl
* lunes 7 de marzo de 2022 12:16:48 PM COT
*/

abstract public class EjercicioDTOHelper
{
  private static String  _id = "IDL:sop_corba/EjercicioDTO:1.0";

  public static void insert (org.omg.CORBA.Any a, s_seguimiento_usuarios.sop_corba.EjercicioDTO that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static s_seguimiento_usuarios.sop_corba.EjercicioDTO extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [3];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_string_tc (0);
          _members0[0] = new org.omg.CORBA.StructMember (
            "nombre",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[1] = new org.omg.CORBA.StructMember (
            "repeticiones",
            _tcOf_members0,
            null);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_double);
          _members0[2] = new org.omg.CORBA.StructMember (
            "pese",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (s_seguimiento_usuarios.sop_corba.EjercicioDTOHelper.id (), "EjercicioDTO", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static s_seguimiento_usuarios.sop_corba.EjercicioDTO read (org.omg.CORBA.portable.InputStream istream)
  {
    s_seguimiento_usuarios.sop_corba.EjercicioDTO value = new s_seguimiento_usuarios.sop_corba.EjercicioDTO ();
    value.nombre = istream.read_string ();
    value.repeticiones = istream.read_long ();
    value.pese = istream.read_double ();
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, s_seguimiento_usuarios.sop_corba.EjercicioDTO value)
  {
    ostream.write_string (value.nombre);
    ostream.write_long (value.repeticiones);
    ostream.write_double (value.pese);
  }

}
