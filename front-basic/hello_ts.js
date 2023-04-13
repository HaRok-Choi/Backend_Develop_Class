console.log('Hello Typescript!');
//! 변수 //
var number;
//@ 타입 지정 후 그 타입의 값만 받음. 
number = 10;
// number = 'string';
//@ 값이 처음에 들어올 때 묵시적으로 타입을 지정함.
var string = 'string';
// string = 10;
//! 함수 //
//@ 매개변수로 받으면 타입을 지정해줘야 함
var funtion = function (arg) {
    return 'string';
};
//! 객체 //
//# 1. class를 이용
var Object1 = /** @class */ (function () {
    function Object1(prop1, prop2) {
        this.prop1 = prop1;
        this.prop2 = prop2;
    }
    ;
    return Object1;
}());
;
var object1 = { prop1: 'prop1', prop2: 26 };
var object2 = { prop1: 'prop1', prop2: 26 };
var object3 = { prop1: 'prop1', prop2: 26 };
//@ 타입을 동시에 가지고 있어야한다.
var object4 = { prop1: 'prop1', prop2: 26, prop3: 'prop1', prop4: 26 };
//# 4. enum
var Fruits;
(function (Fruits) {
    Fruits["APPLE"] = "\uC0AC\uACFC";
    Fruits["BANANA"] = "\uBC14\uB098\uB098";
    Fruits["MELON"] = "\uBA54\uB860";
})(Fruits || (Fruits = {}));
var fruit = Fruits.APPLE;
console.log(fruit);
