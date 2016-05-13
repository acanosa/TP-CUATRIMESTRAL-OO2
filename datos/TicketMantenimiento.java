package datos;

import java.util.GregorianCalendar;

public class TicketMantenimiento {
	private long idTicketMantenimiento;
	private GregorianCalendar fechaGeneracion;
	private String lugar;
	private String problema;
	private String observacion;
	private boolean reparado;
	private GregorianCalendar fechaInicio;
	private GregorianCalendar fechaFinalizacion;
	private Login login;
	
	
	public TicketMantenimiento(){}

	public TicketMantenimiento(GregorianCalendar fechaGeneracion, String lugar, String problema,
			String observacion, boolean reparado, GregorianCalendar fechaInicio, 
			GregorianCalendar fechaFinalizacion) {
		super();
		this.fechaGeneracion= fechaGeneracion;
		this.lugar = lugar;
		this.problema = problema;
		this.observacion = observacion;
		this.reparado = reparado;
		this.fechaInicio=fechaInicio;
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public long getIdTicketMantenimiento() {
		return idTicketMantenimiento;
	}

	protected void setIdTicketMantenimiento(long idTicketMantenimiento) {
		this.idTicketMantenimiento = idTicketMantenimiento;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public GregorianCalendar getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(GregorianCalendar fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public GregorianCalendar getFechaGeneracion() {
		return fechaGeneracion;
	}

	public void setFechaGeneracion(GregorianCalendar fechaGeneracion) {
		this.fechaGeneracion = fechaGeneracion;
	}

	public String getProblema() {
		return problema;
	}

	public void setProblema(String problema) {
		this.problema = problema;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public boolean isReparado() {
		return reparado;
	}

	public void setReparado(boolean reparado) {
		this.reparado = reparado;
	}

	public GregorianCalendar getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(GregorianCalendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
	
	


}
