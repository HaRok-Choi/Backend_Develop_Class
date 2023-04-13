import React, { useRef, useState } from 'react';
import logo from './logo.svg';
import './naver-sign-in.css'

//@ react에서 함수가 대문자로 시작하는 함수는 컴포넌트로 인식
//@ App처럼 해놓으면 html태그처럼 쓸 수 있다(모듈화)

//@ App.tsx -> x는 XML(XHTML)이기 때문에 완벽한 문법을 요구함
//@ tsx : typescript XML(XHTML)
//@ class를 className이라 표기함, js와 구분하기 위해서, error를 뱉음

function App() { // <- 함수형 컴포넌트

  const formRef = useRef<HTMLFormElement | null>(null);

  //@ const [상태 변수명, 상태를 변경해주는 메서드] = useState<타입>(초기값);
  const [isIdCheck, setIdCheck] = useState<boolean>(false);
  const [id, setId] = useState<string>(''); 

  //@ 그냥 변수로 두면 화면상에 뜨지 않는다. 상태변수로 둬야지 뜬다. react가 변경을 인식하지 못함
  // let isIdCheck2 = false;

  //@ 변수로 값만 가지고 왔고, 내부의 값이 바뀌지 않았음
  // let [isIdCheck, setIdCheck] = useState<boolean>(false);

  const onSubmitHandler = () => {
    if (!id.trim()){
      setIdCheck(true);
      return;
    }
    setIdCheck(false);
    // isIdCheck2 = !isIdCheck2;
    // console.log(isIdCheck2);

    // isIdCheck = !isIdCheck;
    // console.log(isIdCheck);

    if (formRef.current) formRef.current.submit(); 

    //@ 속성이나 메소드앞에 ?를 찍으면 null이 와도 에러를 뱉지 않지만 실행을 안시킴
    // if (formRef) formRef.current?.submit();
  }

  return (
    // html을 작성하지만 html 주석은 못받음
    // 자식요소가 하나만 올 수 있음(최상위 요소 기준)
    // 전부다 문자열로 온다 but 숫자 표현하고 싶다면 {}를 해주면 된다.
    // {} : 코드블럭 -> 이 안에는 ts, js의 문법을 쓸 수 있다.
    <>
      <div className="header">
        <div className="header-inner">
          <a href="http://naver.com" className="logo">
            <h1 className="blind">NAVER</h1>
          </a>
          <div className="lang">
            <select className="select">
              <option>한국어</option>
              <option>English</option>
            </select>
          </div>
        </div>
      </div>
      <div className="main">
        <div className="content">
          <div className="sign-in-wrapper">
            <form
              ref={formRef}
              id="form"
              action="http://nid.naver.com/nidlogin.login"
              method="POST"
            >
              <ul className="panel-wrapper">
                <li className="panel-item">
                  <div className="panel-inner">
                    <div className="id-password-wrapper">
                      <div className="input-row">
                        <div className="icon-cell">
                          <span className="icon-id">
                            <span className="blind">아이디</span>
                          </span>
                        </div>
                        <input
                          type="text"
                          className="input-text"
                          maxLength={41}
                          placeholder="아이디"
                          name="id"
                          onChange={(event) => setId(event.target.value)}
                          // onChange는 event라는 결과물을 내준다. 사용자가 변경하는 타겟의 밸류로 설정함
                          // input의 값이 바뀔때마다 {}안의 함수를 호출함
                        />
                      </div>
                      <div className="input-row">
                        <div className="icon-cell">
                          <span className="icon-pw">
                            <span className="blind">비밀번호</span>
                          </span>
                        </div>
                        <input
                          type="password"
                          className="input-text"
                          maxLength={16}
                          placeholder="비밀번호"
                          name="pw"
                          id="pw"
                        />
                      </div>
                    </div>
                    <div className="sign-in-keep-wrapper">
                      <div className="keep-check">
                        <input type="checkbox" className="input-keep" value="off" />
                        <label className="keep-text">로그인 상태 유지</label>
                      </div>
                      <div className="ip-check"></div>
                    </div>

                    {/* isIdCheck가 false라는 개념을 이용 */}
                    {/* if문 사용할 수 없다. 모든것을 연산자로 처리함 */}
                    {/* ↓ if문 처럼 사용 */}

                    { isIdCheck && (
                    <div
                      id="sign-in-error"
                      className="sign-in-error"
                      // style={{ display: 'none' }}
                      // ↑ 객체를 만들어줌
                    >                      
                      <div className="error-message">
                        <strong>아이디</strong>를 입력하세요.
                      </div>
                    </div>) }

                    <div className="sign-in-button-wrapper">
                      <button
                        type="button"
                        className="sign-in-button"
                        onClick={onSubmitHandler}
                        // onClick={() => onSubmitHandler()}
                        // ↑ 같이 만들어도 됨
                        // 위와 마찬가지로 {} 묶어줌
                        // () 제거 하면 함수, () 있으면 함수호출결과
                      >                        
                        <span className="button-text">로그인</span>
                      </button>
                    </div>
                  </div>
                </li>
              </ul>
            </form>
          </div>
          <ul className="find-wrapper">
            <li>
              <a
                className="find-text"
                href="https://nid.naver.com/user2/api/route?m=routePwInquiry&lang=ko_KR"
              >비밀번호 찾기</a
              >
            </li>
            <li>
              <a
                className="find-text"
                href="https://nid.naver.com/user2/api/route?m=routeIdInquiry&lang=ko_KR"
              >아이디 찾기</a
              >
            </li>
            <li>
              <a
                className="find-text"
                href="https://nid.naver.com/user2/V2Join?m=agree&lang=ko_KR"
              >회원가입</a
              >
            </li>
          </ul>
          <div className="banner-wrapper">
            <div className="banner-content">
              <img
                className="banner-img"
                src="https://ssl.pstatic.net/melona/libs/1378/1378592/9baf2c4b14aec68ea800_20220902161708847.jpg"
              />
            </div>
          </div>
        </div>
      </div>
      <div className="footer">
        <div className="footer-inner">
          <ul className="footer-link">
            <li>
              <a
                className="footer-item"
                href="http://www.naver.com/rules/service.html"
              ><span className="text">이용약관</span></a
              >
            </li>
            <li>
              <a
                className="footer-item"
                href="http://www.naver.com/rules/privacy.html"
              ><span className="text"><strong>개인정보처리방식</strong></span></a
              >
            </li>
            <li>
              <a
                className="footer-item"
                href="http://www.naver.com/rules/disclaimer.html"
              ><span className="text">책임의 한계와 법적고지</span></a
              >
            </li>
            <li>
              <a
                className="footer-item"
                href="https://help.naver.com/support/service/main.nhn?serviceNo=532"
              ><span className="text">회원정보 고객센터</span></a
              >
            </li>
          </ul>
          <div className="footer-copy">
            <a href="http;//navercorp.com">
              <span className="footer-logo">
                <span className="blind">네이버</span>
              </span>
            </a>
            <span className="text">Copylight</span>
            <span className="copy">© NAVER Corp.</span>
            <span className="text">All Rights Reserved.</span>
          </div>
        </div>
      </div>
    </>


  );
}

export default App;
//@ index.tsx에서 import해서 받을 수 있다.