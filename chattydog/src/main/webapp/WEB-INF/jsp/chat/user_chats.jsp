<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Find Friends</title>
    <jsp:include page="chat_style.jsp"/>
</head>
<body>
<jsp:include page="../_header.jsp" />
<div class="container">
    <div class="chats_container">
        <c:forEach var="chat" items="${requestScope.chats}">
            <div class="chat">
                <div class="chat_name">
                    <a href="/chattydog/chats/${chat.chatId}">${chat.chatterFullName}</a>
                </div>
                <div class="last_author">
                        ${chat.senderName} ${chat.created}
                </div>
                <div class="last_content">
                        ${chat.lastMessageContent}
                </div>
            </div>
        </c:forEach>
    </div>

    <c:if test="${requestScope.showChat == true}">
        <div class="chat_container">
            <div class="private_chat">
                <div class="private_chat_name">
                    <a href="/chattydog/home/${requestScope.chat.chatterId}"> ${requestScope.chat.chatterFullName}</a>
                </div>
                <c:if test="${requestScope.haveMessages == true}">
                    <c:forEach var="message" items="${requestScope.chat.messages}">
                        <div class="message">
                            <div class="message_author">
                                <a href="/chattydog/home/${message.senderId}">${message.senderFullName}  ${message.created}</a>
                            </div>
                            <div class="message_content">
                                <span>${message.content}</span>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
            </div>

        <c:if test="${requestScope.haveMessages == false}">
            <div class="private_chat_name">
                No messages yet
            </div>
        </c:if>
    <form id="msform" method="post" action="/chattydog/chats/${requestScope.chat.chatId}/message">
        <fieldset>
            <h2 class="fs-title">Post your message</h2>
            <label>
                <textarea form="msform" name="content" placeholder="Type your message"></textarea>
            </label>
            <input type="submit" name="submit" class="submit action-button" value="Post" />
        </fieldset>
    </form>
    <jsp:include page="chat_js.jsp"/>
        </div>
    </c:if>
</div>
</body>
</html>