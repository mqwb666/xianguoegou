package dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import dao.BaseDao;



/*
 * DBUtils�����ࣺBeanListHandler��BeanHandler��Maphandler��MapListHandler
 * 
 * 	����ִ��sql�õ���jdbc��һ�������ࣺDBUtils,���ṩ��һ��QueryRunner��
 * 
 * ��ӡ��޸ġ�ɾ��   ����update������������Ĳ�����
 *      ��һ�����������ݿ���Ϣ��
 *      �ڶ����������ݵ�����Ҫִ�е�sql
 *      ������������Ϊ����������ֵ��һ�㶼��ѣ���Ҫ��ֵ�Ĳ�����װ��object���飬���д��ݣ�
 * 
 * �����ѯ���õ��� query����������Ĳ������ܣ�
 *      ��һ�����������ݿ���Ϣ��
 *      �ڶ����������ݵ�����Ҫִ�е�sql
 *      �����������Ǹ��ݲ�ѯ�Ľ�������ģ�������ѯֻ��Ҫ����һ�����ݼ��ɣ������� new BeanListHandler
 * 
 * �����ѯ���Ϸ�����map��ʱ�� �õ���new MapListHandler()
 * 
 * ������ѯ��������ѯ�õ��� query����������Ĳ������ܣ�
 *      ��һ�����������ݿ���Ϣ��
 *      �ڶ����������ݵ�����Ҫִ�е�sql
 *      �����������Ǹ��ݲ�ѯ�Ľ�������ģ�������ѯֻ��Ҫ����һ�����ݼ��ɣ������� new BeanHandler
 *      ���ĸ�����������Ҫ��sql�У���ֵ
 *      ---------------------------
 * ������ѯ ����Ҫ���ص�ʵ���࣬����Ҫ��map:new MapHandler();
 *      
 * ��ѯ������
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
	//�������ݿ�
	Connection con=utils.conn.con();
	//����һ����� �޸�  ɾ��  ����һ��dao����
	@Override
	public int add_update_delete(Object[] obj, String sql) {
		int a=0;
		try {
			QueryRunner q=new QueryRunner();
			a=q.update(con, sql, obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}

	//������ѯ �����ص���map
	@Override
	public Map<String, Object> selectone(Object[] obj, String sql) {
		Map<String, Object> map=new HashMap<>();
		try {
			QueryRunner q=new QueryRunner();
			map = q.query(con,sql,new MapHandler(),obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	//��ѯȫ��
	@Override
	public List<Map<String, Object>> selectallMap(String sql, Object[] obj) {
		List<Map<String, Object>> list=new ArrayList<>();
		try {
			QueryRunner q=new QueryRunner();
			list = q.query(con,sql,new MapListHandler(),obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(list.size());
		return list;
	}

	//��ѯ��������
	@Override
	public Long count(Object[] obj, String sql) {
		Long c=null;
		try {
			QueryRunner q=new QueryRunner();
			c = (Long) q.query(con,sql,new ScalarHandler<>(),obj);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

}
