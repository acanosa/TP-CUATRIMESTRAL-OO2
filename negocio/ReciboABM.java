package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import datos.Promocion;
import datos.Recibo;
import dao.ReciboDao;
public class ReciboABM {
	
	ReciboDao dao= new ReciboDao();
	
	public long agregarRecibo(GregorianCalendar fecha, float importe, String formaPago)
	{
		Recibo r= new Recibo(fecha,importe,formaPago);
		return dao.agregarRecibo(r);
	}
	
	public long agregarRecibo(Recibo r) throws Exception
	{
		if(r==null) throw new Exception("ERROR: objeto nulo");
		return dao.agregarRecibo(r);
	}
	
	public Recibo traerRecibo(long idRecibo) throws Exception
	{
		if(dao.traerRecibo(idRecibo)==null) throw new Exception("ERROR: no se encuentra recibo con ese id");
		return dao.traerRecibo(idRecibo);
	}
	
	public void modificarRecibo(Recibo recibo) throws Exception
	{
		if(recibo==null) throw new Exception("ERROR: objeto nulo");
		dao.actualizarRecibo(recibo);
	}
	
	public void eliminarRecibo(Recibo recibo) throws Exception
	{
		if(recibo==null) throw new Exception("ERROR: objeto nulo");
		dao.eliminarRecibo(recibo);
	}

	public List<Recibo> traerRecibos()
	{
		return dao.traerRecibos();
	}
}
