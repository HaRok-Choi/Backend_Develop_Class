export default function Footer() {
    return (
        <div className="footer">
            <div className="footer-inner">
                <ul className="footer-link">
                    <li>
                        <a
                            className="footer-item"
                            href="http://www.naver.com/rules/service.html"
                        ><span className="text">이용약관</span></a>
                    </li>
                    <li>
                        <a
                            className="footer-item"
                            href="http://www.naver.com/rules/privacy.html"
                        ><span className="text"><strong>개인정보처리방식</strong></span></a>
                    </li>
                    <li>
                        <a
                            className="footer-item"
                            href="http://www.naver.com/rules/disclaimer.html"
                        ><span className="text">책임의 한계와 법적고지</span></a>
                    </li>
                    <li>
                        <a
                            className="footer-item"
                            href="https://help.naver.com/support/service/main.nhn?serviceNo=532"
                        ><span className="text">회원정보 고객센터</span></a>
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
    );
}
