package service;

import java.util.List;
import java.util.Map;

import entity.OrderMore;

public interface OrdermoreService {
	public int addOrderMore(OrderMore u);
	public int updateOrderMore(OrderMore u);
	public int deleteOrderMore(int id);
	public Map<String, Object> selectOrderMoreByID(int id);
	public List<Map<String, Object>> selectAllOrderMore(OrderMore u);
	public List<Map<String, Object>> selectLimitOrderMore(OrderMore u,int start,int page);
	public Long countOrderMore(OrderMore u);
}
