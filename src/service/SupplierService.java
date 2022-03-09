package service;

import java.util.List;
import java.util.Map;

import entity.Supplier;

public interface SupplierService {

	public int addSupplier(Supplier u);
	public int updateSupplier(Supplier u);
	public int ischeck(int id);
	public int deleteData(int id);	
	public Map<String, Object> selectSupplierByID(int id);
	public List<Map<String, Object>> selectAllSupplier(Supplier u);
	public List<Map<String, Object>> selectSupplierByLevel(int level,int ischeck,int start, int page);
	public List<Map<String, Object>> selectLimitSupplier(Supplier u,int ischeck,int start,int page);
	public Long countSupplier(int ischeck);
	public List<Map<String, Object>> countByLevel(int ischeck);
}
