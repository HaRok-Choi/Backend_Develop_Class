package board.repository;

import java.util.ArrayList;
import java.util.List;

import board.entity.User;

public class UserRepository {
	
	private static List<User> userTable = new ArrayList<>();
	
//	로그인 할때 이메일 유무 여부
	public User findByEmail(String email) {
		User result = null;
		for (User user : userTable) {
			if (user.getEmail().equals(email)) {
				result = user;
				break;
			}
		}
		return result;
	}
	
//	가입할때 이메일 중복 여부
	public boolean existsByEmail(String email) {
		boolean result = false;
		for (User user : userTable) {
			if (user.getEmail().equals(email)) {
				result = true;
				break;
			}
		}
		return result;
	}
	
//	유저 정보 추가하는거
	public User save(User user) {
		userTable.add(user);
		return user;
	}
	
}
