<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="/chattydog/home">ChattyDog</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0" >
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/chattydog/home">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/chattydog/chats">Chats</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Topics
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="/chattydog/topics/favorite">Favorite Topics</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="/chattydog/topics">Find Topics</a></li>
          </ul>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" id="navbarDropdown_2" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Friends
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="/chattydog/friends">My Friends</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="/chattydog/friends/requests">Friendship requests</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="/chattydog/friends/find">Find Friends</a></li>
          </ul>
        </li>
          <sec:authorize access="hasAuthority('ADMIN')">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" id="navbarDropdown_3" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Admin
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="/chattydog/admin/users/active">Block Users</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="/chattydog/admin/users/blocked">Activate Users</a></li>
          </ul>
        </li>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
          <li class="nav-item">
            <a class="nav-link" href="/chattydog/logout">Log In</a>
          </li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
        <li class="nav-item">
          <a class="nav-link" href="/chattydog/logout">Log Out</a>
        </li>
        </sec:authorize>
      </ul>
    </div>
  </div>
</nav>