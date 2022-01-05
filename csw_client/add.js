var domain = "http://localhost:8080/api";
$(document).ready(function(){
  $("#save").on("click", function(){
    addProduct();
  });
})

function addProduct() {
    var data = {
        name: $("#nane").val(),
        quantity: $("#quantity").val(),
        price: $("#price").val(),
      };
  $.ajax({
    type: "POST",
    url: domain + "/save",
    contentType: "application/json; charset=utf-8",
    data: JSON.stringify(data),
    datatype: "json",
    
    success: function (response) {
      console.log(response);
      window.location.href = "index.html";
    },
  });


}