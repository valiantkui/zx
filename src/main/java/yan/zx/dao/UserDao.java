package yan.zx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import yan.zx.entity.User;

@Repository
public interface UserDao {

	public User findUserByU_id(String u_id);
	
	public int addUser(User user);
	
	
	public List<User> findUserListByU_idList(@Param("u_idList") List<String> u_idList);
}
