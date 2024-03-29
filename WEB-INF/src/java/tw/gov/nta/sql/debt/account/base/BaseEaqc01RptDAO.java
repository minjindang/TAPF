package tw.gov.nta.sql.debt.account.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import tw.gov.nta.sql.debt.account.dao.Eaqc01RptDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseEaqc01RptDAO extends tw.gov.nta.sql.debt.account.dao._RootDAO {

	// query name references


	public static Eaqc01RptDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static Eaqc01RptDAO getInstance () {
		if (null == instance) instance = new Eaqc01RptDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return tw.gov.nta.sql.debt.account.Eaqc01Rpt.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a tw.gov.nta.sql.debt.account.Eaqc01Rpt
	 */
	public tw.gov.nta.sql.debt.account.Eaqc01Rpt cast (Object object) {
		return (tw.gov.nta.sql.debt.account.Eaqc01Rpt) object;
	}

	public tw.gov.nta.sql.debt.account.Eaqc01Rpt get(java.lang.Integer key)
	{
		return (tw.gov.nta.sql.debt.account.Eaqc01Rpt) get(getReferenceClass(), key);
	}

	public tw.gov.nta.sql.debt.account.Eaqc01Rpt get(java.lang.Integer key, Session s)
	{
		return (tw.gov.nta.sql.debt.account.Eaqc01Rpt) get(getReferenceClass(), key, s);
	}

	public tw.gov.nta.sql.debt.account.Eaqc01Rpt load(java.lang.Integer key)
	{
		return (tw.gov.nta.sql.debt.account.Eaqc01Rpt) load(getReferenceClass(), key);
	}

	public tw.gov.nta.sql.debt.account.Eaqc01Rpt load(java.lang.Integer key, Session s)
	{
		return (tw.gov.nta.sql.debt.account.Eaqc01Rpt) load(getReferenceClass(), key, s);
	}

	public tw.gov.nta.sql.debt.account.Eaqc01Rpt loadInitialize(java.lang.Integer key, Session s) 
	{ 
		tw.gov.nta.sql.debt.account.Eaqc01Rpt obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<tw.gov.nta.sql.debt.account.Eaqc01Rpt> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<tw.gov.nta.sql.debt.account.Eaqc01Rpt> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<tw.gov.nta.sql.debt.account.Eaqc01Rpt> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param eaqc01Rpt a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(tw.gov.nta.sql.debt.account.Eaqc01Rpt eaqc01Rpt)
	{
		return (java.lang.Integer) super.save(eaqc01Rpt);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param eaqc01Rpt a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(tw.gov.nta.sql.debt.account.Eaqc01Rpt eaqc01Rpt, Session s)
	{
		return (java.lang.Integer) save((Object) eaqc01Rpt, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param eaqc01Rpt a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(tw.gov.nta.sql.debt.account.Eaqc01Rpt eaqc01Rpt)
	{
		saveOrUpdate((Object) eaqc01Rpt);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param eaqc01Rpt a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(tw.gov.nta.sql.debt.account.Eaqc01Rpt eaqc01Rpt, Session s)
	{
		saveOrUpdate((Object) eaqc01Rpt, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param eaqc01Rpt a transient instance containing updated state
	 */
	public void update(tw.gov.nta.sql.debt.account.Eaqc01Rpt eaqc01Rpt) 
	{
		update((Object) eaqc01Rpt);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param eaqc01Rpt a transient instance containing updated state
	 * @param the Session
	 */
	public void update(tw.gov.nta.sql.debt.account.Eaqc01Rpt eaqc01Rpt, Session s)
	{
		update((Object) eaqc01Rpt, s);
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
	 * @param eaqc01Rpt the instance to be removed
	 */
	public void delete(tw.gov.nta.sql.debt.account.Eaqc01Rpt eaqc01Rpt)
	{
		delete((Object) eaqc01Rpt);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param eaqc01Rpt the instance to be removed
	 * @param s the Session
	 */
	public void delete(tw.gov.nta.sql.debt.account.Eaqc01Rpt eaqc01Rpt, Session s)
	{
		delete((Object) eaqc01Rpt, s);
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
	public void refresh (tw.gov.nta.sql.debt.account.Eaqc01Rpt eaqc01Rpt, Session s)
	{
		refresh((Object) eaqc01Rpt, s);
	}


}