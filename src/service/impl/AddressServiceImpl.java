package service.impl;

import java.util.List;
import java.util.Map;

import dao.BaseDao;
import dao.impl.BaseDaoImpl;
import entity.Address;
import service.AddressService;


public class AddressServiceImpl implements AddressService {
	BaseDao<Address> bs = new BaseDaoImpl<>();

	@Override
	public int addAddress(Address a) {
		String sql = "INSERT INTO address(province,city,county,content,uid) values(?,?,?,?,?);";
		Object[] obj = { a.getProvince(), a.getCity(), a.getCounty(), a.getContent(), a.getUid() };
		return bs.add_update_delete(obj, sql);
	}

	@Override
	public int deleteAddress(int id) {
		String sql = "DELETE FROM address WHERE id =?";
		Object[] obj = { id };
		return bs.add_update_delete(obj, sql);
	}

	@Override
	public int updateAddress(Address a) {
		String sql = "UPDATE  address SET province=?,city=?,county=?,county=?,uid=? WHERE id = ? ";
		Object[] obj = { a.getProvince(), a.getCity(), a.getCounty(), a.getUid(), a.getId() };
		return bs.add_update_delete(obj, sql);
	}

	@Override
	public Map<String, Object> selectAddressById(int id) {
		String sql = "select * from address where id = ?";
		Object[] obj = { id };
		return bs.selectone(obj, sql);
	}

	@Override
	public List<Map<String, Object>> selectAllAddress(Address a) {
		String sql = "select * from address";
		return bs.selectallMap(sql, null);
	}

	@Override
	public List<Map<String, Object>> selectLimitAddress(Address a, int start, int page) {
		String sql = "SELECT * FROM address LIMIT ?,?";
		Object[] obj = { start, page };
		return bs.selectallMap(sql, obj);
	}

	@Override
	public Long countAddress(Address a) {
		String sql = "SELECT count(1) FROM address";
		return bs.count(null, sql);
	}

}
