var domain = "http://localhost:8080/api";
$(document).ready(function(){
  getList();
})

function getList() {
  $.ajax({
    type: "GET",
    url: domain + "/list",
    contentType: "application/json; charset=utf-8",
		datatype:"jsonp",
    async: false,
    success: function (response) {
      console.log(response);
      for (let index = 0; index < response.length; index++) {
        showSeminar(response[index]);
      }  
    },
  });
}

//show seminar
function showSeminar(product) {
  $("#list-seminar tbody").append(
    "<tr>" +
      "<td>" +
      product.id +
      "</td>" +
      "<td>" +
      product.name +
      "</td>" +
      "<td>" +
      product.price +
      "</td>" +
      "<td>" +
      product.quantity +
      "</td>" +
    "</tr>"
  );

}