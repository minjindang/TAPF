/*
 * �b 2006/2/20 �إ�
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ��ɮת��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
package tw.gov.nta.central.common;

import gov.dnt.tame.util.MailUtil;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.mail.Address;
import javax.mail.FetchProfile;
import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

import tw.gov.nta.sql.MailContentRef;
import tw.gov.nta.sql.UnitAllocateMain;
import tw.gov.nta.sql.UnitInfoMain;
import tw.gov.nta.sql.dao.MailContentRefDAO;
import tw.gov.nta.sql.dao.UnitAllocateMainDAO;

/**
 * @author Jack Du
 *
 * TODO �p�G�n�ܧ�o�Ӳ��ͪ����O���Ѫ��d���A�в���
 * ���� - �ߦn�]�w - Java - �{���X�˦� - �{���X�d��
 */
public class MailContent {

	public static MailContentRef get(int id) throws HibernateException
	{
		MailContentRefDAO dao = new MailContentRefDAO();
        return dao.get(new Integer(id));
	}

	public static void update(MailContentRef mailContentRef) throws HibernateException
	{
		MailContentRefDAO dao = new MailContentRefDAO();
		mailContentRef.setContentb("");
		mailContentRef.setTitleb("");
		dao.saveOrUpdate(mailContentRef);
	}

	public static void sendMail(String year,String month,String kind, String pDate, String pCount) throws Exception
	{
		String	TO_add	=	"";		//����
		String	CC_add	=	"";		//�ƥ�
		String	BCC_add	=	"";		//�K��ƥ�
		String	Subject	=	"";		//�D��
		String	Context	=	"";		//���e
		MailContentRefDAO tMailContentDao = new MailContentRefDAO();
		MailContentRef mailContentRefDto = getByKind(kind);
		
		MailUtil mailUtil = new MailUtil();
		UnitAllocateMainDAO unitAllocateMainDao = new UnitAllocateMainDAO(); 
		List<UnitAllocateMain> unitAllocateMainList = UnitAllocate.getByYear(year,month,kind);
		int tmp = 0;
		for(Iterator it=unitAllocateMainList.iterator();it.hasNext();)
		{
			UnitAllocateMain unitAllocateMain = (UnitAllocateMain) it.next();
			UnitInfoMain unitInfo = unitAllocateMain.getUnitInfo();
//			if("F".equalsIgnoreCase(unitInfo.getMail()))
//				continue;
			if(!"T".equalsIgnoreCase(unitInfo.getMail()))
				continue;
			TO_add = unitInfo.getTemail();
			CC_add = "cart@mail.nta.gov.tw";
//			System.out.println(TO_add);
//			TO_add = "251856@gmail.com";
//			TO_add = "lijane@mail.nta.gov.tw";
			Subject = buildSubject(unitAllocateMain, mailContentRefDto);
			Context = buildContent(unitAllocateMain, mailContentRefDto, pDate ,pCount,kind);
			
//			if("�Ὤ��".equals(unitInfo.getUnitName()) || "�y����".equals(unitInfo.getUnitName()) || "�s�˥�".equals(unitInfo.getUnitName()))
//				continue;
			
			if(TO_add == null || TO_add.trim().length() <= 0)
				continue;
			try{
//				System.out.println(unitInfo.getUnitName());
				mailUtil.SendMail( TO_add, CC_add, BCC_add, Subject, Context );
				unitAllocateMain.setSendDate(new Date());
				unitAllocateMainDao.update(unitAllocateMain);
			}catch(Exception e){
				System.out.println(unitAllocateMain.getUnitInfo().getUnitName()+"�o�e����");
				e.printStackTrace();
			}
//			Thread.sleep(30000);
//			System.out.println("-----"+tmp);
//			tmp++;
//			if(tmp >5)
//				break;
		}
	}

