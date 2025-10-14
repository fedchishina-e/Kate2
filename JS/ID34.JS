const Http = new XMLHttpRequest();
const url='http://example.com/';
Http.open("GET", url);
Http.send();
Http.onreadystatechange=(e)=>{
console.log(Http.responseText)
}

