console.log("zzz");

function f01() {

    console.log("f01 called");

    const title = document.querySelector("#a").value;
    const content = document.querySelector("#b").value;
    
    // POST : 127.0.0.1:8080/board/insert + packed body > data
    const vo = {
        title , //  value 값의 경우, 문자열 그대로 내보낼 경우 "" 따옴표, key 값이면 그냥 써줘도 ok 
        content ,
    };
    
    const url = "http://127.0.0.1:8080/api/board/insert";
    const option = {
        method : "POST",
        // headers : {},
        headers : {
            "Content-Type" : "application/json"
        },
        // body : "title 제목01 / content 내용01",
        // body : "{title: 제목01, content: 내용01}",
        body :  JSON.stringify(vo),
    }; 
    fetch(url, option)
    .then( resp => resp.text() )
    .then( data => {
        // console.log(data);
        if(data == 1){
            location.href = "http://127.0.0.1:8080/board/list";
        } else {
            alert("작성 실패 ...");
        }
        location.href = "http://127.0.0.1:8080/board/list";
        // 작성하기 잘됐을 때 보내는 걸로
    })
    ;

}