	private static String buildSubject(UnitAllocateMain unitAllocateMain, MailContentRef mailContentRefDto){
		String tSubject = null;
//		if(unitAllocateMain.getFounda() == null || unitAllocateMain.getFounda().doubleValue() == 0){
//			//�S���k���ԭɴ�
//			tSubject = mailContentRefDto.getTitlea();
//		}
//		else{
//			//���k���ԭɴ�
//			tSubject = mailContentRefDto.getTitleb();
//		}
		tSubject = mailContentRefDto.getTitlea();
		return tSubject;		
	}
	
	private static String buildContent(UnitAllocateMain unitAllocateMain, MailContentRef mailContentRefDto, String pDate, String pCount,String kind){
		String tContent = null;
		UnitInfoMain unitInfoMain = unitAllocateMain.getUnitInfo();
		tContent = mailContentRefDto.getContenta();
		tContent = tContent.replaceFirst("\\$0", unitInfoMain.getUnitName());
		tContent = tContent.replaceFirst("\\$1", unitAllocateMain.getAllYear());
		//tContent = tContent.replaceFirst("\\$2", unitAllocateMain.getAllMonth());
		tContent = tContent.replaceFirst("\\$2", pCount);
		if(kind.equals("1"))
			tContent = tContent.replaceFirst("\\$3", new DecimalFormat("#,##0").format(unitAllocateMain.getNowFound().setScale(0,4)));
		else if(kind.equals("2")){
			if(tContent.indexOf("$3") > 0)
				tContent = tContent.replaceFirst("\\$3", new DecimalFormat("#,##0").format(unitAllocateMain.getAllMoney().setScale(0,4)));
			else
				tContent = tContent.replaceFirst("\\$9", new DecimalFormat("#,##0").format(unitAllocateMain.getLastFound().setScale(0,4)));
		}
		tContent = tContent.replaceFirst("\\$4", pDate.substring(3,5));
		tContent = tContent.replaceFirst("\\$5", pDate.substring(5,7));
		if(kind.equals("1")){
			tContent = tContent.replaceFirst("\\$6", unitInfoMain.getSbank1());
			tContent = tContent.replaceFirst("\\$7", unitInfoMain.getTbank1());
			tContent = tContent.replaceFirst("\\$8", unitInfoMain.getTacct1());
		}else if(kind.equals("2")){
			tContent = tContent.replaceFirst("\\$6", unitInfoMain.getSbank2());
			tContent = tContent.replaceFirst("\\$7", unitInfoMain.getTbank2());
			tContent = tContent.replaceFirst("\\$8", unitInfoMain.getTacct2());
		}
//		if(unitAllocateMain.getFounda() == null || unitAllocateMain.getFounda().doubleValue() == 0){
//			//�S���k���ԭɴ�
//			tContent = mailContentRefDto.getContenta();
//			tContent = tContent.replaceFirst("\\$0", unitInfoMain.getUnitName());
//			tContent = tContent.replaceFirst("\\$1", unitAllocateMain.getAllYear());
//			//tContent = tContent.replaceFirst("\\$2", unitAllocateMain.getAllMonth());
//			tContent = tContent.replaceFirst("\\$2", pCount);
//			tContent = tContent.replaceFirst("\\$3", new DecimalFormat("#,##0").format(unitAllocateMain.getSrcMoney().setScale(0,4)));
//			tContent = tContent.replaceFirst("\\$4", pDate.substring(3,5));
//			tContent = tContent.replaceFirst("\\$5", pDate.substring(5,7));
//			tContent = tContent.replaceFirst("\\$6", unitInfoMain.getSbank1());
//			tContent = tContent.replaceFirst("\\$7", unitInfoMain.getTbank1());
//			tContent = tContent.replaceFirst("\\$8", unitInfoMain.getTacct1());			
//		}
//		else{
//			//���k���ԭɴ�			
//			tContent = mailContentRefDto.getContentb();
//			tContent = tContent.replaceFirst("\\$0", unitInfoMain.getUnitName());
//			tContent = tContent.replaceFirst("\\$1", unitAllocateMain.getAllYear());
//			//tContent = tContent.replaceFirst("\\$2", unitAllocateMain.getAllMonth());
//			tContent = tContent.replaceFirst("\\$2", pCount);
//			tContent = tContent.replaceFirst("\\$3", new DecimalFormat("#,##0").format(unitAllocateMain.getSrcMoney()));
//			tContent = tContent.replaceFirst("\\$4", new DecimalFormat("#,##0").format(unitAllocateMain.getFounda()));
//			tContent = tContent.replaceFirst("\\$5", new DecimalFormat("#,##0").format(unitAllocateMain.getFoundb()));
//			tContent = tContent.replaceFirst("\\$6", new DecimalFormat("#,##0").format(unitAllocateMain.getAllMoney()));
//			tContent = tContent.replaceFirst("\\$7", pDate.substring(3,5));
//			tContent = tContent.replaceFirst("\\$8", pDate.substring(5,7));
//			tContent = tContent.replaceFirst("\\$9", unitInfoMain.getSbank1());
//			tContent = tContent.replaceFirst("\\$10", unitInfoMain.getTbank1());
//			tContent = tContent.replaceFirst("\\$11", unitInfoMain.getTacct1());
//		}
		return tContent;
	}
	public void receiveMail() throws MessagingException{
		UnitAllocateMainDAO unitAllocateMainDao = new UnitAllocateMainDAO();
		UnitAllocateMain unitAllocateMain = new UnitAllocateMain();
		Folder folder = new MailUtil().getMail();
		Message message[]=folder.getMessages();
		FetchProfile fp=new FetchProfile();
		fp.add(FetchProfile.Item.ENVELOPE);
		fp.add(FetchProfile.Item.FLAGS);
		fp.add("X-Mailer");
		folder.fetch(message,fp);
		System.out.println("�@"+folder.getMessageCount()+"��");
		for(int i=0;i<folder.getMessageCount();i++){
			message[i].setFlag(Flags.Flag.SEEN,true);
			System.out.println("���D:"+message[i].getSubject());
			System.out.println("�H�H�ɶ�:"+message[i].getSentDate());
			Address[] to  = message[i].getAllRecipients();
			String deposit = new String();
			int id = 0;
			if(to!=null){ 
				for(int j=0;j<to.length;j++){
					deposit += getDisplayAddress(to[j]);
				}
			}
			if(deposit.indexOf("{$")> 0 && deposit.indexOf("}")>0 ){
				id = new Integer(Integer.parseInt(deposit.substring(deposit.indexOf("{$")+2,deposit.indexOf("}"))));
			}
			if(id != 0){
				unitAllocateMain = new UnitAllocate().getBean(id);
				if(message[i].getSentDate() != null && unitAllocateMain!=null){
					unitAllocateMain.setRecvDate(message[i].getSentDate());
					unitAllocateMainDao.update(unitAllocateMain);
				}
			}
		}
	}
	private String getDisplayAddress(Address a){ //�ഫRFC822��Unicode
		String pers = null;
		String addr = null;
		if(a instanceof InternetAddress &&((pers=((InternetAddress)a).getPersonal())!=null))
			addr=pers+" "+"<"+((InternetAddress)a).getAddress()+">";
		else
			addr = a.toString();
		return pers;
//		return addr; ���B�Ȼݦ^��pers�Y�i
	}

	public static MailContentRef getByKind(String monKind) {
		MailContentRefDAO dao = new MailContentRefDAO();
		Session session = dao.getSession();
		Criteria criteria = session.createCriteria(MailContentRef.class);
		criteria.add(Expression.eq("monKind", monKind));
		List list = criteria.list();
		session.close();
		if(list.size()>0)
			return (MailContentRef) list.get(0);
		else
			return null;
	}
}
