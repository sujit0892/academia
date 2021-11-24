document.getElementById("domain").addEventListener("click",setDomain);
document.getElementById("student").addEventListener("click",setStudent);
document.getElementById("reset").addEventListener("click",reset);
document.getElementById("submit").addEventListener("click",submit);


var domain_id= document.getElementById("domainid");
var roll_no = document.getElementById("rollno");
var desc=document.getElementById("desc_t");
var amount = document.getElementById("amount");
var deadline = document.getElementById("deadline");
var roll_div = document.getElementById("rollno-div");
domain_id.addEventListener("change",checkValue);
document.getElementById("submit").disabled = true;
document.getElementById("submit").style.opacity = 0.6;
var domain_div = document.getElementById("select-div");
domain_id.value = "";
roll_no.value = "";
desc.value = "";
amount.value = ""
deadline.value = "";
roll_div.style.display = "none";
domain_div.style.display="block";
roll_no.addEventListener("keyup",checkValue);
desc.addEventListener("keyup",checkValue);
amount.addEventListener("keyup",checkValue);
deadline.addEventListener("keyup",checkValue);
deadline.addEventListener("change",checkValue);
document.getElementById("alert").style.display="None";
document.getElementById("danger").style.display="None";



getDomain();
async function getDomain()
{
    let response = await fetch('api/academia/getDomain', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
    });
    let dresult =   response;

    if(dresult["status"]===200){
        let data = await response.json();
        console.log(data);
        val = "<option value=''> Choose...</option>";
        for(var i=0;i<data.length;i++)
        {
            val+="<option value='"+data[i]["domain_id"]+"'>"+data[i]["program"]+" "+data[i]["batch"]+"</option>";
            console.log(val);
        }
        domain_id.innerHTML = val;
    }else{

        document.getElementById("danger").style.display="block";
        document.getElementById("danger").innerHTML="Error!";

    }
}

function setDomain()
{

    document.getElementById("dropdownMenuButton").value = "Domain";
    document.getElementById("dropdownMenuButton").innerHTML = "Domain";
    document.getElementById("toggle_l").innerHTML = "Domain";
    roll_div.style.display = "none";
    domain_div.style.display="block";
    domain_id.value=""
    roll_no.value = "";
    desc.value = "";
    amount.value = ""
    deadline.value = "";
}

function setStudent()
{
    document.getElementById("dropdownMenuButton").value = "Student";
    document.getElementById("dropdownMenuButton").innerHTML = "Student";
    document.getElementById("toggle_l").innerHTML = "Roll no";
    domain_id.value = "";
    roll_no.value = "";
    desc.value = "";
    amount.value = ""
    deadline.value = "";
    roll_div.style.display = "block";
    domain_div.style.display="none";
}

function reset()
{

    domain_id.value=""
    roll_no.value = "";
    desc.value = "";
    amount.value = ""
    deadline.value = "";
}


function checkValue()
{
    if(desc.value && amount.value && deadline.value && (rollno.value || domain_id.value))
    {
        document.getElementById("submit").disabled = false;
        document.getElementById("submit").style.opacity = 1;
    }
    else
    {
        document.getElementById("submit").disabled = true;
        document.getElementById("submit").style.opacity = 0.6;
    }
}

async function submit()
{
    document.getElementById("submit").disabled = true;
    document.getElementById("submit").style.opacity = 0.6;
    var description = desc.value;
    var amt = amount.value;
    var dead = deadline.value;
    var domain=null;
    var rollno =null;
    if(document.getElementById("dropdownMenuButton").value==="Domain")
        domain = domain_id.value;
    else
        rollno = roll_no.value;

    let response = await fetch('api/academia/createbill', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify({
            description: description,
            rollno:rollno,
            domain:domain,
            amount:amt,
            deadline:dead
        })
    });
    let result =   response;
    console.log(response);
    if(result["status"]===200){
        let data = await result.text();

        roll_no.value = "";
        domain_id.value="";
        desc.value = "";
        amount.value = ""
        deadline.value = "";
        document.getElementById("danger").style.display="None";
        document.getElementById("alert").style.display="block";
        if(data>0)
            document.getElementById("alert").innerHTML="<strong>Bill Generated! bill id: "+data+"</strong>";
        else
            document.getElementById("alert").innerHTML="<strong>Bill Generated! bill </strong>";
    }else{
        if(document.getElementById("dropdownMenuButton").value==="Domain")
            document.getElementById("danger").innerHTML = "No student in this domain";
        else
            document.getElementById("danger").innerHTML = "Roll no dont exist";
        document.getElementById("submit").disabled = false;
        document.getElementById("submit").style.opacity = 1.0;
        document.getElementById("alert").style.display="None";
        document.getElementById("danger").style.display="block";

    }

}

