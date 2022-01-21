<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <jsp:include page="../registration/registration_style.jsp"/>
</head>
<body>
<jsp:include page="../_header.jsp" />

<!-- /login?error=true -->

<form id="msform" action="${pageContext.request.contextPath}/j_spring_security_check" method='POST'>
    <fieldset>
    <h2 class="fs-title">Login</h2>
    <h3 class="fs-subtitle">Enter user name and password:</h3>
    <label>
        <input type="text" name="username" placeholder="Username" />
    </label>
    <label>
        <input type="password" name="password" placeholder="Password" />
    </label>
        <c:if test="${param.error == 'true'}">
            <div style="color:red;">

                Login Failed!!!<br />
                Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
        </c:if>
    <label>
        <input name="submit" type="submit" class="submit action-button" value="Sing in" />
    </label>
    </fieldset>
</form>
<div class="sing_up">
    <div>Don't have an account?</div>
    <button class="button" onclick="document.location='/chattydog/registration'">Sign up</button>
</div>
</body>
</html>