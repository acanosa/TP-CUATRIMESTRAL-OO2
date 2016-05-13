package datos;

import java.util.Set;

public class Habitacion {
	private long idHabitacion;
	private int capacidadMaxima;
	private boolean disponible;
	private float precioNoche;
	private float precioTemporada;
	private Set<Estadia> lstEstadias;
	private TipoHabitacion tipoHabitacion;
	
	public Habitacion(){}

	public Habitacion(int capacidadMaxima, boolean disponible, float precioNoche,
			float precioTemporada) {
		super();
		this.capacidadMaxima = capacidadMaxima;
		this.disponible = disponible;
		this.precioNoche = precioNoche;
		this.precioTemporada = precioTemporada;
	}

	public long getIdHabitacion() {
		return idHabitacion;
	}

	protected void setIdHabitacion(long idHabitacion) {
		this.idHabitacion = idHabitacion;
	}

	public TipoHabitacion getTipoHabitacion() {
		return tipoHabitacion;
	}

	public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
		this.tipoHabitacion = tipoHabitacion;
	}

	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}

	public void setCapacidadMaxima(int capacidadMaxima) {
		this.capacidadMaxima = capacidadMaxima;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public float getPrecioNoche() {
		return precioNoche;
	}

	public void setPrecioNoche(float precioNoche) {
		this.precioNoche = precioNoche;
	}

	public float getPrecioTemporada() {
		return precioTemporada;
	}

	public void setPrecioTemporada(float precioTemporada) {
		this.precioTemporada = precioTemporada;
	}

	public Set<Estadia> getLstEstadias() {
		return lstEstadias;
	}

	public void setLstEstadias(Set<Estadia> lstEstadias) {
		this.lstEstadias = lstEstadias;
	}

	@Override
	public String toString() {
		return "idHabitacion=" + idHabitacion + ", capacidadMaxima=" + capacidadMaxima + ", disponible="
				+ disponible + ", precioNoche=" + precioNoche + ", precioTemporada=" + precioTemporada
				+ ", lstEstadias=" + lstEstadias + ", tipoHabitacion=" + tipoHabitacion + "\n";
	}
	
	
	
	
	
	
}
