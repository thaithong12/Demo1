$(document).ready(function() {
	handleChangeColor();
	
	$("#color-change-select").change(function() {
		handleChangeColor();
	});

	function handleChangeColor(){
		let color_id = $("#color-change-select").val();
		let product_id = get('id');
		//let product_id = $("#color-change-select").attr('productid');
		$.ajax({
			contentType: "application/json; charset=utf-8",
			url: "http://localhost/api/change-color",
			method: "POST",
			data: JSON.stringify({
				productId: product_id,
				colorId: color_id
			}),
		}).then(function(data) {
			$("#price-after").text(data.price.toLocaleString('it-IT', { style: 'currency', currency: 'VND' }));
		});
	}
	function get(name) {
		if (name = (new RegExp('[?&]' + encodeURIComponent(name) + '=([^&]*)')).exec(location.search))
			return decodeURIComponent(name[1]);
	}
});