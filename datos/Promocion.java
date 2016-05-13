package datos;

import java.util.GregorianCalendar;

import funciones.Funciones;

public class Promocion {
	private long idPromocion;
	private GregorianCalendar fechaInicio;
	private GregorianCalendar fechaFin;
	private float descuento;
	private Estadia estadia;
	
	public Promocion(){}

	public Promocion(GregorianCalendar fechaInicio, GregorianCalendar fechaFin,
			float descuento) {
		super();
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.descuento = descuento;
	}

	public long getIdPromocion() {
		return idPromocion;
	}

	protected void setIdPromocion(long idPromocion) {
		this.idPromocion = idPromocion;
	}

	public GregorianCalendar getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(GregorianCalendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public GregorianCalendar getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(GregorianCalendar fechaFin) {
		this.fechaFin = fechaFin;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public Estadia getEstadia() {
		return estadia;
	}

	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}

	@Override
	public String toString() {
		return "idPromocion=" + idPromocion + ", fechaInicio=" + Funciones.obtenerFechaCorta(fechaInicio) + 
				", fechaFin=" + Funciones.obtenerFechaCorta(fechaFin) + ", descuento=" + descuento + ", estadia=" + estadia  + "\n";
	}
	
	
	
	
}
