function selectBoardOne(){

    const no = location.href.split("/").pop();
    const url = `http://127.0.0.1:8080/api/board/${no}`;
    const option = {};

    fetch(url)
    .then( resp => resp.json() )
    .then( map => {
        console.log(map);
        const vo = map.data;
        const resultArea = document.querySelector("#result-area");
        resultArea.innerHTML = `
            <h1>${vo.title}</h1>
            <h3>${vo.hit}</h3>
            <h3>${vo.writerNo}</h3>
            <h3>${vo.content}</h3>
            <h3>${vo.originName}</h3>
            <h3>${vo.changeName}</h3>
            <img src="http://192.168.20.209:5500/upload/${vo.changeName}">
        `;
    } )
    ;

}

selectBoardOne();