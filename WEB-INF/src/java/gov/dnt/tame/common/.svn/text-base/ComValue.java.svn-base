/**
*
* @author Andrew Sung
* @createDate 2006/5/24
*/
package gov.dnt.tame.common;

import java.math.BigDecimal;

public class ComValue {
	@SuppressWarnings("unchecked")
	public BigDecimal sub(Object v1,Object v2){
		BigDecimal b1 = new BigDecimal(0);
		BigDecimal b2 = new BigDecimal(0);
		BigDecimal b3 = new BigDecimal(0);
		if (!v1.equals(null)){
			b1 = (BigDecimal) v1;
		}
		if (!v1.equals(null)){
			b2 = (BigDecimal) v2;
		}
		b3 = b1.subtract(b2);
		return b3;
	}
	public BigDecimal add(Object v1,Object v2){
		BigDecimal b1 = new BigDecimal(0);
		BigDecimal b2 = new BigDecimal(0);
		BigDecimal b3 = new BigDecimal(0);
		if (!v1.equals(null)){
			b1 = (BigDecimal) v1;
		}
		if (!v1.equals(null)){
			b2 = (BigDecimal) v2;
		}
		b3 = b1.add(b2);
		return b3;
	}
	public BigDecimal multi(Object v1,Object v2,Integer v3,Integer v4){
		BigDecimal b1 = new BigDecimal(0);
		BigDecimal b2 = new BigDecimal(0);
		BigDecimal b3 = new BigDecimal(0);
		Integer s1 = new Integer(0);
		Integer s2 = new Integer(4);
		if (!v1.equals(null)){
			b1 = (BigDecimal) v1;
		}
		if (!v2.equals(null)){
			b2 = (BigDecimal) v2;
		}
		if (!v3.equals(null) && !v3.equals(0) ){
			s1 =  v3;
		}
		if (!v4.equals(null) && !v4.equals(0) ){
			s2 = v4;
		}		
		b3 = (b1.multiply(b2)).setScale(s1,s2);
		return b3;
	}
	public BigDecimal div(Object v1,Object v2,Integer v3,Integer v4){
		BigDecimal b1 = new BigDecimal(0);
		BigDecimal b2 = new BigDecimal(0);
		BigDecimal b3 = new BigDecimal(0);
		Integer s1 = new Integer(0);
		Integer s2 = new Integer(4);
		if (!v1.equals(null)){
			b1 = (BigDecimal) v1;
		}
		if (!v2.equals(null) && !v2.equals(0) ){
			b2 = (BigDecimal) v2;
		}else{
			return new BigDecimal(0);
		}
		if (!v3.equals(null) && !v3.equals(0) ){
			s1 =  v3;
		}
		if (!v4.equals(null) && !v4.equals(0) ){
			s2 = v4;
		}		
		b3 = (b1.divide(b2,BigDecimal.ROUND_HALF_UP)).setScale(s1,s2);
		return b3;
	}
}
