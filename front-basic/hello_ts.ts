console.log('Hello Typescript!');

//! 변수 //
let number: number;
//@ 타입 지정 후 그 타입의 값만 받음. 
number = 10;
// number = 'string';

//@ 값이 처음에 들어올 때 묵시적으로 타입을 지정함.
let string = 'string';
// string = 10;

//! 함수 //
//@ 매개변수로 받으면 타입을 지정해줘야 함
const funtion = (arg: number): string => {
    return 'string';
}

//! 객체 //
//# 1. class를 이용
class Object1 {
    prop1: string;
    prop2: number;

    constructor(prop1: string, prop2: number) {
        this.prop1=prop1;
        this.prop2=prop2;
    };
};
const object1: Object1 = { prop1: 'prop1', prop2: 26 };

//# 2. type 키워드 사용(1과 같이 생성자를 안만들어도 됨)
type Object2 = {
    prop1: string,
    prop2: number
}
const object2: Object2 = { prop1: 'prop1', prop2: 26 };

//# 3. interface 활용(그냥 type 형태로 쓰면 됨)
interface Object3 {
    prop1: string;
    prop2: number;
    // ↓ 선언만 하고 싶을때(함수의 타입을 지정할 수 있다.)
    // ? : 필수에서 선택으로 바꾸어준다.
    func1?: (arg1: number) => string;
}
const object3: Object3 = { prop1: 'prop1', prop2: 26 };

//@ TS는 객체에다가 null을 넣는것이 불가.
// const object3: Object3 = null;

//@ or연산자를 통해서 변수에 대한 타입을 여러개를 받을 수 있다.
//const object3: Object3 | null = null;

//@ 객체 타입을 합칠 수 있다.
interface Object4 {
    prop3: string;
    prop4: number;
}

//@ 타입을 동시에 가지고 있어야한다.
const object4: Object3 & Object4 = { prop1: 'prop1', prop2: 26, prop3: 'prop1', prop4: 26 }

//# 4. enum
enum Fruits {
    APPLE = '사과',
    BANANA = '바나나',
    MELON = '메론'
}
const fruit: Fruits = Fruits.APPLE;
console.log(fruit);