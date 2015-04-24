package gov.dnt.tame.common;

import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class FileUploadForm extends ActionForm
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3963523614475663509L;
	private FormFile uploadFile = null;
	
	/**
	 * @return
	 */
	public FormFile getUploadFile() {
		return uploadFile;
	}

	/**
	 * @param file
	 */
	public void setUploadFile(FormFile file) {
		uploadFile = file;
	}

}
