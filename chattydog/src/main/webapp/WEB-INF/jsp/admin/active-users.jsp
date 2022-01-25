<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <jsp:include page="admin-style.jsp"/>
    <title>Find Friends</title>
</head>
<body>
<jsp:include page="../_header.jsp" />
<content>
    <div id="main" class="card">
        <c:forEach var="user" items="${requestScope.users}">
            <div class="border">
                <table style="text-align: center; width: 100%">
                    <tr>
                        <td>
                            <img class="img" src="https://bootstraptema.ru/snippets/element/2016/profilesection/myprofile.jpg">
                        </td>
                        <td>
                            <h3><a href="/chattydog/home/${user.id}">${user.firstName} ${user.lastName}</a></h3>
                            <small>${user.city}</small>
                            <small>${user.status}</small>
                        </td>
                        <td>
                            <button class="action-button" onclick="document.location='/chattydog/admin/users/block/${user.id}'">Block User</button>
                        </td>
                    </tr>
                </table>
            </div>
        </c:forEach>
    </div>
</content>
</body>