package model;

import java.util.List;

public class Result {
	private List<Dia> list;

	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Result(List<Dia> list) {
		super();
		this.list = list;
	}

	public List<Dia> getList() {
		return list;
	}

	public void setList(List<Dia> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Result [list=" + list + "]";
	}
	

}
