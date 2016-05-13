package datos;

public class Usuario {
	private long idUsuario;
	private String nombre;
	private String apellido;
	private int dni;
	private String usuario;
	private String clave;
	private boolean baja;
	private Login login;
	private TipoUsuario tipoUsuario;
	
	public Usuario(){}

	public Usuario(String nombre, String apellido, boolean baja, int dni, String usuario, String clave) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.baja=false;
		this.usuario= usuario;
		this.clave= clave;
	}

	public long getIdUsuario() {
		return idUsuario;
	}

	protected void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public boolean isBaja() {
		return baja;
	}

	public void setBaja(boolean baja) {
		this.baja = baja;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "idUsuario=" + idUsuario + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", dni=" + dni + ", usuario="
				+ usuario  + "\n";
	}
	
	
	
	
	
	
}
