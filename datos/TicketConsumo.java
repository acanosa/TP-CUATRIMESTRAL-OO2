package datos;

import java.util.GregorianCalendar;

public class TicketConsumo {
	
	private long idTicketConsumo;
	private String descripcion;
	private float precio;
	private GregorianCalendar fecha;
	private Estadia estadia;
	
	public TicketConsumo(){}

	public TicketConsumo(String descripcion,  float precio, GregorianCalendar fecha) {
		super();
		this.descripcion = descripcion;
		this.precio = precio;
		this.fecha = fecha;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public long getIdTicketConsumo() {
		return idTicketConsumo;
	}

	public void setIdTicketConsumo(long idTicketConsumo) {
		this.idTicketConsumo = idTicketConsumo;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public Estadia getEstadia() {
		return estadia;
	}

	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}
	
	
	
	
}
