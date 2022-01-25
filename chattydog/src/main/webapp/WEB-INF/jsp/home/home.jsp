<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <jsp:include page="home_style.jsp"/>
    <title>Home</title>
</head>
<body>
<jsp:include page="../_header.jsp" />
<div class="container">
    <div id="main">
        <br>
        <br>
        <div class="row" id="real-estates-detail">
            <div class="col-lg-4 col-md-4 col-xs-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <header class="panel-title">
                            <div class="text-center" style="background-color: #f2f2f2">
                                <strong>ChattyDog User</strong>
                            </div>
                        </header>
                    </div>
                    <div class="panel-body">
                        <div class="text-center" id="author">
                            <img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAA1BMVEVYWFjSB0xIAAAASElEQVR4nO3BgQAAAADDoPlTX+AIVQEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAADwDcaiAAFXD1ujAAAAAElFTkSuQmCC">
                            <h3>${requestScope.user.firstName} ${requestScope.user.lastName}</h3>
                            <small class="label label-warning">${requestScope.user.country}</small>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-8 col-md-8 col-xs-12">
                <div class="panel">
                    <div class="panel-body">
                        <ul id="myTab" class="nav nav-pills">
                            <c:if test="${requestScope.showButtons == true}">
                                <c:if test="${requestScope.user.friend == false}">
                                <li class="active"><button class="action-button" onclick="document.location='/chattydog/friends/${requestScope.user.id}'">Add to Friends</button></li>
                                </c:if>
                            <li class=""><button class="action-button" onclick="document.location='/chattydog/chats/user/${requestScope.user.id}'">Send Message</button></li>
                            </c:if>
                        </ul>
                        <div id="myTabContent" class="tab-content">
                            <hr>
                            <div >
                                <table class="table" style="table-layout: fixed">
                                    <tbody>
                                    <tr><td class="active">Country</td><td>${requestScope.user.country}</td></tr>
                                    <tr><td class="active">City</td><td>${requestScope.user.city}</td></tr>
                                    <tr><td class="active">Email:</td><td>${requestScope.user.email}</td></tr>
                                    <tr><td class="active">Phone</td><td>${requestScope.user.phone}</td></tr>
                                    <tr><td class="active">Instagram</td><td>${requestScope.user.instagram}</td></tr>
                                    <tr><td class="active">Skype</td><td>${requestScope.user.skype}</td></tr>
                                    <tr><td class="active">Pet Description</td><td>${requestScope.user.aboutInfo}</td></tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>