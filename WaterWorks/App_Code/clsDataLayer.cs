using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
// Add following classes from .NET framework to 
// allow using database and dataset
using System.Data.OleDb;
using System.Net;
using System.Data;


/// <summary>
/// Summary description for clsDataLayer
/// </summary>
public class clsDataLayer
{
    // This function saves the new user data
    public static bool SaveUser(string Database, string UserName, string Password, string SecurityLevel)
    {
        bool recordSaved;

        // Create a transaction object to start the transaction session and initialize it to "null"
        OleDbTransaction myTransaction = null;

        try
        {
            // Create a data base connection object and open the connection
            OleDbConnection conn = new OleDbConnection("PROVIDER=Microsoft.Jet.OLEDB.4.0;" +
                                                       "Data Source=" + Database);
            conn.Open();

            // Create a data base command object to hold the SQL query command
            OleDbCommand command = conn.CreateCommand();
            string strSQL;

            // Mark the beginning of the transaction
            myTransaction = conn.BeginTransaction();
            command.Transaction = myTransaction;

            // Create the first SQL query string command to insert just the user name & password
            strSQL = "Insert into tblUserLogin " +
                     "(UserName, UserPassword, SecurityLevel) values ('" +
                     UserName + "', '" + Password + "', '" + SecurityLevel + "')";

            // Set the command object command type to text, then set it to the string command above
            command.CommandType = CommandType.Text;
            command.CommandText = strSQL;

            // Execute the SQL query command that we created
            command.ExecuteNonQuery();


            // Mark the end of the transaction by saving or "commit" my transaction 
            // if all SQL queries executed correctly
            myTransaction.Commit();

            // close the data base connection
            conn.Close();

            // Tell the user that the record saved correctly
            recordSaved = true;
        }

        catch
        {
            // Undo or "rollback" my transaction if any of my SQL queries didn't execute correctly
            myTransaction.Rollback();

            // Tell the user that the record did not save correctly
            recordSaved = false;
        }
        
        // Return the value to display the correct message to user
        return recordSaved;
     }


    // This function verifies a user in the tblUser table exists
    public static dsUser VerifyUser(string Database, string UserName, string UserPassword)
    {
        // Allocate memory for dsUser dataset, connection, and data adaptor objects
        dsUser DS;
        OleDbConnection sqlConn;
        OleDbDataAdapter sqlDA;

        // Make a connection to the database
        sqlConn = new OleDbConnection("PROVIDER=Microsoft.Jet.OLEDB.4.0;" +
                                      "Data Source=" + Database);

        // Instantiate and import the information from the login form into the data adaptor object
        sqlDA = new OleDbDataAdapter("Select SecurityLevel from tblUserLogin " +
                                      "where UserName like '" + UserName + "' " +
                                      "and UserPassword like '" + UserPassword + "'", sqlConn);

        // Instantiate the dataset object
        DS = new dsUser();

        // Put the imported information into the dataset table
        sqlDA.Fill(DS.tblUserLogin);

        // Send the dataset back to the calling form for display
        return DS;

    }

    // This function saves the personnel data
    public static bool SavePersonnel(string Database, string FirstName, string LastName,
                                     string PayRate, string StartDate, string EndDate)
    {
        bool recordSaved;

        // Create a transaction object to start the transaction session and initialize it to "null"
        OleDbTransaction myTransaction = null;

        try
        {
            // Create a data base connection object and open the connection
            OleDbConnection conn = new OleDbConnection("PROVIDER=Microsoft.Jet.OLEDB.4.0;" +
                                                       "Data Source=" + Database);
            conn.Open();

            // Create a data base command object to hold the SQL query command
            OleDbCommand command = conn.CreateCommand();
            string strSQL;

            // Mark the beginning of the transaction
            myTransaction = conn.BeginTransaction();
            command.Transaction = myTransaction;

            // Create the first SQL query string command to insert just the first & last names
            strSQL = "Insert into tblPersonnel " +
                     "(FirstName, LastName) values ('" +
                     FirstName + "', '" + LastName + "')";

            // Set the command object command type to text, then set it to the string command above
            command.CommandType = CommandType.Text;
            command.CommandText = strSQL;

            // Execute the SQL query command that we created
            command.ExecuteNonQuery();

            // Create the second SQL query string command to update the record with the remaining data
            strSQL = "Update tblPersonnel " +
                     "Set PayRate=" + PayRate + ", " +
                     "StartDate='" + StartDate + "', " +
                     "EndDate='" + EndDate + "' " +
                     "Where ID=(Select Max(ID) From tblPersonnel)";

            // Set the command object command type to text, then set it to the string command above
            command.CommandType = CommandType.Text;
            command.CommandText = strSQL;

            // Execute the SQL query command that we created
            command.ExecuteNonQuery();

            // Mark the end of the transaction by saving or "commit" my transaction 
            // if all SQL queries executed correctly
            myTransaction.Commit();
            
            // close the data base connection
            conn.Close();

            // Tell the user that the record saved correctly
            recordSaved = true;
        }
        catch (Exception ex)
        {
            // Undo or "rollback" my transaction if any of my SQL queries didn't execute correctly
            myTransaction.Rollback();
            
            // Tell the user that the record did not save correctly
            recordSaved = false;
        }

        // Return the value to display the correct message to user
        return recordSaved;
    }

