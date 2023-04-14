import { useRef, useState } from 'react'
import NaverInput from '../../component/InputComponent';
import NaverFind from '../../component/FindComponent';

const FIND_LIST = [
    {
        title: '비밀번호 찾기',
        link: 'https://nid.naver.com/user2/api/route?m=routePwInquiry&lang=ko_KR',
    },
    {
        title: '아이디 찾기',
        link: 'https://nid.naver.com/user2/api/route?m=routeIdInquiry&lang=ko_KR',
    },
    {
        title: '회원가입',
        link: 'https://nid.naver.com/user2/V2Join?m=agree&lang=ko_KR',
    },
];

export default function Main() {
    //@ ↑ 객체 형태로 받아와야 함
    const formRef = useRef<HTMLFormElement | null>(null);

    //@ const [상태 변수명, 상태를 변경해주는 메서드] = useState<타입>(초기값);
    const [isIdCheck, setIdCheck] = useState<boolean>(false);

    const [password, setPassword] = useState<string>('');
    const [id, setId] = useState<string>('');

    const onSubmitHandler = () => {
        if (!id.trim()) {
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
                                        <NaverInput label="아이디" type="text" name="id" maxLength={41} iconClass="icon-id" setter={setId} />
                                        <NaverInput label="비밀번호" type="password" name="pw" maxLength={16} iconClass="icon-pw" setter={setPassword} />
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

                                    {isIdCheck && (
                                        <div
                                            id="sign-in-error"
                                            className="sign-in-error"
                                        // style={{ display: 'none' }}
                                        // ↑ 객체를 만들어줌
                                        >
                                            <div className="error-message">
                                                <strong>아이디</strong>를 입력하세요.
                                            </div>
                                        </div>)}

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
                    {
                        //@ 반복작업
                        FIND_LIST.map((findItem) => (<NaverFind title={findItem.title} link={findItem.link} />))
                        // map 자체에서 요소를 하나 꺼내옴
                    }
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
    );
}
