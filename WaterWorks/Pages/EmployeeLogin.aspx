<%@ Page Language="C#" AutoEventWireup="true" CodeFile="EmployeeLogin.aspx.cs" Inherits="Pages_Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
</head>
<link rel="stylesheet" type="text/css" href="../Styles/Master.css"/>
</head>

<body id="body">
    <form id="form1" runat="server">
<div class = "general-wrapper">
<div id = "header-wrapper" class="nocontent">
<div id = "header-logo-container"> <a href= "../Pages/HomePage.html" title="HomePage" id="ww-logo" style="display: block;"></a></div>
<div id = "menu-container">
<div id ="search-wrapper">
<div id ="search-left">
</div>
<input type = "text" name="c" id="search-field" value autocomplete="off" style = "width:43px;"> 
<div id = "search-right">
</div>
</div>
<ul id = "main-menu" class ="black-menu" style="min-height: 0px; height: 12px;">

<li style"width: 73px;">
<a  href= "../Pages/HomePage.html" Title="Home">Home</a>
</li>

<li>
<a  href= "../Pages/Portfolio.html" Title="Portfolio">Portfolio</a>
</li>

<li>
<a  href= "../Pages/ProjectEstimator.aspx" Title="Project Estimator">Project Estimator</a>
</li>

<li>
<a  href= "../Pages/CustomerAccount.aspx" Title="Customer Account">Customer Account</a>
</li>

<li>
<a  href= "../Pages/EmployeeLogin.aspx" Title="Employee Login">Employee Login</a>
</li>

</ul>
</div>
</div>
</div>

<div class="general-wrapper" id="content-general-wrapper">
  <div class ="Empcontent-wrapper">
  <div id="breadcrumb-wrapper">
  <div id="breadcrumb"> Featured Projects  </div>
</div>
 <div id="Employee-wrapper">
 <div id= "EmpContent-Left"> <h1>  </h1>
     <h3>
         Please Upload Photo</h3>
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
     <p>  </p>
 </div>
   <div id="EmpMiddle-Wrapper">
     <div id="Emp-Content">
   <div id = "Emp-login">
   <h1>Employee Login</h1>
  <p> Please enter your Login Credentials Below</p>
       <p> &nbsp;</p>

       <asp:Login ID="Login1" runat="server" BackColor="White" BorderColor="#1888C8" 
           BorderPadding="5" BorderStyle="Dotted" BorderWidth="2px" 
           DestinationPageUrl="~/Pages/SecurityLevel1.aspx" DisplayRememberMe="False" 
           Enabled="False" EnableTheming="False" style="margin-left: 12px" 
           TitleText="" Width="316px">
       </asp:Login>

   </div>   
  
</div>
</div>
 <div id= "Emp-right"> <h1>  </h1>
 </div>
 

<div class ="spacer" style="height:40px;"> </div>
</div>


<div id ="footer-wrapper" class="footer-wrapper">
<div id ="footer-menu-wrapper">
<a href="../Pages/Sitemap.html" class="footer-link" id="site-map-link">Site Map</a>
<a href="../Pages/Contact.html" class="footer-link" id="contact-link">Contact</a>
</div>
<div id ="footer-about-events-wrapper">
<div class="expandable-div expandable-div-footer"> 
<a href ="../Pages/AboutUs.html" class="aboutus-button">About Us
</a>
</div>
<div class="expandable-div expandable-div-footer"> 
<a href ="#" class="aboutus-button"> 
</a>
</div>

</div>
</div>
</div>
</div>
</div>
</div>
</div>
</div>

    </form>

</body>
</html>
