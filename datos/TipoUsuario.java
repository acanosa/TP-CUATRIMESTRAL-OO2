package datos;

public class TipoUsuario {
	private long idTipoUsuario;
	private String tipo;
	private Usuario usuario;
	
	public TipoUsuario(){}
	
	public TipoUsuario(String tipo){
		super();
		this.tipo = tipo;
	}

	public long getIdTipoUsuario() {
		return idTipoUsuario;
	}

	protected void setIdTipoUsuario(long idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "idTipoUsuario=" + idTipoUsuario + ", tipo=" + tipo + ", usuario=" + usuario + "\n";
	}
	
	
	
	
}
