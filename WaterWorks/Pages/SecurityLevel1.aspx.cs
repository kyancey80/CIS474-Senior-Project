using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Luxand;
using System.Drawing.Design;

public partial class Pages_SecurityLevel1 : System.Web.UI.Page
{
    protected void Page_Load(object sender, EventArgs e)
    {

    }

    public void Upload(object sender, EventArgs e)
    {
        string LicenseKey = "KRqmHRA9WtCO2wHR5gB0ACcHGf3bd+n6jw8OuMm8GBqcJ+hZdbn/FVA8K4pFgO3p4L2rMF/jMALTysayelfrLrjYFJkXFrKwcbkAaPFejPnRbyTf87PNxC0bDHK0FU2anxn1K6hlON08tV1PaElVySwNdetLswHXYm5JS9bj+20=";

        Luxand.FSDK.ActivateLibrary(LicenseKey);

        //Luxand.fcGetLicenseInfo(out string LicenseInfo);


        Luxand.fc.FaceCrop("C:\\inetpub\\wwwroot\\" + FileName,
            "C:\\inetpub\\wwwroot\\" + FileName + "-crop.jpg", 128, 196);

        Luxand.fc.Finalize();

        int FSDKcam;


        //int FSDK.ActivateLibrary(out string LicenseKey);
    }
}
