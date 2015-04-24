package tw.gov.nta.surplusage.form;

import gov.dnt.tame.common.SupportForm;

public class Gara3501Form extends SupportForm {
	private static final long serialVersionUID = 1L;
	private String year;//統計年度

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		if (year.length()<3 && !"".equals(year.trim())){
			if(year.length()<2)
				year = "00"+year;
			else
				year = "0"+year;
		}
		this.year = year.trim();
	}
	
	
}
