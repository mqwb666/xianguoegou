package entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @ClassName: AdvertisngDataGrideBean
 * @description:
 * @author: your name
 * @Date: 2020年5月17日 上午10:19:16
 * 
 */
public class DataGrideBean {
	private Integer page;
	private Integer sumpage;
	private Long count;
	private List<?> list = new ArrayList();

	public DataGrideBean() {
	}

	public DataGrideBean(Integer page, Integer sumpage, Long count, List<?> list) {
		super();
		this.page = page;
		this.sumpage = sumpage;
		this.count = count;
		this.list = list;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSumpage() {
		return sumpage;
	}

	public void setSumpage(Integer sumpage) {
		this.sumpage = sumpage;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}
