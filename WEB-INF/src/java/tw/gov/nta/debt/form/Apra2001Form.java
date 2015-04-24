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
		String[] label = new String[]{"55C","56C","57A","57C","58A","59A","60A","61A","62A","64B","70B","71B","72B","73B","74B","75B","76B","77B","78B","80B","81B","82B","83B","84B","85B","86B","BAB","BCB","BDB甲","BDB乙"};
		String[] valuess = new String[]{"五十五年度愛國公債","五十六年度愛國公債","五十七年度公債","五十七年度愛國公債","五十八年度公債","五十九年度公債","六十年度公債","六十一年度公債","六十二年度公債","中央政府建設公債64年度公債","中央政府建設公債70年度公債","中央政府建設公債71年度公債","中央政府建設公債72年度公債","中央政府建設公債73年度公債","中央政府建設公債74年度公債","中央政府建設公債75年度公債","中央政府建設公債76年度公債","中央政府建設公債77年度公債","中央政府建設公債78年度公債","中央政府建設公債80年度公債","中央政府建設公債81年度公債","中央政府建設公債82年度公債","中央政府建設公債83年度公債","中央政府建設公債84年度公債","中央政府建設公債85年度公債","中央政府建設公債86年度公債","高速公路債票","北二高債票","中央政府重大交通建設公債(甲類)","中央政府重大交通建設公債(乙類)"};
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
