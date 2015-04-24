package tw.gov.nta.sql.debt.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import tw.gov.nta.sql.debt.dao.IssueExchangeDetDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseIssueExchangeDetDAO extends tw.gov.nta.sql.debt.dao._RootDAO {

	// query name references


	public static IssueExchangeDetDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static IssueExchangeDetDAO getInstance () {
		if (null == instance) instance = new IssueExchangeDetDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return tw.gov.nta.sql.debt.IssueExchangeDet.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a tw.gov.nta.sql.debt.IssueExchangeDet
	 */
	public tw.gov.nta.sql.debt.IssueExchangeDet cast (Object object) {
		return (tw.gov.nta.sql.debt.IssueExchangeDet) object;
	}

	public tw.gov.nta.sql.debt.IssueExchangeDet get(java.lang.Integer key)
	{
		return (tw.gov.nta.sql.debt.IssueExchangeDet) get(getReferenceClass(), key);
	}

	public tw.gov.nta.sql.debt.IssueExchangeDet get(java.lang.Integer key, Session s)
	{
		return (tw.gov.nta.sql.debt.IssueExchangeDet) get(getReferenceClass(), key, s);
	}

	public tw.gov.nta.sql.debt.IssueExchangeDet load(java.lang.Integer key)
	{
		return (tw.gov.nta.sql.debt.IssueExchangeDet) load(getReferenceClass(), key);
	}

	public tw.gov.nta.sql.debt.IssueExchangeDet load(java.lang.Integer key, Session s)
	{
		return (tw.gov.nta.sql.debt.IssueExchangeDet) load(getReferenceClass(), key, s);
	}

	public tw.gov.nta.sql.debt.IssueExchangeDet loadInitialize(java.lang.Integer key, Session s) 
	{ 
		tw.gov.nta.sql.debt.IssueExchangeDet obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}

/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<tw.gov.nta.sql.debt.IssueExchangeDet> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<tw.gov.nta.sql.debt.IssueExchangeDet> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<tw.gov.nta.sql.debt.IssueExchangeDet> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param issueExchangeDet a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Integer save(tw.gov.nta.sql.debt.IssueExchangeDet issueExchangeDet)
	{
		return (java.lang.Integer) super.save(issueExchangeDet);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param issueExchangeDet a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Integer save(tw.gov.nta.sql.debt.IssueExchangeDet issueExchangeDet, Session s)
	{
		return (java.lang.Integer) save((Object) issueExchangeDet, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param issueExchangeDet a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(tw.gov.nta.sql.debt.IssueExchangeDet issueExchangeDet)
	{
		saveOrUpdate((Object) issueExchangeDet);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param issueExchangeDet a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(tw.gov.nta.sql.debt.IssueExchangeDet issueExchangeDet, Session s)
	{
		saveOrUpdate((Object) issueExchangeDet, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param issueExchangeDet a transient instance containing updated state
	 */
	public void update(tw.gov.nta.sql.debt.IssueExchangeDet issueExchangeDet) 
	{
		update((Object) issueExchangeDet);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param issueExchangeDet a transient instance containing updated state
	 * @param the Session
	 */
	public void update(tw.gov.nta.sql.debt.IssueExchangeDet issueExchangeDet, Session s)
	{
		update((Object) issueExchangeDet, s);
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
	 * @param issueExchangeDet the instance to be removed
	 */
	public void delete(tw.gov.nta.sql.debt.IssueExchangeDet issueExchangeDet)
	{
		delete((Object) issueExchangeDet);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param issueExchangeDet the instance to be removed
	 * @param s the Session
	 */
	public void delete(tw.gov.nta.sql.debt.IssueExchangeDet issueExchangeDet, Session s)
	{
		delete((Object) issueExchangeDet, s);
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
	public void refresh (tw.gov.nta.sql.debt.IssueExchangeDet issueExchangeDet, Session s)
	{
		refresh((Object) issueExchangeDet, s);
	}


}