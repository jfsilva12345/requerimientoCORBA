package s_gestion_usuarios.sop_corba;


/**
* s_gestion_usuarios/sop_corba/_GestionPersonalIntStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ./gusuarios.idl
* lunes 7 de marzo de 2022 12:17:04 PM COT
*/

public class _GestionPersonalIntStub extends org.omg.CORBA.portable.ObjectImpl implements s_gestion_usuarios.sop_corba.GestionPersonalInt
{

  public void registrarPersonal (s_gestion_usuarios.sop_corba.PersonalDTO objPersonal)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("registrarPersonal", true);
                s_gestion_usuarios.sop_corba.PersonalDTOHelper.write ($out, objPersonal);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                registrarPersonal (objPersonal        );
            } finally {
                _releaseReply ($in);
            }
  } // registrarPersonal

  public boolean consultarPersonal (int id, s_gestion_usuarios.sop_corba.PersonalDTOHolder objPersonal)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("consultarPersonal", true);
                $out.write_long (id);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                objPersonal.value = s_gestion_usuarios.sop_corba.PersonalDTOHelper.read ($in);
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return consultarPersonal (id, objPersonal        );
            } finally {
                _releaseReply ($in);
            }
  } // consultarPersonal

  public int abrirSesion (s_gestion_usuarios.sop_corba.CredencialDTO objCredencial)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("abrirSesion", true);
                s_gestion_usuarios.sop_corba.CredencialDTOHelper.write ($out, objCredencial);
                $in = _invoke ($out);
                int $result = $in.read_long ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return abrirSesion (objCredencial        );
            } finally {
                _releaseReply ($in);
            }
  } // abrirSesion

  public boolean editarPersonal (int id, s_gestion_usuarios.sop_corba.PersonalDTO objPersonalNuevosDatos)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("editarPersonal", true);
                $out.write_long (id);
                s_gestion_usuarios.sop_corba.PersonalDTOHelper.write ($out, objPersonalNuevosDatos);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return editarPersonal (id, objPersonalNuevosDatos        );
            } finally {
                _releaseReply ($in);
            }
  } // editarPersonal

  public boolean eliminarPersonal (int id)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("eliminarPersonal", true);
                $out.write_long (id);
                $in = _invoke ($out);
                boolean $result = $in.read_boolean ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return eliminarPersonal (id        );
            } finally {
                _releaseReply ($in);
            }
  } // eliminarPersonal

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:sop_corba/GestionPersonalInt:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} // class _GestionPersonalIntStub
