function insert(){

    const title = document.querySelector("input[name=title]").value;
    const content = document.querySelector("input[name=content]").value;
    const categoryNo = document.querySelector("select[name=categoryNo]").value;

    const fd = new FormData();
    fd.append("title", title);
    fd.append("content", content);
    fd.append("categoryNo", categoryNo);

    const url = "http://127.0.0.1:8080/api/board";
    const option = {
        method: "POST" ,
        body : fd ,
    };
    fetch(url, option)
    .then( resp => {
        if(!resp.ok){
            throw new Error();
        }
        return resp.json();
    } )
    .then( result => {
        if(result == 1){
            alert("게시글 등록 성공 !");
            location.href = "/board/list";
        }else{
            alert("게시글 등록 실패 ...");
            // location.reload();
            // 혹시라도 실패했을 때 
            // 인풋태그 새로 달리는데(?) 테스트할 때 번거로워져서 주석처리
        }
    } )
    ;

    return false;
    // 얘를 써줘야 기본 submit 이벤트가 동작하지 않음
    // 없으면 페이지가 아예 갈린다(?) 액션에 있는 경로로 폼 태그

}

function showCategoryList() {
    //data
    const url = "http://127.0.0.1:8080/api/board/category";
    const option = {
        method : "~" ,
        headers : {} ,
    };
    //view
    fetch(url)
    .then( resp => {
        if(!resp.ok){
            throw new Error("HTTP STATUS CODE IS NOT OK");
        }
        return resp.json();
    } )
    .then( voList => {
        // console.log(voList);
        const selectTag = document.querySelector("select[name=categoryNo]");
        
        let str = "";
        for(const vo of voList){
            str += `
                <option value="${vo.no}">${vo.name}</option>
            `;
        }
        selectTag.innerHTML = str;
        
    } )
    .catch( err => {
        console.log(err);
        
    } )
    ;
    //json으로 보내는거 없고 get 방식으로 받아올거라 url만
}

showCategoryList();