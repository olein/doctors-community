<%@ include file="./template/_header.jsp" %>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron text-center">
    <div class="container">
        <h1>Hello, world!</h1>
        <p>This is a template for a simple marketing or informational website. It includes a large callout called a jumbotron and three supporting pieces of content. Use it as a starting point to create something more unique.</p>
        <p><a class="btn btn-success btn-lg" href="user/register" role="button">Join us NOW</a></p>
    </div>
</div>

<div class="container">
    <div class="row search-block">
        <div class="col-md-12">
            <h1>Doctor Search</h1>
        </div>
        <div class="col-md-6">
            <form action="search-by-name" class="form">
                <div class="form-group">
                    <label for="">Search by Name</label><br>
                    <div class="input-group">
                        <input type="text" class="form-control input-lg" name="name" id="" placeholder="Enter name">
                        <span class="input-group-btn">
                            <button type="submit" class="btn btn-primary btn-lg">Search</button>
                        </span>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-6">
            <form action="search-by-location" class="form">
                <div class="form-group">
                    <label for="">Search by Location</label><br>
                    <div class="input-group">
                        <input type="text" class="form-control input-lg" name="district" id="" placeholder="Enter location">
                        <span class="input-group-btn">
                            <button type="submit" class="btn btn-primary btn-lg">Search</button>
                        </span>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-6">
            <form action="search-by-key-word" class="form">
                <div class="form-group">
                    <label for="">Search</label><br>
                    <div class="input-group">
                        <input type="text" class="form-control input-lg" name="key-word" id="" placeholder="Enter search word">
                        <span class="input-group-btn">
                            <button type="submit" class="btn btn-primary btn-lg">Search</button>
                        </span>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-md-6">
            <form action="search-by-speciality" class="form">
                <div class="form-group">
                    <label for="">Search by Speciality</label><br>
                    <div class="input-group">
                        <select class="form-control input-lg" name="speciality">
                            <option value=0>--select option--</option>
                            <s:iterator value="categoryList">
                                <option value=<s:property value="id"/>><s:property value="name"/></option>
                            </s:iterator>
                        </select>
                        <span class="input-group-btn">
                            <button type="submit" class="btn btn-primary btn-lg">Search</button>
                        </span>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <hr/>

    <!-- Example row of columns -->
    <div class="row latest-tips">
        <div class="col-md-12">
            <h1>Latest Tips</h1>
        </div>
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <h2>Heading</h2>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <h2>Heading</h2>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <h2>Heading</h2>
                    <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus.</p>
                    <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
                </div>
            </div>
        </div>
    </div>

</div> <!-- /container -->

<%@include file="./template/_footer.jsp" %>


