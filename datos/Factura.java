package datos;

import java.util.GregorianCalendar;
import java.util.Set;

import funciones.Funciones;

public class Factura {
	private long idFactura;
	private GregorianCalendar fecha;
	private float total;
	private boolean pagado;
	private Estadia estadia;
	private Set<ItemFactura> itemFactura;
	private Set<Recibo> recibos;
		
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

	public Set<ItemFactura> getItemFactura() {
		return itemFactura;
	}

	public void setItemFactura(Set<ItemFactura> itemFactura) {
		this.itemFactura = itemFactura;
	}

	public Set<Recibo> getRecibos() {
		return recibos;
	}

	public void setRecibos(Set<Recibo> recibo) {
		this.recibos = recibo;
	}

	@Override
	public String toString() {
		return "idFactura=" + idFactura + ", fecha=" + Funciones.obtenerFechaCorta(fecha) + ", total=" + total + ", pagado=" + pagado
				+ ", estadia=" + estadia + ", itemFactura=" + itemFactura + ", recibos=" + recibos + "\n";
	}
	
	

	
	
	
}
