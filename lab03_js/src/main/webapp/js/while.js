/**
 * while.html에 포함
 */

const list = document.querySelector('#list'); //id로 찾기.
 //document.getElementById('list')랑 같은거
 
const tableBody = document.querySelector('#tableBody');

let html = ''; //ul태그에 넣어줄 html 코드

let n = 1;
while (n<=5){
    html += `<li> 아이템 ${n} </li>`;
    n++;
}

list.innerHTML = html;

html='';
n=1;
while (n<=5){
    html += `<tr> <td>${n}</td> <td>제목${n}</td> </tr>`;    
    n++;
}
console.log(html);

tableBody.innerHTML = html;