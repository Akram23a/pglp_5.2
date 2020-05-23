package PGL.pglp_5_2;
import java.io.Serializable;
/**
 * 
 * @author Akram
 *
 */
public class NumTel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String numero;
	private int id;
	
	/**
	 * 
	 * @param num numero
	 */
	NumTel(String num, int newId){
		setNumero(num);
        this.setId(newId);
	}
	/**
	 * 
	 * @return numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * 
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param id identifier
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * update func
	 */
    public void update(final String nm) {
		// TODO Auto-generated method stub
    }
}
