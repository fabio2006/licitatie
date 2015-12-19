<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<%@ include file="../layout/taglib.jsp"%>
<style>
body {
    margin-top:60px;
    font-family: 'Montserrat',sans-serif;
}
/* this is just for the demo */





.panel-heading:hover {
    cursor:pointer;
}
.panel-heading {
    -webkit-touch-callout: none;
    -webkit-user-select: none;
    -khtml-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;    
}

.side-tab:hover {
        cursor: pointer;
    }
    .panel.panel-default {
        border: none;
        box-shadow: none !important;
        border-bottom-right-radius: 0px;
        border-bottom-left-radius: 0px;
        
    }
    .panel-heading {
        border: none;
        background-color: #eee;
    
    }
    .panel-body {
        background-color: #f5f5f5;
    }
    .panel-title {
        font-weight: 400;
        color: $white;
    }

/*----------------------------------
    Macbook pro mockup from:
    http://jaredhardy.com/minimal-devices/
    
----------------------------------*/

.md-macbook-pro {
  display: block;
  width: 55.3125em;
  height: 31.875em;
  font-size: 13px;
  margin: 0 auto;

  @media (max-width:1199px){
    font-size: 11px;
  }
  @media (max-width:1024px){
    font-size: 10px;
  }

  @media (max-width:767px){
    font-size: 7px;
  }

  @media (max-width:320px){
    font-size: 5px;
  }

}
.md-macbook-pro .md-lid {
  width: 45em;
  height: 30.625em;
  overflow: hidden;
  margin: 0 auto;
  position: relative;
  border-radius: 1.875em;
  border: solid 0.1875em #cdced1;
  background: #131313;
}
.md-macbook-pro .md-camera {
  width: 0.375em;
  height: 0.375em;
  margin: 0 auto;
  position: relative;
  top: 1.0625em;
  background: #000;
  border-radius: 100%;
  box-shadow: inset 0 -1px 0 rgba(255, 255, 255, 0.25);
}
.md-macbook-pro .md-camera:after {
  content: "";
  display: block;
  width: 0.125em;
  height: 0.125em;
  position: absolute;
  left: 0.125em;
  top: 0.0625em;
  background: #353542;
  border-radius: 100%;
}
.md-macbook-pro .md-screen {
  width: 42.25em;
  height: 26.375em;
  margin: 0 auto;
  position: relative;
  top: 2.0625em;
  // background: #1d1d1d;
  background: #fff;
  overflow: hidden;
}
.md-macbook-pro .md-screen img {
  width: 100%;
}
.md-macbook-pro .md-base {
  width: 100%;
  height: 0.9375em;
  position: relative;
  top: -0.75em;
  background: #c6c7ca;
}
.md-macbook-pro .md-base:after {
  content: "";
  display: block;
  width: 100%;
  height: 0.5em;
  margin: 0 auto;
  position: relative;
  bottom: -0.1875em;
  background: #b9babe;
  border-radius: 0 0 1.25em 1.25em;
}
.md-macbook-pro .md-base:before {
  content: "";
  display: block;
  width: 7.6875em;
  height: 0.625em;
  margin: 0 auto;
  position: relative;
  background: #a6a8ad;
  border-radius: 0 0 0.625em 0.625em;
}
.md-macbook-pro.md-glare .md-lid:after {
  content: "";
  display: block;
  width: 50%;
  height: 100%;
  position: absolute;
  top: 0;
  right: 0;
  border-radius: 0 1.25em 0 0;
  background: -webkit-linear-gradient(37deg, rgba(255, 255, 255, 0) 50%, rgba(247, 248, 240, 0.025) 50%, rgba(250, 245, 252, 0.08));
  background: -moz-linear-gradient(37deg, rgba(255, 255, 255, 0) 50%, rgba(247, 248, 240, 0.025) 50%, rgba(250, 245, 252, 0.08));
  background: -o-linear-gradient(37deg, rgba(255, 255, 255, 0) 50%, rgba(247, 248, 240, 0.025) 50%, rgba(250, 245, 252, 0.08));
  background: linear-gradient(53deg, rgba(255, 255, 255, 0) 50%, rgba(247, 248, 240, 0.025) 50%, rgba(250, 245, 252, 0.08));

}
.chat
{
    list-style: none;
    margin: 0;
    padding: 0;
}

.chat li
{
    margin-bottom: 10px;
    padding-bottom: 5px;
    border-bottom: 1px dotted #B3A9A9;
}

.chat li.left .chat-body
{
    margin-left: 60px;
}

.chat li.right .chat-body
{
    margin-right: 60px;
}


.chat li .chat-body p
{
    margin: 0;
    color: #777777;
}

.panel .slidedown .glyphicon, .chat .glyphicon
{
    margin-right: 5px;
}

.panel-body
{
    overflow-y: scroll;
    height: 250px;
}

::-webkit-scrollbar-track
{
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
    background-color: #F5F5F5;
}

::-webkit-scrollbar
{
    width: 12px;
    background-color: #F5F5F5;
}

::-webkit-scrollbar-thumb
{
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,.3);
    background-color: #555;
}

</style>
<h1>Bine a-ti venit la Licitatie Online!!!!</h1>
<security:authorize access="!hasRole('ROLE_USER')">
<h2>trebuie sa va logati pentru a vedea lista de licitatii: </h2>
</security:authorize>
<br>  
  




<security:authorize access="hasRole('ROLE_USER')">

<!-- ---------------------- -->
		<c:if test="${empty licitatii}">
			<p>Nu sunt licitatii in acest moment</p>
			<% System.out.println("Nu sunt licitatii in acest moment");%>
		</c:if>

		<c:forEach var="licitatie" items="${licitatii}">
			



				<table class="table table-bordered table-hover table-striped">
					<tr>
						<th>#</th>
						<th>Titlu</th>
						<th>Descriere</th>
						<th>Status</th>
						<th>Image</th>
						<th>Pret plecare</th>
						<th>Pretul actual</th>
						<th>Moment incepere</th>
						<th>Moment incheiere</th>
						<th>Operatii</th>
					
					
					</tr>
					<tr>
					<td>#${licitatie.id}</td>
					<td>${licitatie.title}</td>
					<td>
							<%-- Show a short description... --%>
							<c:set var="MAX" value="30"/>
							<c:if test="${licitatie.description.length() ge MAX}">
								${licitatie.description.substring(0, MAX)}...
								<a href="licitatie.cgi?id=${licitatie.id}" >[More]</a>
<%-- 								title="${licitatie.title}" --%>
							</c:if>
							<c:if test="${licitatie.description.length() lt MAX}">
								${licitatie.description}
							</c:if>
					</td>    
					<td>
<%-- 					<c:out value="${licitatie.status}"/> --%>
					</td>
					<td>
						<img src="images/imageDisplay/${licitatie.image.getId()}-trumb.html"/>
				    </td>
					<td>${licitatie.startPrice}</td>
					<td>${licitatie.currentPrice}</td>
					<td>${licitatie.startTime}</td>
					<td>${licitatie.endTime}</td>
					
						<td colspan="2" style="text-align: center;">
							<a href="licitatie/detalii?id=${licitatie.id}" title="Details">Detalii</a>
							<a href="licitatie/update?id=${licitatie.id}" title="Edit">Editare</a>
							<a href="licitatie/delete?id=${licitatie.id}" onclick="return confirm('Stergeti licitatie?')" title="Delete">Stergere</a>
						</td>
					
					</tr>
					
					
					
				</table>


		
		</c:forEach>

<!-- ------------------------------ -->

</security:authorize>

</table>
