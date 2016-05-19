package datos;

public class Usuario {
	private long idUsuario;
	private String nombre;
	private String apellido;
	private int dni;
	
	private boolean baja;
	private Login login;
	private TipoUsuario tipoUsuario;
	
	public Usuario(){}

	public Usuario(String nombre, String apellido, boolean baja, int dni, Login login) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.baja=false;
		this.login=login;
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
				+ ", apellido=" + apellido + ", dni=" + dni +  "\n";
	}
	
	
	
	
	
	
}
