package negocio;

import java.util.List;

import dao.ItemFacturaDao;
import datos.ItemFactura;

public class ItemFacturaABM {
ItemFacturaDao dao=new ItemFacturaDao();
	
	public ItemFactura traerItemFactura(long idItemFactura)throws Exception{
		ItemFactura i= dao.traerItemFactura(idItemFactura);
		if(i==null) throw new Exception("ERROR: No se encuentra el ItemFactura con id "+idItemFactura);
		return i;
	}
	
	public long agregarItemFactura(String detalle, float importe, int cantidad)throws Exception{
		ItemFactura i=new ItemFactura(detalle,importe,cantidad);
		return dao.agregarItemFactura(i);
	}
	
	public long agregarItemFactura(ItemFactura i)throws Exception{
		return dao.agregarItemFactura(i);
	}
	
	public void modificarItemFactura(ItemFactura i)throws Exception{
	if(dao.traerItemFactura(i.getIdItemFactura())==null) throw new Exception("ERROR: no existe factura con ese id" +i.getIdItemFactura());
		dao.actualizarItemFactura(i);
	}
	
	public  void eliminarItemFactura(long idItemFactura)throws Exception{
		ItemFactura i=dao.traerItemFactura(idItemFactura);
		if(i==null) throw new Exception("ERROR: No se encuentra el ItemFactura con id "+idItemFactura);
		dao.eliminarItemFactura(i);
	}

	public List<ItemFactura> traerItemFacturas(){
		return dao.traerItemFacturas();
	}
	

}
