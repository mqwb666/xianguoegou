package service;

import java.util.List;
import java.util.Map;

import entity.Advertising;


public interface AdvertisingService {
	public int addAdvertising(Advertising u);
	public int updateAdvertising(Advertising u);
	public int deleteAdvertising(int id);
	public Map<String, Object> selectAdvertisingByID(int id);
	public List<Map<String, Object>> selectAllAdvertising(Advertising u);
	public List<Map<String, Object>> selectLimitAdvertising(Advertising u,int start,int page);
	public Long countAdvertising(Advertising u);
}
