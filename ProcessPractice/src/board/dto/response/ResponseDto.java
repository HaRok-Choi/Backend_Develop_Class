package board.dto.response;

// 규칙적으로 사용자에게 반환을 해주기 위한 포맷

public class ResponseDto<D> {
//	어떠한 메서드던간에 여기서 반환을 할 거다.
	private boolean status;
	private String message;
	private D data;	// 그래서 유연하게 변경 되어야 함.
	
	public ResponseDto() {}
	
	public ResponseDto(boolean status, String message, D data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public D getData() {
		return data;
	}

	public void setData(D data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseDto [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
	
	
	
}
