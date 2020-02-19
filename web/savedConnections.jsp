<jsp:include page="header.jsp" />
<jsp:include page="navigation.jsp" />
<div id="wrapper">
    <div class="container">
        <div class="row" >
            <div class="col-12"><h1 class="category">My Events</h1></div>
            <div class="col-12">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Events</th>
                            <th scope="col">Category</th>
                            <th scope="col">Going</th>
                            <th scope="col">Edit</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <th scope="row">Cricket Today? at SAC, 4pm</th>
                            <td>Cricket</td>
                            <td>Going</td>
                            <td>
                                <form>
                                    <button type="submit" class="btn btn-secondary"  formaction="connection.html">Update</button>
                                    <button type="submit" class="btn btn-danger" formaction="connections.html">Delete</button>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">Cricket near UTN at 5pm</th>
                            <td>Cricket</td>
                            <td>Maybe</td>
                            <td>
                                <form>
                                    <button type="submit" class="btn btn-secondary"  formaction="connection.html">Update</button>
                                    <button type="submit" class="btn btn-danger" formaction="connections.html">Delete</button>
                                </form>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">FUT online?</th>
                            <td>Video Games</td>
                            <td>Going</td>
                            <td>
                                <form>
                                    <button type="submit" class="btn btn-secondary"  formaction="connection.html">Update</button>
                                    <button type="submit" class="btn btn-danger" formaction="connections.html">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp" />