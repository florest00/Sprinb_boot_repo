function selectMemberOne() {

    fetch("http://127.0.0.1:8080/api/member")
    .then( resp => resp.json() )
    .then( loginMember => {
        document.querySelector("input[name=id]").value = loginMember.id;
        document.querySelector("input[name=nick]").value = loginMember.nick;
    } )
    ;

}

selectMemberOne();

//quit
function quit(){

    const isReal = confirm("정말로 탈퇴하시겠습니까?");
    if(!isReal){return;}
    
    const url = "http://127.0.0.1:8080/api/member";
    const option = {
        method : "DELETE",
    };
    fetch(url, option)
    .then( resp => resp.json() )
    .then( result => {
        if(result == 1) {
            alert("회원 탈퇴 완료 !");
            location.href = "/home";
        } else {
            alert("회원 탈퇴 실패 ... ");
        }
    } )
    .catch( err => {} )
    ;
}

//current pwd empty check
function checkCurrentPwd() {
    const oldPwd = document.querySelector("input[name=oldPwd]").value;
    return oldPwd.length > 0;
}

function checkSamePwd(){
    const newPwd = document.querySelector("input[name=newPwd]").value;
    const newPwdCheck = document.querySelector("input[name=newPwdCheck]").value;
    return newPwd === newPwdCheck;
}

//edit
function edit(){
    // const result = checkCurrentPwd();
    const checkResultDiv = document.querySelector("#newPwdCheckResult");
    const pwdCheckResult = checkCurrentPwd();
    if(!pwdCheckResult){
        alert("현재 비밀번호를 입력하세요");
        return;
    }

    const isSame = checkSamePwd();
    if(!isSame){
        checkResultDiv.innerHTML = "일치하게 적어주세요";
        checkResultDiv.classList.add("color-red");
        return;
    }

    const pwd = document.querySelector("input[name=oldPwd]").value;
    const newPwd = document.querySelector("input[name=newPwd]").value;
    const nick = document.querySelector("input[name=nick]").value;
    const fileInputTag = document.querySelector("input[name=f]");
    const f = fileInputTag.files[0];
    const fd = new FormData();
    fd.append("pwd", pwd);
    fd.append("newPwd", newPwd);
    fd.append("nick", nick);
    fd.append("f", f);

    // console.log("edit ~~~ fetch ~~~");
    const url = "http://127.0.0.1:8080/api/member";
    const option = {
        method :  "PUT" ,
        body : fd ,
    };
    fetch(url, option)
    .then( resp => resp.json() )
    .then( result => {
        console.log(result);
        if(result === 1){
            alert("정보 수정 성공 !");
            location.href="/home";
        }else {
            alert("정보 수정 실패 ...");
        }
        
    } )
    ;

}