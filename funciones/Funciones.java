package funciones;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;

//Document: hace referencia al documento XML
//Element: el Elemento que predomina en el documento o una clase con atributos (pelicula, feriado.. etc), hereda de Node
//DocumentBuilderFactory: usado para crear documento, se instancia con el metodo newInstance(), necesario para DB
//DocumentBuilder: constructor del documento, se instancia con el metodo newDocumentBuilder() (necesario DBF)
//InputSource: fuente que se leera del archivo, se instancia como cualquier clase
//setCharacterStream: metodo para InputSource, indica la cadena de caracteres a leer, entre parentesis se declara el lector (StringReader aca) y la variable
//StringReader: Lector de String, que lee los caracteres del XML obviando los caracteres de codeo
//normalize(): normaliza el texto del xml, osea que si una palabra u oracion esta separado en lineas distintas, los une como uno, y elimina caracteres unicode, etc
//getDocumentElement(): auto explicativo, devuelve el elemento del documento
//NodeList: referencia a la coleccion de nodos, es una implementacion abstracta
//getElementsByTagName("TAG"): lee solamente los elementos que contengan ese tag, ejemplo "pelicula"
//parse: analiza caracteres del archivo y java los extrae, en este caso con "archivo", sacamos nomas las cadenas de caracteres y las ponemos en el documento
//File: archivo, al declarar se necesita ruta del mismo en parentesis
//getAbsolutePath(): da ruta desde directorio raiz, necesaria
//BufferedReader: lector del archivo, necesita declaracion de filereader al declararse
//FileReader: lector del archivo (contiene ruta del mismo al declarar)
//Node: es una interface para todo el objeto del documento
//getItem(INDICE), obtiene el nodo de la lista con el valor del indice
//getLength() (nodolista)= obtiene longitud nodolista
//ELEMENT_NODE: es un tipo de nodo, indica q es elemento del documento
//getChildNodes(): aca buscamos los atributos del elemento
//getNodeValue(): devuelve el valor del nodo, lo usamos con toString para que lo pase a cadena



public class Funciones {
	
//private static final List<GregorianCalendar> lstFeriados=cargarLstFeriados();
	
	/*private static List cargarLstFeriados()
	{
		List<GregorianCalendar> lista=new ArrayList<GregorianCalendar>();
		try{
		File dirBase=new File("src/datos/feriados.xml");
		String ruta= dirBase.getAbsolutePath();
		BufferedReader br= new BufferedReader(new FileReader(ruta));
		String cadena="";
		String entrada;
		
		while((entrada=br.readLine()) !=null)
			cadena += entrada;
		
		DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
		DocumentBuilder db= dbf.newDocumentBuilder();
		
		InputSource archivo= new InputSource ();
		archivo.setCharacterStream(new StringReader(cadena));
		
		Document documento= db.parse(archivo);
		documento.getDocumentElement().normalize();
		
		NodeList nodeLista = documento.getElementsByTagName("feriado");
		String[] tags = {"anio","mes","dia"};
		for (int s = 0; s < nodeLista.getLength(); s++) {
		Node nodo = nodeLista.item(s);
		String[] valores = new String[tags.length];
		if (nodo.getNodeType() == Node.ELEMENT_NODE) {
			Element elemento = (Element) nodo;
			
			for (int i = 0; i < tags.length; i++) {
				NodeList nombreElementoLista =
						elemento.getElementsByTagName(tags[i]);
				Element nombreElemento = (Element) nombreElementoLista.item(0);
				NodeList nombre = nombreElemento.getChildNodes();
				valores[i] = ((Node) nombre.item(0)).getNodeValue().toString();
			}
		
			int anio=Integer.parseInt(valores[0]);
			int mes=Integer.parseInt(valores[1]);
			int dia=Integer.parseInt(valores[2]);
			
			GregorianCalendar f=new GregorianCalendar(anio,mes,dia);
			lista.add(f);
			}
		}
		
		
		br.close();
		return lista;
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return lista;
	}
	
	public static boolean esHabil(GregorianCalendar fecha)
	{
		if(	fecha.get(Calendar.DAY_OF_WEEK) == 6 || fecha.get(Calendar.DAY_OF_WEEK) == 7)
		{
			return false;
		}
		else 
		{
			for(int i=0; i<lstFeriados.size();i++)
			{
				if(sonFechasIguales(lstFeriados.get(i), fecha))
					return false;
			}
			return true;
		}
	}
	
	public static GregorianCalendar traerPrimerDiaHabil(GregorianCalendar fecha)
	{
		if(esHabil(fecha))
			return fecha;
		else
		{
			while(!esHabil(fecha))
			{
				fecha.add(Calendar.DAY_OF_MONTH, 1);
			}
			return fecha;
		}
	}
	
	public static void imprimirLstFeriados()
	{
		for(GregorianCalendar c: lstFeriados)
		{
			System.out.println(Funciones.traerFechaCorta(c));
		}
	}*/
	
	
	public static int obtenerDia(GregorianCalendar fecha)
	{
		int dia=fecha.get(Calendar.DAY_OF_MONTH);
		return dia;
	}
	
