session = sessionStorage.getItem("id")
if(!session)
{
    location.href = "login.html"
}
document.getElementById("create").addEventListener("click",createPage);
document.getElementById("search").addEventListener("click",searchPage);
document.getElementById("update").addEventListener("click",updatePage);
document.getElementById("delete").addEventListener("click",deletePage);
document.getElementById("logout").addEventListener("click",logoutPage);


function createPage() {
    location.href = "create.html"
}



function searchPage() {
    location.href = "search.html"
}



function updatePage() {
    location.href = "update.html"
}



function deletePage() {
    location.href = "delete.html"
}



function logoutPage() {
    sessionStorage.clear();
    location.href = "login.html"
}



