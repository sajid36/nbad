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
                        <label for="topic" class="col-sm-2 col-form-label col-form-label-sm">Topic*</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control form-control-sm" id="colFormLabelSm" name="topic" required/>  <br />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="name" class="col-sm-2 col-form-label col-form-label-sm">Name*</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control form-control-sm" id="colFormLabelSm" name="name" required/>  <br />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="host" class="col-sm-2 col-form-label col-form-label-sm">Host*</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control form-control-sm" id="colFormLabelSm" name="host" required/>  <br />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="desc" class="col-sm-2 col-form-label col-form-label-sm">About*</label>
                        <div class="col-sm-10">
                            <textarea class="form-control form-control-sm" id="colFormLabelSm" name="desc" required/></textarea> <br />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="location" class="col-sm-2 col-form-label col-form-label-sm">Where*</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control form-control-sm" id="colFormLabelSm" name="location" required/><br />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="time" class="col-sm-2 col-form-label col-form-label-sm">When*</label>
                        <div class="col-sm-10">
                            <input type="datetime-local" class="form-control form-control-sm" id="colFormLabelSm" name="time" value="2018-06-12T19:30"
                                   min="2018-06-07T00:00" max="2020-06-14T00:00" required>  <br />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2 col-form-label col-form-label-sm"></label>
                        <div class="col-sm-10">
                            <button type="submit" class="form-control form-control-sm btn btn-danger" id="colFormLabelSm" name="task">Create Connection</button>
                        </div>
                    </div>
                    <input type="hidden" name="requestType" value="newConnectionCreate"></input>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp" />

