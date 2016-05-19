package datos;

import java.util.GregorianCalendar;
import java.util.Set;

import funciones.Funciones;

public class Promocion {
	private long idPromocion;
	private GregorianCalendar fechaInicio;
	private GregorianCalendar fechaFin;
	private float descuento;
	private Set<Estadia> estadias;
	
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

	public Set<Estadia> getEstadias() {
		return estadias;
	}

	public void setEstadias(Set<Estadia> estadias) {
		this.estadias = estadias;
	}

	@Override
	public String toString() {
		return "idPromocion=" + idPromocion + ", fechaInicio=" + Funciones.obtenerFechaCorta(fechaInicio) + 
				", fechaFin=" + Funciones.obtenerFechaCorta(fechaFin) + ", descuento=" + descuento + ", estadia=" + estadias  + "\n";
	}
	
	
	
	
}
