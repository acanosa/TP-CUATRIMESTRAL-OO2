package datos;

public class TipoHabitacion {
	private long idTipoHabitacion;
	private String descripcion;
	private float precioTemporadaAlta;
	private float precioTemporadaBaja;
	private Habitacion habitacion;
	
	public TipoHabitacion(){}

	public TipoHabitacion(String descripcion, float precioTemporadaAlta,
			float precioTemporadaBaja) {
		super();
		this.descripcion = descripcion;
		this.precioTemporadaAlta = precioTemporadaAlta;
		this.precioTemporadaBaja = precioTemporadaBaja;
	}

	public long getIdTipoHabitacion() {
		return idTipoHabitacion;
	}

	protected void setIdTipoHabitacion(long idTipoHabitacion) {
		this.idTipoHabitacion = idTipoHabitacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecioTemporadaAlta() {
		return precioTemporadaAlta;
	}

	public void setPrecioTemporadaAlta(float precioTemporadaAlta) {
		this.precioTemporadaAlta = precioTemporadaAlta;
	}

	public float getPrecioTemporadaBaja() {
		return precioTemporadaBaja;
	}

	public void setPrecioTemporadaBaja(float precioTemporadaBaja) {
		this.precioTemporadaBaja = precioTemporadaBaja;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	@Override
	public String toString() {
		return "idTipoHabitacion=" + idTipoHabitacion + ", descripcion=" + descripcion
				+ ", precioTemporadaAlta=" + precioTemporadaAlta + ", precioTemporadaBaja=" + precioTemporadaBaja
				+ ", habitacion=" + habitacion + "\n";
	}

	
	
	
	
	
}
