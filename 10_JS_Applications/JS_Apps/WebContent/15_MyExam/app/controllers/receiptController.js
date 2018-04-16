let receiptController = (function() {
	
	function addZeros(num) {
		if (("" + num).length > 1) {
			return num;
		}
		return "0" + num; 
	}
	
	function formatDate(date) {
		let day = addZeros(date.getDate());
		let month = addZeros(date.getMonth() + 1);
		let year = date.getFullYear();
		let hours = addZeros(date.getHours());
		let minutes = addZeros(date.getMinutes());
		
		return `${year}-${month}-${day} ${hours}:${minutes}`
	}
	
	function getMyReceipts(ctx) {
		let isLoggedIn = userService.isLoggedIn();
		if (!isLoggedIn) {
			ctx.redirect('#/home');
		}
		ctx.isLoggedIn = isLoggedIn;
		ctx.username = userService.getUsername();
		let userId = userService.getUserId();
		receiptService.getUserReceipts(userId)
		.then(function(receipts) {
			let total = 0;
			for (let r of receipts) {
				total += Number(r.total);
				r['date'] = formatDate(new Date(r._kmd.ect));
			}
			ctx.total = total.toFixed(2);
			ctx.receipts = receipts;
			ctx.loadPartials({
				header: 'templates/common/header.hbs',
				footer: 'templates/common/footer.hbs'
			}).then(function() {
				this.partial('templates/receipts/allReceipts.hbs');
			});
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function getActiveReceipt(ctx) {
		let isLoggedIn = userService.isLoggedIn();
		if (!isLoggedIn) {
			ctx.redirect('#/home');
		}
		ctx.username = userService.getUsername();
		let userId = userService.getUserId();
		receiptService.getActiveReceipt(userId)
		.then(function(receipt) {
			if (receipt == undefined || receipt.length < 1) {
				receiptService.createReceipt(true, 0, 0)
				.then(function (newReceipt) {
					ctx._id = newReceipt._id;
					productService.getByReceiptId(newReceipt._id)
					.then(function(products) {
						ctx.productCount = products.length;
						let receiptTotal = 0;
						for (let p of products) {
							let total = (p.qty * p.price);
							receiptTotal += total;
							p['total'] = total.toFixed(2);
						}
						ctx.receiptTotal = receiptTotal;
						ctx.products = products;
						ctx.loadPartials({
							header: 'templates/common/header.hbs',
							footer: 'templates/common/footer.hbs'
						}).then(function() {
							this.partial('templates/receipts/activeReceipt.hbs')
							.then(function () {
								receiptEvents.attachChangeReceiptSumEvent();
							});
						});
					}).catch(function(err) {
						infoService.handleAjaxError(err);
					});
				}).catch(function(err) {
					infoService.handleAjaxError(err);
				});
				return;
			}
			ctx._id = receipt[0]._id;
			productService.getByReceiptId(receipt[0]._id)
			.then(function(products) {
				let receiptTotal = 0;
				for (let p of products) {
					let total = (p.qty * p.price);
					receiptTotal += total;
					p['total'] = total.toFixed(2)
				}
				ctx.productCount = products.length;
				ctx.hasProducts = (products.length > 0);
				ctx.receiptTotal = receiptTotal.toFixed(2);
				ctx.products = products;
				ctx.loadPartials({
					header: 'templates/common/header.hbs',
					footer: 'templates/common/footer.hbs'
				}).then(function() {
					this.partial('templates/receipts/activeReceipt.hbs')
					.then(function () {
						receiptEvents.attachChangeReceiptSumEvent();
					})
				});
			}).catch(function(err) {
				infoService.handleAjaxError(err);
			});
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function checkoutReceipt(ctx) {
		let receiptId = ctx.params.receiptId;
		receiptService.getReceiptById(receiptId)
		.then(function (receipt) {
			let active = false;
			let productCount = ctx.params.productCount;
			let total = ctx.params.total;
			receiptService.updateReceipt(receiptId, active, productCount, total)
			.then(function(res) {
				ctx.redirect('#/myReceipts');
				infoService.showInfo('Receipt checked out.');
			}).catch(function(err) {
				infoService.handleAjaxError(err);
			});
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	function getDetails(ctx) {
		let isLoggedIn = userService.isLoggedIn();
		if (!isLoggedIn) {
			ctx.redirect('#/home');
		}
		ctx.username = userService.getUsername();
		
		let receiptId = ctx.params.receiptId;
		productService.getByReceiptId(receiptId)
		.then(function(products) {
			let receiptTotal = 0;
			for (let p of products) {
				let total = (p.qty * p.price);
				receiptTotal += total;
				p['total'] = total.toFixed(2)
			}
			ctx.receiptTotal = receiptTotal.toFixed(2);
			ctx.products = products;
			ctx.loadPartials({
				header: 'templates/common/header.hbs',
				footer: 'templates/common/footer.hbs'
					
			}).then(function() {
				this.partial('templates/receipts/receiptDetails.hbs');
			});
		}).catch(function(err) {
			infoService.handleAjaxError(err);
		});
	}
	
	return {
		getActiveReceipt,
		getDetails,
		getMyReceipts,
		checkoutReceipt
	}
	
})();
