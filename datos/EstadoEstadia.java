package datos;

public class EstadoEstadia {
	private long idEstadoEstadia;
	private String descripcion;
	private Estadia estadia;
	
	public EstadoEstadia(){}
	
	public EstadoEstadia(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public long getIdEstadoEstadia() {
		return idEstadoEstadia;
	}

	protected void setEstadoIdEstadia(long idEstadia) {
		this.idEstadoEstadia = idEstadia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Estadia getEstadia() {
		return estadia;
	}

	public void setEstadia(Estadia estadia) {
		this.estadia = estadia;
	}
	
	
	
	
}

