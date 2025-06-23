function insertBoard() {
    
    console.log("zzz");

    const title = document.querySelector("input[name=title]").value;
    const content = document.querySelector("textarea[name=content]").value;
    const fileTag = document.querySelector("input[name=f]");
    const f = fileTag.files[0];

    const fd = new FormData();
    fd.append("title", title);
    fd.append("content", content);
    fd.append("f", f);

    const url = "http://127.0.0.1:8080/api/board";
    const option = {
        method : "POST",
        body : fd ,
    };
    
    fetch(url, option)
    .then( resp => resp.json() )
    .then( data => {
        console.log(data);
        
    } )
    ;
}

