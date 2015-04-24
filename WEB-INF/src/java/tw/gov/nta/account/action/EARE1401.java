package tw.gov.nta.account.action;

import gov.dnt.tame.common.ExcelReportBaseAction;
import gov.dnt.tame.util.DateUtil;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.struts.action.ActionForm;

import tw.gov.nta.account.form.Eare1401Form;

import com.kangdainfo.ast.sql.ConnectionSQLRunner;
import com.kangdainfo.ast.sql.SQLJob;
import com.kangdainfo.ast.sql.SQLRunner;

public class EARE1401 extends ExcelReportBaseAction{

	//�ɥH�L���o��ɪ��ǲ��D��(voucher_main)
	protected SQLJob SQL1(ActionForm form){
		
		Eare1401Form myForm = (Eare1401Form) form;
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select RTRIM(a.debt_name) as debt_name, RTRIM(b.debt_serial) as debt_serial, a.source_issue_id as source_issue_id, b.issue_id as issue_id, b.id as debt_id,  ");
		sqljob.appendSQL("b.budget_code as budget_code, b.debt_code as debt_code, "); 
		sqljob.appendSQL("1 as debt_type_id, a.issue_kind as issue_kind, 'DebtMain' as source_type, ");
		
		//����
		if (myForm.getConvertType().equals("A")){
			//�����o���
			sqljob.appendSQL("182 as phase_id, ");
			//�w�ﷸ���diversity_amount
			if (myForm.getConvertKind().equals("3")){
				sqljob.appendSQL(" (b.diversity_amount) as amount, ");
			//�w��o�榨���Bissue_cost_amount
			}else if (myForm.getConvertKind().equals("4")){
				sqljob.appendSQL(" b.issue_cost_amount as issue_cost_amount, ");
			}
		}
		
		//���
		if (myForm.getConvertType().equals("B")){
			//����o���
			sqljob.appendSQL("180 as phase_id, ");
			//�w�ﷸ���diversity_amount
			if (myForm.getConvertKind().equals("3")){
				sqljob.appendSQL(" (0 - b.diversity_amount) as amount, ");
			//�w��o�榨���Bissue_cost_amount
			}else if (myForm.getConvertKind().equals("4")){
				sqljob.appendSQL(" b.issue_cost_amount as issue_cost_amount, ");
			}
		}
		
		sqljob.appendSQL("1 as voucher_ser, 2 as voucher_type, ");
//		sqljob.appendSQL("a.issue_date as voucher_date,");
		sqljob.appendSQL("'"+myForm.getConvertDate()+"' as voucher_date,"); 
		sqljob.appendSQL("'N' as is_delete, 'GBA' as usr_id, '"+myForm.getConvertDate()+"' as mod_date,");		
		sqljob.appendSQL("'"+myForm.getConvertDate()+"' as post_date, 'GBA' as post_usr");	

		sqljob.appendSQL(" from issue_main a, debt_main b, debit_ref e ");
		sqljob.appendSQL(" where a.id = b.issue_id ");
		sqljob.appendSQL(" and b.debt_code = e.id ");
		sqljob.appendSQL(" and a.account_year >= '084'");
		
		if (myForm.getConvertType().equals("A")){
			sqljob.appendSQL(" and b.diversity_amount > 0");
		}else if(myForm.getConvertType().equals("B")){
			sqljob.appendSQL(" and b.diversity_amount <= 0");
		}
		
		sqljob.appendSQL(" and debt_type = 'A' ");
		sqljob.appendSQL(" and a.issue_date <= '"+myForm.getConvertDate()+"'");
//		sqljob.appendSQL(" and (a.capital_amount = 0 or a.capital_amount = null)");
//		sqljob.appendSQL(" and isnull(a.capital_amount,0) < (select sum(capital_amount) from payment_main where a.id = issue_id)");
//		sqljob.appendSQL(" and isnull(a.capital_amount,0) < a.issue_amount");
		sqljob.appendSQL(" and a.issue_amount > " +
				"isnull((select sum(capital_amount) from payment_main where a.id = issue_id and repay_date <= '"+myForm.getConvertDate()+"'),0)");
		sqljob.appendSQL(" order by a.issue_date");		
		System.out.println("EARE14-�ɥH�L���o��ɪ��ǲ��D��SQL1----::"+sqljob.toString());
		return sqljob;
		
	}
	
