package datos;

import java.util.GregorianCalendar;

public class TicketLimpieza {
	
	private long idTicketLimpieza;
	private boolean realizado;
	private GregorianCalendar fecha;
	private Login login;
	private TipoLimpieza tipoLimpieza;
	
	public TicketLimpieza(){}

	public TicketLimpieza(boolean realizado, GregorianCalendar fecha) {
		super();
		this.realizado = realizado;
		this.fecha = fecha;
	}

	public boolean isRealizado() {
		return realizado;
	}

	public void setRealizado(boolean realizado) {
		this.realizado = realizado;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public TipoLimpieza getTipoLimpieza() {
		return tipoLimpieza;
	}

	public void setTipoLimpieza(TipoLimpieza tipoLimpieza) {
		this.tipoLimpieza = tipoLimpieza;
	}

	public long getIdTicketLimpieza() {
		return idTicketLimpieza;
	}

	public void setIdTicketLimpieza(long idTicketLimpieza) {
		this.idTicketLimpieza = idTicketLimpieza;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
	
}
