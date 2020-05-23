package PGL.pglp_5_2;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
/**
 * 
 * @author Akram
 *
 */
public class Personnel implements Component, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private final int id;
	/**
	 * Name
	 */
	private final String nom;
	/**
	 * first name
	 */
	private final String prenom;
	/**
	 * function
	 */
	private final String fonction;
	/**
	 * date of birth
	 */
	private final LocalDate dateNaissance;
	/**
	 * phone number
	 */
	private ArrayList<NumTel> numsTel;
	/**
	 * 
	 * @author Akram
	 *
	 */
	public static class PBuilder {
		
		public final String nom;
		public final String prenom;
		public final String fonction;
		public LocalDate dateNaissance;
		public final ArrayList<NumTel> numsTelephone;
        private final int id;
		/**
		 * 
		 * @param nom name
		 * @param prenom first name
		 * @param fonction function
		 * @param dateNaissance date of birth
		 */
		public PBuilder(final String nom, final String prenom, final String fonction, final LocalDate dateNaissance, final int newId) {
			this.nom = nom;
			this.prenom = prenom;
			this.fonction = fonction;
			this.dateNaissance = dateNaissance;
            this.numsTelephone = new ArrayList<NumTel>();
            this.id = newId;
		}
		/**
		 * 
		 * @param dN
		 * @return this
		 */
		public PBuilder Naissance(final LocalDate dN) {
			
			this.dateNaissance = dN;
			return this;
			
		}
		/**
		 * 
		 * @param num
		 * @return Builder
		 */
		public PBuilder numsTelephone(NumTel num) {
			this.numsTelephone.add(num);
			return this;
		}
		/**
		 * 
		 * @return built personnel
		 */
		public Personnel build() {
			return new Personnel(this);
		}
		public int getId() {
			return id;
		}
	}
	/**
	 * 
	 * @param builder
	 */
	private Personnel(PBuilder builder) {
		nom = builder.nom;
		prenom = builder.prenom;
		fonction = builder.fonction;
		dateNaissance = builder.dateNaissance;
		setNumsTel(builder.numsTelephone);
		this.id = builder.id;
	}
	/**
	 * 
	 * @return numeros
	 */
	public ArrayList<NumTel> getNumsTel() {
		return numsTel;
	}
	/**
	 *  
	 * @param numsTel numeros
	 */
	public void setNumsTel(ArrayList<NumTel> numsTel) {
		this.numsTel = numsTel;
	}
	public int getId() {
		return this.id;
	}
	public void update() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * 
	 * @return nom
	 */
    public String getNom() {
        return nom;
    }
    /**
     * 
     * @return pnom
     */
    public String getPrenom() {
        return prenom;
    }
    /**
     * 
     * @return fct
     */
    public String getFonction() {
        return fonction;
    }
    /**
     * 
     * @return date naissance
     */
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }
    /**
     * 
     * @return nums de telephone
     */
    public ArrayList<NumTel> getNumTelephones() {
        return numsTel;
    }
    /**
     * print func
     */
    public void print() {
        System.out.println(this.nom + " " + this.prenom + ": \nfonction: "
                + this.fonction + "\ndate de naissance: "
                + this.dateNaissance + "\n");
    }
}

