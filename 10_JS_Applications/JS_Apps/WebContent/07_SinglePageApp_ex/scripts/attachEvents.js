function attachAllEvents() {
	$('#linkLogin').on('click', function() {
		showView('viewLogin');
	});
	$('#linkHome').on('click', function() {
		showView('viewHome');
	});
	$('#linkRegister').on('click', function() {
		showView('viewRegister');
	});
	$('#linkCreateAd').on('click', function() {
		showView('viewCreateAd');
	});
	
	$('#linkListAds').on('click', listAds);
	$('#linkLogout').on('click', logoutUser);
	
	$('#buttonLoginUser').on('click', loginUser);
	$('#buttonRegisterUser').on('click', registerUser);
	$('#buttonCreateAd').on('click', createAd);
	$('#buttonEditAd').on('click', editAd);
	
}
