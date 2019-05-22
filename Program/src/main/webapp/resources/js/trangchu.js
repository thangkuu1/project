var data = '';
$(document).ready(function() {
	detailLoadFood();
});

detailLoadFood = function() {
	$.ajax({
		url: '/Project/detail-load-food',
		type: 'post',
		success: function(result) {
			data = result.data;

		}
	})
	.done(function() {
		console.log("success");
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		console.log("complete");
	});
	
}