	//�d�߶ǲ��D��ID
	protected SQLJob SQL2(String voucherNo){
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select id from voucher_main where voucher_no='"+voucherNo+"'");
		System.out.println("EARE14-SQL2-::"+sqljob.toString());
		return sqljob;
	}
	
	//�ɹL���w�u�P���ǲ��D��(voucher_main)
	protected SQLJob SQL3(ActionForm form){
		
		Eare1401Form myForm = (Eare1401Form) form;
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select RTRIM(a.debt_name) as debt_name, RTRIM(b.debt_serial) as debt_serial, a.source_issue_id as source_issue_id, b.issue_id as issue_id, b.id as debt_id,  ");
		sqljob.appendSQL("b.budget_code as budget_code, b.debt_code as debt_code, "); 
		sqljob.appendSQL("1 as debt_type_id, a.issue_kind as issue_kind, 'DebtMain' as source_type, ");
		sqljob.appendSQL("1 as voucher_ser, 2 as voucher_type,");
//		sqljob.appendSQL("a.issue_date as voucher_date,");
		sqljob.appendSQL("'"+myForm.getConvertDate()+"' as voucher_date,");
		sqljob.appendSQL("'N' as is_delete, 'GBA' as usr_id, '"+myForm.getConvertDate()+"' as mod_date,");		
		sqljob.appendSQL("'"+myForm.getConvertDate()+"' as post_date, 'GBA' as post_usr,");
		
		//����
		if (myForm.getConvertType().equals("A")){
			//�����u�P��
			sqljob.appendSQL("181 as phase_id, ");
			if (myForm.getConvertKind().equals("3")){
				//�w�ﷸ���
				sqljob.appendSQL(" ((b.diversity_amount / a.interest_alternate) * ");
				sqljob.appendSQL(" (select Max(d.interest_serial) from debt_plan_det d " +
//						"where d.debt_id = b.id and d.repay_date < '2007/06/30')) as amount");
						"where d.debt_id = b.id and d.repay_date <'"+myForm.getConvertDate()+"')) as amount");
			}else if (myForm.getConvertKind().equals("4")){
				//�w��o�榨���B
				sqljob.appendSQL(" ((b.issue_cost_amount / a.interest_alternate) * ");
				sqljob.appendSQL(" (select Max(d.interest_serial) from debt_plan_det d " +
//					"where d.debt_id = b.id and d.repay_date < '2007/06/30')) as issue_cost_amount");
					"where d.debt_id = b.id and d.repay_date < '"+myForm.getConvertDate()+"')) as issue_cost_amount");
			}
		}
		
		//���
		if (myForm.getConvertType().equals("B")){
			//����u�P��
			sqljob.appendSQL("183 as phase_id, ");
			if (myForm.getConvertKind().equals("3")){
//				sqljob.appendSQL(" (((0 - b.diversity_amount) / a.interest_alternate) * ");
				//�w�ﷸ���
				sqljob.appendSQL("(((b.issue_amount - b.real_amount + b.payable_interest_amount) / a.interest_alternate) * ");
				sqljob.appendSQL(" (select Max(d.interest_serial) from debt_plan_det d " +
//					"where d.debt_id = b.id and d.repay_date < '2007/06/30')) as amount");
					"where d.debt_id = b.id and d.repay_date < '"+myForm.getConvertDate()+"')) as amount");
			}else if (myForm.getConvertKind().equals("4")){
//				sqljob.appendSQL(" ((b.issue_cost_amount / a.interest_alternate) * ");
				//�w��o�榨���B
				sqljob.appendSQL("((b.issue_cost_amount / a.interest_alternate) * ");
				sqljob.appendSQL(" (select Max(d.interest_serial) from debt_plan_det d " +
//					"where d.debt_id = b.id and d.repay_date < '2007/06/30')) as issue_cost_amount");
					"where d.debt_id = b.id and d.repay_date < '"+myForm.getConvertDate()+"')) as issue_cost_amount");
			}
		}
		
		sqljob.appendSQL(" from issue_main a, debt_main b, debit_ref e ");
		sqljob.appendSQL(" where a.id = b.issue_id ");
		sqljob.appendSQL(" and b.debt_code = e.id ");
		sqljob.appendSQL(" and a.account_year >= '084'");
		
		if (myForm.getConvertType().equals("A")){
			sqljob.appendSQL(" and b.diversity_amount > 0");
		}else if(myForm.getConvertType().equals("B")){
			sqljob.appendSQL(" and b.diversity_amount <= 0")	;
		}
		
		sqljob.appendSQL(" and debt_type = 'A' ");
		sqljob.appendSQL(" and issue_date <= '"+myForm.getConvertDate()+"'");
//		sqljob.appendSQL(" and (a.capital_amount = 0 or a.capital_amount = null)");
//		sqljob.appendSQL(" and isnull(a.capital_amount,0) < (select sum(capital_amount) from payment_main where a.id = issue_id)");
//		sqljob.appendSQL(" and isnull(a.capital_amount,0) < a.issue_amount");
		sqljob.appendSQL(" and a.issue_amount > " +
				"isnull((select sum(capital_amount) from payment_main where a.id = issue_id and repay_date <= '"+myForm.getConvertDate()+"'),0)");
		sqljob.appendSQL(" order by a.issue_date");
		System.out.println("EARE14-�ɹL���w�u�P���ǲ��D��SQL3-::"+sqljob.toString());
		return sqljob;
	}
	
