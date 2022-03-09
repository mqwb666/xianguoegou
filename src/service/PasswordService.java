package service;

import java.util.List;
import java.util.Map;

import entity.Password;


public interface PasswordService {

	public int addUser(Password u);
	public int updateUser(Password u);
	public int deleteUser(int uid);
	public Map<String, Object> selectUserByID(int uid);
	public List<Map<String, Object>> selectAllUser(Password u);
	public List<Map<String, Object>> selectLimitUser(Password u,int start,int page);
	public Long countUser(Password u);
}
