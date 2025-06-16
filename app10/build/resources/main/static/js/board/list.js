console.log("quero ir embora pra casa");

const url = "http://127.0.0.1:8080/api/board/list";
// const option = {
//     method : "get",
//     // headers : {}, // headers도 마찬가지로 쓸 필요  x 써도 상관 x
//     // body : , //body를 무조건 쓸 필요 x 
// }; // 결론은 option 안 써도 됨
// fetch(url, option); // 자동으로 get방식으로 url 불러온다 (?)
fetch(url) 
.then( resp => resp.json() ) // 서버측에서 json 변환 알아서 해주니 할 필요 x
.then( data => {
    console.log(data);
    
})
;