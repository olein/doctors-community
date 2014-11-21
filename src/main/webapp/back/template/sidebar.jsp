<!-- left sidebar -->
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="<% if( currentPage.equals("dashboard") ) { out.print("active"); } %>"><a href="dashboard"><i class="fa fa-bars"></i> Dashboard</a></li>
	</ul>
	<ul class="nav nav-sidebar">
		<li class="hasSub"><a href="#boards"><i class="fa fa-th-large"></i> Boards</a>
			<ul class="nav nav-sidebar sub-nav">
				<li><a href="#all-boards">All Boards</a></li>
				<li><a href="#add-new-board">Add New</a></li>
			</ul>
		</li>
		<li class="hasSub"><a href="#articles"><i class="fa fa-file-text"></i> Articles</a>
			<ul class="nav nav-sidebar sub-nav">
				<li><a href="#all-articles">All Articles</a></li>
				<li><a href="#add-new-article">Add New</a></li>
			</ul>
		</li>
		<!-- <li><a href="#export">Export</a></li> -->
	</ul>
	<ul class="nav nav-sidebar">
		<li><a href="#notification"><i class="fa fa-bell"></i> Notifications</a></li>
		<li class="hasSub"><a href="messages"><i class="fa fa-comments"></i> Messages</a>
			<ul class="nav nav-sidebar sub-nav">
				<li><a href="#inbox">Inbox</a></li>
				<li><a href="#new-message">New Message</a></li>
			</ul>
		</li>
	</ul>
	<ul class="nav nav-sidebar">
		<li class="hasSub <% if( currentPage.equals("profile") || currentPage.equals("chambers") || currentPage.equals("new-chamber") || currentPage.equals("edit-chamber") ) { out.print("active"); } %>"><a href="#profile"><i class="fa fa-user"></i> Profile</a>
			<ul class="nav nav-sidebar sub-nav" <% if( currentPage.equals("profile") || currentPage.equals("chambers") || currentPage.equals("new-chamber") || currentPage.equals("edit-chamber") ) { %>style="display: block"<% } %>>
				<li><a href="profile">About &amp; Bio</a></li>
				<li><a href="#interest-area">Interst Area</a></li>
				<li><a href="#experience">Experience</a></li>
				<li><a href="#education">Education</a></li>
				<li><a href="chambers">Chambers</a></li>
			</ul>
		</li>
		<li><a href="#settings"><i class="fa fa-cog"></i> Settings</a></li>
		<li><a href="logout"><i class="fa fa-sign-out"></i> Logout</a></li>
	</ul>
</div><!-- end left sidebar