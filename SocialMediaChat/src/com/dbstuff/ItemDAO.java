package com.dbstuff;

import java.util.HashMap;

public interface ItemDAO {
	public void addItem(Object o);

	public boolean update(Object o);

	public Object findById(String id);

	public HashMap<String, Object> getAll();

	boolean delete(Object o);

}
