
//insert
function insert(){
    const title = document.querySelector("#title").value;
    const content = document.querySelector("#content").value;
    const vo = {
        title ,
        content ,
    };
    const url = "http://127.0.0.1:8080/api/board";
    const option = {
        method : "POST" ,
        headers : {
            "Content-Type" : "application/json"
        } ,
        body : JSON.stringify(vo) ,
    };
    fetch(url, option)
    .then( resp => resp.text() )
    .then( data => {
        console.log(data);
        if(data == 1){
            alert("게시글 작성 성공 !");
        }else {
            alert("게시글 작성 실패 ...");
        }
        
    } )
    ;
}


//목록조회
function selectList(pno = "1"){
    const url = `http://127.0.0.1:8080/api/board?pno=${pno}`;
    fetch(url)
    .then(resp => resp.json() )
    .then( map => {
        const voList = map.voList;
        const pvo = map.pvo;
        console.log(voList);
        const tbody = document.querySelector("tbody");
        let str = "";
        for(const vo of voList){
            str += `<tr onclick='selectOne(${vo.no});'>`;
            str += `<td>${vo.no}</td>`;
            str += `<td>${vo.title}</td>`;
            str += `<td>${vo.createdDate}</td>`;
            str += "</tr>";
        }
        
        tbody.innerHTML = str;
        createPageAreaBtn(pvo);
    })
    ;



}

//상세조회
function selectOne(no) {
    const url = `http://127.0.0.1:8080/api/board/${no}`;
    fetch(url)
    .then(resp => resp.json() )
    .then(vo => {
        console.log(vo);
        const boardDetail = document.querySelector("#boardDetail");
        let str = "";
        str += `
            <h3>제목 : ${vo.title}</h3>
            <h4>작성일 : ${vo.createDate}</h4>
            <h4>조회수 : ${vo.hit}</h4>
            <p>${vo.content}</p>
        `;
        boardDetail.innerHTML = str;
    } )
    ;
}

function createPageAreaBtn(pvo) {
    console.log(pvo);
    const pageArea = document.querySelector("#page-area");
    pageArea.innerHTML = "";
    if(pvo.startPage != 1){
        pageArea.innerHTML += `<button onclick="selectList(${pvo.startPage - 1});">이전</button>`;
    } 
    for(let i = pvo.startPage; i <= pvo.endPage; ++i){
        if(pvo.currentPage == i) {
            pageArea.innerHTML += `<button disabled onclick="selectList(${i});">${i}</button>`;
        }else {
            pageArea.innerHTML += `<button onclick="selectList(${i});">${i}</button>`;
        }
    }
    if(pvo.endPage != pvo.maxPage){
        pageArea.innerHTML += `<button onclick="selectList(${pvo.endPage + 1});">다음</button>`;
    }
}