package gov.dnt.tame.util;
/**
 * SendMailException.java is a simple exception class used by SendMail.java
 *
 * @version     1.0
 * @author Kavitha Lopendrakumar
 *
 */
public class SendMailException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * Class constructor
	 * This constructor calls the super class constructor to pass the error message
	 */
	public SendMailException(String exceptionMessage)
	{
		super(exceptionMessage);
	}
}