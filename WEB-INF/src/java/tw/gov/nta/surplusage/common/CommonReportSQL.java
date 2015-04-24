package tw.gov.nta.surplusage.common;

import java.math.BigDecimal;

import com.kangdainfo.ast.sql.SQLJob;

public class CommonReportSQL 
{
	public static SQLJob Gara30SQL(String qryYear,BigDecimal unit){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select case ");
		sqljob.appendSQL("when (account_year ='088' and year_kind='1' ) then '088' ");
		sqljob.appendSQL("when ((account_year ='088' and year_kind='2') or account_year ='089' ) then '088�W�b��089' ");
		sqljob.appendSQL("else account_year ");
		sqljob.appendSQL("end + ");
		sqljob.appendSQL("case account_kind ");
		sqljob.appendSQL("when '1' then '(�w)' ");
		sqljob.appendSQL("when '2' then '(�M)' ");
		sqljob.appendSQL("when '3' then '(�O)' ");
		sqljob.appendSQL("when '4' then '(��)' ");
		sqljob.appendSQL("else '' ");
		sqljob.appendSQL("end item ,account_year,account_kind,");
		/*
		 * �o��,�|�ɼ�
		 */
		//���� �`�w�� ����
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code = '1'   and debt_type = 'A' then  issue_amount  else 0 end)/"+unit+" TA1,");
		//���� �S�O�w�� ����
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code = '2' and is_account ='N'  and debt_type = 'A' then  issue_amount else 0 end)/"+unit+" TA2,");
		//���� �S�O�w�� �A��
		sqljob.appendSQL("sum(case when bound_code = '2' and  budget_code = '2' and is_account ='N'  and debt_type = 'A'  and account_year < 091 then  issue_amount else 0 end)/"+unit+" TA3,");
		//���� �S�O�w�� �E�G�@
		sqljob.appendSQL("sum(case when is_account='Y'  and debt_type = 'A' then  issue_amount else 0 end )/"+unit+" TA4,");
		//���� �ŰȰ��
		sqljob.appendSQL("sum(case when budget_code = '3'  and debt_type = 'A'   then  issue_amount else 0 end)/"+unit+" TA5,");
		//���� �ٶ�
		sqljob.appendSQL("sum(case when debt_type = 'A' and debt_code = '35'  and  is_account<>'Y'  and  budget_code <> '3'   then issue_amount else 0 end)/"+unit+" TA6,");
		//���� �s�ͦa�}�o
		sqljob.appendSQL("sum(case when debt_type = 'A' and budget_code = '5' and debt_code=48 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA7,");
		//���� ³�����ǰ��
		sqljob.appendSQL("sum(case when debt_type = 'A' and budget_code = '5' and debt_code=36 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA8,");
		//���� �D��~���
		sqljob.appendSQL("sum(case when debt_type = 'A' and budget_code = '5' and debt_code=37 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA9, ");
		
		//���� ����
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code in ('1','2') and  is_account='N' and debt_type in ('C','E') then  issue_amount  else 0 end)/"+unit+" TA10,");
		//����  �A��
		sqljob.appendSQL("sum(case when bound_code = '2'      and debt_type in ('C','E')  then  issue_amount else 0 end)/"+unit+" TA11,");
		//���� �E�G�@��
		sqljob.appendSQL("sum(case when budget_code = '2' and bound_code<>'2' and debt_code not in (26,44,42)  and debt_type  in ('C','E') then  issue_amount else 0 end )/"+unit+" TA12,");
		//���� �ŰȰ��
		sqljob.appendSQL("sum(case when budget_code = '3'  and debt_type in ('C','E')   then  issue_amount else 0 end)/"+unit+" TA13,");
		//���� �ٶ�
		sqljob.appendSQL("sum(case when debt_type in ('C','E') and debt_code = '35'  and  is_account<>'Y'  and  budget_code <> '3'   then issue_amount else 0 end)/"+unit+" TA14,");
		//�ٶ�89�~�}�l���v�l�B��l�� �w:890.727(�Q��)�M:904.769(�Q��)��:897.719(�Q��)
		sqljob.appendSQL("((case when account_year = 089 and account_kind='1'  then 890727000000.0 ");
		sqljob.appendSQL("when account_year = 089 and account_kind='2'  then 904769000000.0 ");
		sqljob.appendSQL("when account_year = 089 and account_kind='4'  then 897539000000.0 ");
		//sqljob.appendSQL("when account_year = 089 and account_kind='4'  then 897719000000 ");
		sqljob.appendSQL("else 0.0 end))/"+unit+" as TB14,");
		//���� �s�ͦa�}�o
		sqljob.appendSQL("sum(case when debt_type in ('C','E') and budget_code = '5' and debt_code=48 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA15,");
		//�s�ͦa�}�o94�~�}�l���v�l�B��l�� �w:0.450(�Q��)�M:0.450(�Q��)��:0.450(�Q��)
		sqljob.appendSQL("((case when account_year = 094 and account_kind='1'  then 450000000.0 ");
		sqljob.appendSQL("when account_year = 094 and account_kind='2'  then 450000000.0 ");
		sqljob.appendSQL("when account_year = 094 and account_kind='4'  then 450000000.0 ");
		sqljob.appendSQL("else 0.0 end))/"+unit+" as TB15,");
		//���� ³�����ǰ��
		sqljob.appendSQL("sum(case when debt_type in ('C','E') and budget_code = '5' and debt_code=36 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA16,");
		//³�����ǰ��90�~�}�l���v�l�B��l��  �w:93.170(�Q��) �M:93.976(�Q��) ��:93.976(�Q��)
		sqljob.appendSQL("((case when account_year = 090 and account_kind='1'  then 93170000000.0 ");
		sqljob.appendSQL("when account_year = 090 and account_kind='2'  then 93976000000.0 ");
		sqljob.appendSQL("when account_year = 090 and account_kind='4'  then 93976000000.0 ");
		sqljob.appendSQL("else 0.0 end))/"+unit+" as TB16,");
		//���� �D��~���
		sqljob.appendSQL("sum(case when debt_type in ('C','E') and budget_code = '5' and debt_code=37 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA17, ");
		
		/*
		 * �٥���
		 */
		//���� �`�w�� ����
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code = '1'   and debt_type = 'A' then  pay_amount  else 0 end)/"+unit+" SA1,");
		//���� �S�O�w�� ����
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code = '2' and is_account ='N'  and debt_type = 'A' then  pay_amount else 0 end)/"+unit+" SA2,");
		//���� �S�O�w�� �A��
		sqljob.appendSQL("sum(case when bound_code = '2' and  budget_code = '2' and is_account ='N'  and debt_type = 'A'  and account_year < 091 then  pay_amount else 0 end)/"+unit+" SA3,");
		//���� �S�O�w�� �E�G�@
		sqljob.appendSQL("sum(case when is_account='Y'  and debt_type = 'A' then  pay_amount else 0 end )/"+unit+" SA4,");
		//���� �ŰȰ��
		sqljob.appendSQL("sum(case when budget_code = '3'  and debt_type = 'A'   then  pay_amount else 0 end)/"+unit+" SA5,");
		//���� �ٶ�
		sqljob.appendSQL("sum(case when debt_type = 'A' and debt_code = '35'  and  is_account<>'Y'  and  budget_code <> '3'   then pay_amount else 0 end)/"+unit+" SA6,");
		//���� �s�ͦa�}�o
		sqljob.appendSQL("sum(case when debt_type = 'A' and budget_code = '5' and debt_code=48 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA7,");
		//���� ³�����ǰ��
		sqljob.appendSQL("sum(case when debt_type = 'A' and budget_code = '5' and debt_code=36 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA8,");
		//���� �D��~���
		sqljob.appendSQL("sum(case when debt_type = 'A' and budget_code = '5' and debt_code=37 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA9, ");
		
		//���� ����
		sqljob.appendSQL("sum(case when bound_code = '1' and budget_code in ('1','2') and  is_account='N' and debt_type in ('C','E') then  pay_amount  else 0 end)/"+unit+" SA10,");
		//����  �A��
		sqljob.appendSQL("sum(case when bound_code = '2' and debt_type in ('C','E')  then  pay_amount else 0 end)/"+unit+" SA11,");
		//���� �E�G�@��
		sqljob.appendSQL("sum(case when budget_code = '2' and bound_code<>'2' and debt_code not in (26,44,42)  and debt_type  in ('C','E') then  pay_amount else 0 end )/"+unit+" SA12,");
		//���� �ŰȰ��
		sqljob.appendSQL("sum(case when budget_code = '3'  and debt_type in ('C','E')   then  pay_amount else 0 end)/"+unit+" SA13, ");
		//���� �ٶ�
		sqljob.appendSQL("sum(case when debt_type in ('C','E') and debt_code = '35'  and  is_account<>'Y'  and  budget_code <> '3'   then pay_amount else 0 end)/"+unit+" SA14,");
		//���� �s�ͦa�}�o
		sqljob.appendSQL("sum(case when debt_type in ('C','E') and budget_code = '5' and debt_code=48 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA15,");
		//���� ³�����ǰ��
		sqljob.appendSQL("sum(case when debt_type in ('C','E') and budget_code = '5' and debt_code=36 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA16,");
		//���� �D��~���
		sqljob.appendSQL("sum(case when debt_type in ('C','E') and budget_code = '5' and debt_code=37 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA17, ");