    // This function gets the user activity from the tblUserActivity
    public static dsUserActivity GetUserActivity(string Database)
    {
        // Decare object variables to allocate memory
        dsUserActivity DS;
        OleDbConnection sqlConn;
        OleDbDataAdapter sqlDA;

        // Instantiate an OleDbConnection object called "sqlConn"
        sqlConn = new OleDbConnection("PROVIDER=Microsoft.Jet.OLEDB.4.0;" +
            "Data Source=" + Database);

        // Instantiate an OleDbDataAdapter object called "sqlDA" and pass it a SQL command
        sqlDA = new OleDbDataAdapter("select * from tblUserActivity", sqlConn);

        // Instantiate a dsUserActivity object called "DS"
        DS = new dsUserActivity();

        // Call to the sqlDA method called "Fill" passing the DS object as an argument,
        // passing the table User Activity with it
        sqlDA.Fill(DS.tblUserActivity);

        // Return the DS dataset object
        return DS;
    }

    // This function saves the user activity
    public static void SaveUserActivity(string Database, string FormAccessed)
    {
        // The following block of code instantiates an OldDbConnection object called "conn",
        // then opens the connection to the database, creates a SQL command, executes the
        // SQL command, and then closes the connection.
        OleDbConnection conn = new OleDbConnection("PROVIDER=Microsoft.Jet.OLEDB.4.0;" +
            "Data Source=" + Database);
        conn.Open();
        OleDbCommand command = conn.CreateCommand();
        string strSQL;

        strSQL = "Insert into tblUserActivity (UserIP, FormAccessed) values ('" +
            GetIP4Address() + "', '" + FormAccessed + "')";

        command.CommandType = CommandType.Text;
        command.CommandText = strSQL;
        command.ExecuteNonQuery();
        conn.Close();
    }

    // This function gets the personnel data from the tblPersonnel
    public static dsPersonnel GetPersonnel(string Database,string strSearch)
    {
        // Decare object variables to allocate memory
        dsPersonnel DS;
        OleDbConnection sqlConn;
        OleDbDataAdapter sqlDA;

        // Instantiate an OleDbConnection object called "sqlConn"
        sqlConn = new OleDbConnection("PROVIDER=Microsoft.Jet.OLEDB.4.0;" +
            "Data Source=" + Database);

        // Instantiate an OleDbDataAdapter object called "sqlDA" and pass it a SQL command
        //(next line commented out for search capability)
        //sqlDA = new OleDbDataAdapter("select * from tblPersonnel", sqlConn);

        // New code added for search capability
        // If nothing is entered in the search box, then return all personnel
        if (strSearch == null || strSearch.Trim() == "")
        {
            sqlDA = new OleDbDataAdapter("select * from tblPersonnel", sqlConn);
        }
        // O'wise, return only personnel with last name entered
        else
        {
            sqlDA = new OleDbDataAdapter("select * from tblPersonnel where LastName = '" + 
                strSearch + "'", sqlConn);
        }

        // Instantiate a dsPersonnel object called "DS"
        DS = new dsPersonnel();

        // Call to the sqlDA method called "Fill" passing the DS object as an argument,
        // passing the table Personnel with it
        sqlDA.Fill(DS.tblPersonnel);

        // Return the DS dataset object
        return DS;
    }

    // This function gets the IP Address
    public static string GetIP4Address()
    {
        string IP4Address = string.Empty;

        foreach (IPAddress IPA in
                    Dns.GetHostAddresses(HttpContext.Current.Request.UserHostAddress))
        {
            if (IPA.AddressFamily.ToString() == "InterNetwork")
            {
                IP4Address = IPA.ToString();
                break;
            }
        }

        if (IP4Address != string.Empty)
        {
            return IP4Address;
        }

        foreach (IPAddress IPA in Dns.GetHostAddresses(Dns.GetHostName()))
        {
            if (IPA.AddressFamily.ToString() == "InterNetwork")
            {
                IP4Address = IPA.ToString();
                break;
            }
        }

        return IP4Address;
    }


	public clsDataLayer()
	{
		//
		// TODO: Add constructor logic here
		//
	}
}