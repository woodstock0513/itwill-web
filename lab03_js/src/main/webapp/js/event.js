/**
 * event.html 에 포함
 */

//const output = document.querySelector('div#output');
const btnInput = document.querySelector('button#btnInput');
/*
btnInput.addEventListener('click', function(e){ //callback 함수
    console.log(e); //PointerEvent가 반환됨
    
    const itemInput = document.querySelector('input#itemInput');
    const output = document.querySelector('div#output');
    output.innerHTML = itemInput.value;
    itemInput.value = '';
}); 
*/
//input 내용을 list에 하나씩 저장되도록
btnInput.addEventListener('click', function(){
    const itemInput = document.querySelector('input#itemInput');
    const itemList = document.querySelector('ul#itemList');
    itemList.innerHTML += `<li>${itemInput.value}</li>`
    //itemList.innerHTML += itemInput.value + '<br/>';
    itemInput.value = '';
});

// TODO: input#itemInput2 요소에 'keydown' 이벤트 리스너를 등록:
// 엔터키가 눌렸을 때, input에 입력된 내용을 ul#itemList2의 리스트 아이템으로 추가.

const input = document.querySelector('input#itemInput2');
input.addEventListener('keydown', function(e){
    if (e.keyCode == 13){ //e.key==='Enter'
        const itemList2 = document.querySelector('ul#itemList2');
        itemList2.innerHTML += `<li>${input.value}</li>`;
        input.value = '';
    }
    //아무것도 없을때에도 입력됨
});

// TODO: input#username 요소에 'change' 이벤트 리스너를 등록:
// input에 입력된 내용이 바뀔 때마다 div를 입력 내용으로 덮어씀.
const userNameInput = document.querySelector('input#username');
const output = document.querySelector('div#output');
userNameInput.addEventListener('change',function(e){
    output.textContent = e.target.value;
    //output.innerHTML = userNameInput.value; 으로 써도됨
}); 

// TODO: img#bulb 요소에 'mouseenter' 이벤트 리스너를 등록:
// img의 src를 'images/bulb_on.gif'로 변경.

const bulb = document.querySelector('#bulb');
bulb.addEventListener('mouseenter', function(e){
    bulb.src = 'images/bulb_on.gif';
});

// TODO: img#bulb 요소에 'mouseleave' 이벤트 리스너를 등록:
// img의 src를 'images/bulb_off.gif'로 변경.

bulb.addEventListener('mouseleave', () => {bulb.src = 'images/bulb_off.gif';});










