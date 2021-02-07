/**
 * Created by KA_Software_Tek on 12/9/2019.
 */

function resetLoginFields(){
    $("#username").val("");
    $("#password").val("");
}
function login(){
    var username = $("#username").val();
    var password = $("#password").val();

    if(username == ""){
        $("#snackbar").html("username cannot be empty.");
        $("#snackbar").show();
        setTimeout(function(){  $("#snackbar").hide(); }, 2000);
    }
    if(password == ""){
        $("#snackbar").html("password cannot be empty.");
        $("#snackbar").show();
        setTimeout(function(){  $("#snackbar").hide(); }, 2000);
    }
}