$(document).ready(function() {
	handleChangeColor();
	
	//$("#color-change-select").change(function() {
		
	//});
	
	document.getElementById("color-change-select").addEventListener("change", (e) => {
		handleChangeColor();
	})
	

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

	document.getElementById("add-to-cart-btn").addEventListener("click", (e)=> {
		let color_id = $("#color-change-select").val();
		let product_id = get('id');
		
		let productJSObj = {
			colorId: color_id,
			productId: product_id
		}

		// console.log(productJSObj);
		let productJSONObj = JSON.stringify(productJSObj);
		$.ajax({
			contentType: "application/json; charset=utf-8",
			url: "http://localhost/api/handle-add-cart",
			method: "POST",
			data: productJSONObj,
		}).then(function() {
			getInfoCart();
		});
	});

	function getInfoCart() {
		$.ajax({
			contentType: "application/json; charset=utf-8",
			url: "http://localhost/api/info-cart",
			method: "POST",
		}).then(function(data) {
			return data;
		});
	}

	document.getElementById("btn-info-cart").addEventListener("click", (e) => {
		let a = document.getElementsByClassName("product-widget")[0].cloneNode(true);
		document.getElementsByClassName("product-widget")[0].remove
		//console.log(a);
		let cartlist = document.getElementsByClassName("cart-list")[0];
		$.ajax({
			contentType: "application/json; charset=utf-8",
			url: "http://localhost/api/info-cart",
			method: "POST",
		}).then(function(data) {
			data.forEach(elm => {
				console.log(elm)
				let b = a.cloneNode(true);
				b.getElementsByTagName("img")[0].src = "resources/images/" + elm.image;
				cartlist.append(b);
			});
		});
	})
});