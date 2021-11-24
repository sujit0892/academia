document.getElementById("search-text").addEventListener("keyup",Search);
var table = document.getElementById("table");
var table_header = "<tr class=\"header\">\n" +
    "                    <th style=\"width:10%;\">Bill id</th>\n" +
    "                    <th style=\"width:12%;\">Roll no</th>\n" +
    "                    <th style=\"width:32%;\">Description</th>\n" +
    "                    <th style=\"width:10%;\">Amount</th>\n" +
    "                    <th style=\"width:12%;\">Bill Date</th>\n" +
    "                    <th style=\"width:12%;\">Deadline</th>\n" +
    "                    <th style=\"width:12%;\"><select  onchange=changeStatus() id=\"status\">\n" +
    "    <option value=\"all\">All</option>\n" +
    "    <option value=\"paid\">Paid</option>\n" +
    "    <option value=\"unpaid\">Unpaid</option>\n" +
    "  </select></th>\n" +
    "                </tr>";




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
            data[i]['bill']['amount']+"</td><td>"+new Date(data[i]['bill']['bill_date']).toDateString()+"</td><td>"+new Date(data[i]['bill']['deadline']).toDateString()+"</td>" ;
        if(data[i]['status']==0)
        {
            val+="<td>Unpaid</td></tr>"
        }
        else
        {
            val+="<td>Paid</td></tr>"
        }
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


function changeStatus()
{

    var status, filter,table, tr, td, i, txtValue;
    status = document.getElementById("status");

    filter = status.value.toUpperCase();
    table = document.getElementById("table");
    tr = table.getElementsByTagName("tr");
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td");

        if (td[td.length-1]) {
            txtValue = td[td.length-1].textContent || td[td.length-1].innerText;
            if (txtValue.toUpperCase()===filter || filter==="ALL") {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }

    }
}

