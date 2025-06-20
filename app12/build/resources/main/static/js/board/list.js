function selectBoardList(){
    const url = "http://127.0.0.1:8080/api/board";
    fetch(url)
    .then(resp => resp.json())
    .then(map => {
        const voList = map.data;
        const tbody = document.querySelector("tbody");
        tbody.innerHTML = "";
        let str = "";
        for(const vo of voList){
            str += `
                <tr>
                    <td>${vo.no}</td>
                    <td>${vo.title}</td>
                    <td>${vo.writerNo}</td>
                </tr>
            `;
        }
        tbody.innerHTML = str;
    })
    ;
}

selectBoardList();