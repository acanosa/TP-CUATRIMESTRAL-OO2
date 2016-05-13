package negocio;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import datos.Factura;
import datos.ItemFactura;
import datos.Recibo;
import dao.FacturaDao;
public class FacturaABM {
	
	FacturaDao dao= new FacturaDao();
	
	public Factura traerFactura(long idFactura)throws Exception{
		Factura f= dao.traerFactura(idFactura);
		if(f==null) throw new Exception("ERROR: No se encuentra la factura con id "+idFactura);
		return f;
	}
	
	public long agregarFactura(GregorianCalendar fecha, float total, boolean pagado){
		
		Factura f=new Factura(fecha, total, pagado);
		return dao.agregarFactura(f);
	}
	
	public long agregarFactura(Factura f)throws Exception{
		
		if(dao.traerFactura(f.getIdFactura())!=null) throw new Exception("ERROR: Ya existe una Factura con ese id "+f.getIdFactura());
		return dao.agregarFactura(f);
	}
	
	public void modificarFactura(Factura f)throws Exception{
		if(f==null) throw new Exception("ERROR: objeto nulo");
		dao.actualizarFactura(f);
	}
	
	
	public Factura traerListasFactura(long idFactura) throws Exception //traigo tanto recibos como Items, ahorra validaciones
	{
		if(dao.traerFactura(idFactura)== null) throw new Exception ("ERROR: no existe factura");
		return dao.traerListasFactura(idFactura);
	}
	
	public void pagarFactura(Factura f) throws Exception
	{
		int i=0;
		float totalRecibos=0.0f;
		float totalItems=0.0f;
		
		if (f.getRecibos() == null || f.getItemFactura()==null)
		{
			f = traerListasFactura(f.getIdFactura());
			
			if(f.getRecibos()==null){
				totalRecibos=0;
				List<ItemFactura> lista=new ArrayList(f.getItemFactura());
				while(i<lista.size())
				{
					
				}
			}else{
				List<Recibo> listaRecibos=new ArrayList(f.getRecibos()); //transfiere el Set a ArrayList, para pasar los datos a lista
				while(i<listaRecibos.size()){
					totalRecibos=totalRecibos + listaRecibos.get(i).getImporte();
					i++;
				}
				
			}
				
		}
		
		
	}

}
