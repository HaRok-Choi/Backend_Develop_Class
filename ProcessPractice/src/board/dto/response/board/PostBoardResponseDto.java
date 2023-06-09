package board.dto.response.board;

import java.util.List;

import board.entity.Board;
import board.entity.Comment;
import board.entity.Like;
// 글 쓰는거
public class PostBoardResponseDto {
	
	private int boardNumber;
	private String boardImageUrl;
	private String writerEmail;
	private String writeNickname;
	private String writerProfileImageUrl;
	private String writeDate;
	private String title;
	private String content;
//	댓글수, 좋아요수는 굳이 안넣어도 됨 why? 리스트의 size를 구하면 됨
	private int viewCount;
	private List<Like> likeList;
	private List<Comment> commentList;
	
	public PostBoardResponseDto() {}

	public PostBoardResponseDto(int boardNumber, String boardImageUrl, String writerEmail, String writeNickname,
			String writerProfileImageUrl, String writeDate, String title, String content, int viewCount,
			List<Like> likeList, List<Comment> commentList) {
		this.boardNumber = boardNumber;
		this.boardImageUrl = boardImageUrl;
		this.writerEmail = writerEmail;
		this.writeNickname = writeNickname;
		this.writerProfileImageUrl = writerProfileImageUrl;
		this.writeDate = writeDate;
		this.title = title;
		this.content = content;
		this.viewCount = viewCount;
		this.likeList = likeList;
		this.commentList = commentList;
	}
	
	public PostBoardResponseDto(Board board) {
		this.boardNumber = board.getBoardNumber();
		this.boardImageUrl = board.getBoardImageUrl();
		this.writerEmail = board.getWriterEmail();
		this.writeNickname = board.getWriteNickname();
		this.writerProfileImageUrl = board.getWriterProfileImageUrl();
		this.writeDate = board.getWriteDate();
		this.title = board.getTitle();
		this.content = board.getContent();
		this.viewCount = board.getViewCount();
		this.likeList = board.getLikeList();
		this.commentList = board.getCommentList();
	}

	public int getBoardNumber() {
		return boardNumber;
	}

	public void setBoardNumber(int boardNumber) {
		this.boardNumber = boardNumber;
	}

	public String getBoardImageUrl() {
		return boardImageUrl;
	}

	public void setBoardImageUrl(String boardImageUrl) {
		this.boardImageUrl = boardImageUrl;
	}

	public String getWriterEmail() {
		return writerEmail;
	}

	public void setWriterEmail(String writerEmail) {
		this.writerEmail = writerEmail;
	}

	public String getWriteNickname() {
		return writeNickname;
	}

	public void setWriteNickname(String writeNickname) {
		this.writeNickname = writeNickname;
	}

	public String getWriterProfileImageUrl() {
		return writerProfileImageUrl;
	}

	public void setWriterProfileImageUrl(String writerProfileImageUrl) {
		this.writerProfileImageUrl = writerProfileImageUrl;
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

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public List<Like> getLikeList() {
		return likeList;
	}

	public void setLikeList(List<Like> likeList) {
		this.likeList = likeList;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	@Override
	public String toString() {
		return "PostBoardResponseDto [boardNumber=" + boardNumber + ", boardImageUrl=" + boardImageUrl
				+ ", writerEmail=" + writerEmail + ", writeNickname=" + writeNickname + ", writerProfileImageUrl="
				+ writerProfileImageUrl + ", writeDate=" + writeDate + ", title=" + title + ", content=" + content
				+ ", viewCount=" + viewCount + ", likeList=" + likeList + ", commentList=" + commentList + "]";
	}
	
	
}
