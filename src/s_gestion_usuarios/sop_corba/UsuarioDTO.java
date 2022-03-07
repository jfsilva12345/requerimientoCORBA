package s_gestion_usuarios.sop_corba;



public final class UsuarioDTO implements org.omg.CORBA.portable.IDLEntity {
  public String nombreCompleto = null;
  public int id = (int) 0;
  public String dependencia = null;
  public String tipoUsuario = null;
  public String fechaIngreso = null;
  public String patologia = null;
  public String usuario = null;
  public String clave = null;
  public boolean valorado = false;

  public UsuarioDTO() {
  } // ctor

  public UsuarioDTO(String _nombreCompleto, int _id, String _dependencia, String _tipoUsuario, String _fechaIngreso,
      String _patologia, String _usuario, String _clave) {
    nombreCompleto = _nombreCompleto;
    id = _id;
    dependencia = _dependencia;
    tipoUsuario = _tipoUsuario;
    fechaIngreso = _fechaIngreso;
    patologia = _patologia;
    usuario = _usuario;
    clave = _clave;
    valorado = false;
  } // ctor

  public boolean isValorado() {
    return valorado;
  }

  public void setValorado(boolean valorado) {
    this.valorado = valorado;
  }

} // class UsuarioDTO
