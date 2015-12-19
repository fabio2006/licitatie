<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras" prefix="tilesx" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<tilesx:useAttribute name="current"/>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="ro" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="ro" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="ro" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="ro" class="no-js"> <!--<![endif]-->
<!--Main body-->

<tiles:insertAttribute name="body" />
<!--End of Main body-->
	
    
</html>

		
