/**
 * array.html에 포함 
 * 
 * 자바 스크립트의 배열(array): 여러개의 원소(아이템)들을 하나의 변수 이름으로 저장하기 위한 타입
 * 자바의 배열: 한가지 타입의 값들 여러개를 저장하는 타입
 * 자바 스크립트 배열에서는 다른 타입의 값들이 저장될 수 있음.
 * 인덱스는 둘 다 0부터 시작.
 */


//div #output인 요소를 찾음.
const output = document.querySelector('#output'); 

//배열 선언 & 초기화
const arr = [1,2,3]; //자바 : int[] arr = {1,2,3};

//배열 arr의 내용을 output 영역에 작성
let html='';
for (let i = 0; i<arr.length;i++){
    html += `${arr[i]}, `;   
}
output.innerHTML += html + '<br/>';

//자바 향상된 for 문장. for(변수 선언 : 배열)

html='';

//for-of 구문: 배열의 원소들을 iteration(순회)
for (let val of arr){
    html += `${val}, `;
}
output.innerHTML += html + '<br/>';


html='';
//for-in 문장: 배열의 인덱스들을 iteration
for (let idx in arr){
    html +=`${idx}번째 ${arr[idx]}, `;
}
output.innerHTML += html + '<br/>';

//배열 arr의 원소들의 합계, 평균을 output에 출력
html='';
let sum = 0;

for (let val of arr){
    sum += val;
}
html = `sum = ${sum}, average = ${sum/arr.length}`; // 자바와 달리 정수와 실수를 구분하지 않으므로 /는 몫 구하는게 아니라 걍 나누기
output.innerHTML += html + '<br/>';

//배열의 원소들을 ul의 li 요소로 만듦
const movie = ['로봇드림', '가필드', '이프: 상상의 친구'];
const list = document.querySelector('ul#list');

html='';
for (let val of movie){
    html += `<li>${val}</li>`;
}
list.innerHTML += html + '<br/>';