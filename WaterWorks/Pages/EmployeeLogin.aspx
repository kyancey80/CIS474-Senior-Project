<%@ Page Language="C#" AutoEventWireup="true" CodeFile="EmployeeLogin.aspx.cs" Inherits="Pages_Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="../Styles/Master.css"/>
<link rel="stylesheet" type="text/css" href="../Styles/Master.css"/>
<script src="../Scripts/jquery-2.0.2.js" type="text/javascript"></script>
<script type="text/javascript">
    $(document).ready(function () {
        $(".logo").click(function () {
            window.location = $(this).find("a").attr("href");
            return false;
        });

    });
</script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

</head>

<body>

    <form id="form1" runat="server">
<div class="logo"><a href="HomePage.html"></a></div>
 <div class="main-nav">
      <div class="search">
        <form action = "/Search" method="get">
          <input type = "text" placeholder="Search..." autocomplete="off" />
        </form>
      </div>
      <nav class="main-menu">
      <ul>
        <li> <a  href= "HomePage.html" title="Home">Home</a> </li>
        <li> <a  href= "Portfolio.html" title="Portfolio">Portfolio</a> </li>
        <li> <a  href= "ProjectEstimator.aspx" title="Project Estimator">Project Estimator</a> </li>
        <li> <a  href= "CustomerAccount.aspx" title="Customer Account">Customer Account</a> </li>
        <li> <a  href= "EmployeeLogin.aspx" title="Customers &amp; Community">Employee Login</a> </li>
      </ul>
      </nav>
    </div>
    
    <div class = "photo">
     <h1>
         Please Upload Photo</h1>
     <div>
         File:
         <input id="myFile" runat="server" type="file" />
         <input id="Button1" runat="server" onserverclick="Upload" type="button" 
             value="Upload" />
         <asp:Label ID="lblMsg" runat="server" />
         <br />
         <asp:Image ID="Pic" runat="server" height="65px" width="56px" />
         <asp:Image ID="FacePic" runat="server" Height="65px" />
     </div>

     </div>
     
    <div class = "login">

   <h1>Employee Login</h1>
  <p> Please enter your Login Credentials Below</p>
       <p> &nbsp;</p>

       <asp:Login ID="Login1" runat="server" BackColor="White" BorderColor="#1888C8" 
           BorderPadding="5" BorderStyle="Dotted" BorderWidth="2px" 
           DestinationPageUrl="~/Pages/SecurityLevel1.aspx" DisplayRememberMe="False" 
           Enabled="False" EnableTheming="False" style="margin: 3% auto 3% auto" 
           TitleText="" Width="316px">
       </asp:Login>

    </div>

   
<div class ="spacer" style="height:40px;"> </div>
 <footer>
      <div class="footer-right"> <a href="SiteMap.html">Site Map</a>  &nbsp;&copy;<p>2013 WaterWorks Pool Construction</p> </div>
      <div class="footer-left"><a href ="AboutUs.html">About Us</a> <a href="Contact.html">Contact</a></div>
 </footer>

    </form>

</body>
</html>
