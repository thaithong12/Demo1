$(document).ready(function() {

	function getInfoCart() {
		$.ajax({
			contentType: "application/json; charset=utf-8",
			url: "http://localhost/api/info-cart",
			method: "POST",
		}).then(function(data) {
			return data;
		});
	}
	
	let a = document.getElementsByClassName("product-widget")[0].cloneNode(true);
	
	document.getElementById("btn-info-cart").addEventListener("click", (e) => {
		//document.getElementsByClassName("product-widget")[0].remove
		$(".product-widget").first().remove();
		//console.log(a);
		let cartlist = document.getElementsByClassName("cart-list")[0];
		$(".cart-list").html('');
		$.ajax({
			contentType: "application/json; charset=utf-8",
			url: "http://localhost/api/info-cart",
			method: "POST",
		}).then(function(data) {
			if(data && data.length > 0){
				let total = 0;
				data.forEach(elm => {
					console.log(elm)
					let b = a.cloneNode(true);
					b.getElementsByTagName("img")[0].src = "resources/images/" + elm.image;
					b.getElementsByTagName("a")[0].href = "http://localhost/product-detail?id="+elm.productId;
					b.getElementsByTagName("a")[0].innerHTML = elm.name;
					b.getElementsByTagName("span")[0].innerHTML = "x"+ elm.quantity;
					b.getElementsByTagName("span")[1].innerHTML = elm.price.toLocaleString('it-IT', { style: 'currency', currency: 'VND' });
					cartlist.append(b);
					total += elm.quantity * elm.price;
				});
				$("#sub-total").text("Subtotal : " +total.toLocaleString('it-IT', { style: 'currency', currency: 'VND' }))
			} else {
				cartlist.append('Khong co san pham nao');
				$("#sub-total").text("Subtotal : 0")
			}
			
		});
	
	})
});