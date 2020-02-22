<%-- 
    Document   : newConnection
    Created on : Feb 17, 2020, 2:24:44 PM
    Author     : msajid
--%>

<jsp:include page="header.jsp" />
<jsp:include page="navigation.jsp" />
<div id="wrapper">
    <div class="container">
        <div class="row justify-content-md-center">
            <div class="col-md-auto">
                <form action="newConnection" method="post">
                    <div class="form-group row">
                        <div class="col-sm-10">
                            Topic   
                              <input type="radio" id="Cricket" name="topic" value="Cricket"
                                    checked><span> Cricket</span>
                             <label for="Cricket" class="col-sm-2 col-form-label col-form-label-sm"></label>
                              <input type="radio" id="Soccer" name="topic" value="Soccer"><span> Soccer </span>
                             <label for="Soccer" class="col-sm-2 col-form-label col-form-label-sm"></label>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="name" class="col-sm-2 col-form-label col-form-label-sm">Name</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control form-control-sm" id="name" name="name" required/>  <br />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="host" class="col-sm-2 col-form-label col-form-label-sm">Host</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control form-control-sm" name="host" id="host" required/>  <br />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="desc" class="col-sm-2 col-form-label col-form-label-sm">About</label>
                        <div class="col-sm-10">
                            <textarea class="form-control form-control-sm" name="desc" id="desc" required></textarea> <br />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="location" class="col-sm-2 col-form-label col-form-label-sm">Where</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control form-control-sm" name="location" id="location" required/><br />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="time" class="col-sm-2 col-form-label col-form-label-sm">When</label>
                        <div class="col-sm-10">
                            <input type="datetime-local" class="form-control form-control-sm" name="time" id="time" value="2018-06-12T19:30"
                                   min="2018-06-07T00:00" max="2020-06-14T00:00" required>  <br />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label col-form-label-sm"></label>
                        <div class="col-sm-10">
                            <button type="submit" class="form-control form-control-sm btn btn-danger"  id="task">Create Connection</button>
                        </div>
                    </div>
                    <input type="hidden" name="requestType" value="newConnectionCreate">
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp" />

