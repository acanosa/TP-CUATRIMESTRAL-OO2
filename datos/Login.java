package datos;

import java.util.Set;

public class Login {
	private long idLogin;
	private String usuario;
	private String clave;
	private int privilegio;
	
	private Usuario datosUsuario;
	private Cliente cliente;
	private Set<TicketLimpieza> ticketLimpieza;
	private Set<TicketMantenimiento> ticketMantenimiento;
	
	
	
	public Login(){}

	public Login(String usuario, String clave, int privilegio) {
		super();
		this.usuario = usuario;
		this.clave = clave;
		this.privilegio = privilegio;
	}

	
	
	public long getIdLogin() {
		return idLogin;
	}

	protected void setIdLogin(long idLogin) {
		this.idLogin = idLogin;
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

	public int getPrivilegio() {
		return privilegio;
	}

	public void setPrivilegio(int privilegio) {
		this.privilegio = privilegio;
	}

	public Usuario getDatosUsuario() {
		return datosUsuario;
	}

	public void setDatosUsuario(Usuario datosUsuario) {
		this.datosUsuario = datosUsuario;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Set<TicketLimpieza> getTicketLimpieza() {
		return ticketLimpieza;
	}

	public void setTicketLimpieza(Set<TicketLimpieza> ticketLimpieza) {
		this.ticketLimpieza = ticketLimpieza;
	}

	public Set<TicketMantenimiento> getTicketMantenimiento() {
		return ticketMantenimiento;
	}

	public void setTicketMantenimiento(Set<TicketMantenimiento> ticketMantenimiento) {
		this.ticketMantenimiento = ticketMantenimiento;
	}

	@Override
	public String toString() {
		return "idLogin=" + idLogin + ", usuario=" + usuario + ", clave=" + clave + ", privilegio=" + privilegio
				+ ", datosUsuario=" + datosUsuario + "\n";/*", cliente=" + cliente + ", ticketLimpieza=" + ticketLimpieza
				+ ", ticketMantenimiento=" + ticketMantenimiento + "\n";*/
	}
	
	
	
	
}	
