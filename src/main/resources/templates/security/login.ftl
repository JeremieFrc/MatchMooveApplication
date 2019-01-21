<#import "/spring.ftl" as spring/>

		<title>Login</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link rel="stylesheet" type="text/css" href="<@spring.url '/css/bootstrap.css'/>"/>
	<link rel="stylesheet" type="text/css" href="<@spring.url '/css/login.css'/>"/>
		
	<body onload="document.f.username.focus();">
		
		<a href=""><img src="images/Matchmoovecouleurs.png" alt="logo matchmoove" class="logo"></a>
		<#if Session.SPRING_SECURITY_LAST_EXCEPTION?? && Session.SPRING_SECURITY_LAST_EXCEPTION.message?has_content>
		    <h1>L'email ou le mot de passe est incorrect</h1>
		</#if>
		<div id="container">
			<img src="images/lock%20(1)%20(1).png" id="lock">
            <form action="/login" method="POST">
                
                <label><b>Adresse mail</b></label>
                <input type="text" placeholder="Adresse mail" name='${form_username}' value=''>

                <label><b>Mot de passe</b></label>
                <input type="password" placeholder="Mot de passe" name='${form_password}' value=''>

				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="submit" id='submit' value='CONNEXION' >
                
            </form>
        </div>
	</body>
	
</html>



<!--
<#import "/spring.ftl" as spring/>
<html>
  <head>
    <title tiles:fragment="title">Messages : Create</title>
    <#include "/utils/bootstrap.ftl"/>
  </head>
  <body onload="document.f.username.focus();">
    <h1>Spring Security Login (Freemarker)</h1>

    <form action="/login" method="POST">
      <table>
        <tr><td>User:</td><td><input type='text' name='${form_username}' value=''/></td></tr>
        <tr><td>Password:</td><td><input type='password' name='${form_password}' value=''/></td></tr>
        <input type="hidden"
            name="${_csrf.parameterName}"
            value="${_csrf.token}"/>
        <tr><td colspan='2'><input name="submit" type="submit"></td></tr>
        <tr><td colspan='2'><input name="reset" type="reset"></td></tr>
      </table>

    </form>

  </body>
</html>

<#if Session.SPRING_SECURITY_LAST_EXCEPTION?? && Session.SPRING_SECURITY_LAST_EXCEPTION.message?has_content>
    <h1>Bad credential</h1>
</#if>
-->