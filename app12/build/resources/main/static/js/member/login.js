function login() {
    const userId = document.querySelector("input[name=userId]").value;
    const userPwd = document.querySelector("input[name=userPwd]").value;
    const vo = {
        userId,
        userPwd,
    };
    const url = "http://127.0.0.1:8080/api/member/login";
    const option = {
        method : "POST",
        headers : {
            "Content-Type" : "application/json"
        },
        body : JSON.stringify(vo),
    };
    fetch(url, option)
    // .then(resp => JSON() )
    .then(resp => resp.json() )
    .then(map => {
        const vo = map.data;
        alert(`${vo.userNick} 님 로그인 성공!`);
        location.href="http://127.0.0.1:8080/board/insert";
    } )
    .cath(err => {
        location.reload;
    })
    ;
}