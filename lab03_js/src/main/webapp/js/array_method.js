/**
array_method.html에 포함.
JS array 객체의 함수(메서드)들.

 */


const arr = [1,2,3,4,5];
console.log(arr);

//새로운 원소를 배열 끝에 추가:
arr.push(100); //push(): 원본 배열의 끝에 새로운 원소를 추가. 원본 배열이 바뀜!!
//arr은 const인데 왜 바뀌지? -> 주소값은 그대로, 안의 원소만 바뀌는거라 ㄱㅊ.
//const는 주소!!가 안 바뀐다 라고 생각
//arr=[1,2,3,4,5,6]는 안됨. 새로운 배열 넣는거 ㄴㄴ
console.log(arr);


let result = arr.concat(200); //원본 배열은 변경하지 않고 원소가 추가된 새로운 배열 리턴.
console.log(arr);
console.log(result);

//배열의 마지막 원소 삭제
arr.pop(); //pop(): 원본 배열의 마지막 원소를 삭제. 원본 배열의 내용이 바뀜!!
console.log(arr);

result = arr.slice(0,-1);
//slice(start index, end index): 배열에서 start index부터 end index까지를 잘라낸 새로운 배열을 리턴.
console.log(arr);
console.log(result);

const arr2 = [1,'4',33,2,'z','a',-4];
//정렬하기
//toSorted(): 배열의 원소들을 문자열로 변환하여 크기 비교를 함.
//toSorted(callback): 배열 원소들의 크기를 비교할 때 사용할 콜백을 아규먼트로 전달.
result = arr2.toSorted(); //원본 배열을 오름차순으로 정렬한 새로운 배열을 리턴.
console.log(arr2); //toSorted() 메서드는 원본 배열을 변경하지 않음
console.log(result);

//sort(): 배열의 원소들을 문자열로 변환하여 크기 비교를 함.
//sort(callback): 배열 원소들의 크기를 비교할 때 사용할 콜백을 아규먼트로 전달.
// 원본 배열의 원소 순서를 오름차순으로 변경. 원본 배열이 바뀜!!
arr2.sort();
arr2.sort((x,y) => x-y); //callback. 비교할 때 x-y를 이용해서 해라~라는 뜻
console.log(arr2);

// forEach, filter, map, reduce(는월욜에)
const numbers =[1,2,3,4,5,6];

// 배열 numbers의 원소들 중에서 홀수들로만 이루어진 새로운 배열 만들기
const odds = []; // let odds = []; concat 사용하려면 let으로 선언해야함
for (let x of numbers){
    if (x%2){ // 숫자 1은 true
        odds.push(x); // odds = odds.concat(x);
    }
}
console.log(numbers);
console.log(odds);

//filter : for문 없이 간단하게!
result = numbers.filter((x)=>x%2); //아규먼트는 1개 (배열에서 원소 1개씩 넘기기). return 값이 true(1)이면 추가.
//화살표 함수를 이용해서 filter 한것. 익명함수도 이용 가능.
//근데 익명함수를 간단하게 쓴게 화살표니까 대부분 화살표 이용
//근데 익명함수 == 화살표함수는 아님 다른 경우도 잇음. 그건 나중에..
result = numbers.filter(function(x){
    return x%2;
});

console.log(result);

//배열 numbers의 원소들의 제곱을 원소로 갖는 새로운 배열을 만드세요.
const squares = [];
for (let x of numbers){
    squares.push(x*x); //x을 어떻게 이용해서 push 할지 정해야.
}
console.log(squares);

result = numbers.map((x)=> x*x);
console.log(result);

numbers.forEach((x)=> console.log(x));
//numbers의 각각의 원소에 대해 ()안의 행동을 함.








