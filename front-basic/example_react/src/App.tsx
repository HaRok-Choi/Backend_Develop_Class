import React, { Dispatch, SetStateAction, useRef, useState } from 'react';
import logo from './logo.svg';
import './naver-sign-in.css'

import Header from './view/HeaderView';
import Footer from './view/FooterView';
import Main from './view/MainView';

//@ react에서 함수가 대문자로 시작하는 함수는 컴포넌트로 인식
//@ App처럼 해놓으면 html태그처럼 쓸 수 있다(모듈화)

//@ App.tsx -> x는 XML(XHTML)이기 때문에 완벽한 문법을 요구함
//@ tsx : typescript XML(XHTML)
//@ class를 className이라 표기함, js와 구분하기 위해서, error를 뱉음

function App() { // <- 함수형 컴포넌트

  //@ 그냥 변수로 두면 화면상에 뜨지 않는다. 상태변수로 둬야지 뜬다. react가 변경을 인식하지 못함
  // let isIdCheck2 = false;

  //@ 변수로 값만 가지고 왔고, 내부의 값이 바뀌지 않았음
  // let [isIdCheck, setIdCheck] = useState<boolean>(false);

  return (
    // html을 작성하지만 html 주석은 못받음
    // 자식요소가 하나만 올 수 있음(최상위 요소 기준)
    // 전부다 문자열로 온다 but 숫자 표현하고 싶다면 {}를 해주면 된다.
    // {} : 코드블럭 -> 이 안에는 ts, js의 문법을 쓸 수 있다.
    <>
      <Header />
      <Main />
      {/* Main 컴포넌트에 값을 전달, HTML 속성값 지정하듯이 */}
      <Footer />
    </>
  );
}

export default App;
//@ index.tsx에서 import해서 받을 수 있다.