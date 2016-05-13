package datos;

public class TipoLimpieza {
	private long idTipoLimpieza;
	private String descripcion;
	private TicketLimpieza ticketLimpieza;
	
	
	public TipoLimpieza(){}
	
	public TipoLimpieza(String descripcion){
		super();
		this.descripcion = descripcion;
	}

	public long getIdTipoLimpieza() {
		return idTipoLimpieza;
	}

	protected void setIdTipoLimpieza(long idTipoLimpieza) {
		this.idTipoLimpieza = idTipoLimpieza;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TicketLimpieza getTicketLimpieza() {
		return ticketLimpieza;
	}

	public void setTicketLimpieza(TicketLimpieza ticketLimpieza) {
		this.ticketLimpieza = ticketLimpieza;
	}

	@Override
	public String toString() {
		return "idTipoLimpieza=" + idTipoLimpieza + ", descripcion=" + descripcion + ", ticketLimpieza="
				+ ticketLimpieza + "\n";
	}
	
	
	
}
