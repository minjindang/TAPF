package tw.gov.nta.sql.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import tw.gov.nta.sql.dao.LawPercentRefDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseLawPercentRefDAO extends tw.gov.nta.sql.dao._RootDAO {

	// query name references


	public static LawPercentRefDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static LawPercentRefDAO getInstance () {
		if (null == instance) instance = new LawPercentRefDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return tw.gov.nta.sql.LawPercentRef.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a tw.gov.nta.sql.LawPercentRef
	 */
	public tw.gov.nta.sql.LawPercentRef cast (Object object) {
		return (tw.gov.nta.sql.LawPercentRef) object;
	}

	public tw.gov.nta.sql.LawPercentRef get(java.lang.Integer key)
	{
		return (tw.gov.nta.sql.LawPercentRef) get(getReferenceClass(), key);
	}

	public tw.gov.nta.sql.LawPercentRef get(java.lang.Integer key, Session s)
	{
		return (tw.gov.nta.sql.LawPercentRef) get(getReferenceClass(), key, s);
	}

	public tw.gov.nta.sql.LawPercentRef load(java.lang.Integer key)
	{
		return (tw.gov.nta.sql.LawPercentRef) load(getReferenceClass(), key);
	}

	public tw.gov.nta.sql.LawPercentRef load(java.lang.Integer key, Session s)
	{
		return (tw.gov.nta.sql.LawPercentRef) load(getReferenceClass(), key, s);
	}

	public tw.gov.nta.sql.LawPercentRef loadInitialize(java.lang.Integer key, Session s) 
	{ 
		tw.gov.nta.sql.LawPercentRef obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<tw.gov.nta.sql.LawPercentRef> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<tw.gov.nta.sql.LawPercentRef> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<tw.gov.nta.sql.LawPercentRef> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param lawPercentRef a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(tw.gov.nta.sql.LawPercentRef lawPercentRef)
	{
		return (java.lang.Integer) super.save(lawPercentRef);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param lawPercentRef a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(tw.gov.nta.sql.LawPercentRef lawPercentRef, Session s)
	{
		return (java.lang.Integer) save((Object) lawPercentRef, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param lawPercentRef a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(tw.gov.nta.sql.LawPercentRef lawPercentRef)
	{
		saveOrUpdate((Object) lawPercentRef);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param lawPercentRef a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(tw.gov.nta.sql.LawPercentRef lawPercentRef, Session s)
	{
		saveOrUpdate((Object) lawPercentRef, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param lawPercentRef a transient instance containing updated state
	 */
	public void update(tw.gov.nta.sql.LawPercentRef lawPercentRef) 
	{
		update((Object) lawPercentRef);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param lawPercentRef a transient instance containing updated state
	 * @param the Session
	 */
	public void update(tw.gov.nta.sql.LawPercentRef lawPercentRef, Session s)
	{
		update((Object) lawPercentRef, s);
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
	 * @param lawPercentRef the instance to be removed
	 */
	public void delete(tw.gov.nta.sql.LawPercentRef lawPercentRef)
	{
		delete((Object) lawPercentRef);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param lawPercentRef the instance to be removed
	 * @param s the Session
	 */
	public void delete(tw.gov.nta.sql.LawPercentRef lawPercentRef, Session s)
	{
		delete((Object) lawPercentRef, s);
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
	public void refresh (tw.gov.nta.sql.LawPercentRef lawPercentRef, Session s)
	{
		refresh((Object) lawPercentRef, s);
	}


}