var id=document.getElementById("input-text");
var id2=document.getElementById("video-data");
id.addEventListener("keydown",search);


function search(){
    var str=id.value;
    var text="";
    var xhttp=new XMLHttpRequest();
    xhttp.onreadystatechange=function () {
        if(this.readyState===4) {
            text = this.responseText;
            id2.innerHTML=text;
        }
    }
    xhttp.open("post", "search", true);
    xhttp.send(str);
}