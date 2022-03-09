package service.impl;

import java.util.List;
import java.util.Map;

import dao.BaseDao;
import dao.impl.BaseDaoImpl;
import entity.Order;
import service.OrderService;

public class OrderServiceImpl implements OrderService{
	BaseDao<Order> base = new BaseDaoImpl<>(); 
	@Override
	public int addOrder(Order b) {
		String sql = "INSERT Order (aid,createtime,orderid) VALUES(?,?,?)";
		Object[] obj = {b.getAid(),b.getCreattime(),b.getOrderid()};
		return base.add_update_delete(obj, sql);
	}

	@Override
	public int updateOrder(Order b) {
		String sql = "update Order set aid=?,createtime=?,orderid=? where id=?";
		Object[] obj = {b.getAid(),b.getCreattime(),b.getOrderid(),b.getId()};
		return base.add_update_delete(obj, sql);
	}

	@Override
	public int deleteOrder(int id) {
		String sql = "delete from `order` where id=?";
		Object[] obj = {id};
		return base.add_update_delete(obj, sql);
	}

	@Override
	public Map<String, Object> selectOrderByID(int id) {
		String sql = "select * from Order where id=?";
		Object []obj= {id};
		return base.selectone(obj, sql);
	}

	@Override
	public List<Map<String, Object>> selectAllOrder(Order u) {
		String sql = "select * from Order ";
		return base.selectallMap(sql, null);
	}

	@Override
	public List<Map<String, Object>> selectLimitOrder(Order u, int start, int page) {
		String sql = "select * from Order";
		sql +=" limit ?,?";
		Object []obj = {start,page};
		return base.selectallMap(sql, obj);

	}

	@Override
	public Long countOrder(Order u) {
		String sql = "SELECT count(1) FROM `order`";
		return base.count(null, sql);
	}

	@Override
	public List<Map<String, Object>> getInformation(Order u,int start,int page) {
		// TODO Auto-generated method stub
		String sql = "SELECT o.id,o.orderid,u.uname,SUM(g.price*om.omnumber) price,CONCAT(province,city,county,a.content) AS address,o.creattime AS `time`\r\n" + 
				"FROM `user` u,address a,`order` o,good g,ordermore om \r\n" + 
				"WHERE u.id IN(\r\n" + 
				"SELECT uid FROM address WHERE a.id IN(\r\n" + 
				"SELECT aid FROM `order`))\r\n" + 
				"AND a.uid=u.id \r\n" + 
				"AND o.aid=a.id \r\n" + 
				"AND o.id=om.oid\r\n" + 
				"AND g.id IN(\r\n" + 
				"SELECT gid FROM ordermore)\r\n" + 
				"AND g.id=om.gid \r\n" + 
				"GROUP BY om.oid limit ?,?";
		Object []obj = {start,page};
		return base.selectallMap(sql, obj);
	}

	@Override
	public List<Map<String, Object>> getordermore(int id) {
		// TODO Auto-generated method stub
		String sql = "SELECT  g.gname,g.price,om.* FROM good g,ordermore om WHERE g.id IN(SELECT gid FROM ordermore) AND g.id=om.gid AND oid=?";
		Object []obj = {id};
		return base.selectallMap(sql, obj);
	}



	

}
