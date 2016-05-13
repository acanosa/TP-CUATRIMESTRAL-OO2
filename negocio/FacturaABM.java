package negocio;

import java.util.GregorianCalendar;
import java.util.List;

import datos.Factura;
import dao.FacturaDao;
public class FacturaABM {
	
	FacturaDao dao= new FacturaDao();
	
	public Factura traerFactura(long idFactura)throws Exception{
		Factura f= dao.traerFactura(idFactura);
		if(f==null) throw new Exception("ERROR: No se encuentra la factura con id "+idFactura);
		return f;
	}
	
	public long agregar(GregorianCalendar fecha, float total, boolean pagado){
		
		Factura f=new Factura(fecha, total, pagado);
		return dao.agregarFactura(f);
	}
	
	public long agregar(Factura f)throws Exception{
		
		if(dao.traerFactura(f.getIdFactura())!=null) throw new Exception("ERROR: Ya existe una Factura con ese id "+f.getIdFactura());
		return dao.agregarFactura(f);
	}
	
	public void modificar(Factura f)throws Exception{
		if(f==null) throw new Exception("ERROR: objeto nulo");
		dao.actualizarFactura(f);
	}

}
