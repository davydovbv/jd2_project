<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>registration</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <jsp:include page="registration_style.jsp"/>
</head>
<body>
<jsp:include page="../_header.jsp"/>
<form id="msform" method="post" action="/chattydog/registration">
    <!-- progressbar -->
    <ul id="progressbar">
        <li class="active">Account Setup</li>
        <li>Social Profiles</li>
        <li>Personal Details</li>
    </ul>
    <!-- fieldsets -->
    <fieldset>
        <h2 class="fs-title">Create your account</h2>
        <h3 class="fs-subtitle">Registration info</h3>
        <label>
            <input type="text" name="username" placeholder="Username" />
        </label>
        <label>
            <input type="password" name="password" placeholder="Password" />
        </label>
        <label>
            <input type="password" name="confirmPassword" placeholder="Confirm Password" />
        </label>
        <input type="button" name="next" class="next action-button" value="Next" />
    </fieldset>
    <fieldset>
        <h2 class="fs-title">Personal Details</h2>
        <h3 class="fs-subtitle">It will help other people to contact you!</h3>
        <label>
            <input type="text" name="firstName" placeholder="First Name" />
        </label>
        <label>
            <input type="text" name="lastName" placeholder="Last Name" />
        </label>
        <label>
            <input type="text" name="country" placeholder="Country" />
        </label>
        <label>
            <input type="text" name="city" placeholder="City" />
        </label>
        <label>
            <input type="text" name="status" placeholder="Status" />
        </label>
        <label>
            <textarea name="aboutInfo" placeholder="About info"></textarea>
        </label>
        <input type="button" name="previous" class="previous action-button" value="Previous" />
        <input type="button" name="next" class="next action-button" value="Next" />
    </fieldset>
    <fieldset>
        <h2 class="fs-title">Contact Details</h2>
        <h3 class="fs-subtitle">Fast way to communicate with you!</h3>
        <label>
            <input type="text" name="skype" placeholder="Skype" />
        </label>
        <label>
            <input type="text" name="instagram" placeholder="Instagram" />
        </label>
        <label>
            <input type="tel" name="phone" placeholder="Phone" />
        </label>
        <label>
            <input type="email" name="email" placeholder="Email" />
        </label>

        <input type="button" name="previous" class="previous action-button" value="Previous" />
        <input type="submit" name="submit" class="submit action-button" value="Submit" />
    </fieldset>
</form>
<jsp:include page="regitration_js.jsp"/>
</body>
</html>