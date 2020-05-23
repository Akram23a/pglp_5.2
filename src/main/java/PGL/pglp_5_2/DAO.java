package PGL.pglp_5_2;
/**
 * 
 * @author Akram
 *
 * @param <T>
 */
public interface DAO<T> {
	/**
	 * Create
	 * @param obj
	 * @return
	 */
  public T create(T obj);
  /**
   * 
   * @param id
   * @return
   */
  public T find(String id);
  /**
   * 
   * @param obj
   * @return
   */
  public T update(T obj);
  /**
   * 
   * @param obj
   */
  public void delete(T obj);
}
