package tw.gov.nta.sql.debt.base;

import org.hibernate.Session;
import tw.gov.nta.sql.debt.dao.CentralBondSepDayDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseCentralBondSepDayDAO extends tw.gov.nta.sql.debt.dao._RootDAO {

	// query name references


	public static CentralBondSepDayDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static CentralBondSepDayDAO getInstance () {
		if (null == instance) instance = new CentralBondSepDayDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return tw.gov.nta.sql.debt.CentralBondSepDay.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a tw.gov.nta.sql.debt.CentralBondSepDay
	 */
	public tw.gov.nta.sql.debt.CentralBondSepDay cast (Object object) {
		return (tw.gov.nta.sql.debt.CentralBondSepDay) object;
	}


/* Generic methods */

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<tw.gov.nta.sql.debt.CentralBondSepDay> findAll () {
		return super.findAll();
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 */
	public java.util.List<tw.gov.nta.sql.debt.CentralBondSepDay> findAll (Order defaultOrder) {
		return super.findAll(defaultOrder);
	}

	/**
	 * Return all objects related to the implementation of this DAO with no filter.
	 * Use the session given.
	 * @param s the Session
	 */
	public java.util.List<tw.gov.nta.sql.debt.CentralBondSepDay> findAll (Session s, Order defaultOrder) {
		return super.findAll(s, defaultOrder);
	}


	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param centralBondSepDay a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(tw.gov.nta.sql.debt.CentralBondSepDay centralBondSepDay)
	{
		saveOrUpdate((Object) centralBondSepDay);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param centralBondSepDay a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(tw.gov.nta.sql.debt.CentralBondSepDay centralBondSepDay, Session s)
	{
		saveOrUpdate((Object) centralBondSepDay, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param centralBondSepDay a transient instance containing updated state
	 */
	public void update(tw.gov.nta.sql.debt.CentralBondSepDay centralBondSepDay) 
	{
		update((Object) centralBondSepDay);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param centralBondSepDay a transient instance containing updated state
	 * @param the Session
	 */
	public void update(tw.gov.nta.sql.debt.CentralBondSepDay centralBondSepDay, Session s)
	{
		update((Object) centralBondSepDay, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param centralBondSepDay the instance to be removed
	 */
	public void delete(tw.gov.nta.sql.debt.CentralBondSepDay centralBondSepDay)
	{
		delete((Object) centralBondSepDay);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param centralBondSepDay the instance to be removed
	 * @param s the Session
	 */
	public void delete(tw.gov.nta.sql.debt.CentralBondSepDay centralBondSepDay, Session s)
	{
		delete((Object) centralBondSepDay, s);
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
	public void refresh (tw.gov.nta.sql.debt.CentralBondSepDay centralBondSepDay, Session s)
	{
		refresh((Object) centralBondSepDay, s);
	}


}