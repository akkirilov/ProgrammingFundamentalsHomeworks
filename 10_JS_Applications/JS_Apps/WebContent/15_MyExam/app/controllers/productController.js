let productController = (function() {
	
	function addProduct(ctx) {
		if (!userService.isLoggedIn()) {
			ctx.redirect('#/home');
		}
		let type = ctx.params.type;
		let qty = ctx.params.qty;
		let price = ctx.params.price;
		let receiptId = ctx.params.receiptId;

		if (type.length < 1) {
			infoService.showError('Product name must be a non-empty string.');
			return;
		}
		if (isNaN(qty)) {
			infoService.showError('Quantity must be a number.');
			return;
		}
		if (isNaN(price)) {
			infoService.showError('Price must be a number.');
			return;
		}
		productService.create(type, qty, price, receiptId)
		.then(function(res) {
			ctx.redirect('#/activeReceipt');
			infoService.showInfo('Entry added.');
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}

	function deleteProduct(ctx) {
		if (!userService.isLoggedIn()) {
			ctx.redirect('#/home');
		}
		
		let productId = ctx.params.productId;
		productService.deleteById(productId)
		.then(function(res) {
			ctx.redirect('#/activeReceipt');
			infoService.showInfo('Entry removed.');
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	return {
		addProduct,
		deleteProduct
	}
	
})();
