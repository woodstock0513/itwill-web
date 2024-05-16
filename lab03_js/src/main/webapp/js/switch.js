/**
 * switch.html에 포함
 */
//console.log('test');

const weekday = document.getElementById('weekday');
const btn = document.getElementById('btn');
const result = document.getElementById('result');

function selectListener(){
    const value = weekday.value;  //select의 value. sun 이런거.
    switch (value){
        case 'mon':
        case 'tue':
        case 'wed':
        case 'thu':
        case 'fri':
            result.innerHTML = '학원 출석';
            break;
        case 'sat':
        case 'sun':
            result.innerHTML = '놀기';
            break;
        default:
            result.innerHTML = '몰?루';
    }
}

btn.addEventListener("click", selectListener);


