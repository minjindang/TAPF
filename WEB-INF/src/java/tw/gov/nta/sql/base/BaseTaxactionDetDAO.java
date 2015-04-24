package tw.gov.nta.sql.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import tw.gov.nta.sql.dao.TaxactionDetDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseTaxactionDetDAO extends tw.gov.nta.sql.dao._RootDAO {

	// query name references


	public static TaxactionDetDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static TaxactionDetDAO getInstance () {
		if (null == instance) instance = new TaxactionDetDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return tw.gov.nta.sql.TaxactionDet.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a tw.gov.nta.sql.TaxactionDet
	 */
	public tw.gov.nta.sql.TaxactionDet cast (Object object) {
		return (tw.gov.nta.sql.TaxactionDet) object;
	}

	public tw.gov.nta.sql.TaxactionDet get(java.lang.Integer key)
	{
		return (tw.gov.nta.sql.TaxactionDet) get(getReferenceClass(), key);
	}

	public tw.gov.nta.sql.TaxactionDet get(java.lang.Integer key, Session s)
	{
		return (tw.gov.nta.sql.TaxactionDet) get(getReferenceClass(), key, s);
	}

	public tw.gov.nta.sql.TaxactionDet load(java.lang.Integer key)
	{
		return (tw.gov.nta.sql.TaxactionDet) load(getReferenceClass(), key);
	}

	public tw.gov.nta.sql.TaxactionDet load(java.lang.Integer key, Session s)
	{
		return (tw.gov.nta.sql.TaxactionDet) load(getReferenceClass(), key, s);
	}

	public tw.gov.nta.sql.TaxactionDet loadInitialize(java.lang.Integer key, Session s) 
	{ 
		tw.gov.nta.sql.TaxactionDet obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<tw.gov.nta.sql.TaxactionDet> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<tw.gov.nta.sql.TaxactionDet> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<tw.gov.nta.sql.TaxactionDet> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param taxactionDet a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(tw.gov.nta.sql.TaxactionDet taxactionDet)
	{
		return (java.lang.Integer) super.save(taxactionDet);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param taxactionDet a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(tw.gov.nta.sql.TaxactionDet taxactionDet, Session s)
	{
		return (java.lang.Integer) save((Object) taxactionDet, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param taxactionDet a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(tw.gov.nta.sql.TaxactionDet taxactionDet)
	{
		saveOrUpdate((Object) taxactionDet);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param taxactionDet a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(tw.gov.nta.sql.TaxactionDet taxactionDet, Session s)
	{
		saveOrUpdate((Object) taxactionDet, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param taxactionDet a transient instance containing updated state
	 */
	public void update(tw.gov.nta.sql.TaxactionDet taxactionDet) 
	{
		update((Object) taxactionDet);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param taxactionDet a transient instance containing updated state
	 * @param the Session
	 */
	public void update(tw.gov.nta.sql.TaxactionDet taxactionDet, Session s)
	{
		update((Object) taxactionDet, s);
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
	 * @param taxactionDet the instance to be removed
	 */
	public void delete(tw.gov.nta.sql.TaxactionDet taxactionDet)
	{
		delete((Object) taxactionDet);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param taxactionDet the instance to be removed
	 * @param s the Session
	 */
	public void delete(tw.gov.nta.sql.TaxactionDet taxactionDet, Session s)
	{
		delete((Object) taxactionDet, s);
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
	public void refresh (tw.gov.nta.sql.TaxactionDet taxactionDet, Session s)
	{
		refresh((Object) taxactionDet, s);
	}


}