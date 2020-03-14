<%-- 
    Document   : login
    Created on : Mar 13, 2020, 11:50:38 PM
    Author     : sajid
--%>

<jsp:include page="header.jsp" />
<jsp:include page="navigation.jsp" />
<div id="wrapper">
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col-md-auto">
                <form action="userController" method="post">
                    <div class="form-group row">
                     <h2>Welcome to CLT Game Shop</h2>
                    </div>
                    <div class="form-group row">
                     <h4>Please sign-in</h4><br />
                    </div>
                    <div class="form-group row">
                        <label for="uname" class="col-sm-2 col-form-label col-form-label-sm">Username</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control form-control-sm" id="uname" name="uname" required/>  <br />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="password" class="col-sm-2 col-form-label col-form-label-sm">Password</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control form-control-sm" name="password" id="password" required/>  <br />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label col-form-label-sm"></label>
                        <div class="col-sm-10">
                            <button type="submit" class="form-control form-control-sm btn btn-danger">Login</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp" />