//		���� �D��~���(�D���v)
		sqljob.appendSQL("sum(case when bound_code = '1' and debt_type in ('C','E') and budget_code = '5' and debt_code=37 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA18, ");
//		���� �D��~���(�D���v)
		sqljob.appendSQL("sum(case when bound_code = '1' and debt_type = 'A' and budget_code = '5' and debt_code=37 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA19 ");

		sqljob.appendSQL("from Central_statistics_main ");
				//�s�W���~�ű���
		sqljob.appendSQL("where 1=1 and inout_type='0' ");
				//����ܫO�d��
		sqljob.appendSQL("and account_kind <> '3' ");
		if (!"".equals(qryYear)){
			sqljob.appendSQL("and account_year between 0 and ? +0 ");
			sqljob.addParameter(qryYear);
		}
		sqljob.appendSQL("group by case ");
		sqljob.appendSQL("when (account_year ='088' and year_kind='1' ) then '088' ");
		sqljob.appendSQL("when ((account_year ='088' and year_kind='2') or account_year ='089' ) then '088�W�b��089' ");
		sqljob.appendSQL("else account_year ");
		sqljob.appendSQL("end + ");
		sqljob.appendSQL("case account_kind ");
		sqljob.appendSQL("when '1' then '(�w)' ");
		sqljob.appendSQL("when '2' then '(�M)' ");
		sqljob.appendSQL("when '3' then '(�O)' ");
		sqljob.appendSQL("when '4' then '(��)' ");
		sqljob.appendSQL("else '' ");
		sqljob.appendSQL("end ,account_kind,account_year");
		sqljob.appendSQL("order by account_year,account_kind ");
		return sqljob;
	}
	public static SQLJob Gara34SQL(String qryYear,BigDecimal unit ){
		return Gara34SQL( qryYear, unit ,null);
	}
	public static SQLJob Gara34SQL(String qryYear,BigDecimal unit ,String inoutType){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select  case ");

		sqljob.appendSQL("when (account_year ='089' ) then '088�W�b��089' ");
		sqljob.appendSQL("else account_year ");
		sqljob.appendSQL("end as account_year,");
		sqljob.appendSQL("(case  ");
		sqljob.appendSQL("when  account_kind='1' then '(�w)' ");
		sqljob.appendSQL("when account_kind='2' then '(�M)' ");
		sqljob.appendSQL("when account_kind='3' then '(�O)' ");
		sqljob.appendSQL("when account_kind='4'  then '(��)' ");
		sqljob.appendSQL("else '' ");
		sqljob.appendSQL("end ) as account_kind_name ,");
		sqljob.appendSQL("(case");
		sqljob.appendSQL("when account_kind='1'  then '1' ");
		sqljob.appendSQL("when account_kind='2' then '2' ");
		sqljob.appendSQL("when account_kind='3' then '3' ");
		sqljob.appendSQL("when account_kind='4' then '4' ");
		sqljob.appendSQL("else '' ");
		sqljob.appendSQL("end ) as account_kind,");
		//�o�� �`�w��
		sqljob.appendSQL("sum(case when budget_code = '1' then  issue_amount else 0 end)/"+unit+" TA1,");
		//�o�� �`�w��-�ո`��
		sqljob.appendSQL("isNull((select (case when A.account_kind='1' then budget_adjust_amount when A.account_kind='2' then audit_adjust_amount when A.account_kind='4' then real_adjust_amount else 0 end) ");
		sqljob.appendSQL("from current_adjust_main B where A.account_year=B.account_year),0)/"+unit+" as TB1,");
		//�o�� �`�w��-���v�l�B��l��
		sqljob.appendSQL("(case when account_year = 072 and account_kind='1' then 1982000000.0 ");
		sqljob.appendSQL("when account_year = 072 and account_kind='2'  then 1982000000.0 ");
		sqljob.appendSQL("when account_year = 072 and account_kind='4'  then 1982000000.0 ");
		sqljob.appendSQL("else 0.0 end)/"+unit+" as TC1,");
		//�o�� �S�O�w�� �Ծ�
		sqljob.appendSQL("sum(case when budget_code = '2' and debt_code=42 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA2,");
		//�o�� �S�O�w�� �_�G��
		sqljob.appendSQL("sum(case when bound_code='1' and budget_code = '2' and debt_code=26 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA3,");
		//�o�� �S�O�w�� �A��
		sqljob.appendSQL("sum(case when bound_code = '2'  and budget_code = '2'  then  issue_amount else 0 end)/"+unit+" TA4,");
		//�o�� �S�O�w�� �߰|�E��
		sqljob.appendSQL("sum(case when budget_code = '2' and debt_code=44 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA5,");
		//�o�� �S�O�w�� �E�G�@��
		sqljob.appendSQL("sum(case when budget_code = '2' and bound_code<>'2' and debt_code not in (26,44,42)   then  issue_amount else 0 end)/"+unit+" TA6,");
		//�o�� �S�O�w�� �ٶ�
		sqljob.appendSQL("sum(case when budget_code = '5' and debt_code=35 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA7,");
		//�ٶ�89�~�}�l���v�l�B��l�� �w:890.727(�Q��)�M:904.769(�Q��)��:897.719(�Q��)
		sqljob.appendSQL("(case when account_year = 089 and account_kind='1'  then 890727000000.0 ");
		sqljob.appendSQL("when account_year = 089 and account_kind='2'  then 904769000000.0 ");
		sqljob.appendSQL("when account_year = 089 and account_kind='4'  then 897539000000.0 ");
		//sqljob.appendSQL("when account_year = 089 and account_kind='4'  then 897719000000 ");
		sqljob.appendSQL("else 0.0 end)/"+unit+" as TB7,");
		//�o��s�ͦa�}�o
		sqljob.appendSQL("sum(case when budget_code = '5' and debt_code=48 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA8,");
		//�s�ͦa�}�o94�~�}�l���v�l�B��l�� �w:0.450(�Q��)�M:0.450(�Q��)��:0.450(�Q��)
		sqljob.appendSQL("(case when account_year = 094 and account_kind='1'  then 450000000.0 ");
		sqljob.appendSQL("when account_year = 094 and account_kind='2'  then 450000000.0 ");
		sqljob.appendSQL("when account_year = 094 and account_kind='4'  then 450000000.0 ");
		sqljob.appendSQL("else 0.0 end)/"+unit+" as TB8,");
		//�o�� �S�O�w�� ³�����ǰ��
		sqljob.appendSQL("sum(case when budget_code = '5' and debt_code=36 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA9,");
		//³�����ǰ��90�~�}�l���v�l�B��l��  �w:93.170(�Q��) �M:93.976(�Q��) ��:93.976(�Q��)
		sqljob.appendSQL("(case when account_year = 090 and account_kind='1'  then 93170000000.0 ");
		sqljob.appendSQL("when account_year = 090 and account_kind='2'  then 93976000000.0 ");
		sqljob.appendSQL("when account_year = 090 and account_kind='4'  then 93976000000.0 ");
		sqljob.appendSQL("else 0.0 end)/"+unit+" as TB9,");
		//�o�� �ŰȰ��
		sqljob.appendSQL("sum(case when budget_code = '3'   then  issue_amount else 0 end)/"+unit+" TA10,");
		//�o�� �S�O�w�� �D��~���
		sqljob.appendSQL("sum(case when budget_code = '5' and debt_code=37 and is_account ='N'  then  issue_amount else 0 end)/"+unit+" TA11,");
		//�٥� �`�w��
		sqljob.appendSQL("sum(case when budget_code = '1'  then  pay_amount else 0 end)/"+unit+" SA1,");		
		//�٥� �S�O�w�� �Ծ�
		sqljob.appendSQL("sum(case when budget_code = '2' and debt_code=42 and is_account ='N' then  pay_amount else 0 end)/"+unit+" SA2,");
		//�٥� �S�O�w�� �_�G��
		sqljob.appendSQL("sum(case when bound_code='1' and budget_code = '2' and debt_code=26 and is_account ='N' then  pay_amount else 0 end)/"+unit+" SA3,");
		//�٥� �S�O�w�� �A��
		sqljob.appendSQL("sum(case when bound_code = '2'  and budget_code = '2' and is_account ='N' then  pay_amount else 0 end)/"+unit+" SA4,");
		//�٥� �S�O�w�� �߰|�E��
		sqljob.appendSQL("sum(case when budget_code = '2' and debt_code=44 and is_account ='N' then  pay_amount else 0 end)/"+unit+" SA5,");
		//�٥� �S�O�w�� �E�G�@��
		sqljob.appendSQL("sum(case when budget_code = '2' and bound_code<>'2' and debt_code not in (26,44,42)   then  pay_amount else 0 end)/"+unit+" SA6,");
		//�٥� �S�O�w�� �ٶ�
		sqljob.appendSQL("sum(case when budget_code = '5' and debt_code=35 and is_account ='N' then  pay_amount else 0 end)/"+unit+" SA7,");
		//�٥� �s�ͦa�}�o
		sqljob.appendSQL("sum(case when budget_code = '5' and debt_code=48 and is_account ='N' then  pay_amount else 0 end)/"+unit+" SA8,");
		//�٥� �S�O�w�� ³�����ǰ��
		sqljob.appendSQL("sum(case when budget_code = '5' and debt_code=36 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA9,");
		//�٥� �ŰȰ��
		sqljob.appendSQL("sum(case when budget_code = '3'   then  pay_amount else 0 end)/"+unit+" SA10,");
		//�٥� �S�O�w�� �D��~���
		sqljob.appendSQL("sum(case when budget_code = '5' and debt_code=37 and is_account ='N'  then  pay_amount else 0 end)/"+unit+" SA11 ");
		sqljob.appendSQL("from Central_statistics_main A");
		sqljob.appendSQL("where debt_type IN ('C','E') ");
		//����ܫO�d��
		sqljob.appendSQL("and account_kind <> '3' ");
		if (!"".equals(qryYear)){
			sqljob.appendSQL("and account_year between 0 and ? +0 ");
			sqljob.addParameter(qryYear);
		}
		if(inoutType != null){
			sqljob.appendSQL("and inout_type=? ");
			sqljob.addParameter(inoutType);
		}
		sqljob.appendSQL("group by case ");
		sqljob.appendSQL("when (account_year ='089' ) then '088�W�b��089' ");
		sqljob.appendSQL("else account_year ");
		sqljob.appendSQL("end , ");
		sqljob.appendSQL("(case  ");
		sqljob.appendSQL("when  account_kind='1' then '(�w)' ");
		sqljob.appendSQL("when account_kind='2' then '(�M)' ");
		sqljob.appendSQL("when account_kind='3' then '(�O)' ");
		sqljob.appendSQL("when account_kind='4'  then '(��)' ");
		sqljob.appendSQL("else '' ");
		sqljob.appendSQL("end ),");
		sqljob.appendSQL("(case");
		sqljob.appendSQL("when account_kind='1'  then '1' ");
		sqljob.appendSQL("when account_kind='2' then '2' ");
		sqljob.appendSQL("when account_kind='3' then '3' ");
		sqljob.appendSQL("when account_kind='4' then '4' ");
		sqljob.appendSQL("else '' ");
		sqljob.appendSQL("end ),account_year ,account_kind ");
		sqljob.appendSQL("order by 1,3");
		return sqljob;
	}
	public static SQLJob Gara33SQL(String qryYear,BigDecimal unit ){
		return Gara33SQL( qryYear, unit ,null);
	}
	public static SQLJob Gara33SQL(String qryYear,BigDecimal unit,String inoutType){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select  case ");
		sqljob.appendSQL("when (account_year ='088' and year_kind='1' ) then '088' ");
		sqljob.appendSQL("when ((account_year ='088' and year_kind='2') or account_year ='089' ) then '088�W�b��089' ");
		sqljob.appendSQL("else account_year ");
		sqljob.appendSQL("end + ");
		sqljob.appendSQL("case account_kind ");
		sqljob.appendSQL("when '1' then '(�w)' ");
		sqljob.appendSQL("when '2' then '(�M)' ");
		sqljob.appendSQL("when '3' then '(�O)' ");
		sqljob.appendSQL("when '4' then '(��)' ");
		sqljob.appendSQL("else '' ");
		sqljob.appendSQL("end item ,account_kind,account_year, ");
		//�o�� �`�w�� ����
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code = '1' then  issue_amount else 0 end)/? TA1,");
		//�o�� �S�O�w�� ����
		sqljob.appendSQL("sum(case when bound_code = '1' and  budget_code = '2' and is_account ='N'  then  issue_amount else 0 end)/? TB1,");
		//�o�� �S�O�w�� �A��  91�~�}�l�ŰȤ��C�J�p��
		sqljob.appendSQL("sum(case when bound_code = '2' and  budget_code = '2' and is_account ='N' and account_year<'091' then  issue_amount else 0 end)/? TA2,");
		sqljob.appendSQL("sum(case when bound_code = '2' and  budget_code = '1' and is_account ='N' and account_year<'091' then  issue_amount else 0 end)/? TB2,");
		//�o�� �ٶ�
		sqljob.appendSQL("sum(case when  debt_code = '35'  and  is_account<>'Y'  and  budget_code <> '3'   then issue_amount else 0 end)/? TA3,");
		//�o�� �S�O�w�� �E�G�@
		sqljob.appendSQL("sum(case when is_account='Y' then  issue_amount else 0 end )/? TA4,");
		//�o�� �ŰȰ��
		sqljob.appendSQL("sum(case when budget_code = '3'   then  issue_amount else 0 end)/? TA5,");
		//�٥� ����
		sqljob.appendSQL("sum(case when  bound_code = '1'  and  debt_code <> '35' and  is_account<>'Y'  and  budget_code in ( '1','2')    then pay_amount  else 0 end)/? SA1,");
		//�٥� �A�� 91�~�}�l�ŰȤ��C�J�p��
		sqljob.appendSQL("sum(case when  bound_code = '2' and account_year<'091' then pay_amount  else 0 end)/? SA2,");
		//�٥� �ٶ�
		sqljob.appendSQL("sum(case when  debt_code = '35'  and  is_account<>'Y'  and  budget_code <> '3'   then pay_amount  else 0 end)/? SA3,");
		//�٥� �E�G�@
		sqljob.appendSQL("sum(case when is_account='Y' and  debt_code <> '35' and   budget_code <> '3'  then  pay_amount  else 0 end )/? SA4,");
		//�٥� �ŰȰ��
		sqljob.appendSQL("sum(case when budget_code = '3'  and  debt_code <> '35' and  is_account<>'Y'  then  pay_amount  else 0 end)/? SA5");
		sqljob.appendSQL("from Central_statistics_main ");
		sqljob.appendSQL("where debt_type = 'A' ");
		//����ܫO�d��
		sqljob.appendSQL("and account_kind <> '3' ");
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		sqljob.addParameter(unit);
		if (!"".equals(qryYear)){
			sqljob.appendSQL("and account_year between 0 and ? +0 ");
			sqljob.addParameter(qryYear);
		}
		if(inoutType != null){
			sqljob.appendSQL("and inout_type=? ");
			sqljob.addParameter(inoutType);
		}
		sqljob.appendSQL("group by case ");
		sqljob.appendSQL("when (account_year ='088' and year_kind='1' ) then '088' ");
		sqljob.appendSQL("when ((account_year ='088' and year_kind='2') or account_year ='089' ) then '088�W�b��089' ");
		sqljob.appendSQL("else account_year ");
		sqljob.appendSQL("end + ");
		sqljob.appendSQL("case account_kind ");
		sqljob.appendSQL("when '1' then '(�w)' ");
		sqljob.appendSQL("when '2' then '(�M)' ");
		sqljob.appendSQL("when '3' then '(�O)' ");
		sqljob.appendSQL("when '4' then '(��)' ");
		sqljob.appendSQL("else '' ");
		sqljob.appendSQL("end ,account_kind,account_year ");
		sqljob.appendSQL("order by account_year,account_kind ");
		System.out.println("GARA3301-SQL"+sqljob.toString());
		return sqljob;
	}
}
