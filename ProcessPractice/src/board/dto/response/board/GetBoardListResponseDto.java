package board.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import board.entity.Board;

// 화면에 보이는것들 여부
// 게시글 이때까지 쓴거 다 나열
public class GetBoardListResponseDto {
	
	private int boardNumber;
	private String writerProfileImageUrl;
	private String writernickname;
	private String writeDate;
	private String title;
	private String content;
	private String boardImageUrl;
	private int commnetCount;
	private int likeCount;
	private int viewCount;
	
	public GetBoardListResponseDto() {}
	
	public GetBoardListResponseDto(int boardNumber, String writerProfileImageUrl, String writernickname,
			String writeDate, String title, String content, String boardImageUrl, int commnetCount, int likeCount,
			int viewCount) {
		this.boardNumber = boardNumber;
		this.writerProfileImageUrl = writerProfileImageUrl;
		this.writernickname = writernickname;
		this.writeDate = writeDate;
		this.title = title;
		this.content = content;
		this.boardImageUrl = boardImageUrl;
		this.commnetCount = commnetCount;
		this.likeCount = likeCount;
		this.viewCount = viewCount;
	}
	
	public GetBoardListResponseDto(Board board) {
		this.boardNumber = board.getBoardNumber();
		this.writerProfileImageUrl = board.getWriterProfileImageUrl();
		this.writernickname = board.getWriteNickname();
		this.writeDate = board.getWriteDate();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.boardImageUrl = board.getBoardImageUrl();
		this.commnetCount = board.getCommentList().size();
		this.likeCount = board.getLikeList().size();
		this.viewCount = board.getViewCount();
	}

	public int getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}

	public String getWriterProfileImageUrl() {
		return writerProfileImageUrl;
	}

	public void setWriterProfileImageUrl(String writerProfileImageUrl) {
		this.writerProfileImageUrl = writerProfileImageUrl;
	}

	public String getWriternickname() {
		return writernickname;
	}

	public void setWriternickname(String writernickname) {
		this.writernickname = writernickname;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBoardImageUrl() {
		return boardImageUrl;
	}

	public void setBoardImageUrl(String boardImageUrl) {
		this.boardImageUrl = boardImageUrl;
	}

	public int getCommnetCount() {
		return commnetCount;
	}

	public void setCommnetCount(int commnetCount) {
		this.commnetCount = commnetCount;
	}

	public int getLikeCount() {
		return likeCount;
	}

	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	@Override
	public String toString() {
		return "GetBoardListResponseDto [boardNumber=" + boardNumber + ", writerProfileImageUrl="
				+ writerProfileImageUrl + ", writernickname=" + writernickname + ", writeDate=" + writeDate + ", title="
				+ title + ", content=" + content + ", boardImageUrl=" + boardImageUrl + ", commnetCount=" + commnetCount
				+ ", likeCount=" + likeCount + ", viewCount=" + viewCount + "]";
	}
	
//	값을 item에 복사하는 과정
	public static List<GetBoardListResponseDto> copyList(List<Board> boardList) {
		List<GetBoardListResponseDto> result = new ArrayList<>();
		for (Board board : boardList) {
			GetBoardListResponseDto item = new GetBoardListResponseDto(board);
			result.add(item);
		}
		return result;
	}
	
	
	
}
