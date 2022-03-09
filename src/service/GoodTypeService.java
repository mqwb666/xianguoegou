package service;

import java.util.List;
import java.util.Map;

import entity.GoodType;

/**
 *
 * @ClassName: GoodTypeService
 * @description:
 * @author: your name
 * @Date: 2020年5月16日 下午3:43:52
 * 
 */
public interface GoodTypeService {
	public int addGoodType(GoodType gt);

	public int delteGoodType(int id);

	public int updateGoodType(GoodType gt);

	public Map<String, Object> selectGoodTypeById(int id);

	public List<Map<String, Object>> selectAllGoodType(GoodType gt);

	public List<Map<String, Object>> selectLimitGoodType(GoodType gt, int start, int page);

	public Long countGoodType(GoodType gt);
}
