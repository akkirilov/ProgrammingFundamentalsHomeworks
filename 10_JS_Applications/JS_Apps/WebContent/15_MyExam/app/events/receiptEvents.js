let receiptEvents = (function () {
	
	function calcNewSum() {
		let qtyInput = $('input[name="qty"]');
		let priceInput = $('input[name="price"]');
		let qty = Number(qtyInput.val());
		let price = Number(priceInput.val());
		if (isNaN(qty)) {
			qty = 0;
		}
		if (isNaN(price)) {
			price = 0;
		}
		if ($('input[name="type"]').val().length < 1) {
			qty = 0;
			price = 0;
		}
		let sum = 0;
		$('#subTotal').text((qty * price).toFixed(2));
		$('.subtotal').toArray().forEach(x => sum += Number($(x).text()));
		$('#receiptTotal').text(sum.toFixed(2));
	}

	function attachChangeReceiptSumEvent() {
		$('input[name="qty"]').on('keyup', calcNewSum);
		$('input[name="price"]').on('keyup', calcNewSum);
		$('input[name="type"]').on('keyup', calcNewSum);
	}
	
	return {
		attachChangeReceiptSumEvent
	}
	
})();