<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <title>Favorite Topics</title>
    <jsp:include page="favorite_topics_style.jsp"/>
</head>
<body>
<jsp:include page="../_header.jsp" />
<content>
    <div class="container">
        <button class="button" onclick="document.location='/chattydog/topics/create'">Create Topic</button>
        <c:if test="${requestScope.personalEmpty == false}">
            <h4>Personal Topics</h4>
            <c:forEach var="topic" items="${requestScope.personal}">
                <div class="topic">
                    <div class="theme">
                        <a href="/chattydog/topics/${topic.id}">${topic.theme}</a>
                    </div>
                    <div class="author">
                        <a href="/chattydog/home/${topic.creatorId}">${topic.creatorName}</a>
                    </div>
                    <div class="description">
                        ${topic.description}
                    </div>
                </div>
            </c:forEach>
        </c:if>
        <h4>Favorite Topics</h4>
        <c:forEach var="topic" items="${requestScope.favorite}">
            <div class="topic">
                <div class="theme">
                    <a href="/chattydog/topics/${topic.id}">${topic.theme}</a>
                </div>
                <div class="author">
                    <a href="/chattydog/home/${topic.creatorId}">${topic.creatorName}</a>
                </div>
                <div class="description">
                        ${topic.description}
                </div>
            </div>
        </c:forEach>
    </div>
</content>
</body>
</html>