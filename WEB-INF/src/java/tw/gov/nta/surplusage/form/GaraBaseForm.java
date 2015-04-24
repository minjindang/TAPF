package tw.gov.nta.surplusage.form;

import java.util.Date;

import tw.gov.nta.sql.debt.GaraNote;
import gov.dnt.tame.common.SupportForm;

public class GaraBaseForm extends SupportForm {
	private GaraNote garaNote = new GaraNote();

	public GaraNote getGaraNote() {
		return garaNote;
	}

	public void setGaraNote(GaraNote garaNote) {
		this.garaNote = garaNote;
	}

	public Integer getId() {
		return garaNote.getId();
	}

	public String getMemo() {
		return garaNote.getMemo();
	}

	public Date getModDate() {
		return garaNote.getModDate();
	}

	public String getPath() {
		return garaNote.getPath();
	}

	public String getUsrid() {
		return garaNote.getUsrid();
	}

	public void setId(Integer id) {
		garaNote.setId(id);
	}

	public void setMemo(String meno) {
		garaNote.setMemo(meno);
	}

	public void setModDate(Date modDate) {
		garaNote.setModDate(modDate);
	}

	public void setPath(String path) {
		garaNote.setPath(path);
	}

	public void setUsrid(String usrid) {
		garaNote.setUsrid(usrid);
	}
	
}
