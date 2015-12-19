<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<h1>Bine a-ti venit la Licitatie Online!!!!</h1>

<security:authorize access="hasRole('ROLE_ADMIN')">
 <form:form method="post" action="images/savePhoto.html"  
        commandName="uploadItem" enctype="multipart/form-data"> 
 		Please select a photo to upload : <input type="file" name="file" />
 		
		<input type="submit" value="upload" />
		<span><form:errors path="file" cssClass="error" />
		</span>

		</form:form>
</security:authorize>     

<!-- ---------------------- -->
		<c:if test="${empty licitatii}">
			<p>Nu sunt licitatii in acest moment</p>
			<% System.out.println("Nu sunt licitatii in acest moment");%>
		</c:if>

		<c:forEach var="licitatie" items="${licitatii}">
			<div id="licitatieLot" class="licitatieLot">



				<table class="table table-bordered table-hover table-striped">
					<tr>
						<th>Lot #${licitatie.id}</th>
						<th>${licitatie.title}</th>
					</tr>
					<tr>
						<td colspan="2" style="text-align: center;">
							<a href="licitatie?id=${licitatie.id}" title="Details">Details</a>
							<a href="update?id=${licitatie.id}" title="Edit">Edit</a>
							<a href="delete?id=${licitatie.id}" onclick="return confirm('Delete licitatie?')" title="Delete">Delete</a>
						</td>
					</tr>
					<tr>
						<td>Description</td>
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
					</tr>
					<tr>
						<td>Image</td>
						<td>
						<img src="images/imageDisplay/${licitatie.image.getId()}.html"/>
						</td>
					</tr>
					<tr>
						<td>Start time</td>
						<td><fmt:formatDate value="${licitatie.startTime}" type="both" timeStyle="SHORT" /></td>
					</tr>
					<tr>
						<td>End time</td>
						<td><fmt:formatDate value="${licitatie.endTime}" type="both" timeStyle="SHORT" /></td>
					</tr>
					<tr>
						<td>Starting price</td>
						<td>${licitatie.startPrice}</td>
					</tr>
					<tr>
						<td>Current price</td>
						<td>${licitatie.currentPrice}</td>
					</tr>
				</table>


			</div>
		</c:forEach>

<!-- ------------------------------ -->
