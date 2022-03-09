package service.impl;

import java.util.List;
import java.util.Map;

import dao.BaseDao;
import dao.impl.BaseDaoImpl;
import entity.Good;
import entity.GoodType;
import service.GoodService;

/**
 *
 * @ClassName: GoodServiceImp
 * @description:
 * @author: your name
 * @Date: 2020年5月16日 下午4:03:49
 * 
 */
public class GoodServiceImpl implements GoodService {
	BaseDao<GoodType> bs = new BaseDaoImpl<>();

	@Override
	public int addGood(Good g) {
		String sql = "INSERT INTO good(gtid,gname,content,nownumber,number,lasttime,sid,price,pic,ismarket) VALUES(?,?,?,?,?,now(),?,?,?,?)";
		Object[] obj = { g.getGid(), g.getGname(), g.getContent(), g.getNownumber(), g.getNumber(), g.getSid(),
				g.getPrice(), g.getPic(), g.getIsmarket() };
		return bs.add_update_delete(obj, sql);
	}

	@Override
	public int deleteGood(int id) {
		String sql = "UPDATE good SET ismarket =1 WHERE id =?";
		Object[] obj = { id };
		return bs.add_update_delete(obj, sql);
	}

	@Override
	public int updateGood(Good g) {
		String sql = "UPDATE  good SET gtid=?,gname=?,content=?,nownumber=?,number=?,lasttime=now(),sid=?,price=?,pic=?,ismarket=? WHERE id = ? ";
		Object[] obj = { g.getGid(), g.getGname(), g.getContent(), g.getNownumber(), g.getNumber(), g.getSid(),
				g.getPrice(), g.getPic(), g.getIsmarket(), g.getId() };
		return bs.add_update_delete(obj, sql);
	}

	@Override
	public Map<String, Object> selectGoodById(int id) {
		String sql = "select * from good where id = ?";
		Object[] obj = { id };
		return bs.selectone(obj, sql);
	}

	@Override
	public List<Map<String, Object>> selectAllGood(Good g) {
		String sql = "select * from good";
		return bs.selectallMap(sql, null);
	}

	@Override
	public List<Map<String, Object>> selectLimitGood(Good g, int start, int page) {
		Integer fy = (page - 1) * 5;
		System.out.println("fy===" + fy);
		String sql = "SELECT *,IF(ismarket=0,'0','1') issmarket FROM good";
		sql += " limit " + fy + ",5";
		return bs.selectallMap(sql, null);
	}

	@Override
	public Long countGood(Good g) {
		String sql = "SELECT count(1) FROM good";
		return bs.count(null, sql);
	}

}
