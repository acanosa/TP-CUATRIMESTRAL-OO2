package datos;

import java.util.GregorianCalendar;

import funciones.Funciones;

public class Recibo {
	
	private long idRecibo;
	
	private GregorianCalendar fecha;
	private float importe;
	private String formaPago;
	
	private Factura factura;
	
	public Recibo(){}

	public Recibo(GregorianCalendar fecha, float importe, String formaPago) {
		super();
		this.fecha = fecha;
		this.importe = importe;
		this.formaPago = formaPago;
	}

	

	public long getIdRecibo() {
		return idRecibo;
	}

	protected void setIdRecibo(long idRecibo) {
		this.idRecibo = idRecibo;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public String toString() {
		return "idRecibo=" + idRecibo + ", fecha=" + Funciones.obtenerFechaCorta(fecha) + ", importe=" + importe + ", formaPago=" + formaPago
				+ ", factura=" + factura  + "\n";
	}
	
	
	
}
