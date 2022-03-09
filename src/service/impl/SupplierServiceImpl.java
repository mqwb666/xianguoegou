package service.impl;

import java.util.List;
import java.util.Map;

import dao.BaseDao;
import dao.impl.BaseDaoImpl;
import entity.Supplier;
import service.SupplierService;

public class SupplierServiceImpl implements SupplierService {

	BaseDao<Supplier> base = new BaseDaoImpl<>();
	@Override
	public int addSupplier(Supplier s) {
		// TODO Auto-generated method stub
		String sql = "INSERT supplier (sname,content,uid,province,city,county,contentaddress,level,pic,uzcbirthday,ischeck,isdelete) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] obj = {s.getSname(),s.getContent(),s.getUid(),s.getProvince(),s.getCity(),s.getCounty(),s.getContentaddress(),s.getLevel(),s.getUzcbirthday(),s.getIscheck(),s.getIsdelete()};
		return base.add_update_delete(obj, sql);
	}

	@Override
	public int updateSupplier(Supplier s) {
		// TODO Auto-generated method stub
		String sql = "update supplier set sname=?,content=?,uid=?,province=?,city=?,county=?,contentaddress=?,level=?,pic=?,uzcbirthday=?,ischeck=? where id=?";
		Object[] obj = {s.getSname(),s.getContent(),s.getUid(),s.getProvince(),s.getCity(),s.getCounty(),s.getContentaddress(),s.getLevel(),s.getUzcbirthday(),s.getIscheck(),s.getIsdelete(),s.getId()};
		return base.add_update_delete(obj, sql);
	}



	@Override
	public Map<String, Object> selectSupplierByID(int id) {
		// TODO Auto-generated method stub
		String sql = "select * from supplier where id=?";
		Object []obj = {id};
		return base.selectone(obj, sql);
	}

	@Override
	public List<Map<String, Object>> selectAllSupplier(Supplier s) {
		// TODO Auto-generated method stub
		String sql = "select * from supplier";
		return base.selectallMap(sql, null);
	}

	@Override
	public List<Map<String, Object>> selectLimitSupplier(Supplier s,int ischeck, int start, int page) {
		// TODO Auto-generated method stub
		String sql = "select * from supplier where ischeck = ?";
		sql +=" limit ?,?";
		Object []obj = {ischeck,start,page};
		return base.selectallMap(sql, obj);
	}

	@Override
	public Long countSupplier(int ischeck) {
		// TODO Auto-generated method stub
		String sql = "select count(1) c from supplier where ischeck = ?";
		Object []obj = {ischeck};
		return base.count(obj, sql);
	}

	@Override
	public int ischeck(int id) {
		String sql = "update supplier set ischeck=1 where id=?";
		Object[] obj = {id};
		return base.add_update_delete(obj, sql);
	}

	@Override
	public int deleteData(int id) {
		String sql = "delete from supplier where id = ?";
		Object[] obj = {id};
		return base.add_update_delete(obj, sql);
	}

	@Override
	public List<Map<String, Object>> selectSupplierByLevel(int level,int ischeck, int start, int page) {
		if(level==-1) {
			String sql = "select * from supplier where ischeck = ?  limit ?,? ";
			Object []obj = {ischeck,start,page};
			return base.selectallMap(sql,obj);
			
		}else {
			String sql = "select * from supplier where ischeck = ? and level = ?  limit ?,?";
			Object []obj = {ischeck,level,start,page};
			return base.selectallMap(sql,obj);
		}
	}

	@Override
	public List<Map<String, Object>> countByLevel(int ischeck) {
		String sql = "SELECT LEVEL ,COUNT(LEVEL) FROM supplier where ischeck = ? GROUP BY LEVEL";
		Object []obj = {ischeck};
		return base.selectallMap(sql, obj);
	}

}
