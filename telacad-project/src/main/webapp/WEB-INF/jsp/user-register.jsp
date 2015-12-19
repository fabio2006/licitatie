<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>

<style>


.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
</style>


   

<div class="container">

<form:form id="form" commandName="user" cssClass="form-horizontal registrationForm">
<c:if test="${param.reg eq true}">
	<div id="message" class="alert form-control alert-success">Userul a fost salvat cu success!!!</div>
	
	</c:if>
	
		
	

	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Nume:</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control" placeholder="Nume" />
			<form:errors path="name" />
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">Email:</label>
		<div class="col-sm-10">
			<form:input path="email" cssClass="form-control" placeholder="Email"/>
			<form:errors path="email" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Parola:</label>
		<div class="col-sm-10">
			<form:password path="password" cssClass="form-control" placeholder="Parola"/>
			<form:errors path="password" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Repeta parola:</label>
		<div class="col-sm-10">
			<input type="password" name="password_again" id="password_again" class="form-control" placeholder="Repeta parola"/>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-2">
			<input type="submit" value="Save" class="btn btn-lg btn-primary" />
		</div>
		
	</div>
</form:form>
<div id="msgEroare"></div>
</div>
 