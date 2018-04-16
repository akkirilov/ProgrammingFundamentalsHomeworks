let receiptService = (function() {
	
	const MODULE = 'appdata';
	const COLLECTION = 'receipts/';
	const AUTH = 'kinvey';
	
    function getReceiptById(id) {
        return requestService.get(MODULE, COLLECTION + id, AUTH);
    }
    
    function getUserReceipts(id) {
    	let query = '?query={"_acl.creator": "' + id + '", "active": "false"}';
        return requestService.get(MODULE, COLLECTION + query, AUTH);
    }
    
    function getActiveReceipt(id) {
    	let query = '?query={"_acl.creator": "' + id + '", "active": "true"}';
        return requestService.get(MODULE, COLLECTION + query, AUTH);
    }

    function getReceiptDetails(id) {
        return requestService.get(MODULE, COLLECTION + id, AUTH);
    }
    
    function createReceipt(active, productCount, total) {
    	let data = {
    			active,
    			productCount,
    			total
    		};
    	return requestService.post(MODULE, COLLECTION, AUTH, data);
    }
    
    function updateReceipt(receiptId, active, productCount, total) {
    	let data = {
    			active,
    			productCount,
    			total
    		};
    	return requestService.update(MODULE, COLLECTION + receiptId, AUTH, data);
    }

    return {
    	getUserReceipts,
    	getActiveReceipt,
    	getReceiptDetails,
    	createReceipt,
    	getReceiptById,
    	updateReceipt
    }
    
})();