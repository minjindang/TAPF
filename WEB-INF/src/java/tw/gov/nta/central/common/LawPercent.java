/*
 * �b 2006/2/21 �إ�
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ��ɮת��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
package tw.gov.nta.central.common;

import org.hibernate.HibernateException;

import tw.gov.nta.sql.LawPercentRef;
import tw.gov.nta.sql.dao.LawPercentRefDAO;

/**
 * @author WeiMing-Lee
 * ���Ѩt�ξާ@�k�w�������t��Ҹ��(�ק�B�d��)
 */
public class LawPercent {

	/**
	 * �H�D��ȧ�X�������k�w�������t��Ҹ��
	 * @param id:�D���
	 * @return:�^�ǩҹ������k�w�������t��Ҹ��
	 * @throws HibernateException
	 * @throws LawPercentRefDaoException
	 */
	public static LawPercentRef get(int id) throws HibernateException{
	    LawPercentRefDAO tLawPercentRefDAO = new LawPercentRefDAO();
	    return tLawPercentRefDAO.get(new Integer(id));
	}
	
	/**
	 * �H��J��������ȧ�s�k�w�������t��Ҹ��
	 * @param id:�D���
	 * @param dto:�������
	 * @throws HibernateException
	 * @throws LawPercentRefDaoException
	 */
	public static void update(LawPercentRef dto) throws HibernateException{
	    LawPercentRefDAO tLawPercentRefDAO = new LawPercentRefDAO();
	    tLawPercentRefDAO.saveOrUpdate(dto);
	}
}
