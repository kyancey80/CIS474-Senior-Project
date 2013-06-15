<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"><html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" type="text/css" href="../Styles/Master.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Share Point - Home Page</title>
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
<a  href= "../Pages/EmployeeLogin.aspx" Title="Customers & Community">Employee Login</a>
</li>

</ul>
</div>
</div>
</div>

<div class="general-wrapper" id="content-general-wrapper">
  <div class ="AboutUsContent-wrapper">
  <div id="breadcrumb-wrapper">
  <div id="breadcrumb"> Featured Projects  </div>
</div>
 <div id="workforce-wrapper">
   <div id="AboutUS-Wrapper">
   <div id="AboutUsContent">
   <h2>
        <span> About Us </span>
        </h2>
        <p> 
 Funday Sunday.
        </p>
       <p> 
           <asp:Button ID="Button1" runat="server" onclick="Start" 
               style="height: 29px" Text="Start" Value ="Start" />
        </p>      
   </div>
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


    </form>


</body>
</html>