	//�ɹL���w�u�P���ǲ��A�d�߶ǲ��D��ID
	protected SQLJob SQL4(String voucherNo){
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select id from voucher_main where voucher_no='"+voucherNo+"'");
		System.out.println("EARE14-SQL4-::"+sqljob.toString());
		return sqljob;
	}
	
	//�w��O�W��
	protected SQLJob SQL5(Integer debtCode){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select debit_name from debit_ref where id ="+debtCode);
		return sqljob;
	}
	
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		// TODO Auto-generated method stub
		
		Eare1401Form myForm = (Eare1401Form) form;
		
		//���o�ϥΪ̱b��
		String usrId = this.getUserId(request);
		//���oSQLRunner		
		SQLRunner run = new ConnectionSQLRunner(connection); 
		
		//����insert
//		List tList = null;
		List tList = new ArrayList();
		System.out.println(myForm.getConvertDate());
		//�P�_�O�o��άO�u�P�A1���o��A2���u�P
		if (myForm.getConvertTiming().equals("1")){
			tList = (List) run.query(SQL1(myForm), new MapListHandler());
		}else if (myForm.getConvertTiming().equals("2")){
			tList = (List) run.query(SQL3(myForm), new MapListHandler());
		}
		
		Map tMap = null;
		
		Integer i = 1;
		Integer issue_id = 0;
		
