<%@ include file="./template/_header.jsp" %>

<!-- Main jumbotron for a primary marketing message or call to action -->
<div class="jumbotron text-center">
    <div class="container">
        <h1>Hello, world!</h1>
        <p>This is community for doctors. Doctors can share their knowledge and experience by being part of this community.
           Patients can also ask question to any doctor and doctors will answer them. It is a great place to share knowledge and
           explore new world of adventure.</p>
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
        <s:iterator value="healthTips">
        <div class="col-md-4">
            <div class="panel panel-default">
                <div class="panel-body">
                    <h2><s:property value="title"/> </h2>
                    <p><s:property value="description"/></p>
                </div>
            </div>
        </div>
        </s:iterator>
    </div>

</div> <!-- /container -->

<%@include file="./template/_footer.jsp" %>


