package service.impl;

import java.util.List;
import java.util.Map;

import dao.BaseDao;
import dao.impl.BaseDaoImpl;
import entity.OrderMore;
import service.OrdermoreService;

public class OrdermoreServiceImpl implements OrdermoreService{
	BaseDao<OrderMore> base = new BaseDaoImpl<>(); 
	@Override
	public int addOrderMore(OrderMore b) {
		String sql = "INSERT OrderMore (gid,omnumber,oid) VALUES(?,?,?)";
		Object[] obj = {b.getGid(),b.getOmnumber(),b.getOid()};
		return base.add_update_delete(obj, sql);
	}

	@Override
	public int updateOrderMore(OrderMore b) {
		String sql = "update OrderMore set gid=?,omnumber=?,oid=? where id=?";
		Object[] obj = {b.getGid(),b.getOmnumber(),b.getOid(),b.getId()};
		return base.add_update_delete(obj, sql);
	}

	@Override
	public int deleteOrderMore(int id) {
		String sql = "delete from OrderMore where id=?";
		Object[] obj = {id};
		return base.add_update_delete(obj, sql);
	}

	@Override
	public Map<String, Object> selectOrderMoreByID(int id) {
		String sql = "select * from OrderMore where id=?";
		Object []obj= {id};
		return base.selectone(obj, sql);
	}

	@Override
	public List<Map<String, Object>> selectAllOrderMore(OrderMore u) {
		String sql = "select * from OrderMore ";
		return base.selectallMap(sql, null);
	}

	@Override
	public List<Map<String, Object>> selectLimitOrderMore(OrderMore u, int start, int page) {
		String sql = "select * from OrderMore";
		sql +=" limit ?,?";
		Object []obj = {start,page};
		return base.selectallMap(sql, obj);

	}

	@Override
	public Long countOrderMore(OrderMore u) {
		String sql = "select count(1) c from OrderMore";
		return base.count(null, sql);
	}

}
