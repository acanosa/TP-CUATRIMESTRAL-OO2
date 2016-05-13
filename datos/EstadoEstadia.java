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

	
	public void setIdEstadoEstadia(long idEstadoEstadia) {
		this.idEstadoEstadia = idEstadoEstadia;
	}

	public long getIdEstadoEstadia() {
		return idEstadoEstadia;
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

	@Override
	public String toString() {
		return "idEstadoEstadia=" + idEstadoEstadia + ", descripcion=" + descripcion + ", estadia="
				+ estadia + "\n";
	}
	
	
	
	
	
	
}

