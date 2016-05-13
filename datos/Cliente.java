package datos;
import java.util.Set;

import datos.Estadia;
public class Cliente {
	
	private long idCliente;
	private String nombre;
	private String apellido;
	private int dni;
	private boolean borrado;
	private Set<Estadia> estadias;
	private Login login;
	
	public Cliente(){}
	
	public Cliente(String nombre, String apellido, int dni) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.borrado=false;
	}
	
	public long getIdCliente() {
		return idCliente;
	}

	protected void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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
	
	public boolean isBorrado() {
		return borrado;
	}

	public void setBorrado(boolean borrado) {
		this.borrado = borrado;
	}

	public Set<Estadia> getEstadias() {
		return estadias;
	}

	public void setEstadias(Set<Estadia> estadias) {
		this.estadias = estadias;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	@Override
	public String toString() {
		return "idCliente=" + idCliente + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", dni=" + dni + ", borrado="
				+ borrado + ", estadias=" + estadias + "\n";
	}

	
	
	

}
