<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <jsp:include page="find_friends_style.jsp"/>
    <title>Find Friends</title>
</head>
<body>
<jsp:include page="../_header.jsp" />
<content>
    <div id="main" class="card">
        <c:forEach var="request" items="${requestScope.requests}">
            <div>
                <table style="text-align: center">
                    <tr>
                        <td>
                            <img class="img" src="https://bootstraptema.ru/snippets/element/2016/profilesection/myprofile.jpg">
                        </td>
                        <td>
                            <h3><a href="/chattydog/home.html/${request.id}" >${request.firstName} ${request.lastName}</a></h3>
                            <small>${request.city}</small>
                            <small>${request.status}</small>
                        </td>
                        <td>
                            <button class="action-button" onclick="document.location='/chattydog/friends/requests/${request.id}'">Accept</button>
                            <button class="action-button" onclick="document.location='#'">Decline</button>
                        </td>
                    </tr>
                </table>
            </div>
        </c:forEach>
    </div>
</content>
</body>