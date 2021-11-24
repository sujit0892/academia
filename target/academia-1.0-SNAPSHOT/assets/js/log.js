document.getElementById("login").addEventListener("click", login);
document.getElementById("email").addEventListener("keyup",checkValue);
document.getElementById("password").addEventListener("keyup",checkValue);
document.getElementById("login").disabled = true;
document.getElementById("login").style.opacity = 0.6;
document.getElementById("alert").style.display="None";
function checkValue()
{

    email = document.getElementById("email").value;
    password = document.getElementById("password").value;
    if(email && password)
    {
        document.getElementById("login").disabled = false;
        document.getElementById("login").style.opacity = 1;
    }
    else
    {
        document.getElementById("login").disabled = true;
        document.getElementById("login").style.opacity = 0.6;
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
    email = document.getElementById("email").value;
    password = document.getElementById("password").value;
    if(email && password)
    {
        let response = await fetch('api/academia/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            email: email,
            password:password,
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