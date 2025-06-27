function getBoardList(){

    const pno = location.href.split("/").pop();
    const url = `http://127.0.0.1:8080/api/board/${pno}`;
    fetch(url)
    .then( resp => {
        if(!resp.ok){
            throw new Error();
        }
        return resp.json();
    } )
    // .then( voList => {
    .then( map => {
        // console.log(voList);
        const voList = map.voList;
        const pvo = map.pvo;
        // tbody를 voList로 채움
        const tbody = document.querySelector("main tbody");
        let str = "";

        //voList가 잘 받아지고 있는지
        console.log(voList);
        

        for(const vo of voList){
            str += `
                <tr>
                    <td>${vo.no}</td>
                    <td>${vo.title}</td>
                    <td>${vo.hit}</td>
                    <td>${vo.writerNo}</td>
                </tr>
            `;
        }

        tbody.innerHTML = str;

        //page-area 를 pvo 로 채움
        const pageAreaDiv = document.querySelector("#page-area");
        let pageStr = "";
        // for(let i = pvo.startPage; i <= 5; ++ i) {


        // if( pvo.startPage != 1 ){
        //     pageStr += `<button onclick = "location.href='/board/list/${pvo.startPage-1}'">이전</button>`;
        // }
        if( pvo.startPage > 1 ){
            pageStr += `<button onclick = "location.href='/board/list/${pvo.startPage-1}'">이전</button>`;
        }


        for(let i = pvo.startPage; i <= pvo.endPage; ++ i) {
            pageStr += `<button onclick = "location.href='/board/list/${i}'">${i}</button>`;
        }


        if( pvo.endPage < pvo.maxPage ){
            pageStr += `<button onclick = "location.href='/board/list/${pvo.endPage+1}'">다음</button>`;
        }
        // if( pvo.endPage === pvo.maxPage ){
        //     pageStr += `<button onclick = "location.href='/board/list/${pvo.endPage+1}'">다음</button>`;
        // }


        pageAreaDiv.innerHTML = pageStr;

    } )
    .catch( err => {
        console.log(err);
    } )
    ;
}

getBoardList();