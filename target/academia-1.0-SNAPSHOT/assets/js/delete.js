document.getElementById("search-text").addEventListener("keyup",Search);
var table = document.getElementById("table");
var table_header = "<tr class=\"header\">\n" +
    "                    <th style=\"width:10%;\">Bill id</th>\n" +
    "                    <th style=\"width:12%;\">Roll no</th>\n" +
    "                    <th style=\"width:32%;\">Description</th>\n" +
    "                    <th style=\"width:10%;\">Amount</th>\n" +
    "                    <th style=\"width:12%;\">Bill Date</th>\n" +
    "                    <th style=\"width:12%;\">Deadline</th>\n" +
    "                    <th style=\"width:12%;\"><input type='checkbox' id='source' onchange='selectAll()'></th>\n" +
    "                </tr>";


document.getElementById("delete-btn").addEventListener("click",deleteBill);

table.innerHTML=table_header;


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
        val+= "<tr><td>"+data[i]['bill']['id']+"</td><td>"+data[i]['roll_number']+"</td><td>"+data[i]['bill']['description']+"</td><td>"+
            data[i]['bill']['amount']+"</td><td>"+new Date(data[i]['bill']['bill_date']).toDateString()+"</td><td>"+new Date(data[i]['bill']['deadline']).toDateString()+"</td>" +
            "<td><input type=\"checkbox\" class='check'  value=\""+data[i]['bill']['id']+"\"></td></tr>" ;



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

function selectAll()
{

    source = document.getElementById("source");
    checkboxes = document.getElementsByClassName('check');

    for(var i=0;i<checkboxes.length;i++)
        checkboxes[i].checked = source.checked;
}

async function deleteBill(){
    document.getElementById("delete-btn").disabled = true;
    document.getElementById("delete-btn").opacity = 0.6;
    document.getElementById("danger").style.display = "none";
    checkboxes= document.getElementsByClassName('check');
    data = [];
    flag = 0;
    for(var i=0;i<checkboxes.length;i++)
    {
        if(checkboxes[i].checked) {
            data.push({"billId": checkboxes[i].value});
            flag=1;
        }

    }
    if(!flag) {
        document.getElementById("danger").style.display = "block";
        document.getElementById("delete-btn").disabled = false;
        document.getElementById("delete-btn").opacity = 1;
        return

    }
    let response = await fetch('api/academia/deleteBill', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json;charset=utf-8'
        },
        body: JSON.stringify(data)
    });
    let result =   response;
    console.log(response);
    if(result["status"]===200){

        location.href = "delete.html";

    }else{
        document.getElementById("delete-btn").disabled = false;
        document.getElementById("delete-btn").style.opacity = 1.0;

    }

}

