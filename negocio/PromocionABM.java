package negocio;

import datos.Promocion;

import java.util.GregorianCalendar;
import java.util.List;

import dao.PromocionDao;

public class PromocionABM {
	PromocionDao dao= new PromocionDao();
	
	public long agregarPromocion(GregorianCalendar fechaInicio, GregorianCalendar fechaFin, float descuento)
	{
		Promocion p=new Promocion(fechaInicio,fechaFin,descuento);
		return dao.agregarPromocion(p);
	}
	
	public Promocion traerPromocion(long idPromocion) throws Exception
	{
		if(dao.traerPromocion(idPromocion) == null) throw new Exception ("ERROR: no existe promocion con ese id");
		return dao.traerPromocion(idPromocion);
	}
	
	public List<Promocion> traerPromociones()
	{
		return dao.traerPromociones();
	}
	
	public void modificarPromocion(Promocion p) throws Exception
	{
		if(p==null) throw new Exception("ERROR: objeto nulo");
		if(dao.traerPromocion(p.getIdPromocion()) == null) throw new Exception("ERROR: no se encuentra promocion con ese id");
		dao.actualizarPromocion(p);
	}
	
	public void eliminarPromocion(Promocion p) throws Exception
	{
		if(p==null) throw new Exception("ERROR: objeto nulo");
		if(dao.traerPromocion(p.getIdPromocion()) == null) throw new Exception("ERROR: no se encuentra promocion con ese id");
		dao.eliminarPromocion(p);
	}
	

}