		//���Map
		for(Iterator tIterator = tList.iterator(); tIterator.hasNext(); )
		{
			tMap = (Map) tIterator.next();
			Map dMap = new HashMap();
			
			System.out.println("voucherMain==================================");
			//�o�椽��ID
			dMap.put("issue_id",(Integer)tMap.get("source_issue_id"));			
			System.out.println("���O�G"+dMap.get("issue_id"));
			
			if (issue_id.equals((Integer)tMap.get("issue_id"))){
				i = i+1;
				System.out.println("i �G "+i);
			}else{
				i = 1;
				System.out.println("���P������ i �G "+i);
			}
			
			//�ǲ��s��
			//�P�_�O�o��άO�u�P�A1���o��A2���u�P
			if (myForm.getConvertTiming().equals("1")){
				dMap.put("voucher_no",(String)tMap.get("debt_serial")+"000DP");
			}else if (myForm.getConvertTiming().equals("2")){
				dMap.put("voucher_no",(String)tMap.get("debt_serial")+"000DU");
			}
			System.out.println("�ǲ��s���G"+dMap.get("voucher_no"));
			
			//���s���wissue_id
			issue_id = (Integer)tMap.get("issue_id");

			//�ŰȧO
			dMap.put("budget_code",(Integer)tMap.get("budget_code"));
			System.out.println("�ŰȧO�G"+dMap.get("budget_code"));
			
			//�w��O
			Integer debtCode = (Integer)tMap.get("debt_code");
			dMap.put("debt_code",debtCode);
			System.out.println("�w��O�G"+dMap.get("debt_code"));
			
			//����������
			dMap.put("debt_type_id",(Integer)tMap.get("debt_type_id"));
			System.out.println("�źج����šG"+dMap.get("debt_type_id"));
			
			//�ǲ��ӷ�
			dMap.put("source_type",(String)tMap.get("source_type"));
			System.out.println("�ǲ��ӷ��G"+dMap.get("source_type"));
			
			//�|�p���q
			dMap.put("phase_id",(Integer)tMap.get("phase_id"));
			System.out.println("�|�p���q�G"+dMap.get("phase_id"));
			
			//��������B
//			dMap.put("amount",(BigDecimal)tMap.get("amount"));
			System.out.println("��������B�G"+tMap.get("amount"));
			
			//�o�榨�����B
//			dMap.put("issue_cost_amount",(BigDecimal)tMap.get("issue_cost_amount"));
			System.out.println("�o�榨�����B�G"+tMap.get("issue_cost_amount"));	
			
			//voucher_type
			dMap.put("voucher_type",(Integer)tMap.get("voucher_type"));
			System.out.println("voucher_type�G"+dMap.get("voucher_type"));
			
			//�ǲ����
//			if (myForm.getConvertTiming().equals("1")){
//				dMap.put("voucher_date",(Date)tMap.get("voucher_date"));
//			}else{
//				dMap.put("voucher_date",DateUtil.str2Date((String)tMap.get("voucher_date")));				
//			}
			dMap.put("voucher_date",DateUtil.str2Date("20081231"));
			System.out.println("�ǲ�����G"+dMap.get("voucher_date"));
			
			//�O�_�R��
			dMap.put("is_delete",(String)tMap.get("is_delete"));
			System.out.println("�O�_�R���G"+dMap.get("is_delete"));
			
			dMap.put("usr_id",(String)tMap.get("usr_id"));
			System.out.println("�ϥΪ̡G"+dMap.get("usr_id"));
			
			dMap.put("mod_date",(String)tMap.get("mod_date"));
			System.out.println("�ק�ɶ��G"+dMap.get("mod_date"));
			
			dMap.put("issue_kind",(String)tMap.get("issue_kind"));
			System.out.println("issue_kind�G"+dMap.get("issue_kind"));
			
			dMap.put("voucher_ser",(Integer)tMap.get("voucher_ser"));
			System.out.println("voucher_ser�G"+dMap.get("voucher_ser"));
			
			List debtNameList = (List)run.query(SQL5(debtCode), new MapListHandler());
			Map debtNameMap = (Map)debtNameList.get(0);
			dMap.put("remark",(String)tMap.get("debt_name")+"("+(String)debtNameMap.get("debit_name")+")"+"�A�t�XGBA�t����J�ǲ�");
			System.out.println("remark�G"+dMap.get("remark"));
			
			//�L�b���
			dMap.put("post_date",(String)tMap.get("post_date"));
			System.out.println("�L�b����G"+dMap.get("post_date"));
			
			//�L�b�H��
			dMap.put("post_usr",(String)tMap.get("post_usr"));
			System.out.println("�L�b�H���G"+dMap.get("post_usr"));
			
			if ((BigDecimal)tMap.get("issue_cost_amount") != null || (BigDecimal)tMap.get("amount") != null ){

				//�g�J�ǲ��D��voucher_main
				List mainList = new ArrayList();
				mainList = (List)run.query(SQL2((String)dMap.get("voucher_no")), new MapListHandler());
				if (mainList.isEmpty())
					run.update(connection,insTemp("voucher_main",dMap));
				
				//�d�߶ǲ��D��ID
				List dList = new ArrayList();
				if (myForm.getConvertTiming().equals("1")){
					dList = (List) run.query(SQL2((String)dMap.get("voucher_no")), new MapListHandler());
				}else if (myForm.getConvertTiming().equals("2")){
					dList = (List) run.query(SQL4((String)dMap.get("voucher_no")), new MapListHandler());
				}
				
				
				Map detMap = null;

				//�o�����ǲ�����
				if (myForm.getConvertTiming().equals("1")){
					
					for(Iterator detIterator = dList.iterator(); detIterator.hasNext(); )
					{
						detMap = (Map) detIterator.next();
						Map ddetMap = new HashMap();
					
						System.out.println("voucherDet�ɤ�==================================");
						ddetMap.put("voucher_id",(Integer)detMap.get("id"));
						System.out.println("issue_kind�G"+ddetMap.get("voucher_id"));
						
						//����
						if (myForm.getConvertType().equals("A")){
							//�����o���
							if (myForm.getConvertKind().equals("3")){
								//���ŷ���
								ddetMap.put("account_code","37");
							}else if (myForm.getConvertKind().equals("4")){
								//�����O��
								ddetMap.put("account_code","225");
							}
							
						}
						
						//���
						if (myForm.getConvertType().equals("B")){
							//����o���
							if (myForm.getConvertKind().equals("3")){
								//���ŧ��
								ddetMap.put("account_code","33");
							}else if (myForm.getConvertKind().equals("4")){
								//�����O��
								ddetMap.put("account_code","225");
							}
							
						}
						System.out.println("account_code�G"+ddetMap.get("account_code"));
						
						//�w�ﷸ����B�z���|�p�ǲ����B
						if (myForm.getConvertKind().equals("3")){
							BigDecimal amount = (BigDecimal)tMap.get("amount");
							amount = amount.setScale(0,BigDecimal.ROUND_DOWN);
							ddetMap.put("account_amount",amount);
//							ddetMap.put("account_amount",(BigDecimal)tMap.get("amount"));
						//�w��o�榨���B���|�p�ǲ����B
						}else if (myForm.getConvertKind().equals("4")){
							BigDecimal accountAmount = (BigDecimal)tMap.get("issue_cost_amount");
							accountAmount = accountAmount.setScale(0,BigDecimal.ROUND_DOWN);
							ddetMap.put("account_amount",accountAmount);
//							ddetMap.put("account_amount",(BigDecimal)tMap.get("issue_cost_amount"));
						}
						
						System.out.println("account_amount�G"+ddetMap.get("account_amount"));
					
						ddetMap.put("account_type","D");
						System.out.println("account_type�G"+ddetMap.get("account_type"));
					
						run.update(connection,insTemp("voucher_det",ddetMap));
					
						System.out.println("voucherDet�U��==================================");
						ddetMap = new HashMap();
					
						ddetMap.put("voucher_id",(Integer)detMap.get("id"));
						System.out.println("issue_kind�G"+ddetMap.get("voucher_id"));
						
						//����
						if (myForm.getConvertType().equals("A")){
							//�����o���
							if (myForm.getConvertKind().equals("3")){
								//���u�P���ŷ���
								ddetMap.put("account_code","223");
							}else if (myForm.getConvertKind().equals("4")){
								//���u�P���ŵo�榨��
								ddetMap.put("account_code","226");
							}
							
						}
						
						//���
						if (myForm.getConvertType().equals("B")){
							//����o���
							if (myForm.getConvertKind().equals("3")){
								//���u�P���ŧ��
								ddetMap.put("account_code","224");
							}else if (myForm.getConvertKind().equals("4")){
								//���u�P���ŵo�榨��
								ddetMap.put("account_code","226");
							}
							
						}
						System.out.println("account_code�G"+ddetMap.get("account_code"));
						
						//�w�ﷸ����B�z���|�p�ǲ����B
						if (myForm.getConvertKind().equals("3")){
							BigDecimal amount = (BigDecimal)tMap.get("amount");
							amount = amount.setScale(0,BigDecimal.ROUND_DOWN);
							ddetMap.put("account_amount",amount);
//							ddetMap.put("account_amount",(BigDecimal)tMap.get("amount"));
						//�w��o�榨���B���|�p�ǲ����B
						}else if (myForm.getConvertKind().equals("4")){
							BigDecimal accountAmount = (BigDecimal)tMap.get("issue_cost_amount");
							accountAmount = accountAmount.setScale(0,BigDecimal.ROUND_DOWN);
							ddetMap.put("account_amount",accountAmount);
//							ddetMap.put("account_amount",(BigDecimal)tMap.get("issue_cost_amount"));
						}
						
						System.out.println("account_amount�G"+ddetMap.get("account_amount"));
						
						ddetMap.put("account_type","C");
						System.out.println("account_type�G"+ddetMap.get("account_type"));
					
						run.update(connection,insTemp("voucher_det",ddetMap));					
					}
				}
				
			

				
				//�u�P�U���w�L�ǲ�����
				if (myForm.getConvertTiming().equals("2")){
					//�g�J�ǲ�����
					for(Iterator detIterator = dList.iterator(); detIterator.hasNext(); )
					{
						detMap = (Map) detIterator.next();
						Map ddetMap = new HashMap();
					
						System.out.println("voucherDet�ɤ�==================================");
						ddetMap.put("voucher_id",(Integer)detMap.get("id"));
						System.out.println("issue_kind�G"+ddetMap.get("voucher_id"));
						//����
						if (myForm.getConvertType().equals("A")){
							//�����o���
							if (myForm.getConvertKind().equals("3")){
								//���ŷ���
								ddetMap.put("account_code","223");
							}else if (myForm.getConvertKind().equals("4")){
								//�����O��
								ddetMap.put("account_code","226");
							}
							
						}
						
						//���
						if (myForm.getConvertType().equals("B")){
							//����o���
							if (myForm.getConvertKind().equals("3")){
								//���ŧ��
								ddetMap.put("account_code","224");
							}else if (myForm.getConvertKind().equals("4")){
								//�����O��
								ddetMap.put("account_code","226");
							}
							
						}
						System.out.println("account_code�G"+ddetMap.get("account_code"));
						
						//�w�ﷸ����B�z���|�p�ǲ����B
						if (myForm.getConvertKind().equals("3")){
							BigDecimal amount = (BigDecimal)tMap.get("amount");
							amount = amount.setScale(0,BigDecimal.ROUND_DOWN);
							ddetMap.put("account_amount",amount);
//							ddetMap.put("account_amount",(BigDecimal)tMap.get("amount"));
						//�w��o�榨���B���|�p�ǲ����B
						}else if (myForm.getConvertKind().equals("4")){
							BigDecimal accountAmount = (BigDecimal)tMap.get("issue_cost_amount");
							accountAmount = accountAmount.setScale(0,BigDecimal.ROUND_DOWN);
							ddetMap.put("account_amount",accountAmount);
//							ddetMap.put("account_amount",(BigDecimal)tMap.get("issue_cost_amount"));
						}
						
						System.out.println("account_amount�G"+ddetMap.get("account_amount"));
					
						ddetMap.put("account_type","D");
						System.out.println("account_type�G"+ddetMap.get("account_type"));
					
						run.update(connection,insTemp("voucher_det",ddetMap));
					
						System.out.println("voucherDet�U��==================================");
						ddetMap = new HashMap();
					
						ddetMap.put("voucher_id",(Integer)detMap.get("id"));
						System.out.println("issue_kind�G"+ddetMap.get("voucher_id"));
						//����
						if (myForm.getConvertType().equals("A")){
							//�����o���
							if (myForm.getConvertKind().equals("3")){
								//���u�P���ŷ���
								ddetMap.put("account_code","37");
							}else if (myForm.getConvertKind().equals("4")){
								//���u�P���ŵo�榨��
								ddetMap.put("account_code","225");
							}
							
						}
						
						//���
						if (myForm.getConvertType().equals("B")){
							//����o���
							if (myForm.getConvertKind().equals("3")){
								//���u�P���ŧ��
								ddetMap.put("account_code","33");
							}else if (myForm.getConvertKind().equals("4")){
								//���u�P���ŵo�榨��
								ddetMap.put("account_code","225");
							}
							
						}
						System.out.println("account_code�G"+ddetMap.get("account_code"));
						
						//�w�ﷸ����B�z���|�p�ǲ����B
						if (myForm.getConvertKind().equals("3")){
							BigDecimal amouont = (BigDecimal)tMap.get("amount");
							amouont = amouont.setScale(0,BigDecimal.ROUND_DOWN);
							ddetMap.put("account_amount",amouont);
//							ddetMap.put("account_amount",(BigDecimal)tMap.get("amount"));
						//�w��o�榨���B���|�p�ǲ����B
						}else if (myForm.getConvertKind().equals("4")){
							BigDecimal accountAmount = (BigDecimal)tMap.get("issue_cost_amount");
							accountAmount = accountAmount.setScale(0,BigDecimal.ROUND_DOWN);
							ddetMap.put("account_amount",accountAmount);
//							ddetMap.put("account_amount",(BigDecimal)tMap.get("issue_cost_amount"));
						}
						
						System.out.println("account_amount�G"+ddetMap.get("account_amount"));
					
						ddetMap.put("account_type","C");
						System.out.println("account_type�G"+ddetMap.get("account_type"));
					
						run.update(connection,insTemp("voucher_det",ddetMap));
					
					
					}
				}
	
			}

		}
		
		setAlertMessage(request,"��J���\!");
		
	}

}
