package com.createconvertmedia.iface;

import java.util.List;

public interface TaskCallback<T>{
	/**
	 * manages call back from task
	 * @param tData
	 */
	void display(List<T> tData); 
}