	public static void imprimirLstFeriados(List lstFeriados)
	{
		int i;
		for(i=0;i<lstFeriados.size();i++)
		{
			System.out.println(lstFeriados.get(i));
		}
	}
	
	public static int obtenerMes(GregorianCalendar fecha)
	{
		int mes=fecha.get(Calendar.MONTH);
		return mes;
	}
	
	public static int obtenerAnio(GregorianCalendar fecha)
	{
		int anio=fecha.get(Calendar.YEAR);
		return anio;
	}
	
	public static int obtenerDiaSemana(GregorianCalendar fecha)
	{
		return fecha.get(Calendar.DAY_OF_WEEK);
	}
	public static String obtenerMesNombre(GregorianCalendar fecha)
	{
		int Num=fecha.get(Calendar.MONTH);
		String []mes={"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
		return mes[Num];
	}
	
	public static String obtenerDiaNombre(GregorianCalendar fecha)
	{
		int Num=fecha.get(Calendar.DAY_OF_WEEK)-1;
		String []dia={"Domingo", "Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"};
		return dia[Num];
	}
	
	public static String obtenerFechaLarga(GregorianCalendar fecha)
	{
		String diaNombre=obtenerDiaNombre(fecha);
		String MesNombre=obtenerMesNombre(fecha);
		int dia=obtenerDia(fecha);
		int anio=obtenerAnio(fecha);
		return ""+diaNombre+ " "+dia+ " de "+MesNombre+" de "+anio;
	}
	
	public static String obtenerFechaCorta(GregorianCalendar fecha)//arreglar
	{
		int dia=obtenerDia(fecha);
		int mes=obtenerMes(fecha);
		int anio=obtenerAnio(fecha);
		
		if (mes<10 && dia>10){
		return	""+dia+"/0"+mes+"/"+anio;	
		}
		
		if (dia<10 && mes>10){
		return "0"+dia+"/"+mes+"/"+anio;	
		}
		
		if (dia<10 && mes<10){
		return "0"+dia+"/0"+mes+"/"+anio;
		}
		
		return ""+dia+"/"+mes+"/"+anio;
	}
	

	
	public static boolean esBisiesto (GregorianCalendar fecha)
	{
		int anio=fecha.get(Calendar.YEAR);
		if(anio%100==0 && anio%400!=0)
		{
			return false;
		}
		else
		{
			if (anio%4==0)
			{
				return true;
			}
			else
			{
				return false;
			}
				
		}
	}
	
	public static int traerCantidadDiasdeMes(int anio, int mes)
	{
		GregorianCalendar aux=new GregorianCalendar(anio,mes,1);
		int fechamax=aux.getActualMaximum(Calendar.DAY_OF_MONTH);
		return fechamax;
	}
	
	public static boolean esFechaValida(int anio, int mes, int dia)
	{
		GregorianCalendar aux= new GregorianCalendar(anio,mes,dia);
		
		int diaMax= aux.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		return (dia>0 && mes>=0 && mes<12 && dia<=diaMax && anio>0);
	}
	
	public static boolean sonFechasIguales(GregorianCalendar fecha, GregorianCalendar fecha1 )
	{
		return (fecha.get(Calendar.YEAR)==fecha1.get(Calendar.YEAR) && fecha.get(Calendar.MONTH)==fecha1.get (Calendar.MONTH) && fecha.get(Calendar.DAY_OF_MONTH)==fecha1.get(Calendar.DAY_OF_MONTH));
	}
	
	public static boolean esDiaHabil (GregorianCalendar fecha)
	{
		return (fecha.get(Calendar.DAY_OF_WEEK) >=2 && fecha.get(Calendar.DAY_OF_WEEK)<6);
	} 
	
	public static double aproximar2Decimal(double valor)
	{
		return (double) Math.round(valor*100)/100; //usar (double) para devolver los decimales y los ceros son la cantidad a devolver
	}
	
	public static GregorianCalendar traerFecha(String fecha)
	{
		int anio=Integer.parseInt(fecha.substring (6,10));
		int mes=Integer.parseInt(fecha.substring(3,5)) - 1;
		int dia=Integer.parseInt(fecha.substring(0,2));// 31/08/2015
		GregorianCalendar fechaNueva = new GregorianCalendar(anio,mes,dia);
		return fechaNueva;
	}
	
	public static String traerFechaCorta(GregorianCalendar fecha)
	{
		int anio=fecha.get(Calendar.YEAR);
		int mes=fecha.get(Calendar.MONTH) + 1;
		int dia=fecha.get(Calendar.DAY_OF_MONTH);
		return ""+dia+"/"+mes+"/"+anio; 
	}
	
	public static String calcularEdad(GregorianCalendar fecha,GregorianCalendar Nac){
		int edad= fecha.get(Calendar.YEAR)-Nac.get(Calendar.YEAR);
		if(edad<0)
		{
			return "Esta persona no ha nacido";
		}
		else{
			if (edad==0){
				return "Esta persona nacio este año";
			}
			else{
			return "Edad: "+edad;
			}
		}
	}
	
	public static String obtenerFechaMañana(GregorianCalendar fecha)
	{
		int dia=obtenerDia(fecha) + 1;
		int mes=fecha.get(Calendar.MONTH);
		int anio=obtenerAnio(fecha);
		GregorianCalendar aux=new GregorianCalendar(anio,mes,dia);
		return obtenerFechaLarga(aux);
	}

	public static String obtenerFechaAnterior(GregorianCalendar fecha){
		int dia=obtenerDia(fecha) - 1;
		int mes=fecha.get(Calendar.MONTH);
		int anio=obtenerAnio(fecha);
		GregorianCalendar aux=new GregorianCalendar(anio,mes,dia);
		return obtenerFechaLarga(aux);
	}
	
/* FUNCIONES CON STRING*/
	
	public static boolean esNro(char c)
	{
		String validoNro= "0123456789";
		boolean encontrado=false;
		int i=0;
		while(!encontrado && i<validoNro.length())
		{
			if (validoNro.charAt(i)==c)
				encontrado=true;
			else
				i++;
		}
		return encontrado;
	}
	
	public static boolean sonNros(String cadena)
	{
		boolean valido=true;
		int i=0;
		while(valido && i<cadena.length())
		{
			if(esNro(cadena.charAt(i)))
				i++;
			else
				valido=false;
		}
		return valido;
	}
	
	public static boolean esLetra(char c)
	{
		String validoNro= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		boolean encontrado=false;
		int i=0;
		char comparar= Character.toUpperCase(c);
		while(!encontrado && i<validoNro.length())
		{
			if (validoNro.charAt(i)==c)
				encontrado=true;
			else
				i++;
		}
		return encontrado;
	}
	
	public static boolean sonLetras(String cadena)
	{
		boolean valido=true;
		int i=0;
		while(valido && i<cadena.length())
		{
			if(esNro(cadena.charAt(i)))
				i++;
			else
				valido=false;
		}
		return valido;
	}
	
	
	
	
}