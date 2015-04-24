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

	//補以過往發行時的傳票主檔(voucher_main)
	protected SQLJob SQL1(ActionForm form){
		
		Eare1401Form myForm = (Eare1401Form) form;
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select RTRIM(a.debt_name) as debt_name, RTRIM(b.debt_serial) as debt_serial, a.source_issue_id as source_issue_id, b.issue_id as issue_id, b.id as debt_id,  ");
		sqljob.appendSQL("b.budget_code as budget_code, b.debt_code as debt_code, "); 
		sqljob.appendSQL("1 as debt_type_id, a.issue_kind as issue_kind, 'DebtMain' as source_type, ");
		
		//溢價
		if (myForm.getConvertType().equals("A")){
			//溢價發行時
			sqljob.appendSQL("182 as phase_id, ");
			//針對溢折價diversity_amount
			if (myForm.getConvertKind().equals("3")){
				sqljob.appendSQL(" (b.diversity_amount) as amount, ");
			//針對發行成本額issue_cost_amount
			}else if (myForm.getConvertKind().equals("4")){
				sqljob.appendSQL(" b.issue_cost_amount as issue_cost_amount, ");
			}
		}
		
		//折價
		if (myForm.getConvertType().equals("B")){
			//折價發行時
			sqljob.appendSQL("180 as phase_id, ");
			//針對溢折價diversity_amount
			if (myForm.getConvertKind().equals("3")){
				sqljob.appendSQL(" (0 - b.diversity_amount) as amount, ");
			//針對發行成本額issue_cost_amount
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
		System.out.println("EARE14-補以過往發行時的傳票主檔SQL1----::"+sqljob.toString());
		return sqljob;
		
	}
	
	//查詢傳票主檔ID
	protected SQLJob SQL2(String voucherNo){
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select id from voucher_main where voucher_no='"+voucherNo+"'");
		System.out.println("EARE14-SQL2-::"+sqljob.toString());
		return sqljob;
	}
	
	//補過往已攤銷的傳票主檔(voucher_main)
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
		
		//溢價
		if (myForm.getConvertType().equals("A")){
			//溢價攤銷時
			sqljob.appendSQL("181 as phase_id, ");
			if (myForm.getConvertKind().equals("3")){
				//針對溢折價
				sqljob.appendSQL(" ((b.diversity_amount / a.interest_alternate) * ");
				sqljob.appendSQL(" (select Max(d.interest_serial) from debt_plan_det d " +
//						"where d.debt_id = b.id and d.repay_date < '2007/06/30')) as amount");
						"where d.debt_id = b.id and d.repay_date <'"+myForm.getConvertDate()+"')) as amount");
			}else if (myForm.getConvertKind().equals("4")){
				//針對發行成本額
				sqljob.appendSQL(" ((b.issue_cost_amount / a.interest_alternate) * ");
				sqljob.appendSQL(" (select Max(d.interest_serial) from debt_plan_det d " +
//					"where d.debt_id = b.id and d.repay_date < '2007/06/30')) as issue_cost_amount");
					"where d.debt_id = b.id and d.repay_date < '"+myForm.getConvertDate()+"')) as issue_cost_amount");
			}
		}
		
		//折價
		if (myForm.getConvertType().equals("B")){
			//折價攤銷時
			sqljob.appendSQL("183 as phase_id, ");
			if (myForm.getConvertKind().equals("3")){
//				sqljob.appendSQL(" (((0 - b.diversity_amount) / a.interest_alternate) * ");
				//針對溢折價
				sqljob.appendSQL("(((b.issue_amount - b.real_amount + b.payable_interest_amount) / a.interest_alternate) * ");
				sqljob.appendSQL(" (select Max(d.interest_serial) from debt_plan_det d " +
//					"where d.debt_id = b.id and d.repay_date < '2007/06/30')) as amount");
					"where d.debt_id = b.id and d.repay_date < '"+myForm.getConvertDate()+"')) as amount");
			}else if (myForm.getConvertKind().equals("4")){
//				sqljob.appendSQL(" ((b.issue_cost_amount / a.interest_alternate) * ");
				//針對發行成本額
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
		System.out.println("EARE14-補過往已攤銷的傳票主檔SQL3-::"+sqljob.toString());
		return sqljob;
	}
	
	//補過往已攤銷的傳票，查詢傳票主檔ID
	protected SQLJob SQL4(String voucherNo){
		
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select id from voucher_main where voucher_no='"+voucherNo+"'");
		System.out.println("EARE14-SQL4-::"+sqljob.toString());
		return sqljob;
	}
	
	//預算別名稱
	protected SQLJob SQL5(Integer debtCode){
		SQLJob sqljob = new SQLJob();
		sqljob.appendSQL("select debit_name from debit_ref where id ="+debtCode);
		return sqljob;
	}
	
	@Override
	public void executeQuery(ActionForm form, HttpServletRequest request, Connection connection) throws Exception {
		// TODO Auto-generated method stub
		
		Eare1401Form myForm = (Eare1401Form) form;
		
		//取得使用者帳號
		String usrId = this.getUserId(request);
		//取得SQLRunner		
		SQLRunner run = new ConnectionSQLRunner(connection); 
		
		//執行insert
//		List tList = null;
		List tList = new ArrayList();
		System.out.println(myForm.getConvertDate());
		//判斷是發行或是攤銷，1為發行，2為攤銷
		if (myForm.getConvertTiming().equals("1")){
			tList = (List) run.query(SQL1(myForm), new MapListHandler());
		}else if (myForm.getConvertTiming().equals("2")){
			tList = (List) run.query(SQL3(myForm), new MapListHandler());
		}
		
		Map tMap = null;
		
		Integer i = 1;
		Integer issue_id = 0;
		
		//資料Map
		for(Iterator tIterator = tList.iterator(); tIterator.hasNext(); )
		{
			tMap = (Map) tIterator.next();
			Map dMap = new HashMap();
			
			System.out.println("voucherMain==================================");
			//發行公債ID
			dMap.put("issue_id",(Integer)tMap.get("source_issue_id"));			
			System.out.println("期別："+dMap.get("issue_id"));
			
			if (issue_id.equals((Integer)tMap.get("issue_id"))){
				i = i+1;
				System.out.println("i ： "+i);
			}else{
				i = 1;
				System.out.println("不同期公債 i ： "+i);
			}
			
			//傳票編號
			//判斷是發行或是攤銷，1為發行，2為攤銷
			if (myForm.getConvertTiming().equals("1")){
				dMap.put("voucher_no",(String)tMap.get("debt_serial")+"000DP");
			}else if (myForm.getConvertTiming().equals("2")){
				dMap.put("voucher_no",(String)tMap.get("debt_serial")+"000DU");
			}
			System.out.println("傳票編號："+dMap.get("voucher_no"));
			
			//重新指定issue_id
			issue_id = (Integer)tMap.get("issue_id");

			//債務別
			dMap.put("budget_code",(Integer)tMap.get("budget_code"));
			System.out.println("債務別："+dMap.get("budget_code"));
			
			//預算別
			Integer debtCode = (Integer)tMap.get("debt_code");
			dMap.put("debt_code",debtCode);
			System.out.println("預算別："+dMap.get("debt_code"));
			
			//種類為公債
			dMap.put("debt_type_id",(Integer)tMap.get("debt_type_id"));
			System.out.println("債種為公債："+dMap.get("debt_type_id"));
			
			//傳票來源
			dMap.put("source_type",(String)tMap.get("source_type"));
			System.out.println("傳票來源："+dMap.get("source_type"));
			
			//會計階段
			dMap.put("phase_id",(Integer)tMap.get("phase_id"));
			System.out.println("會計階段："+dMap.get("phase_id"));
			
			//溢折價金額
//			dMap.put("amount",(BigDecimal)tMap.get("amount"));
			System.out.println("溢折價金額："+tMap.get("amount"));
			
			//發行成本金額
//			dMap.put("issue_cost_amount",(BigDecimal)tMap.get("issue_cost_amount"));
			System.out.println("發行成本金額："+tMap.get("issue_cost_amount"));	
			
			//voucher_type
			dMap.put("voucher_type",(Integer)tMap.get("voucher_type"));
			System.out.println("voucher_type："+dMap.get("voucher_type"));
			
			//傳票日期
//			if (myForm.getConvertTiming().equals("1")){
//				dMap.put("voucher_date",(Date)tMap.get("voucher_date"));
//			}else{
//				dMap.put("voucher_date",DateUtil.str2Date((String)tMap.get("voucher_date")));				
//			}
			dMap.put("voucher_date",DateUtil.str2Date("20081231"));
			System.out.println("傳票日期："+dMap.get("voucher_date"));
			
			//是否刪除
			dMap.put("is_delete",(String)tMap.get("is_delete"));
			System.out.println("是否刪除："+dMap.get("is_delete"));
			
			dMap.put("usr_id",(String)tMap.get("usr_id"));
			System.out.println("使用者："+dMap.get("usr_id"));
			
			dMap.put("mod_date",(String)tMap.get("mod_date"));
			System.out.println("修改時間："+dMap.get("mod_date"));
			
			dMap.put("issue_kind",(String)tMap.get("issue_kind"));
			System.out.println("issue_kind："+dMap.get("issue_kind"));
			
			dMap.put("voucher_ser",(Integer)tMap.get("voucher_ser"));
			System.out.println("voucher_ser："+dMap.get("voucher_ser"));
			
			List debtNameList = (List)run.query(SQL5(debtCode), new MapListHandler());
			Map debtNameMap = (Map)debtNameList.get(0);
			dMap.put("remark",(String)tMap.get("debt_name")+"("+(String)debtNameMap.get("debit_name")+")"+"，配合GBA系統轉入傳票");
			System.out.println("remark："+dMap.get("remark"));
			
			//過帳日期
			dMap.put("post_date",(String)tMap.get("post_date"));
			System.out.println("過帳日期："+dMap.get("post_date"));
			
			//過帳人員
			dMap.put("post_usr",(String)tMap.get("post_usr"));
			System.out.println("過帳人員："+dMap.get("post_usr"));
			
			if ((BigDecimal)tMap.get("issue_cost_amount") != null || (BigDecimal)tMap.get("amount") != null ){

				//寫入傳票主檔voucher_main
				List mainList = new ArrayList();
				mainList = (List)run.query(SQL2((String)dMap.get("voucher_no")), new MapListHandler());
				if (mainList.isEmpty())
					run.update(connection,insTemp("voucher_main",dMap));
				
				//查詢傳票主檔ID
				List dList = new ArrayList();
				if (myForm.getConvertTiming().equals("1")){
					dList = (List) run.query(SQL2((String)dMap.get("voucher_no")), new MapListHandler());
				}else if (myForm.getConvertTiming().equals("2")){
					dList = (List) run.query(SQL4((String)dMap.get("voucher_no")), new MapListHandler());
				}
				
				
				Map detMap = null;

				//發行期初傳票明細
				if (myForm.getConvertTiming().equals("1")){
					
					for(Iterator detIterator = dList.iterator(); detIterator.hasNext(); )
					{
						detMap = (Map) detIterator.next();
						Map ddetMap = new HashMap();
					
						System.out.println("voucherDet借方==================================");
						ddetMap.put("voucher_id",(Integer)detMap.get("id"));
						System.out.println("issue_kind："+ddetMap.get("voucher_id"));
						
						//溢價
						if (myForm.getConvertType().equals("A")){
							//溢價發行時
							if (myForm.getConvertKind().equals("3")){
								//公債溢價
								ddetMap.put("account_code","37");
							}else if (myForm.getConvertKind().equals("4")){
								//遞延費用
								ddetMap.put("account_code","225");
							}
							
						}
						
						//折價
						if (myForm.getConvertType().equals("B")){
							//折價發行時
							if (myForm.getConvertKind().equals("3")){
								//公債折價
								ddetMap.put("account_code","33");
							}else if (myForm.getConvertKind().equals("4")){
								//遞延費用
								ddetMap.put("account_code","225");
							}
							
						}
						System.out.println("account_code："+ddetMap.get("account_code"));
						
						//針對溢折價處理的會計傳票金額
						if (myForm.getConvertKind().equals("3")){
							BigDecimal amount = (BigDecimal)tMap.get("amount");
							amount = amount.setScale(0,BigDecimal.ROUND_DOWN);
							ddetMap.put("account_amount",amount);
//							ddetMap.put("account_amount",(BigDecimal)tMap.get("amount"));
						//針對發行成本額的會計傳票金額
						}else if (myForm.getConvertKind().equals("4")){
							BigDecimal accountAmount = (BigDecimal)tMap.get("issue_cost_amount");
							accountAmount = accountAmount.setScale(0,BigDecimal.ROUND_DOWN);
							ddetMap.put("account_amount",accountAmount);
//							ddetMap.put("account_amount",(BigDecimal)tMap.get("issue_cost_amount"));
						}
						
						System.out.println("account_amount："+ddetMap.get("account_amount"));
					
						ddetMap.put("account_type","D");
						System.out.println("account_type："+ddetMap.get("account_type"));
					
						run.update(connection,insTemp("voucher_det",ddetMap));
					
						System.out.println("voucherDet貸方==================================");
						ddetMap = new HashMap();
					
						ddetMap.put("voucher_id",(Integer)detMap.get("id"));
						System.out.println("issue_kind："+ddetMap.get("voucher_id"));
						
						//溢價
						if (myForm.getConvertType().equals("A")){
							//溢價發行時
							if (myForm.getConvertKind().equals("3")){
								//未攤銷公債溢價
								ddetMap.put("account_code","223");
							}else if (myForm.getConvertKind().equals("4")){
								//未攤銷公債發行成本
								ddetMap.put("account_code","226");
							}
							
						}
						
						//折價
						if (myForm.getConvertType().equals("B")){
							//折價發行時
							if (myForm.getConvertKind().equals("3")){
								//未攤銷公債折價
								ddetMap.put("account_code","224");
							}else if (myForm.getConvertKind().equals("4")){
								//未攤銷公債發行成本
								ddetMap.put("account_code","226");
							}
							
						}
						System.out.println("account_code："+ddetMap.get("account_code"));
						
						//針對溢折價處理的會計傳票金額
						if (myForm.getConvertKind().equals("3")){
							BigDecimal amount = (BigDecimal)tMap.get("amount");
							amount = amount.setScale(0,BigDecimal.ROUND_DOWN);
							ddetMap.put("account_amount",amount);
//							ddetMap.put("account_amount",(BigDecimal)tMap.get("amount"));
						//針對發行成本額的會計傳票金額
						}else if (myForm.getConvertKind().equals("4")){
							BigDecimal accountAmount = (BigDecimal)tMap.get("issue_cost_amount");
							accountAmount = accountAmount.setScale(0,BigDecimal.ROUND_DOWN);
							ddetMap.put("account_amount",accountAmount);
//							ddetMap.put("account_amount",(BigDecimal)tMap.get("issue_cost_amount"));
						}
						
						System.out.println("account_amount："+ddetMap.get("account_amount"));
						
						ddetMap.put("account_type","C");
						System.out.println("account_type："+ddetMap.get("account_type"));
					
						run.update(connection,insTemp("voucher_det",ddetMap));					
					}
				}
				
			

				
				//攤銷各期已過傳票明細
				if (myForm.getConvertTiming().equals("2")){
					//寫入傳票明細
					for(Iterator detIterator = dList.iterator(); detIterator.hasNext(); )
					{
						detMap = (Map) detIterator.next();
						Map ddetMap = new HashMap();
					
						System.out.println("voucherDet借方==================================");
						ddetMap.put("voucher_id",(Integer)detMap.get("id"));
						System.out.println("issue_kind："+ddetMap.get("voucher_id"));
						//溢價
						if (myForm.getConvertType().equals("A")){
							//溢價發行時
							if (myForm.getConvertKind().equals("3")){
								//公債溢價
								ddetMap.put("account_code","223");
							}else if (myForm.getConvertKind().equals("4")){
								//遞延費用
								ddetMap.put("account_code","226");
							}
							
						}
						
						//折價
						if (myForm.getConvertType().equals("B")){
							//折價發行時
							if (myForm.getConvertKind().equals("3")){
								//公債折價
								ddetMap.put("account_code","224");
							}else if (myForm.getConvertKind().equals("4")){
								//遞延費用
								ddetMap.put("account_code","226");
							}
							
						}
						System.out.println("account_code："+ddetMap.get("account_code"));
						
						//針對溢折價處理的會計傳票金額
						if (myForm.getConvertKind().equals("3")){
							BigDecimal amount = (BigDecimal)tMap.get("amount");
							amount = amount.setScale(0,BigDecimal.ROUND_DOWN);
							ddetMap.put("account_amount",amount);
//							ddetMap.put("account_amount",(BigDecimal)tMap.get("amount"));
						//針對發行成本額的會計傳票金額
						}else if (myForm.getConvertKind().equals("4")){
							BigDecimal accountAmount = (BigDecimal)tMap.get("issue_cost_amount");
							accountAmount = accountAmount.setScale(0,BigDecimal.ROUND_DOWN);
							ddetMap.put("account_amount",accountAmount);
//							ddetMap.put("account_amount",(BigDecimal)tMap.get("issue_cost_amount"));
						}
						
						System.out.println("account_amount："+ddetMap.get("account_amount"));
					
						ddetMap.put("account_type","D");
						System.out.println("account_type："+ddetMap.get("account_type"));
					
						run.update(connection,insTemp("voucher_det",ddetMap));
					
						System.out.println("voucherDet貸方==================================");
						ddetMap = new HashMap();
					
						ddetMap.put("voucher_id",(Integer)detMap.get("id"));
						System.out.println("issue_kind："+ddetMap.get("voucher_id"));
						//溢價
						if (myForm.getConvertType().equals("A")){
							//溢價發行時
							if (myForm.getConvertKind().equals("3")){
								//未攤銷公債溢價
								ddetMap.put("account_code","37");
							}else if (myForm.getConvertKind().equals("4")){
								//未攤銷公債發行成本
								ddetMap.put("account_code","225");
							}
							
						}
						
						//折價
						if (myForm.getConvertType().equals("B")){
							//折價發行時
							if (myForm.getConvertKind().equals("3")){
								//未攤銷公債折價
								ddetMap.put("account_code","33");
							}else if (myForm.getConvertKind().equals("4")){
								//未攤銷公債發行成本
								ddetMap.put("account_code","225");
							}
							
						}
						System.out.println("account_code："+ddetMap.get("account_code"));
						
						//針對溢折價處理的會計傳票金額
						if (myForm.getConvertKind().equals("3")){
							BigDecimal amouont = (BigDecimal)tMap.get("amount");
							amouont = amouont.setScale(0,BigDecimal.ROUND_DOWN);
							ddetMap.put("account_amount",amouont);
//							ddetMap.put("account_amount",(BigDecimal)tMap.get("amount"));
						//針對發行成本額的會計傳票金額
						}else if (myForm.getConvertKind().equals("4")){
							BigDecimal accountAmount = (BigDecimal)tMap.get("issue_cost_amount");
							accountAmount = accountAmount.setScale(0,BigDecimal.ROUND_DOWN);
							ddetMap.put("account_amount",accountAmount);
//							ddetMap.put("account_amount",(BigDecimal)tMap.get("issue_cost_amount"));
						}
						
						System.out.println("account_amount："+ddetMap.get("account_amount"));
					
						ddetMap.put("account_type","C");
						System.out.println("account_type："+ddetMap.get("account_type"));
					
						run.update(connection,insTemp("voucher_det",ddetMap));
					
					
					}
				}
	
			}

		}
		
		setAlertMessage(request,"轉入成功!");
		
	}

}
