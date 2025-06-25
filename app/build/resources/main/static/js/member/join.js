function join() {
    console.log("f01 called");

    const id = document.querySelector("input[name=id]").value;
    const pwd = document.querySelector("input[name=pwd]").value;
    const nick = document.querySelector("input[name=nick]").value;
    const fileInput = document.querySelector("input[name=f]");
    const profile = fileInput.files[0];

    const fd = new FormData();
    fd.append("id", id);
    fd.append("pwd", pwd);
    fd.append("nick", nick);
    fd.append("f", profile);

    const url = "http://127.0.0.1:8080/api/member";
    const option = {
        method: "POST" ,
        body : fd ,
    };
    fetch(url, option)
    .then( resp => resp.json() )
    .then( result => {
        console.log(result);
        //회원가입 됐으면 로그인 페이지 보내주고, 잘 안됐으면 실패로그 띄워준다
        if(result == 1) {
            alert("회원 가입 성공 !!! ");
            location.href = "/member/login";
        } else {
            alert("회원가입 실패 ... ");
            location.reload();
        }
        
    } )
    ;
}

function showPreview(){
    const fileInput = document.querySelector("input[name=f]");
    const profilePreview = document.querySelector("#profile-preview");

    const f = fileInput.files[0];

    const fr = new FileReader();
    fr.onload = (e)=>{ 
        profilePreview.src = e.target.result;
    };
    fr.readAsDataURL(f);
}