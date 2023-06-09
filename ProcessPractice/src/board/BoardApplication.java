package board;

import java.util.Scanner;

import board.common.constant.HttpStatus;
import board.controller.BoardController;
import board.controller.UserController;
import board.dto.request.board.PatchBoardDto;
import board.dto.request.board.PostBoardDto;
import board.dto.request.user.SignInDto;
import board.dto.request.user.SignUpDto;
// 여기서 입력 함
public class BoardApplication {

	private static UserController userController = new UserController();
	private static BoardController boardController = new BoardController();
	
	private static final String SIGN_UP = "POST /sign-up";
	private static final String SIGN_IN = "POST /sign-in";
	private static final String POST_BOARD = "POST /board";
	
	private static final String GET_BOARD_LIST = "GET /board/list";
	private static final String GET_BOARD = "GET /board";
	
	private static final String PATCH_BOARD = "PATCH /board"; // 덮어씌우다(수정하다)
	
	private static final String DELETE_BOARD = "DELETE /board";
	
	public static void main(String[] args) {
		
		while (true) {
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("URL End Point : ");
			String endPoint = scanner.nextLine();
			
			switch (endPoint) {
			
//			회원가입 입력
			case SIGN_UP:
				SignUpDto signUpDto = new SignUpDto();
				
				System.out.print("이메일 주소 : ");
				signUpDto.setEmail(scanner.nextLine());
				System.out.print("비밀번호 : ");
				signUpDto.setPassword(scanner.nextLine());
				System.out.print("비밀번호 확인 : ");
				signUpDto.setPasswordCheck(scanner.nextLine());
				System.out.print("닉네임 : ");
				signUpDto.setNickname(scanner.nextLine());
				System.out.print("휴대전화 번호 : ");
				signUpDto.setPhoneNumber(scanner.nextLine());
				System.out.print("주소 : ");
				signUpDto.setAddress(scanner.nextLine());
				System.out.print("상세 주소 : ");
				signUpDto.setAddressDetail(scanner.nextLine());
				
				userController.signUp(signUpDto);
//				System.out.println(signUpDto.toString()); 값이 잘 들어 갔는지 확인
				
				break;
				
//			로그인 입력
			case SIGN_IN:
				SignInDto signInDto = new SignInDto();
				System.out.print("이메일 주소 : ");
				signInDto.setEmail(scanner.nextLine());
				System.out.print("비밀번호 : ");
				signInDto.setPassword(scanner.nextLine());
				
				System.out.println(signInDto.toString());
//				userController.signin(signInDto);
				
				break;
				
//			사용자가 작성한 게시물	
			case POST_BOARD:
				PostBoardDto postBoardDto = new PostBoardDto();
				System.out.print("제목 : ");
				postBoardDto.setTitle(scanner.nextLine());
				System.out.print("내용 : ");
				postBoardDto.setContent(scanner.nextLine());
				System.out.print("이미지 : ");
				postBoardDto.setBoardImageUrl(scanner.nextLine());
				System.out.print("작성자 이메일 : ");
				postBoardDto.setWriterEmail(scanner.nextLine());
				
				boardController.postBoard(postBoardDto);
				break;
			
			case GET_BOARD_LIST:
				boardController.getBoardList();
				break;
			
			case GET_BOARD:
//				컴파일 로직상 문제는 없지만 외부에서 들어오는 것은 무조건 정수로 들어오지 않을 수 있다.(그래서 예외 처리를 해줘야 한다.) 
				int boardNumber = 0;
				try {
					System.out.print("게시물 번호 : ");
					boardNumber = scanner.nextInt();
				} catch (Exception exception) {
					exception.printStackTrace();
					continue;
				}
				
				boardController.getBoard(boardNumber);
				break;
				
			case PATCH_BOARD:
				PatchBoardDto patchBoardDto = new PatchBoardDto();
//				GET_BOARD 부분과 마찬가지
				try {
					System.out.print("게시물 번호 : ");
					String patchNumberString = scanner.nextLine();
					patchBoardDto.setBoardNumber(Integer.parseInt(patchNumberString));
					System.out.print("제목 : ");
					patchBoardDto.setTitle(scanner.nextLine());
					System.out.print("내용 : ");
					patchBoardDto.setContent(scanner.nextLine());
					System.out.print("이미지 : ");
					patchBoardDto.setBoardImageUrl(scanner.nextLine());
					System.out.print("이메일 : ");
					patchBoardDto.setEmail(scanner.nextLine());
				} catch (Exception exception) {
					exception.printStackTrace();
					continue;
				}
				boardController.patchBoard(patchBoardDto);
				break;
				
			case DELETE_BOARD:
//				어떤 게시물 삭제할지 알아야 됨
				int deleteBoardNumber = 0;
				String deleteEmail = null;
				
				try {
					System.out.println("게시물 번호 : ");
					deleteBoardNumber = Integer.parseInt(scanner.nextLine());
					System.out.println("이메일 : ");
					deleteEmail = scanner.nextLine();
				} catch (Exception exception) {
					exception.printStackTrace();
					continue;
				}
				
				boardController.deleteBoard(deleteBoardNumber, deleteEmail);
				break;
				
			default:
				System.out.println(HttpStatus.NOT_FOUND); // 잘못 입력하면 이거 뜸
			}
			
		}
		
	}

}
