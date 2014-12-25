<!-- left sidebar -->
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="<% if( currentPage.equals("dashboard") ) { out.print("active"); } %>"><a href="dashboard"><i class="fa fa-bars"></i> Dashboard</a></li>
	</ul>
	<ul class="nav nav-sidebar">
		<li class="hasSub <% if( currentPage.equals("all-boards") || currentPage.equals("my-boards") || currentPage.equals("new-board") ) { out.print("active"); } %>"><a href="#boards"><i class="fa fa-th-large"></i> Boards</a>
			<ul class="nav nav-sidebar sub-nav" <% if( currentPage.equals("all-boards") || currentPage.equals("my-boards") || currentPage.equals("new-board") ) {%>style="display: block"<% } %> >
				<li><a href="new-board">Add New</a></li>
				<li><a href="all-boards?type=1">All Boards</a></li>
				<li><a href="my-boards?type=1">My Boards</a></li>
				<li><a href="published-boards?type=1">Published Boards</a></li>
			</ul>
		</li>
		<li class="hasSub"><a href="#patient-case"><i class="fa fa-th-large"></i> Patient Cases</a>
			<ul class="nav nav-sidebar sub-nav">
				<li><a href="all-patient-case?type=2">All patient-case</a></li>
				<li><a href="my-patient-case?type=2">My patient-case</a></li>
			</ul>
		</li>
		<li class="hasSub"><a href="#discussion"><i class="fa fa-th-large"></i> Discussion</a>
			<ul class="nav nav-sidebar sub-nav">
				<li><a href="all-discussion?type=3">All discussion</a></li>
				<li><a href="top-discussion?type=3">Top discussion</a></li>
				<li><a href="my-discussion?type=3">My discussion</a></li>
			</ul>
		</li>
		<li class="hasSub"><a href="#patient-question"><i class="fa fa-th-large"></i> Patient Question</a>
			<ul class="nav nav-sidebar sub-nav">
				<li><a href="all-patient-question?type=4">All patient questions</a></li>
				<li><a href="my-patient-question?type=4">My questions</a></li>
				<li><a href="patient-question-unanswered?type=4">patient-question-unanswered</a></li>
			</ul>
		</li>
		<li class="hasSub"><a href="#articles"><i class="fa fa-file-text"></i> Articles</a>
			<ul class="nav nav-sidebar sub-nav">
				<li><a href="all-article?type=5">All Articles</a></li>
				<li><a href="my-article?type=5">My Articles</a></li>
				<li><a href="new-article?type=5">Add New</a></li>
			</ul>
		</li>
		<li class="hasSub"><a href="#health-tips"><i class="fa fa-file-text"></i> Health Tips</a>
			<ul class="nav nav-sidebar sub-nav">
				<li><a href="all-health-tips?type=6">All Health Tips</a></li>
				<li><a href="my-health-tips?type=6">My Health Tips</a></li>
				<li><a href="new-health-tips?type=6">Add New</a></li>
			</ul>
		</li>
		<li class=""><a href="medical-fields"><i class="fa fa-file-text"></i> Medical Fields</a>
        <li class="<% if( currentPage.equals("media-library") || currentPage.equals("edit-media") ) { out.print("active"); } %>"><a href="media-library"><i class="fa fa-film"></i> Media Library</a></li>
		<li class="<% if( currentPage.equals("messages") ) { out.print("active"); } %>"><a href="messages"><i class="fa fa-comments"></i> Messages</a></li>
	</ul>
	<ul class="nav nav-sidebar">
		<li class="hasSub <% if( currentPage.equals("profile") || currentPage.equals("interest-area") || currentPage.equals("chambers") || currentPage.equals("new-chamber") || currentPage.equals("edit-chamber") ) { out.print("active"); } %>">
            <a href="#profile"><i class="fa fa-user"></i> Profile</a>
			<ul class="nav nav-sidebar sub-nav" <% if( currentPage.equals("profile") || currentPage.equals("interest-area") ||  currentPage.equals("chambers") || currentPage.equals("new-chamber") || currentPage.equals("edit-chamber") ) { %>style="display: block"<% } %>>
				<li><a href="profile">About &amp; Bio</a></li>
				<li><a href="interest-area">Interst Area</a></li>
				<li><a href="experience">Experience</a></li>
				<li><a href="education">Education</a></li>
				<li><a href="chambers">Chambers</a></li>
			</ul>
		</li>
		<li class="<% if( currentPage.equals("settings") ) { out.print("active"); } %>"><a href="settings"><i class="fa fa-cog"></i> Settings</a></li>
		<li><a href="logout"><i class="fa fa-sign-out"></i> Logout</a></li>
	</ul>
</div><!-- end left sidebar