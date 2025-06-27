function login() {
    console.log("login called");

    const id = document.querySelector("input[name=id]").value;
    const pwd = document.querySelector("input[name=pwd]").value;

    const vo = {
        id ,
        pwd ,
    };

    const url = "http://127.0.0.1:8080/api/member/login";
    const option = {
        method: "POST" ,
        headers : {
            "Content-Type" : "application/json" ,
        } ,
        body : JSON.stringify(vo) ,
    };
    fetch(url, option)
    // .then( resp => {resp.json()} )
    .then( resp => {
        if(!resp.ok){
            throw new Error();
        }
        return resp.json();
    } )
    .then( loginMember => {
        if(loginMember) {
            alert("로그인 성공 !!! ");
            location.href = '/home';
        } else {
            throw new Error();
        }
        
    } )
    .catch( err => {
        console.log(err);
        alert("로그인 실패 ... ");
        location.reload();
        //화면 새로고침
    } )
    ;
}