<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>


<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION.message}">
            <font color="red">
                Your login attempt was not successful due to
                <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
            </font>
        
        </c:if>
<!-- <form class="form-signin" role="form" action="j_spring_security_check" method="POST"> -->
<!-- 	<h2 class="form-signin-heading">Autentificare</h2> -->
	
<!-- 	<input type="text" name="j_username" class="form-control" placeholder="Nume" required autofocus>  -->
<!-- 	<input type="password" name="j_password" class="form-control" placeholder="Parola" required>  -->
<!-- 	<button class="btn btn-lg btn-primary btn-block" type="submit">Autentifica-te</button> -->
<!-- </form> -->
<br>
<div id="loginbox" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	<div class="panel panel-default">

		<div class="panel-heading">
				<div class="panel-title">Autentificare</div>
			</div> 

<form class="form-horizontal rcp_form" role="form" action="j_spring_security_check" method="POST">
			<div class="panel-body">
			<fieldset class="login_data">
				<div class="input-group margin-bottom">
					<span class="input-group-addon"><i class="fa fa-user"></i></span>
					<input type="text" name="j_username" class="required form-control" placeholder="Nume" autofocus> 
					
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-lock"></i></span>
					<input type="password" name="j_password" class="required form-control" placeholder="Parola" autofocus> 
					
				</div>
				<br>
				 <div class="input-group margin-bottom">
                  <div class="checkbox">
					<label for="user_remember">
					<input type="checkbox" name="user_remember" id="user_remember" value="1"/> Remember me					</label>
				 </div>
                </div>

                <p class="lost_password pull-right"><a href="redirect_to=login.html">Lost your password?</a></p>
				<br>
				<p>
					<input type="hidden" name="action" value="login"/>
					<input type="hidden" name="redirect" value="http://danielleluxevents.ro/index.html"/>
					<input type="hidden" name="login_nonce" value="cd5ad29914"/>
					<input class="btn btn-primary" id="login_submit" type="submit" value="Autentifica-te"/>
				</p>
			</fieldset>
		</div>
		</form>
	</div>
</div>


		
