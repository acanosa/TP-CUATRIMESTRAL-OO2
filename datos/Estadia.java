package datos;

import java.util.GregorianCalendar;
import java.util.Set;

import funciones.Funciones;

public class Estadia {
	private long idEstadia;
	private GregorianCalendar fechaCheckIn;
	private GregorianCalendar fechaCheckOut;
	private GregorianCalendar fechaPedido;
	private boolean facturado;
	private Cliente cliente;	
	private EstadoEstadia estado;
	private Promocion promocion;	
	private Set<Habitacion> habitaciones;
	private Set<TicketConsumo> ticketsConsumo;
	private Set<Factura> facturas;
	
	public Estadia(){}

	public Estadia(//solo atributos propios de clase estadia, se asocia por BD
			GregorianCalendar fechaCheckIn, GregorianCalendar fechaCheckOut,
			GregorianCalendar fechaPedido, boolean facturado) {
		super();
		this.facturado=facturado;
		this.fechaCheckIn = fechaCheckIn;
		this.fechaCheckOut = fechaCheckOut;
		this.fechaPedido = fechaPedido;
	}

	public long getIdEstadia() {
		return idEstadia;
	}

	protected void setIdEstadia(long idEstadia) {
		this.idEstadia = idEstadia;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public boolean isFacturado() {
		return facturado;
	}

	public void setFacturado(boolean facturado) {
		this.facturado = facturado;
	}

	public Promocion getPromocion() {
		return promocion;
	}

	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}

	public Set<TicketConsumo> getTicketsConsumo() {
		return ticketsConsumo;
	}

	public void setTicketsConsumo(Set<TicketConsumo> ticketsConsumo) {
		this.ticketsConsumo = ticketsConsumo;
	}

	public GregorianCalendar getFechaCheckIn() {
		return fechaCheckIn;
	}

	public void setFechaCheckIn(GregorianCalendar fechaCheckIn) {
		this.fechaCheckIn = fechaCheckIn;
	}

	public GregorianCalendar getFechaCheckOut() {
		return fechaCheckOut;
	}

	public void setFechaCheckOut(GregorianCalendar fechaCheckOut) {
		this.fechaCheckOut = fechaCheckOut;
	}

	public GregorianCalendar getFechaPedido() {
		return fechaPedido;
	}

	public void setFechaPedido(GregorianCalendar fechaPedido) {
		this.fechaPedido = fechaPedido;
	}

	public EstadoEstadia getEstado() {
		return estado;
	}

	public void setEstado(EstadoEstadia estado) {
		this.estado = estado;
	}

	public void setHabitaciones(Set<Habitacion> habitaciones) {
		this.habitaciones = habitaciones;
	}
	
	public Set<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public Set<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(Set<Factura> facturas) {
		this.facturas = facturas;
	}

	@Override
	public String toString() {
		return "idEstadia=" + idEstadia + ", fechaCheckIn="
				+ Funciones.obtenerFechaCorta(fechaCheckIn) + ", fechaCheckOut=" + 
				Funciones.obtenerFechaCorta(fechaCheckOut)
				+ ", fechaPedido=" + Funciones.obtenerFechaCorta(fechaPedido) + 
				", facturado=" + facturado
				+ ", cliente=" + cliente + ", estado=" + estado
				+ ", promocion=" + promocion + ", habitaciones=" + habitaciones
				+ ", ticketsConsumo=" + ticketsConsumo + ", facturas="
				+ facturas ;
	}
	
	
	
	
}
