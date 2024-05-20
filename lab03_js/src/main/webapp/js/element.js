/**
 * element.html에 포함
 */

const btn1 = document.querySelector('button#btn1'); //tag이름은 생략 가능. (id가 한 개인 경우)
//css에서 찾을 때 쓰는 문법 이용. #id .class로 검색

//btn1 요소에 클릭 이벤트 리스너를 설정
btn1.addEventListener('click',function(){
    //document.getElementById(id) 사용. id = id1인 요소 찾기
    const div1 = document.getElementById('id1'); //딱 그 id인 애만 검색. id 자체를 입력
    // 같은 id를 갖는 요소가 여러개가 있으면 가장 먼저 찾은 요소만 리턴. 
    // console.log(div1);
    div1.style.backgroundColor = 'lime';
}); 

// button#btn2인 요소를 찾고 클릭 리스너 설정
const btn2 = document.querySelector('button#btn2');

//이벤트 리스너는 class 속성값이 c1인 요소들의 바탕색 변경
btn2.addEventListener('click',function(){
    const divs= document.getElementsByClassName('c1'); //HTML Collection(배열과 비슷) 리턴
    //console.log(divs);
    for(let val of divs){
        val.style.backgroundColor = 'crimson';
    }
    
});


//button#btn3
const btn3 = document.querySelector('button#btn3');
btn3.addEventListener('click',() => {
    //태그 이름이 div인 모든 요소들을 찾아서 바탕색 변경
     const divs = document.getElementsByTagName('div');
     for(let val of divs){
        val.style.backgroundColor = 'teal';
    }
});

// document.querySelector() , document.querySelectorAll() 는
// CSS 선택자 문법으로 아규먼트를 전달한다!
//tag name, #id, .classname, tagname#id.classname
// parent > child
// ancestor descendent
// element: pseudo - selector

const btn4 = document.querySelector('button#btn4');
btn4.addEventListener('click', function(){
    const div4 = document.getElementById('id4'); //querySelector('div#id4')로 써줘도 좋음
    div4.style.backgroundColor = 'lavender'
    
});

const btn5 = document.querySelector('button#btn5');
btn5.addEventListener('click', () => {
    const divs = document.querySelectorAll('div');
    //console.log(divs);
    /*
    for(let val of divs){
        val.style.backgroundColor = 'pink';
    }
    */
   divs.forEach((x)=> x.style.backgroundColor = 'violet');
});

