<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Topics</title>
        <jsp:include page="topic_search_style.jsp"/>
    </head>
    <body>
        <jsp:include page="../_header.jsp" />
            <div class="container">
                <button class="button" onclick="document.location='/chattydog/topics/create'">Create Topic</button>
                <c:forEach var="topic" items="${requestScope.topics}">
                    <div class="topic">
                        <div class="theme">
                            <a href="/chattydog/topics/${topic.id}">${topic.theme}</a>
                        </div>
                        <div class="author">
                            <a href="/chattydog/home/${topic.creatorId}">Author: ${topic.creatorName}</a>
                        </div>
                        <div class="description">
                                ${topic.description}
                        </div>
                    </div>
                </c:forEach>
            </div>
    </body>
</html>