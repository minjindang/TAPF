/**
 * @author Andrew Sung
 * @create 2006/4/3
 */

package tw.gov.nta.debt.form;

import gov.dnt.tame.common.LabelValueBean;
import gov.dnt.tame.common.SupportForm;
import gov.dnt.tame.util.ListToolManager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Apra2001Form extends SupportForm
{
	private static final long serialVersionUID = 1L;

	private String payYear;
	private String debtName;
	private Integer issueId;

	public String getDebtName() {
		return debtName;
	}

	public void setDebtName(String debtName) {
		this.debtName = debtName;
	}

	public Integer getIssueId() {
		return issueId;
	}

	public void setIssueId(Integer issueId) {
		this.issueId = issueId;
	}

	public String getPayYear()
	{
		return payYear;
	}

	public void setPayYear(String payYear)
	{
		this.payYear = payYear;
	}
	public List getDebtNameList()
	{
		List<LabelValueBean> labelValueBeanList = new LinkedList<LabelValueBean>();
		String[] label = new String[]{"55C","56C","57A","57C","58A","59A","60A","61A","62A","64B","70B","71B","72B","73B","74B","75B","76B","77B","78B","80B","81B","82B","83B","84B","85B","86B","BAB","BCB","BDB��","BDB�A"};
		String[] valuess = new String[]{"���Q���~�׷R�ꤽ��","���Q���~�׷R�ꤽ��","���Q�C�~�פ���","���Q�C�~�׷R�ꤽ��","���Q�K�~�פ���","���Q�E�~�פ���","���Q�~�פ���","���Q�@�~�פ���","���Q�G�~�פ���","�����F���س]����64�~�פ���","�����F���س]����70�~�פ���","�����F���س]����71�~�פ���","�����F���س]����72�~�פ���","�����F���س]����73�~�פ���","�����F���س]����74�~�פ���","�����F���س]����75�~�פ���","�����F���س]����76�~�פ���","�����F���س]����77�~�פ���","�����F���س]����78�~�פ���","�����F���س]����80�~�פ���","�����F���س]����81�~�פ���","�����F���س]����82�~�פ���","�����F���س]����83�~�פ���","�����F���س]����84�~�פ���","�����F���س]����85�~�פ���","�����F���س]����86�~�פ���","���t�����Ų�","�_�G���Ų�","�����F�����j��q�س]����(����)","�����F�����j��q�س]����(�A��)"};
		for(int i = 0; i< valuess.length;i++){
//			Map map = new HashMap();
//			map.put("valuess", valuess[i]);
//			map.put("label", valuess[i]+"   "+label[i]);
			
			labelValueBeanList.add(new LabelValueBean( label[i].toString(), valuess[i].toString() ));
		}	
		System.out.println(labelValueBeanList);
		return labelValueBeanList;
        //return ListToolManager.getList("select id , debtName from IssueMain where debtType = 'A' order by debtType , issueSerial , debtName , accountYear asc ");
	}
}
