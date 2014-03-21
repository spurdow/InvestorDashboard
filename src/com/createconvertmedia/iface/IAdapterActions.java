package com.createconvertmedia.iface;

import java.util.List;

/*
 * Actions to be performed by classes that extends BaseAdapter
 * Author : David Montecillo
 */
public interface IAdapterActions<T> {
	
	/*
	 *  add objects to the list
	 */
	public  void add(T e);
	/*
	 *  remove objects to the list
	 */
	public void delete(int index , long id);
	/*
	 *  update objects
	 */
	public void update(int pos , T object);
	
	/*
	 *  gets all the data in the list 
	 */
	public List<T> getAll();
	
	
}
