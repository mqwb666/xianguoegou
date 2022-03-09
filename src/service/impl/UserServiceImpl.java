package service.impl;

import java.util.List;
import java.util.Map;

import dao.BaseDao;
import dao.impl.BaseDaoImpl;
import entity.User;
import service.PasswordService;
import service.UserService;
import sun.launcher.resources.launcher;

public class UserServiceImpl implements UserService {

	BaseDao<User> base = new BaseDaoImpl<>();
	@Override
	public int addUser(User u) {
		// TODO Auto-generated method stub
		String sql = "INSERT user (uname,sex,birthday,age,phone,email,level,role,uzcbirthday,pic,isdelete) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		Object[] obj = {u.getUname(),u.getSex(),u.getBirthday(),u.getAge(),u.getPhone(),u.getEmail(),u.getLevel(),u.getRole(),u.getUzcbirthday(),u.getPic(),u.getIsdelete()};
		return base.add_update_delete(obj, sql);
		
	}

	@Override
	public int updateUser(User u) {
		// TODO Auto-generated method stub
		String sql = "update user set uname=?,sex=?,birthday=?,age=?,phone=?,email=?,level=?,role=?,uzcbirthday=?,pic=? where id=?";
		Object[] obj = {u.getUname(),u.getSex(),u.getBirthday(),u.getAge(),u.getPhone(),u.getEmail(),u.getLevel(),u.getRole(),u.getUzcbirthday(),u.getPic(),u.getId()};
		return base.add_update_delete(obj, sql);
	}

	@Override
	public int deleteUser(int isdelete,int id) {
		// TODO Auto-generated method stub
		String sql = "update user set isdelete=? where id=?";
		Object[] obj = {isdelete,id};
		return base.add_update_delete(obj, sql);
	}
	
	@Override
	public int deleteData(int id) {
		// TODO Auto-generated method stub
		String sql = "delete from user where id = ?";
		Object[] obj = {id};
		return base.add_update_delete(obj, sql);
	}

	@Override
	public Map<String, Object> selectUserByID(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from user where id=?";
		Object []obj = {id};
		return base.selectone(obj, sql);
	}

	@Override
	public List<Map<String, Object>> selectAllUser(User u) {
		// TODO Auto-generated method stub
		String sql = "select * from user";
		return base.selectallMap(sql, null);
	}
	public List<Map<String, Object>> selectUserByLevel(int level,int start, int page) {
		if(level==-1) {
			String sql = "select * from user limit ?,?";
			Object []obj = {start,page};
			return base.selectallMap(sql,obj);
			
		}else {
			String sql = "select * from user where level = ?  limit ?,?";
			Object []obj = {level,start,page};
			return base.selectallMap(sql,obj);
		}
	}

	@Override
	public List<Map<String, Object>> selectLimitUser(User u, int start, int page) {
		// TODO Auto-generated method stub
		String sql = "select * from user";
		sql +=" limit ?,?";
		Object []obj = {start,page};
		return base.selectallMap(sql, obj);
	}

	@Override
	public Long countUser(User u) {
		// TODO Auto-generated method stub
		String sql = "select count(1) from user";
		return base.count(null, sql);
	}
	
	@Override
	public List<Map<String, Object>> countByLevel(User u) {
		// TODO Auto-generated method stub
		String sql = "SELECT LEVEL ,COUNT(LEVEL) FROM user GROUP BY LEVEL";
		return base.selectallMap(sql, null);
	}
	
	@Override
	public Map<String, Object> login(String uname, String pwd) {
		// TODO Auto-generated method stub
		if(!"admin".equals(uname)) {
			return null;
		}
		else{
			PasswordService ps = new PasswordServiceImpl();
			Map<String, Object> p=ps.selectUserByID(10050);
			if(pwd.equals(p.get("pwd"))) {
				return p;
			}else {
				return null;
			}
		}
		
		
	}
	

}
