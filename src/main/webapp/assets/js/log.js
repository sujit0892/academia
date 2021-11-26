document.getElementById("login").addEventListener("click", checkValue);
// document.getElementById("email").addEventListener("keyup",checkValue);
// document.getElementById("password").addEventListener("keyup",checkValue);
// document.getElementById("login").disabled = true;
// document.getElementById("login").style.opacity = 0.6;
// document.getElementById("alert").style.display="None";

// var form = document.getElementById("loginform")
// form.onsubmit(login())
var email = document.getElementById("email");
var password = document.getElementById("password");
function checkValue()
{

    if(document.getElementById("loginform").reportValidity()){
        login();
    }

}
let id = sessionStorage.getItem("id");
if(id)
{
    location.href = "create.html";
}
async function login()
{


    document.getElementById("login").disabled = true;
    document.getElementById("login").style.opacity = 0.6;
    email_value = email.value;
    password_value = password.value;
    if(email_value && password)
    {
        let response = await fetch('api/academia/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            email: email_value,
            password:password_value,
        })
    });

        let result =   response;
        console.log(response);
        if(result["status"]===200){
            let data = await result.text();
            sessionStorage.setItem("id", data);
            document.getElementById("login").disabled = false;
            location.href = "create.html";

        }else{
            document.getElementById("login").disabled = false;
            document.getElementById("login").style.opacity = 1.0;
            document.getElementById("alert").style.display="block";
        }


    }

}