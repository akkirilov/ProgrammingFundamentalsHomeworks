let itemService = (function() {
	
	const MODULE = 'appdata';
	const COLLECTION = 'collection/';
	const AUTH = 'kinvey';
	
    function getAll() {
        return requester.get(MODULE, COLLECTION, AUTH);
    }
    
    function getAllSortedByDate() {
    	let query = '?query={}&sort={"_kmd.ect": -1}';
        return requestService.get(MODULE, COLLECTION + query, AUTH);
    }
    
    function getById(id) {
        return requestService.get(MODULE, COLLECTION + id, AUTH);
    }
    
    function getByCreatorId(id) {
    	let query = '?query={"_acl.creator": "' + id + '"}';
        return requestService.get(MODULE, COLLECTION + query, AUTH);
    }
    
    function getByAuthorName(author) {
    	let query = '?query={"author": "' + author + '"}';
        return requestService.get(MODULE, COLLECTION + query, AUTH);
    }

    function getDetails(id) {
        return requestService.get(MODULE, COLLECTION + id, AUTH);
    }
    
    function create(params) {
    	let data = {
    			
    	};
    	return requestService.post(MODULE, COLLECTION, AUTH, data);
    }

    function editById(id, data) {
        let data = {
            
        };
        return requestService.update(MODULE, COLLECTION + id, AUTH, data);
    }
    
    function deleteById(id) {
        return requestService.remove(MODULE, COLLECTION + id, AUTH);
    }

    return {
    	getAll,
    	getAllSortedByDate,
    	getById,
    	getByCreatorId,
    	getByAuthorName,
    	getDetails,
    	create,
    	editById,
    	deleteById
    }
    
})();