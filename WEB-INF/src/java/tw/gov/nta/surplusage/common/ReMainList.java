package tw.gov.nta.surplusage.common;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ReMainList{
	/**GARA33,34�ϥ�
	 * �w��ƪ����~�ץ��v�l�B=�W�@�~�ת����v�l�B(�M���)+���~�ת��|�ɼ�(�w���)-���~�ת��٥���(�w���)
	 * �p��ֿn���v�l�BcountNOPayList
	 * �ǤJ��:List tList = SQL�d�� �o���B�P�٥��B ���~���Ӫ�
	 * �ǤJ��:String [] otherField = ���C���p�⪺���
	 * �ǤJ��:String [] issueField = �U�źصo���B���
	 * �ǤJ��:String [] PayField = �U�ź��٥����
	 * �ǤJ��:String AccountKind = account_kind�����W��(�YAccountKind = "noKind" �������O�p��)
	 * �Ǧ^ List = �p��᪺ �o���B�P���v�l�B ���~���Ӫ�
	 */
	@SuppressWarnings("unchecked")
	public List countNOPayList(List tList,String [] otherField,String [] issueField,String [] PayField,String AccountKind){
		List dList = new ArrayList();
		Map tMap = new HashMap();
		Map dMap = new HashMap();
		
		//payAmount���v�l�B�}�C [account_kind][���v�l�B���]
		BigDecimal [][] noPayAmount = new BigDecimal[4][PayField.length];
		//�o��ƪ��Ȧs
		BigDecimal [] tempTotal = new BigDecimal[PayField.length];
		//�W�~�רM��ƪ��Ȧs
		BigDecimal [] lastAuditIssueAmount = new BigDecimal[PayField.length];
		BigDecimal [] lastAuditPayAmount = new BigDecimal[PayField.length];
		for (int ii = 0 ; ii  < 4 ; ii++ ){
			for (int jj = 0 ; jj < PayField.length ; jj++ ){
				noPayAmount[ii][jj] = new BigDecimal(0);
				tempTotal[jj] = new BigDecimal(0);
				lastAuditIssueAmount[jj] = new BigDecimal(0);
				lastAuditPayAmount[jj] = new BigDecimal(0);
			}
		}
		 
		//���account_kind��index�ܼ�
		int kind = 0;
		
		//���@�ӥ��v�l�B��쪺index�ܼ�
		int rIndex = 0;
		
		//�v���O��
		for (Iterator it1 = tList.iterator(); it1.hasNext();){
			tMap = (Map) it1.next();
			dMap = new HashMap();
			/*���account_kind,�o�� payAmount[kind][?]��kind��index��
			 * kind = 0 =>�w���
			 * 		= 1 =>�M���
			 * 		= 2 =>�O�d��
			 * 		= 3 =>��ڼ�
			 */
			if ("noKind".equals(AccountKind))
				kind=0;
			else
				kind = Integer.parseInt((String)tMap.get(AccountKind))-1;
			
				
			//���g�J��L���C�J�p�⪺���
			for (int k = 0 ; k < otherField.length ; k++ ){
				dMap.put(otherField[k],tMap.get(otherField[k]));
			}
			
			//�M��tempTotal�o��ƪ��Ȧs
			for (int jjj = 0 ; jjj < PayField.length ; jjj++ ){
				tempTotal[jjj] = new BigDecimal(0);
			}
			
			//�̦U�źحp��X�`�o���
			for (int j = 0 ; j < issueField.length ; j++ ){
				rIndex = Integer.parseInt(issueField[j].substring(2,issueField[j].length()))-1;
				tempTotal[rIndex] = tempTotal[rIndex].add((tMap.get(issueField[j])!=null)?(BigDecimal)tMap.get(issueField[j]):new BigDecimal(0));
				dMap.put(issueField[j],(BigDecimal)tMap.get(issueField[j]));
			}
			for(int z = 0 ; z < PayField.length ; z++){
				if(kind == 0){
					//�w��ƪ����~�ץ��v�l�B=�W�@�~�ת����v�l�B(X)+���~�ת��|�ɼ�(�w���)-���~�ת��٥���(�w���)
					//�����o�W�~�רM��ƧP�_�O�_��0,X���w��ƤϤ����M���
					if(!((String)tMap.get("account_year")).equals("088�W�b��089")){
						if(Integer.parseInt((String)((Map)tList.get(tList.size()-1)).get("account_year"))>new Date().getYear()-11 ){
							if(Integer.parseInt((String)((Map)tList.get(tList.size()-1)).get("account_year"))-1 <= Integer.parseInt((String)tMap.get("account_year"))){
								if(lastAuditIssueAmount[z].compareTo(new BigDecimal(0)) ==0 && lastAuditPayAmount[z].compareTo(new BigDecimal(0))==0)
									noPayAmount[kind][z] = noPayAmount[kind][z].add(tempTotal[z]).subtract((BigDecimal)tMap.get(PayField[z]));
								else
									noPayAmount[kind][z] = noPayAmount[kind+1][z].add(tempTotal[z]).subtract((BigDecimal)tMap.get(PayField[z]));
							}else
								noPayAmount[kind][z] = noPayAmount[kind+1][z].add(tempTotal[z]).subtract((BigDecimal)tMap.get(PayField[z]));
						}
						else
							noPayAmount[kind][z] = noPayAmount[kind+1][z].add(tempTotal[z]).subtract((BigDecimal)tMap.get(PayField[z]));
					}
					else
						noPayAmount[kind][z] = noPayAmount[kind+1][z].add(tempTotal[z]).subtract((BigDecimal)tMap.get(PayField[z]));
				}
				else
					noPayAmount[kind][z] = noPayAmount[kind][z].add(tempTotal[z]).subtract((BigDecimal)tMap.get(PayField[z]));
				//�Y��~�o��P�٥��Ҭ�0�h���v�l�B��ܬ�0
//				if(tempTotal[z].compareTo(new BigDecimal(0))==0 && ((BigDecimal)tMap.get(PayField[z])).compareTo(new BigDecimal(0))==0)
//					dMap.put(PayField[z],new BigDecimal(0));
//				else
					dMap.put(PayField[z],noPayAmount[kind][z]);
				//dMap.put(PayField[z],noPayAmount[kind][z]);
			}
			
			//�ά��M��ƱN��Ʃ�i�Ȧs��
			if(kind == 1){
				for (int i = 0 ; i < PayField.length ; i++ ){
					lastAuditIssueAmount[i] = new BigDecimal(0);
					lastAuditPayAmount[i] = new BigDecimal(0);
				}
				for(int i = 0 ; i < issueField.length ; i++){
					int tempIndex = Integer.parseInt(issueField[i].substring(2,issueField[i].length()))-1;
					lastAuditIssueAmount[tempIndex] = lastAuditIssueAmount[tempIndex].add((tMap.get(issueField[i])!=null)?(BigDecimal)tMap.get(issueField[i]):new BigDecimal(0));
				}
				for(int i = 0 ; i < PayField.length ; i ++){
					lastAuditPayAmount[i] = lastAuditPayAmount[i].add((BigDecimal)tMap.get(PayField[i]));
				}
			}
		/*  mark by Andrew 2006/10/23
			//�̦U�źرNnoPayAmount�[�W���~���o���
			for (int z = 0 ; z < PayField.length ; z++ ){
				//�w��ƪ����~�ץ��v�l�B=�W�@�~�ת����v�l�B(�M���/�w���)+���~�ת��|�ɼ�(�w���)-���~�ת��٥���(�w���)
				if (kind==0){
					if(((BigDecimal)tMap.get(issueField[z])).compareTo(new BigDecimal(0))==0 && ((BigDecimal)tMap.get(PayField[z])).compareTo(new BigDecimal(0))==0)
						noPayAmount[kind][z]=noPayAmount[kind][z].add(new BigDecimal(0));
					else
						noPayAmount[kind][z]=noPayAmount[kind+1][z].add(tempTotal[z]);
				}
				else
					noPayAmount[kind][z] = noPayAmount[kind][z].add(tempTotal[z]);
				
			}
			
			//�̦U�źرNnoPayAmount����~���٥���
			for (int i = 0 ; i < PayField.length ; i++ ){
				if(((BigDecimal)tMap.get(issueField[i])).compareTo(new BigDecimal(0))==0 && ((BigDecimal)tMap.get(PayField[i])).compareTo(new BigDecimal(0))==0)
					noPayAmount[kind][i]=noPayAmount[kind][i].subtract(new BigDecimal(0));
				else
					noPayAmount[kind][i]=noPayAmount[kind][i].subtract((BigDecimal)tMap.get(PayField[i]));
				if(tempTotal[i].compareTo(new BigDecimal(0))==0 && ((BigDecimal)tMap.get(PayField[i])).compareTo(new BigDecimal(0))==0)
					dMap.put(PayField[i],new BigDecimal(0));
				else
					dMap.put(PayField[i],noPayAmount[kind][i]);
			}
		*/
		
//		List dList = new ArrayList();
//		Map tMap = new HashMap();
//		Map dMap = new HashMap();
//		
//		//payAmount���v�l�B�}�C [account_kind][���v�l�B���]
//		BigDecimal [][] noPayAmount = new BigDecimal[4][PayField.length];
//		//�o��ƪ��Ȧs
//		BigDecimal [] tempTotal = new BigDecimal[PayField.length];
//		for (int ii = 0 ; ii  < 4 ; ii++ ){
//			for (int jj = 0 ; jj < PayField.length ; jj++ ){
//				noPayAmount[ii][jj] = new BigDecimal(0);
//				tempTotal[jj] = new BigDecimal(0);
//			}
//		}
//		
//		//���account_kind��index�ܼ�
//		int kind = 0;
//		
//		//���@�ӥ��v�l�B��쪺index�ܼ�
//		int rIndex = 0;
//		
//		//�v���O��
//		for (Iterator it1 = tList.iterator(); it1.hasNext();){
//			tMap = (Map) it1.next();
//			dMap = new HashMap();
//			/*���account_kind,�o�� payAmount[kind][?]��kind��index��
//			 * kind = 0 =>�w���
//			 * 		= 1 =>�M���
//			 * 		= 2 =>�O�d��
//			 * 		= 3 =>��ڼ�
//			 */
//			if ("noKind".equals(AccountKind))
//				kind=0;
//			else
//				kind = Integer.parseInt((String)tMap.get(AccountKind))-1;
//			
//			//���g�J��L���C�J�p�⪺���
//			
//			for (int k = 0 ; k < otherField.length ; k++ ){
//				dMap.put(otherField[k],tMap.get(otherField[k]));
//			}
//			
//			//�M��temp
//			for (int jjj = 0 ; jjj < PayField.length ; jjj++ ){
//				tempTotal[jjj] = new BigDecimal(0);
//			}
//			//�̦U�źحp��X�`�o���
//			for (int j = 0 ; j < issueField.length ; j++ ){
//				rIndex = Integer.parseInt(issueField[j].substring(2,issueField[j].length()))-1;
//				tempTotal[rIndex] = tempTotal[rIndex].add((BigDecimal)tMap.get(issueField[j]));
//				dMap.put(issueField[j],(BigDecimal)tMap.get(issueField[j]));
//			}
//			//�̦U�źرNnoPayAmount�[�W���~���o���
//			for (int z = 0 ; z < PayField.length ; z++ ){
//				//�w��ƪ����~�ץ��v�l�B=�W�@�~�ת����v�l�B(�M���)+���~�ת��|�ɼ�(�w���)-���~�ת��٥���(�w���)
//				if (kind==0)
//					noPayAmount[kind][z]=noPayAmount[kind+1][z].add(tempTotal[z]);
//				else
//					noPayAmount[kind][z] = noPayAmount[kind][z].add(tempTotal[z]);
//			}
//			
//			//�̦U�źرNnoPayAmount����~���٥���
//			for (int i = 0 ; i < PayField.length ; i++ ){
//				noPayAmount[kind][i]=noPayAmount[kind][i].subtract((BigDecimal)tMap.get(PayField[i]));
//				dMap.put(PayField[i],noPayAmount[kind][i]);
//			}
		
			dList.add(dMap);
		}
		return dList;
	}
}