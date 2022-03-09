package dao;

import java.util.List;
import java.util.Map;

/*
 * ������dao  T ��ʾ��������ҵ�ʱ����Ҵ��ķ�����ʲô��T�ʹ���ʲô
 * 
 * �磺service�㣺  BaseDao<Users>  : T==Users
 */
public interface BaseDao<T> {
	//���������  �޸�  ɾ��
//	public int add(Object[] obj,String sql);
//	public int update(Object[] obj,String sql);
//	public int delete(Object[] obj,String sql);
	//����һ
	public int add_update_delete(Object[] obj,String sql);
	
	//�����Ĳ�ѯ:������ѯ
	//public T selectone(Object[] obj,String sql);
	public Map<String, Object> selectone(Object[] obj,String sql);
	//��ѯȫ�������ϵķ�����T
	//public List<T> selectall();
	public List<Map<String, Object>> selectallMap(String sql,Object[] obj);
	//��ѯ������
	public Long count(Object[] obj,String sql);
	
	
	
	

}
