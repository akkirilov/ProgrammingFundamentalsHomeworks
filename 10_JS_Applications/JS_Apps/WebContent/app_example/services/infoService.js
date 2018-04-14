let infoService = (function() {
	
	function handleAjaxError(response) {
	    let errorMsg = JSON.stringify(response);
	    if (response.readyState === 0) {
	        errorMsg = "Cannot connect due to network error.";
	    }
	    if (response.responseJSON && response.responseJSON.description) {
	    	errorMsg = response.responseJSON.description;
	    }
	    showError(errorMsg);
	}

	function showInfo(message) {
	    let infoBox = $('#infoBox');
	    infoBox.text(message);
	    infoBox.show();
	    setTimeout(function() {
	        $('#infoBox').fadeOut();
	    }, 3000);
	}

	function showError(errorMsg) {
	    let errorBox = $('#errorBox');
	    errorBox.text("Error: " + errorMsg);
	    errorBox.show();
	    setTimeout(function() {
	        $('#errorBox').fadeOut();
	    }, 3000);
	}
	
	return {
		handleAjaxError,
		showInfo, 
		showError
	}
	
})();


