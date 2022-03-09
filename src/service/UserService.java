package service;

import java.util.List;
import java.util.Map;

import entity.User;

public interface UserService {

	public int addUser(User u);
	public int updateUser(User u);
	public int deleteUser(int isdelete,int id);
	public int deleteData(int id);	
	public Map<String, Object> selectUserByID(int id);
	public List<Map<String, Object>> selectAllUser(User u);
	public List<Map<String, Object>> selectUserByLevel(int level,int start, int page);
	public List<Map<String, Object>> selectLimitUser(User u,int start,int page);
	public Long countUser(User u);
	public List<Map<String, Object>> countByLevel(User u);
	Map<String, Object> login(String uname, String pwd);
}
