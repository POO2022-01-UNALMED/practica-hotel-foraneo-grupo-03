package gestorAplicacion.segundo;
import gestorAplicacion.primero.*;
public class Restaurante {
	 
    //private Huesped huesped;
    Administrador administrador = new Administrador();
    Cuenta cuenta = new Cuenta();
    enum Menu
    {
    	TRUCHA_AL_AJILLO(1, 20000), POLLO_BBQ(2,18000),
    	MOJARRA_FRITA(3, 25000), SANCOCHO(4, 15000),
    	CHULETA_DE_CERDO(5, 15000), BANDEJA_PAISA(6, 20000)
    	; 
    	private int numPlato;
    	private int precio;
    	private Menu (int numPlato, int precio){
    		this.numPlato = numPlato;
    		this.precio = precio;
    	}
    	public int getNumPlato() {
    		return numPlato;
    	}
    	public int getPrecio() {
    		return precio;
    	}	
    }
    enum Bebida
    {
    	LIMONADA(1, 2000), TE_HELADO(2,2000),
    	GRANIZADO_DE_FRUTAS(3, 3500),JUGO_EN_AGUA(5, 2000),
    	JUGO_EN_LECHE(6, 3000)
    	; 
    	private int numBebida;
    	private int precio;
    	private Bebida (int numBebida, int precio){
    		this.numBebida = numBebida;
    		this.precio = precio;
    	}
    	public int getNumBebida() {
    		return numBebida;
    	}
    	public int getPrecio() {
    		return precio;
    	}	
    }
    public Restaurante() { }
    
    public String imprimirMenu() {
        String menu = "";
        for(Menu platos : Menu.values()) {
        	menu+= platos.getNumPlato()+". "+platos+": $"+platos.getPrecio()+"\n";
        }
        return menu;
    }
    public String imprimirBebidas() {
        String menu = "";
        for(Bebida bebidas : Bebida.values()) {
        	menu+= bebidas.getNumBebida()+". "+bebidas+": $"+bebidas.getPrecio()+"\n";
        }
        return menu;
    }
   // public void hacerPedido(Huesped huesped, int numPlato,int cantidadPlatos, int numBebida,  int cantidadBebidas) {
    public void hacerPedido(int numPlato,int cantidadPlatos, int numBebida,  int cantidadBebidas) {
    	float auxPrecio = 0;
		for(Menu platos : Menu.values()) {
        	if(platos.getNumPlato()==numPlato) {
        		auxPrecio = (float)platos.getPrecio()*cantidadPlatos;
        		break;
        	}
        }
		for(Bebida bebida : Bebida.values()) {
        	if(bebida.getNumBebida()==numBebida) {
        		auxPrecio = (float)bebida.getPrecio()*cantidadBebidas;
        		break;
        	}
        }
		float aux = cuenta.getTotal();
		auxPrecio = auxPrecio+aux;
		cuenta.setTotal(auxPrecio);
    }
}







