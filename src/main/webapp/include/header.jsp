<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title> 
	  ${param.title}
  </title>
  
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">

<!-- Favicons -->
  <link href="<%=request.getContextPath()%>/assets/img/favicon.png" rel="icon">
  <link href="<%=request.getContextPath()%>/assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Raleway:400,700,900|Lato:400,900" rel="stylesheet">

  <!-- Bootstrap CSS File -->
  <link href="<%=request.getContextPath()%>/assets/lib/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Libraries CSS Files -->
  <link href="<%=request.getContextPath()%>/assets/lib/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/assets/lib/prettyphoto/css/prettyphoto.css" rel="stylesheet">
  <link href="<%=request.getContextPath()%>/assets/lib/hover/hoverex-all.css" rel="stylesheet">

  <!-- Main Stylesheet File -->
  <link href="<%=request.getContextPath()%>/assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
    Template Name: Solid
    Template URL: https://templatemag.com/solid-bootstrap-business-template/
    Author: TemplateMag.com
    License: https://templatemag.com/license/
  ======================================================= -->
</head>

<body>

  <!-- Fixed navbar -->
  <div class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        <a class="navbar-brand" href="${pageContext.request.contextPath}/home.jsp">COLLEGE SYSTEM MANAGEMENT</a>
      </div>
      <div class="navbar-collapse collapse navbar-right">
        <ul class="nav navbar-nav">
          <li><a href="${pageContext.request.contextPath}/home.jsp">HOME</a></li>
          <li><a href="${pageContext.request.contextPath}/about.jsp">ABOUT</a></li>
          <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">ENTITIES <b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="${pageContext.request.contextPath}/student">STUDENTS</a></li>
              <li><a href="${pageContext.request.contextPath}/faculty">FACULTY</a></li>
              <li><a href="${pageContext.request.contextPath}/course">COURSES</a></li>
              <li><a href="${pageContext.request.contextPath}/department">DEPARTMENT</a></li>
              <li><a href="${pageContext.request.contextPath}/courseAssignment">COURSE ASSIGNMENT</a></li>
              <li><a href="${pageContext.request.contextPath}/registration">REGISTRATION</a></li>
            </ul>
          </li>
        </ul>
      </div>
      <!--/.nav-collapse -->
    </div>
  </div>
  
  
  
  
  
  
  
  
  
  
  
  