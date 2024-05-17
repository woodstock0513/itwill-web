/**
 * function.html에 포함
 * 
 * 자바 스크립트 함수 선언(정의) 방법
 * function 함수이름([파라미터, ...]){
 *      실행코드;
 *      [return 값;]
 * }
 * (주의) 함수 이름 앞에 리턴 타입을 선언하지 않음.
 * 파라미터를 선언할 때 const, let, var와 같은 키워드를 사용하지 않음.
 */

function add(x,y){
    console.log(`x = ${x}, y = ${y}`);
    return x+y;
}

let result = add(3,7); //함수 호출
console.log(`result = ${result}`);

//JS의 함수는 파라미터 타입을 검사하지 않음

result = add('g','e');
console.log(`result = ${result}`);

//JS의 함수는 파라미터 개수를 검사하지 않음 -> 에러 안 남
//더 많으면 뒤의 꺼는 날아가고 적으면 부족한 것들을 undefined로 계산.
//undefined : 초기화되지 않은 변수 (값이 할당되지 않은 변수)
// 숫자 + undefined -> NaN.  문자 + undefined -> 걍 두개 붙여서 나옴
//Not a Number 이라는 뜻.

// JS의 모든 함수는 arguements 속성을 가지고 있음
function testArgs(){
    console.log(arguments); 
    for (let arg of arguments){
        console.log(arg);
    }
    
}

testArgs();
testArgs('hello');
testArgs(1);
testArgs(1,'gg');


result = add('g','e', 'f'); // 선언된 파라미터보다 더 많은 아규먼트를 전달하는 경우
console.log(`result = ${result}`);

result = add(1); // 선언된 파라미터보다 적은 개수의 아규먼트를 전달하는 경우
console.log(`result = ${result}`);

// 숫자 2개를 아규먼트로 전달받아서 뺏셈 결과를 리턴하는 함수
function sub(x,y){
    return x-y;
}

result = sub(10,8);
console.log(`result = ${result}`);

//default parameter : 기본값이 설정된 파라미터

function multiply(x,y=1){
    
    return x*y;
}

result = multiply(2,3); // 아규먼트 y를 전달하면 기본값은 무시됨.
// y=1이었는데 y=3으로 재할당한 느낌.
console.log(`result = ${result}`);

result = multiply(2); //아규먼트 y를 전달하지 않으면 기본값이 사용됨.
// 두번째 파라미터가 기본값이 있어서 아규먼트가 1개여도 계산이 잘 됨.
console.log(`result = ${result}`);


/*
JS 함수는 객체(object)임!!!
1. property를 가질 수 있음. 예)arguements
2. 변수에 함수 자체를 저장할 수 있음.
3. 다른 함수를 호출할 때 아규먼트로 함수(객체)를 전달할 수 있음.
4. 함수 내부에서 다른 함수를 선언(정의)할 수 있음
5. 함수(객체)를 리턴할 수 있음.
*/

const plus = add; //함수 객체 add를 변수 plus에 저장. () 없음 주의!!
// ()가 있으면 함수 호출 -> 결과값을 저장하는 것.
console.log(plus);
console.log(plus(2,5)); //함수 호출! plus를 add처럼 사용할 수 있게 됨.

//익명 함수(anonymous function): 이름이 없는 함수
//홀로 쓰일 수 없고 반드시 변수에 저장되어야 함.
const divide = function (x,y){
    return x/y;
};

console.log(divide(5,8));

//화살표 함수(arrow function) : 익명 함수를 간단히 표현하는 문법
//(param, ...) => {...}
//(param, ...) => return값;

const minus = (x,y) => x-y; // 화살표 함수를 변수에 저장
console.log(minus(8,3));

// 함수(객체)를 아규먼트로 전달받는 함수
function calculate(x,y,op){
    return op(x,y);
}

console.log(calculate(4,8,add));
console.log(calculate(4,8,function(x,y){return x-y})); //익명함수
console.log(calculate(4,8,(x,y)=>x/y));//화살표함수
// -> 이벤트 리스너(핸들러) 설정할 때 많이 사용되는 코드 패턴.
// 콜백(callback): (나중에 호출하기 위해) 함수의 아규먼트로 전달하는 함수

//지역(내부)함수: 함수 안에서 선언하는 함수
function increase(n){
    //지역함수 (addN)는 바깥 함수의 지역 변수(파라미터 포함)들을 사용할 수 있음.
    function addN(x){
        return x+n;
    }
    return addN; //함수 객체를 리턴 -> addN을 밖에서 사용할 수 있게 하기 위해.
}

const increaseTwo = increase(2);
console.log(increaseTwo);
console.log(increaseTwo(100));
//-> 사실상 함수를 만들어주는 함수 인것!
const increaseTen = increase(10);
console.log(increaseTen);
console.log(increaseTwo(100)); //지금이 갈색이 함수임.


console.log(increase(1)(2)); // increase(1)은 x+1을 리턴 함수 설정. increase(1)(2)은 2+1이 되는거








