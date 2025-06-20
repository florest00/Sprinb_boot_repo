function join() {
    const userId = document.querySelector("input[name=userId]").value;
    const userPwd = document.querySelector("input[name=userPwd]").value;
    const userNick = document.querySelector("input[name=userNick]").value;
    const vo = {
        userId ,
        userPwd ,
        userNick ,
    };
    const url = "http://127.0.0.1:8080/api/member/join";
    const option = {
        method : "POST",
        headers: {
            "Content-Type" : "application/json" ,
        },
        body: JSON.stringify(vo) ,
    };
    fetch(url, option)
    .then( resp => resp.json() )
    .then( map => {
        if(map.data == 1){
            alert("회원가입 성공 ! ");
            location.href = "http://127.0.0.1:8080/member/login";
        } else {
            alert("회원가입 실패 ... ");
        }
    } )
    ;

}