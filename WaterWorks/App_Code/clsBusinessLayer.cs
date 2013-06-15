using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
// **** Add the following at the top of the class file, 
// Link to the namespace classes in the .Net framework for sending email
using System.Net.Mail;

/// <summary>
/// Summary description for clsBusinessLayer
/// </summary>
public class clsBusinessLayer
{

    //**** Add the following code inside the body of public class clsBusinessLayer ****

    public static bool SendEmail(string Sender, string Recipient, string bcc, string cc,
    string Subject, string Body)
    {
        try
        {

            // Instantiate an email message from the MailMessage class in the 
            //System.Net.Mail namespace
            MailMessage MyMailMessage = new MailMessage();

            // Set the from or sending address in the email that will be sent
            // by setting it to a MailAddress object containing the sender's address
            MyMailMessage.From = new MailAddress(Sender);

            // Set the to or recipient address in the email that will be sent
            // by setting it to a MailAddress object containing the recipient's address
            MyMailMessage.To.Add(new MailAddress(Recipient));

            // If a blind carbon copy is specified and the address is provided,
            // then set the bcc address to a MailAddress object containing the bcc address
            if (bcc != null && bcc != string.Empty)
            {
                // This sets the bcc address when it is specified
                MyMailMessage.Bcc.Add(new MailAddress(bcc));
            }

            // If a carbon copy is specified and the address is provided,
            // then set the cc address to a MailAddress object containing the cc address
            if (cc != null && cc != string.Empty)
            {
                // This sets the cc address when it is specified
                MyMailMessage.CC.Add(new MailAddress(cc));
            }

            // Set the subject of the email by using the MailMessage set subject method
            MyMailMessage.Subject = Subject;

            // Set the body of the email by using the MailMessage set body method
            MyMailMessage.Body = Body;

            // Specify that the body of the message should be renderable in html
            MyMailMessage.IsBodyHtml = true;

            // Set the priority of the email to normal
            MyMailMessage.Priority = MailPriority.Normal;

            // Instantiate an SmtpClient
            SmtpClient MySmtpClient = new SmtpClient();

            // Specify the port and host IP for the SmtpClient to use
            MySmtpClient.Port = 25;
            MySmtpClient.Host = "smtp.mail.yahoo.com";

            // Send the email we "builet" above, contained in the 
            // MyMailMessage MailMessage object (code commented out if iis not available)
            //MySmtpClient.Send(MyMailMessage);

            // If the "try" portion above works (ie, no error or exception detected), then
            // end the method by returning a true boolean value
            return true;
        }
        catch (Exception ex)
        {

            // If the "try" portion doesn't work (ie, has an error or exception), then
            // end the method by returning a false boolean value
            return false;
        }

    }


	public clsBusinessLayer()
	{
		//
		// TODO: Add constructor logic here
		//
	}
}