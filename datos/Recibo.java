package datos;

import java.util.GregorianCalendar;

public class Recibo {
	
	private long idRecibo;
	private GregorianCalendar fecha;
	private double importe;
	private String formaPago;
	private Factura factura;
	
	public Recibo(){}

	public Recibo(GregorianCalendar fecha, double importe, String formaPago) {
		super();
		this.fecha = fecha;
		this.importe = importe;
		this.formaPago = formaPago;
	}

	public long getIdRecibo() {
		return idRecibo;
	}

	public void setIdRecibo(long idRecibo) {
		this.idRecibo = idRecibo;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
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
	
}
