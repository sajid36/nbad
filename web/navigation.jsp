<%-- 
    Document   : navigation
    Created on : Feb 17, 2020, 12:56:02 AM
    Author     : sajid
--%>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark customNav">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="index.jsp">
                <img src="images/logo.png" alt="CltGameShop_log" style="width:80px;">
            </a>
            <ul class="nav navbar-nav float-lg-right">
                <li class="nav-item">
                    <a class="nav-link" href="newConnection.jsp">Start a new connection/event</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Cart</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Sign up</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        Login
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="">
                        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required="">

                        <form>
                            <button class="btn btn-success btn-block" type="submit" formaction="#">Sign in</button>
                            <a href="#" id="forgot_pswd">Forgot password?</a>
                        </form>

                    </div>
                </li>
            </ul>
        </div>
    </div>
</nav>
<header>
    <nav class="navbar navbar-expand-lg navbar-dark bg-danger">
        <div class="container">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar10">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="navbar-collapse collapse" id="navbar10">
                <ul class="navbar-nav nav-fill w-100">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Soccer</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Cricket</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">NBA</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<%=request.getContextPath()%>/connections">Connections/Events</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Forum</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</header>
