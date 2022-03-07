package s_seguimiento_usuarios.sop_corba;


/**
* s_seguimiento_usuarios/sop_corba/ProgramaSemanaDTOHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./susuarios.idl
* lunes 7 de marzo de 2022 12:16:48 PM COT
*/

abstract public class ProgramaSemanaDTOHelper
{
  private static String  _id = "IDL:sop_corba/ProgramaSemanaDTO:1.0";

  public static void insert (org.omg.CORBA.Any a, s_seguimiento_usuarios.sop_corba.ProgramaSemanaDTO that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static s_seguimiento_usuarios.sop_corba.ProgramaSemanaDTO extract (org.omg.CORBA.Any a)
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
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [2];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = org.omg.CORBA.ORB.init ().get_primitive_tc (org.omg.CORBA.TCKind.tk_long);
          _members0[0] = new org.omg.CORBA.StructMember (
            "id",
            _tcOf_members0,
            null);
          _tcOf_members0 = s_seguimiento_usuarios.sop_corba.KeyValEjDTOHelper.type ();
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_sequence_tc (0, _tcOf_members0);
          _tcOf_members0 = org.omg.CORBA.ORB.init ().create_alias_tc (s_seguimiento_usuarios.sop_corba.HashMapEjDTOHelper.id (), "HashMapEjDTO", _tcOf_members0);
          _members0[1] = new org.omg.CORBA.StructMember (
            "plan",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (s_seguimiento_usuarios.sop_corba.ProgramaSemanaDTOHelper.id (), "ProgramaSemanaDTO", _members0);
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

  public static s_seguimiento_usuarios.sop_corba.ProgramaSemanaDTO read (org.omg.CORBA.portable.InputStream istream)
  {
    s_seguimiento_usuarios.sop_corba.ProgramaSemanaDTO value = new s_seguimiento_usuarios.sop_corba.ProgramaSemanaDTO ();
    value.id = istream.read_long ();
    value.plan = s_seguimiento_usuarios.sop_corba.HashMapEjDTOHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, s_seguimiento_usuarios.sop_corba.ProgramaSemanaDTO value)
  {
    ostream.write_long (value.id);
    s_seguimiento_usuarios.sop_corba.HashMapEjDTOHelper.write (ostream, value.plan);
  }

}
