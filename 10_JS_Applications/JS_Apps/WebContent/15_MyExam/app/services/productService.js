let productService = (function() {
	
	const MODULE = 'appdata';
	const COLLECTION = 'products/';
	const AUTH = 'kinvey';
    
    function getByReceiptId(receiptId) {
    	let query = '?query={"receiptId": "' + receiptId + '"}';
        return requestService.get(MODULE, COLLECTION + query, AUTH);
    }
    
    function create(type, qty, price, receiptId) {
    	let data = {
			type,
			qty,
			price,
			receiptId
    	};
    	return requestService.post(MODULE, COLLECTION, AUTH, data);
    }
    
    function deleteById(id) {
        return requestService.remove(MODULE, COLLECTION + id, AUTH);
    }

    return {
    	getByReceiptId,
    	create,
    	deleteById
    }
    
})();