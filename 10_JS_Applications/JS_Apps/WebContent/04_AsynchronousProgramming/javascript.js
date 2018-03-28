// 01. Github Commits
function loadCommits() {
	let list = $('#commits');
	list.empty();
	let username = $('#username').val();
	let repo = $('#repo').val();
	$.ajax({
		method: 'GET',
		url: `https://api.github.com/repos/${username}/${repo}/commits`
	}).then(function(res) {
		for (let r of res) {
			list.append($(`<li>${r.commit.author.name}: ${r.commit.message}</li>`));
		}
	}).catch(function(error) {
		list.append($(`<li>Error: ${error.status} (${error.statusText})</li>`));
	});
}

// 02. Blog
function attachEvents() {
	const URL = 'https://baas.kinvey.com/appdata/kid_ByUU-dzqz/';
	const AUTH = btoa('guest' + ':' + 'guest');
	let select = $('#posts');
	
	$('#btnLoadPosts').on('click', loadPosts);
	$('#btnViewPost').on('click', viewPosts);

	function loadPosts() {
		select.empty();
		$.ajax({
			method: "GET", 
			url: URL + 'posts',
			headers: {
			    "Authorization": "Basic " + AUTH
			  }
		}).then(function(res) {
			for (let r of res) {
				select.append($(`<option value="${r._id}">${r.title}</option>`));
			}
		}).catch(function(err) {
			$('#post-title').text('!!!ERROR!!!');
		})
	}
	
	function viewPosts() {
		let postId = select.val();
		let comments = $('#post-comments');
		$.ajax({
			method: "GET", 
			url: URL + 'posts/' + postId,
			headers: {
			    "Authorization": "Basic " + AUTH
			  }
		}).then(function(res) {
			$('#post-title').text(res.title);
			$('#post-body').append($(`<li>${res.body}</li>`));
			$.ajax({
				method: "GET", 
				url: URL + 'comments?query={"post_id":"' + postId + '"}',
				headers: {
				    "Authorization": "Basic " + AUTH
				  }
			}).then(function(comms) {
				for (let c of comms) {
					comments.append($(`<li>${c.text}</li>`));
				}
			}).catch(function(err) {
				comments.append($(`<li>!!!ERROR!!!</li>`));
			})
		}).catch(function(err) {
			$('#post-title').text('!!!ERROR!!!');
		})
	}
	
}

