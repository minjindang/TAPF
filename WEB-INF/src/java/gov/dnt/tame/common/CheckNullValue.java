/**
*
* @author Andrew Sung
* @createDate 2006/5/24
*/
package gov.dnt.tame.common;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

public class CheckNullValue {
	@SuppressWarnings("unchecked")
	public Map checkNullPasueEmpty(Map map){
		for(Iterator it = map.keySet().iterator();it.hasNext();){
			String key = (String)it.next();
			if(map.get(key) == null)
				map.put(key,"");
		}
		return map;
	}
	public Map checkNullPasueZero(Map map){
		for(Iterator it = map.keySet().iterator();it.hasNext();){
			String key = (String)it.next();
			if(map.get(key) == null || map.get(key).equals(""))
				map.put(key,new BigDecimal(0));
		}
		return map;
	}
	public static String checkNullPasueEmpty(String v1){
			if( v1 == null ){
				return "";	
			}else{
				return v1;
			}
	}
	public static String checkNullPasueEmpty(Object v1){
		if( v1 == null ){
			return "";	
		}else{
			return (String) v1;
		}
}
	public static Integer checkNullPasueZero(Integer v1){
		if( v1 == null ){
			return new Integer(0);	
		}else{
			return v1;
		}
	}
	public static BigDecimal checkNullPasueZero(Object v1){
		if( v1 == null ){
			return new BigDecimal(0);	
		}else{
			return (BigDecimal)v1;
		}
	}
}
