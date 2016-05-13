package datos;

import java.util.GregorianCalendar;

public class Factura {
	private long idFactura;
	private GregorianCalendar fecha;
	private float total;
	private boolean pagado;
	private Estadia estadia;
	private ItemFactura itemFactura;
	private Recibo recibo;
		
	public Factura(){}

	public Factura(GregorianCalendar fecha, float total,
			boolean pagado) {
		super();
		this.fecha = fecha;
		this.total=total;
		this.pagado=pagado;
	}

	public long getIdFactura() {
		return idFactura;
	}

	protected void setIdFactura(long idFactura) {
		this.idFactura = idFactura;
	}

	public GregorianCalendar getFecha() {
		return fecha;
	}

	public void setFecha(GregorianCalendar fecha) {
		this.fecha = fecha;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public Estadia getEstadia() {
		return estadia;
	}

	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}

	public ItemFactura getItemFactura() {
		return itemFactura;
	}

	public void setItemFactura(ItemFactura itemFactura) {
		this.itemFactura = itemFactura;
	}

	public Recibo getRecibo() {
		return recibo;
	}

	public void setRecibo(Recibo recibo) {
		this.recibo = recibo;
	}

	
	
	
}
