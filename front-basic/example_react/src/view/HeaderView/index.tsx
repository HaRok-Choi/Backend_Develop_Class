export default function Header() {
    // 
    return (
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
      );
}
