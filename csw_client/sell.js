var domain = "http://localhost:8080/api";
$(document).ready(function(){
  $("#save").on("click", function(){
    addProduct();
  });
})

function addProduct() {
    var id = $("#id").val();
    var quantity = $("#quantity").val();
  $.ajax({
    type: "POST",
    url: domain + "/sell?id="+id+"&quantity="+quantity,
    contentType: "application/json; charset=utf-8",
    datatype: "json",
    
    success: function (response) {
      console.log(response);
      window.location.href = "index.html";
    },
  });


}