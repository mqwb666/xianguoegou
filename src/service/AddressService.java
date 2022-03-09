package service;

import java.util.List;
import java.util.Map;

import entity.Address;

/**
 *
 * @ClassName: OredeService
 * @description:
 * @author: your name
 * @Date: 2020年5月16日 下午3:44:47
 * 
 */
public interface AddressService {
	public int addAddress(Address a);

	public int deleteAddress(int id);

	public int updateAddress(Address a);

	public Map<String, Object> selectAddressById(int id);

	public List<Map<String, Object>> selectAllAddress(Address a);

	public List<Map<String, Object>> selectLimitAddress(Address a, int start, int page);

	public Long countAddress(Address a);
}
