using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.Security;
using Luxand;


public partial class Pages_Default : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    public void Upload(object sender, EventArgs e)
    {

        string FilePath = myFile.PostedFile.FileName;
        int slashpos = FilePath.LastIndexOf('\\');
        if (slashpos < 0)
            slashpos = -1;
        string FileName = FilePath.Substring(slashpos + 1);

        myFile.PostedFile.SaveAs("C:\\inetpub\\wwwroot\\" + FileName);

        lblMsg.Text = FileName + " uploaded";


#if ! __DEBUG
        //Error: please request the evaluation license key from Luxand, Inc., comment these lines and assign the key to LicenseKey.
        //Please visit http://www.luxand.com/facecrop/ to request the key
#endif
        string LicenseKey = "3526341959934CE190CABF1934A9E7EC1A151F7238A78E41EF85379C7886D17DE55B68BB357F87C840FE4BBA4FD97C0597487E4B90F669769B7461DBF49FFDC3";

        Luxand.fc.Activate(LicenseKey);

        //Luxand.fcGetLicenseInfo(out string LicenseInfo);


        Luxand.fc.FaceCrop("C:\\inetpub\\wwwroot\\" + FileName,
            "C:\\inetpub\\wwwroot\\" + FileName + "-crop.jpg", 128, 196);

        Luxand.fc.Finalize();

        Pic.ImageUrl = FileName;
        Pic.Visible = true;
        FacePic.ImageUrl = FileName + "-crop.jpg";
        FacePic.Visible = true;
    }
}