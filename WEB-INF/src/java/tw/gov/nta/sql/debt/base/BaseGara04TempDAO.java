package tw.gov.nta.sql.debt.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import tw.gov.nta.sql.debt.dao.Gara04TempDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseGara04TempDAO extends tw.gov.nta.sql.debt.dao._RootDAO {

	// query name references


	public static Gara04TempDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static Gara04TempDAO getInstance () {
		if (null == instance) instance = new Gara04TempDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return tw.gov.nta.sql.debt.Gara04Temp.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a tw.gov.nta.sql.debt.Gara04Temp
	 */
	public tw.gov.nta.sql.debt.Gara04Temp cast (Object object) {
		return (tw.gov.nta.sql.debt.Gara04Temp) object;
	}

	public tw.gov.nta.sql.debt.Gara04Temp get(java.lang.Integer key)
	{
		return (tw.gov.nta.sql.debt.Gara04Temp) get(getReferenceClass(), key);
	}

	public tw.gov.nta.sql.debt.Gara04Temp get(java.lang.Integer key, Session s)
	{
		return (tw.gov.nta.sql.debt.Gara04Temp) get(getReferenceClass(), key, s);
	}

	public tw.gov.nta.sql.debt.Gara04Temp load(java.lang.Integer key)
	{
		return (tw.gov.nta.sql.debt.Gara04Temp) load(getReferenceClass(), key);
	}

	public tw.gov.nta.sql.debt.Gara04Temp load(java.lang.Integer key, Session s)
	{
		return (tw.gov.nta.sql.debt.Gara04Temp) load(getReferenceClass(), key, s);
	}

	public tw.gov.nta.sql.debt.Gara04Temp loadInitialize(java.lang.Integer key, Session s) 
	{ 
		tw.gov.nta.sql.debt.Gara04Temp obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<tw.gov.nta.sql.debt.Gara04Temp> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<tw.gov.nta.sql.debt.Gara04Temp> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<tw.gov.nta.sql.debt.Gara04Temp> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param gara04Temp a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(tw.gov.nta.sql.debt.Gara04Temp gara04Temp)
	{
		return (java.lang.Integer) super.save(gara04Temp);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param gara04Temp a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(tw.gov.nta.sql.debt.Gara04Temp gara04Temp, Session s)
	{
		return (java.lang.Integer) save((Object) gara04Temp, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param gara04Temp a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(tw.gov.nta.sql.debt.Gara04Temp gara04Temp)
	{
		saveOrUpdate((Object) gara04Temp);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param gara04Temp a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(tw.gov.nta.sql.debt.Gara04Temp gara04Temp, Session s)
	{
		saveOrUpdate((Object) gara04Temp, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param gara04Temp a transient instance containing updated state
	 */
	public void update(tw.gov.nta.sql.debt.Gara04Temp gara04Temp) 
	{
		update((Object) gara04Temp);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param gara04Temp a transient instance containing updated state
	 * @param the Session
	 */
	public void update(tw.gov.nta.sql.debt.Gara04Temp gara04Temp, Session s)
	{
		update((Object) gara04Temp, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(java.lang.Integer id)
	{
		delete((Object) load(id));
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param id the instance ID to be removed
	 * @param s the Session
	 */
	public void delete(java.lang.Integer id, Session s)
	{
		delete((Object) load(id, s), s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param gara04Temp the instance to be removed
	 */
	public void delete(tw.gov.nta.sql.debt.Gara04Temp gara04Temp)
	{
		delete((Object) gara04Temp);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param gara04Temp the instance to be removed
	 * @param s the Session
	 */
	public void delete(tw.gov.nta.sql.debt.Gara04Temp gara04Temp, Session s)
	{
		delete((Object) gara04Temp, s);
	}
	
	/**
	 * Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement
	 * long-running sessions that span many business tasks. This method is, however, useful in certain special circumstances.
	 * For example 
	 * <ul> 
	 * <li>where a database trigger alters the object state upon insert or update</li>
	 * <li>after executing direct SQL (eg. a mass update) in the same session</li>
	 * <li>after inserting a Blob or Clob</li>
	 * </ul>
	 */
	public void refresh (tw.gov.nta.sql.debt.Gara04Temp gara04Temp, Session s)
	{
		refresh((Object) gara04Temp, s);
	}


}