document.getElementById("search-text").addEventListener("keyup",Search);
var table = document.getElementById("table");
var table_header = "<tr class=\"header\">\n" +
    "                    <th style=\"width:10%;\">Bill id</th>\n" +
    "                    <th style=\"width:12%;\">Roll no</th>\n" +
    "                    <th style=\"width:32%;\">Description</th>\n" +
    "                    <th style=\"width:10%;\">Amount</th>\n" +
    "                    <th style=\"width:12%;\">Bill Date</th>\n" +
    "                    <th style=\"width:12%;\">Deadline</th>\n" +
    "                </tr>";




table.innerHTML=table_header;
var model = document.getElementById("modalid");
var span = document.getElementById("cancelB");
var txt = document.getElementById("updatetxt");
var dat = document.getElementById("updatecalender");

var label = document.getElementById("label");
var heading = document.getElementById("h-billid")
var up = document.getElementById("updateBill");
var amttxt = document.getElementById("amttxt");
txt.addEventListener("keyup",checkValue);
dat.addEventListener("keyup",checkValue);
dat.addEventListener("change",checkValue);
amttxt.addEventListener("keyup",checkValue);

function  checkValue()
{
    if(txt.value || amttxt.value || dat.value)
    {
        up.disabled = false;
        up.style.opacity = 1.0;
    }
    else
    {
        up.disabled = true;
        up.style.opacity = 0.6;
    }
}

function closeModel() {
    model.style.display="none";
    txt.style.display="none";
    dat.style.display="none";
    amttxt.style.display="none";
    up.value="";
    txt.value=null;
    amttxt.value=null;
    dat.value = null;
    document.getElementById("danger").style.display="none";
}

up.addEventListener("click",checkValidity);
span.addEventListener("click",closeModel)

// function validityCheck()
// {
//     if(document.getElementById("formId").reportValidity()){
//         updateBill();
//     }
// }


viewBill();



async function viewBill()
{
    let response = await fetch('api/academia/viewBill', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        }
    });
    let result =   response;
    console.log(response);
    if(result["status"]===200){
        let data = await result.json();
        createTable(data);

    }
}

function createTable(data)
{
    var val= "";

    for(let i=0;i<data.length;i++)
    {
        if(!data[i]['status'])
        val+= "<tr id='"+data[i]['bill']['id']+"'><td>"+data[i]['bill']['id']+"</td><td>"+data[i]['roll_number']+"</td><td class= 'desc' onclick='updateDesc("+data[i]['bill']['id']+")'>"+data[i]['bill']['description']+"</td><td class='amt' onclick='updateAmt("+data[i]['bill']['id']+")'>"+
            data[i]['bill']['amount']+"</td><td>"+new Date(data[i]['bill']['bill_date']).toDateString()+"</td><td class='dead' onclick='updateDeadline("+data[i]['bill']['id']+")'>"+new Date(data[i]['bill']['deadline']).toDateString()+"</td></tr>" ;


    }
    table.innerHTML=table_header+val;
}


function Search() {
    var input, filter, table, tr, td, i, txtValue;
    input = document.getElementById("search-text");
    filter = input.value.toUpperCase();
    table = document.getElementById("table");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td");
        for (j = 0; j < td.length; j++)
        {    if (td[j]) {
            txtValue = td[j].textContent || td[j].innerText;
            if (txtValue.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
                break;
            } else {
                tr[i].style.display = "none";
            }
        }
        }
    }
}

function updateDesc(id)
{
    checkValue();

    model.style.display="block";
    txt.style.display = "block";
    heading.innerHTML = "Bill id: "+id;
    label.innerHTML="Description";
    up.value = id;


}
function updateAmt(id)
{
    checkValue();
    model.style.display="block";
    amttxt.style.display = "block";
    heading.innerHTML = "Bill id: "+id;
    up.value = id;
    label.innerHTML="Amount";

}
function updateDeadline(id)
{
    checkValue();
    model.style.display="block";
    model.style.display="block";
    dat.style.display = "block";
    heading.innerHTML = "Bill id: "+id;
    up.value = id;
    label.innerHTML="Deadline";
}

function checkValidity()
{
    desctxt = txt.value;
    deadlinetxt = dat.value;
    amt_txt = amttxt.value;
    if(desctxt)
    {
        if(document.getElementById("updform").reportValidity()){
            updateBill();
        }
    }
    else if(deadlinetxt)
    {
        if(document.getElementById("deadform").reportValidity()){
            updateBill();
        }

    }
    else if(amt_txt)
    {
        if(document.getElementById("amtform").reportValidity()){
            updateBill();
        }
    }
}
async function updateBill()
{
    up.disabled = true;
    up.style.opacity = 0.6;
    document.getElementById("cancelB").disabled = true;
    document.getElementById("cancelB").style.opacity = 0.6;

    desctxt = txt.value;
    deadlinetxt = dat.value;
    amt_txt = amttxt.value;
    var response = "";
    if(desctxt)
    {
         response = await fetch('api/academia/updateDescription', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                id: up.value,
                description:desctxt
            })
        });
    }
    else if(deadlinetxt)
    {

         response = await fetch('api/academia/updateDeadline', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                id: up.value,
                deadline:deadlinetxt,
            })
        });
    }
    else if(amt_txt)
    {
         response = await fetch('api/academia/updateAmount', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=utf-8'
            },
            body: JSON.stringify({
                id: up.value,
                amount:amt_txt,
            })
        });
    }
    let result =   response;
    if(result["status"]===200){
        closeModel();
        location.href = "update.html";


    }else{
        closeModel();
        document.getElementById("danger").style.display="block";
        document.getElementById("cancelB").disabled = false;
        document.getElementById("cancelB").style.opacity = 1.0;
    }


}



