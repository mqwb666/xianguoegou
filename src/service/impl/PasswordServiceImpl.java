package service.impl;

import java.util.List;
import java.util.Map;

import dao.BaseDao;
import dao.impl.BaseDaoImpl;
import entity.Password;
import service.PasswordService;

public class PasswordServiceImpl implements PasswordService {

	BaseDao<Password> base = new BaseDaoImpl<>();
	@Override
	public int addUser(Password u) {
		// TODO Auto-generated method stub
		String sql = "INSERT password (pwd,uid) VALUES(?,?)";
		Object[] obj = {u.getPwd(),u.getUid()};
		return base.add_update_delete(obj, sql);
	}

	@Override
	public int updateUser(Password u) {
		// TODO Auto-generated method stub
		String sql = "update password set pwd=? where uid=?";
		Object[] obj = {u.getPwd(),u.getUid()};
		return base.add_update_delete(obj, sql);
	}

	@Override
	public int deleteUser(int uid) {
		// TODO Auto-generated method stub
		String sql = "delete from password where uid=?";
		Object[] obj = {uid};
		return base.add_update_delete(obj, sql);
	}

	@Override
	public Map<String, Object> selectUserByID(int uid) {
		// TODO Auto-generated method stub
		String sql = "select * from password where uid=?";
		Object []obj = {uid};
		return base.selectone(obj, sql);
	}

	@Override
	public List<Map<String, Object>> selectAllUser(Password u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Map<String, Object>> selectLimitUser(Password u, int start, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long countUser(Password u) {
		// TODO Auto-generated method stub
		return null;
	}

}
