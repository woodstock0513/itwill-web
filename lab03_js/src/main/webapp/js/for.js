/**
 * 
 */

//아이디가 result인 HTML 요소를 찾음
 const result = document.getElementById('result');
 
 // result 요소에 추가할 HTML 코드를 저장하기 위한 문자열 변수
 let html = '';

 for (let x = 0; x<10; x++){
    html += `2 x ${x} = ${2*x} <br/>`; //문자열 템플릿
 }
 
 result.innerHTML +=html;
 result.innerHTML +='<hr/>'

 //result에 3~9단 붙이기 
 html = '';
 
 for (let x = 3; x<10;x++){
    for (let y=0; y<10; y++){
        html += `${x} x ${y} = ${x*y} <br/>`;
    }
   html +='<hr/>';
 }
 
result.innerHTML +=html;


//break를 사용해서 n단이  n * n까지만 계산 되도록 

html = '';
for (let x = 2; x<10; x++){
    for (let y=0;y<10;y++){
        html += `${x} x ${y} = ${x*y} <br/>`;
        if (x === y){
            break;
        }
    }
    html += '<hr/>';
}

result.innerHTML = html;
