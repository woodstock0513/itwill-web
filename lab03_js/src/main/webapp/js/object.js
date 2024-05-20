/**
 * object.html에 포함
 */

 //JSON(JavaScript Object Notation) : 자바 스크립트 객체 표기법
 //{property: value, property2: value2, ...}
 // '=' 이 아니라 ':' 주의!!!
 const person = {
    name : 'hong',
    age : 22,
    phone : ['010-3087-1280','010-123-5678']
 };
 
 console.log(person)
 
//객체가 가지고 있는 property에 접근하기 위한 방법 : (1) 참조 연산자, (2) 인덱스 연산자
console.log(person.age); //참조 연산자 : object.propertName
console.log(person['name']); // 인덱스 연산자 : object['propertyName']
// '' 주의!! ''없으면 변수이름으로 들어감 -> 에러 프로퍼티 이름 : 문자열로 써야함!!!
console.log(person['phone'][0]);
console.log(person.phone[1]); 
 
person.age = 18; // 객체의 property 값 변경 (재할당)
console.log(person.age);
 
//자바 스크립트의 객체는 객체가 생성된 이후에 프로퍼티를 추가할 수 있ㅇ므!!
person.email = 'ddd@naer';
 
console.log(person);
//person은 const. person을 재할당 하는게 안됨 p={};안됨
//객체가 가지고잇는 값 변경은 ㄱㅊㄱㅊ 새로운 값 추가도 ㄱㄴㄱㄴ

// 메서드를 갖는 객체: 
const score = {
    html : 100,
    css:70,
    js : 90,
    sum: function(){
        return this.css + this.html + this.js;
    },
    //const sum = func(){} 랑 똑같이 생각하면 됨
    mean: function(){
        return this.sum() / 3;
    }
};

console.log(score);
console.log(score.html);
console.log(score.sum); //이렇게 쓰면 그냥 메서드 설명만 나옴. 호출 XX
console.log(score.sum()); //메서드 호출
console.log(score.mean());

//생성자 함수(constructor function) :  this 키워드를 사용해서 프로퍼티를 선언한 함수
function Score(html, css, js){
    //필드
    this.html = html;
    this.css = css;
    this.js = js;
    //메서드
    this.sum = function(){
        return this.css + this.html + this.js;
    };
    this.mean = function(){
        return this.sum / 3;
    }
}

//생성자 함수를 사용한 객체 생성 : new 생성자함수();

const score1 = new Score(10,20,30);
console.log(score1)
console.log(score1.sum())   

const score2 = new Score(); // 모든 필드는 undefined가 됨
console.log(score2)
console.log(score2.mean());  // undefined를 계산하면 Not a Number(NaN)

//자바스크립트 객체는 for-in 구문에서 사용할 수 있음 -> 객체가 가지고 있는 프로퍼티 이름을 반복(iteration)
const student = {
    no:309,
    name : 'moon',
    classNo:160    
}

for (let x in student){ //x 자리에 string으로 들어감.
    console.log(x, ':', student[x]); //student.x 안됨!!
}

//클래스:
class Rectangle {
    // 생성자 : 필드 초기화
    constructor(width, height){
        this.width = width;
        this.height = height;
    }
    //메서든 : (imp) function 키워드를 사용하지 않음!!
    area(){
        return this.height * this.width;
    }
    //this를 생략하면 절대 안됨!!!!
    perimeter(){
        return 2 * (this.height + this.width);
    }
}

//클래스를 사용한 객체 생성 - java랑 똑같음
const rect1 = new Rectangle(4,7);
console.log(rect1);
console.log(`넓이 = ${rect1.area()}`);
console.log(`둘레 = ${rect1.perimeter()}`);


const rect2 = new Rectangle();
console.log(rect2);

//원 클래스 설언
// - 필드 : radius. 기본값 = 0
//메서드: 넓이계산, 둘레계산

class Circle {
    constructor(radius = 0){
        this.radius = radius;
    }
    area(){
        return this.radius * this.radius * 3.14;
    }
    perimeter(){
        return this.radius * 2 * 3.14;
    }
}

const cir1 = new Circle(5);
console.log(cir1);
console.log(cir1.area());
const cir2 = new Circle();
console.log(cir2);




