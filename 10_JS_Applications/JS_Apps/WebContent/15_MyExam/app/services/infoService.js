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
	    infoBox.find('span').text(message);
	    infoBox.show();
	    setTimeout(function() {
	        $('#infoBox').fadeOut();
	    }, 3000);
	}

	function showError(errorMsg) {
	    let errorBox = $('#errorBox');
	    errorBox.find('span').text("Error: " + errorMsg);
	    errorBox.show();
	}
	
	return {
		handleAjaxError,
		showInfo, 
		showError
	}
	
})();


