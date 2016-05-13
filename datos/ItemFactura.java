package datos;

public class ItemFactura {
	private long idItemFactura;
	private String detalle;
	private float importe;
	private int cantidad;
	private Factura factura;
	
	public ItemFactura(){}
	
	public ItemFactura(String detalle, float importe, int cantidad) {
		super();
		this.detalle = detalle;
		this.importe = importe;
		this.cantidad = cantidad;
	}

	public long getIdItemFactura() {
		return idItemFactura;
	}

	protected void setIdItemFactura(long idItemFactura) {
		this.idItemFactura = idItemFactura;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public float getImporte() {
		return importe;
	}

	public void setImporte(float importe) {
		this.importe = importe;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
		
	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	
}
