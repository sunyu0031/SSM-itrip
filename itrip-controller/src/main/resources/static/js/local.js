$(function(){
    var message = $("#message").val();
    if(message == "success"){
        $("#myModalLabel").text("激活");
        $('#myModal').modal();
    }
});