package gov.dnt.tame.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.type.Type;
import org.hibernate.usertype.UserType;
import org.hibernate.util.StringHelper;

public class FormatedBigDecimalType extends BigDecimal implements UserType {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5734065264287569630L;

	/**
	 * 
	 */

	public FormatedBigDecimalType(double arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public boolean isSame(Object x, Object y) throws HibernateException {
		return equals(x, y);
	}

	public int[] sqlTypes() {
		// TODO Auto-generated method stub
		int[] types = {Types.NUMERIC};
		return types;
	}

	public Class returnedClass() {
		// TODO Auto-generated method stub
		return BigDecimal.class;
	}

	public boolean equals(Object arg0, Object arg1) throws HibernateException {
		// TODO Auto-generated method stub
		return arg0==arg1 || ( arg0!=null && arg1!=null && ( (BigDecimal) arg0 ).compareTo( (BigDecimal) arg1 )==0 );
	}

	public int hashCode(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return ( (BigDecimal) arg0 ).intValue();
	}

	public Object deepCopy(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return arg0;
	}

	public Serializable disassemble(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		if (arg0==null) {
			return null;
		}
		else {
			return (Serializable) deepCopy( arg0 );
		}
	}

	public Object assemble(Serializable arg0, Object arg1) throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	public Object replace(Object arg0, Object arg1, Object arg2) throws HibernateException {
		// TODO Auto-generated method stub
		return arg0;
	}
	
	public String toString() {return "";};

	public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
		// TODO Auto-generated method stub
		
		final boolean IS_TRACE_ENABLED = LogFactory.getLog( StringHelper.qualifier( Type.class.getName() ) ).isTraceEnabled();
		
		if (value==null) {
			if (IS_TRACE_ENABLED) {
				LogFactory.getLog( getClass() ).trace("binding null to parameter: " + index);
			}

			st.setNull( index, sqlType() );
		}
		else {
			if (IS_TRACE_ENABLED) {
				LogFactory.getLog( getClass() ).trace("binding '" + value.toString() + "' to parameter: " + index);
			}
			set(st, value, index);
		}		
	}

	private int sqlType() {
		// TODO Auto-generated method stub
		return Types.NUMERIC;
	}

	public void set(PreparedStatement st, Object value, int index)
	throws HibernateException, SQLException {
		st.setBigDecimal(index, (BigDecimal) value);
	}
	
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}



	public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
		// TODO Auto-generated method stub

		Object value = get(rs, names[1]);
		final boolean IS_TRACE_ENABLED = LogFactory.getLog( StringHelper.qualifier( Type.class.getName())).isTraceEnabled();;
		
		if ( value==null || rs.wasNull() ) {
			if (IS_TRACE_ENABLED) {
				LogFactory.getLog( getClass() ).trace("returning null as column: " + names[1]);
			}
			return null;
		}
		else {
			if (IS_TRACE_ENABLED) {
				LogFactory.getLog( getClass() ).trace( "returning '" + value.toString() + "' as column: " + names[1]);
			}
			return value;
		}
	
	}
	
	public Object get(ResultSet rs, String name)
	throws HibernateException, SQLException {
		return rs.getBigDecimal(name);
	}
	
}
