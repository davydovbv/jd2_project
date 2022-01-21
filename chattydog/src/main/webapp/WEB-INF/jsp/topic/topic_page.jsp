<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Find Friends</title>
    <jsp:include page="topic_page_style.jsp"/>
</head>
<body>
<jsp:include page="../_header.jsp" />
    <div class="container">
        <c:if test="${requestScope.add == true}">
           <div class="button_class">
               <button class="button" onclick="document.location='/chattydog/topics/${requestScope.topic.id}/add'">Add to Favorite</button>
           </div>
        </c:if>

        <c:if test="${requestScope.remove == true}">
            <div class="button_class">
            <button  class="button" onclick="document.location='/chattydog/topics/${requestScope.topic.id}/remove'">Remove from Favorite</button>
            </div>
        </c:if>

        <c:if test="${requestScope.add == false}">
            <c:if test="${requestScope.remove == false}">
                <div class="button_class">
                <button class="button" class="action-button" onclick="document.location='/chattydog/topics/${requestScope.topic.id}/delete'">Delete topic</button>
                </div>
            </c:if>
        </c:if>
        <div class="theme">
            ${requestScope.topic.theme}
        </div>
        <div class="author">
            <a href="/chattydog/home/${requestScope.topic.creatorId}">Author: ${requestScope.topic.authorName}</a>
        </div>
        <div class="description">
            ${requestScope.topic.description}
        </div>
        <c:forEach var="message" items="${requestScope.topic.messages}">
            <div class="message">
                <div class="message_author"><a href="/chattydog/home/${message.authorId}">${message.authorName}</a>
                ${message.created}
                </div>
                <div class="message_content">
                ${message.content}
                </div>
            </div>
        </c:forEach>
        <form id="msform" method="post" action="/chattydog/topics/${topic.id}/message">
            <fieldset>
                <h2 class="fs-title">Post your message</h2>
                <label>
                    <textarea form="msform" name="content" placeholder="Type your message"></textarea>
                </label>
                <input type="submit" name="submit" class="submit action-button" value="Post" />
            </fieldset>
        </form>
        <jsp:include page="create_topic_js.jsp"/>
    </div>
</body>
</html>