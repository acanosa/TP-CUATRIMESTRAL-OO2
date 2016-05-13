package datos;

import java.util.GregorianCalendar;

public class Promocion {
	private long idPromocion;
	private GregorianCalendar fechaInicio;
	private GregorianCalendar fechaFin;
	private double descuento;
	private Estadia estadia;
	
	public Promocion(){}

	public Promocion(GregorianCalendar fechaInicio, GregorianCalendar fechaFin,
			double descuento) {
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

	public double getDescuento() {
		return descuento;
	}

	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}

	public Estadia getEstadia() {
		return estadia;
	}

	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}
	
	
	
}
