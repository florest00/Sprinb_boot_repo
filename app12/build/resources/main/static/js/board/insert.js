function insert(){

    const title = document.querySelector("input[name=title]").value;
    const content = document.querySelector("textarea[name=content]").value;
    const vo = {
        title ,
        content ,
    };
    const url = "http://127.0.0.1:8080/api/board";
    const option = {
        method : "POST" , 
        headers : {
            "Content-Type" : "application/json" ,
        } , 
        body : JSON.stringify(vo) ,
    };
    fetch(url , option)
    .then( resp => resp.json() )
    .then( map => {
        if(map.data == 1){
            alert("게시글 작성 성공 !");
            location.href = "http://127.0.0.1:8080/board/list";
        }else{
            alert("게시글 작성 실패 ...");
        }
    } )
    ;

}