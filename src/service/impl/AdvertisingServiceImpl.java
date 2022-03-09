package service.impl;

import java.util.List;
import java.util.Map;

import dao.BaseDao;
import dao.impl.BaseDaoImpl;
import entity.Advertising;
import service.AdvertisingService;

public class AdvertisingServiceImpl implements AdvertisingService {
	BaseDao<Advertising> base = new BaseDaoImpl<>();

	@Override
	public int addAdvertising(Advertising b) {
		String sql = "INSERT advertising (adname,content,gid,pic,creattime,ismarket) VALUES(?,?,?,?,now(),?)";
		Object[] obj = { b.getAdname(), b.getContent(), b.getGid(), b.getPic(), b.getIsmarket() };
		return base.add_update_delete(obj, sql);
	}

	@Override
	public int updateAdvertising(Advertising b) {
		String sql = "update advertising set adname=?,content=?,gid=?,pic=?,creattime=Now(),ismarket=? where id=?";
		Object[] obj = { b.getAdname(), b.getContent(), b.getGid(), b.getPic(), b.getIsmarket(), b.getId() };
		return base.add_update_delete(obj, sql);
	}

	@Override
	public int deleteAdvertising(int id) {
		String sql = "delete from advertising where id=?";
		Object[] obj = { id };
		return base.add_update_delete(obj, sql);
	}

	@Override
	public Map<String, Object> selectAdvertisingByID(int id) {
		String sql = "select * from advertising where id=?";
		Object[] obj = { id };
		return base.selectone(obj, sql);
	}

	@Override
	public List<Map<String, Object>> selectAllAdvertising(Advertising u) {
		String sql = "select * from advertising ";
		return base.selectallMap(sql, null);
	}

	@Override
	public List<Map<String, Object>> selectLimitAdvertising(Advertising u, int start, int page) {
		// SELECT a.*,g.gname FROM advertising a,good g WHERE a.gid = g.id
		Integer fy = (page - 1) * 5;
		String sql = "select a.* ,g.gname,IF(a.ismarket=0,'0','1') issmarket FROM advertising a,good g WHERE a.gid = g.id";
		sql += " limit " + fy + ",5";
		return base.selectallMap(sql, null);

	}

	@Override
	public Long countAdvertising(Advertising u) {
		String sql = "select count(1) c from advertising";
		return base.count(null, sql);
	}

}
