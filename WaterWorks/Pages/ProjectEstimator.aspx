<%@ Page Language="C#" AutoEventWireup="true" CodeFile="ProjectEstimator.aspx.cs" Inherits="Pages_Default" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
   <title>Project Estimator</title>
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
</head>

<body>

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

   <div class ="estimator">

   <h1>Project Estimator</h1>
   <script src="http://www.java.com/js/deployJava.js"></script>
   <script>
       var attributes = { width: 300, height: 300 };
       var parameters = { jnlp_href: 'ProjectEstimator.jnlp' };
       deployJava.runApplet ( attributes, parameters, '1.6');
   </script>

   </div>

   
   <div class ="spacer" style="height:40px;"> </div>
 <footer>
      <div class="footer-right"> <a href="SiteMap.html">Site Map</a>  &nbsp;&copy;<p>2013 WaterWorks Pool Construction</p> </div>
      <div class="footer-left"><a href ="AboutUs.html">About Us</a> <a href="Contact.html">Contact</a></div>
 </footer>

</body>
</html>