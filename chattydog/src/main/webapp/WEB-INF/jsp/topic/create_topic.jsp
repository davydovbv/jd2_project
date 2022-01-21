<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Create Topic</title>
        <jsp:include page="create_topic_style.jsp"/>
    </head>
    <body>
        <jsp:include page="../_header.jsp" />
        <form id="msform" method="post" action="/chattydog/topics/create">
            <fieldset>
                <h2 class="fs-title">Create your topic</h2>
                <label>
                    <input type="text" name="theme" placeholder="Theme" />
                </label>
                <label>
                    <textarea form="msform" name="description" placeholder="Description"></textarea>
                </label>
                <input type="submit" name="submit" class="submit action-button" value="Submit" />
            </fieldset>
        </form>
        <jsp:include page="create_topic_js.jsp"/>
    </body>
</html>
