package service;

import java.util.List;
import java.util.Map;

import entity.Order;

public interface OrderService {
	public int addOrder(Order u);
	public int updateOrder(Order u);
	public int deleteOrder(int id);
	public Map<String, Object> selectOrderByID(int id);
	public List<Map<String, Object>> selectAllOrder(Order u);
	public List<Map<String, Object>> selectLimitOrder(Order u,int start,int page);
	public Long countOrder(Order u);
	
	public List<Map<String, Object>> getInformation(Order u,int start,int page);
	public List<Map<String, Object>> getordermore(int id);
}
