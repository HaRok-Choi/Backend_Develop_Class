console.log("hello javaScript");

//! 변수 선언 방법 //
//# 1. 변수의 타입이 존재하지 않음
var variable_name;
var variable_name = "변수 값";
console.log(variable_name.trim());
variable_name = 10;
//console.log(variable_name.trim());

//# 2. 변수 선언 키워드
//@ var, let, const
//@ var
var variable_name;
if (10 == 10) {
  var variable_name2 = "변수";
}
console.log(variable_name2);

//@ let
let let_variable_1;
if (10 == 10) {
  let let_variable_2 = "블럭 변수";
}
// console.log(let_variable_2);

//@ const
const const_variable_1 = "상수";
// const_variable_1 = "변경 상수";

//# 3. 데이터의 타입
//@ 문자열 string : ' ', " "
let stringVariable1 = "문자열";
let stringVariable2 = "문자열";
console.log(typeof (stringVariable1, stringVariable2));

//@ 숫자 number : 정수, 실수
let numberVariable1 = 10;
let numberVariable2 = 1.5;
console.log(typeof (numberVariable1, numberVariable2));

//@ 논리 boolean : true, false
let booleanVariable = true;
console.log(typeof booleanVariable);

//@ null (object타입)
let nullVariable = null;
console.log(typeof nullVariable);

//@ 배열 : []
let arrayVariable = [1, "A", false];
arrayVariable[0];
// type 섞어서 넣을 수 있다.(Java랑 다름)

//@ 객체 : {} (JSON이라 부르고 객체를 바로 생성가능하다.)
let objectVariable = {
  "key": "value",
  "name": "John",
  "age": 20,
  "object": {
    "key1": 1,
  },
};

//! 연산자 //
//# 1. 나눗셈 연산자
let number1 = 10 / 3;
console.log(number1);

//# 2. 제곱 연산자(**)
let number2 = 10 ** 3;
console.log(number2);

//# 3. 비교연산 ==, ===
let numberValue10 = 10;
let stringValue10 = "10";
console.log(numberValue10 == stringValue10);
console.log(numberValue10 === stringValue10);

//! if 조건 //
// 숫자기준으로 0이 아닌 나머지(음수포함)들은 다 true로 받는다.
// 빈 배열, 공백있는 문자열 true / 공백없는 문자열 false 
let tmpValue = null;
// ↑ 빈 값으로 보기에 null 이면 아래에서 false임
if (tmpValue) console.log("true");
else console.log("false");

//! class //
class Human {
  name;
  age;
  address;
  // 오버로딩 불가능
  constructor(name, age, address) {
    this.name=name;
    this.age=age;
    this.address=address;
  }
}

let humanObject = new Human('Rok', 26, '부산');
console.log(humanObject.name);
// 정의되지 않는 경우 undefined가 나옴

// let { name, age, address } = humanObject;
let { name, ...others } = humanObject;
console.log(name);
console.log(others);

//! 비구조화 할당(객체에 있는것을 분해할 수 있음. js의 최대장점) //
// 변수를 바꾸고 객체에 다시 넣을 때
name = 'Roki';
humanObject = { ...humanObject, name };
// -> 이런식으로 만든 것 { name, age, address, name }
// 스프레드 연산자를 쓸 때 위와 같이 중복이 되더라도 뒤에껄로 덮어 씌운다.
console.log(humanObject);

//@ 배열
const tmpArray = [1, 'A', true];
const [number, ...otherArray] = tmpArray;
console.log(number);
console.log(otherArray);

//! 함수 //
//# 클래스나 인스턴스 내부에 있으면 메소드, 밖에 있으면 함수
//# 타입없이 매개변수를 받는다.
function function1(arg, arg2) {

}
function1(1, 2);

//@ 화살표 함수
const function2 = (arg1, arg2) => {

}
function2(1, 2);
