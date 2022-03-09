package service;

import java.util.List;
import java.util.Map;

import entity.Good;

/**
 *
 * @ClassName: GoodService
 * @description:
 * @author: your name
 * @Date: 2020年5月16日 下午3:44:17
 * 
 */
public interface GoodService {
	public int addGood(Good g);

	public int deleteGood(int id);

	public int updateGood(Good g);

	public Map<String, Object> selectGoodById(int id);

	public List<Map<String, Object>> selectAllGood(Good g);

	public List<Map<String, Object>> selectLimitGood(Good g, int start, int page);

	public Long countGood(Good g);
}
