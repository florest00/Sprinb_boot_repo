function selectList() {
    const url = "http://127.0.0.1:8080/api/board";
    fetch(url)
    .then( resp => resp.json() )
    .then( map => {
        const voList = map.data;
        let str = ""; 

        // of => js 향상된 for문
        for(const vo of voList){
            str += `
                <tr onclick="location.href='http://127.0.0.1:8080/board/detail/${vo.no}'">
                    <td>${vo.no}</td>
                    <td>${vo.title}</td>
                    <td>${vo.writerNo}</td>
                </tr>
            `;
        }


        const tbody = document.querySelector("tbody");
        tbody.innerHTML = "";
        tbody.innerHTML = str;
    } )
    ;
}

selectList();