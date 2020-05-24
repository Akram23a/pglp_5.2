package PGL.pglp_5_2;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
/**
 * 
 * @author Akram
 *
 * @param <T> to choose
 */
public abstract class DAO<T> {
	/**
	 * 
	 * @param obj
	 * @return
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 */
    public abstract T create(T obj) 
    		throws FileNotFoundException, IOException;
    /**
     * 
     * @param obj
     */
    public abstract void delete(T obj);
    /**
     * 
     * @param obj
     * @return
     * @throws IOException 
     */
    public abstract T update(T obj) throws IOException;
    /**
     * 
     * @param id
     * @return
     * @throws IOException 
     * @throws ClassNotFoundException 
     */
    public abstract T find(String nom) 
    		throws IOException, ClassNotFoundException;
    /**
     * 
     * @param bytes
     * @return
     * @throws ClassNotFoundException
     * @throws IOException
     */
    public Object deserialize(final byte[] bytes) throws ClassNotFoundException,
    IOException {
        ByteArrayInputStream b = new ByteArrayInputStream(bytes);
        ObjectInputStream o = new ObjectInputStream(b);
        return o.readObject();
    }
}
