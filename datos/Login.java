package datos;

public class Login {
	private long idLogin;
	private String usuario;
	private String clave;
	private int privilegio;
	
	private Usuario datosUsuario;
	private Cliente cliente;
	private TicketLimpieza ticketLimpieza;
	private TicketMantenimiento ticketMantenimiento;
	
	
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

	public void setIdLogin(long idLogin) {
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

	public TicketLimpieza getTicketLimpieza() {
		return ticketLimpieza;
	}

	public void setTicketLimpieza(TicketLimpieza ticketLimpieza) {
		this.ticketLimpieza = ticketLimpieza;
	}

	public TicketMantenimiento getTicketMantenimiento() {
		return ticketMantenimiento;
	}

	public void setTicketMantenimiento(TicketMantenimiento ticketMantenimiento) {
		this.ticketMantenimiento = ticketMantenimiento;
	}
	
	
	
}	
