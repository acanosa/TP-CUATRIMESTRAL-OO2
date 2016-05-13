package negocio;

public class Facade {
	
	public ClienteABM getClienteABM(){
		return new ClienteABM();
	}

	public EstadiaABM getEstadiaABM(){
		return new EstadiaABM();
	}
	
	public EstadoEstadiaABM getEstadoEstadiaABM(){
		return new EstadoEstadiaABM();
	}
	
	public FacturaABM getFacturaABM(){
		return new FacturaABM();
	}
	
	public HabitacionABM getHabitacionABM(){
		return new HabitacionABM();
	}
	
	public ItemFacturaABM getItemFacturaABM(){
		return new ItemFacturaABM();
	}
	
	public LoginABM getLoginABM(){
		return new LoginABM();
	}
	
	public PromocionABM getPromocionABM(){
		return new PromocionABM();
	}
	
	public ReciboABM getReciboABM(){
		return new ReciboABM();
	}
	
	public TicketConsumoABM getTicketConsumoABM(){
		return new TicketConsumoABM();
	}
	
	public TicketLimpiezaABM getTicketLimpiezaABM(){
		return new TicketLimpiezaABM();
	}
	
	public TicketMantenimientoABM getTicketMantenimientoABM(){
		return new TicketMantenimientoABM();
	}
	
	public TipoHabitacionABM getTipoHabitacionABM(){
		return new TipoHabitacionABM();
	}
	
	public TipoLimpiezaABM getTipoLimpiezaABM(){
		return new TipoLimpiezaABM();
	}
	
	public TipoUsuarioABM getTipoUsuarioABM(){
		return new TipoUsuarioABM();
	}
	
	public UsuarioABM getUsuarioABM(){
		return new UsuarioABM();
	}
}
