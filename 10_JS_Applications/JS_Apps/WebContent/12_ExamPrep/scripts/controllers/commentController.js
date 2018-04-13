let commentController = (function () {

	function addComment(ctx) {
		let isLoggedIn = userController.isLoggedIn();
		ctx.isLoggedIn = isLoggedIn;
		if (!isLoggedIn) {
			ctx.redirect('#/home');
		}
		let postId = ctx.params.id;
		let content = ctx.params.content;
		let author = userController.getUsername();
		let data = {
				postId,
				content,
				author,
			}
		requestService.post('appdata', 'comments', 'Kinvey', data)
		.then(function(res) {
			ctx.redirect('#/details/' + postId);
			infoService.showInfo('Comment added successfully!');
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function deleteComment(ctx) {
		let isLoggedIn = userController.isLoggedIn();
		ctx.isLoggedIn = isLoggedIn;
		if (!isLoggedIn) {
			ctx.redirect('#/home');
		}
		let id = ctx.params.id;
		requestService.remove('appdata', 'comments/' + id, 'Kinvey')
		.then(function(res) {
			ctx.redirect('#/posts');
			infoService.showInfo('Comment deleted successfully!');
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	return {
		addComment,
		deleteComment
	}
	
})()