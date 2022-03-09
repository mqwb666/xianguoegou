package service.impl;

import java.util.List;
import java.util.Map;

import dao.BaseDao;
import dao.impl.BaseDaoImpl;
import entity.GoodType;
import service.GoodTypeService;

/**
 *
 * @ClassName: GoodTypeServiceImp
 * @description:
 * @author: your name
 * @Date: 2020年5月16日 下午4:04:44
 * 
 */
public class GoodTypeServiceImpl implements GoodTypeService {

	BaseDao<GoodType> bs = new BaseDaoImpl<>();

	@Override
	public int addGoodType(GoodType gt) {
		String sql = "INSERT INTO goodtype (gtname) VALUES(?)";
		Object[] obj = { gt.getGtname() };
		return bs.add_update_delete(obj, sql);
	}

	@Override
	public int delteGoodType(int id) {
		String sql = "DELETE FROM goodtype WHERE id =?";
		Object[] obj = { id };
		return bs.add_update_delete(obj, sql);
	}

	@Override
	public int updateGoodType(GoodType gt) {
		String sql = "UPDATE  goodtype SET gtname = ? WHERE id = ? ";
		Object[] obj = { gt.getGtname(), gt.getId() };
		return bs.add_update_delete(obj, sql);
	}

	@Override
	public Map<String, Object> selectGoodTypeById(int id) {
		String sql = "select * from goodtype where id = ?";
		Object[] obj = { id };
		return bs.selectone(obj, sql);
	}

	@Override
	public List<Map<String, Object>> selectAllGoodType(GoodType gt) {
		String sql = "select * from goodtype";
		return bs.selectallMap(sql, null);
	}

	@Override
	public List<Map<String, Object>> selectLimitGoodType(GoodType gt, int start, int page) {
		String sql = "SELECT * FROM goodtype LIMIT ?,?";
		Object[] obj = { start, page };
		return bs.selectallMap(sql, obj);
	}

	@Override
	public Long countGoodType(GoodType gt) {
		String sql = "SELECT count(1) FROM goodtype";
		return bs.count(null, sql);
	}

}
