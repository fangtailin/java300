package cn.sxt.collection;

import java.util.ArrayList;
import java.util.List;

public class MyArrayList {

	// List list=new ArrayList();

	private Object[] elementData;
	private int size;

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public MyArrayList() {
		this(10);
	}

	public MyArrayList(int initialCapacity) {
		if (initialCapacity < 0) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		elementData = new Object[initialCapacity];
	}

	public void add(Object obj) {
		// Increment Capacity 数组扩容+数据拷贝
		ensureCapacity();

		elementData[size++] = obj;
		// size++;
	}

	public Object get(int index) {
		rangeCheck(index);
		return elementData[index];
	}

	public void remore(int index) {
		// 删除指定位置的对象
		rangeCheck(index);
		int numMoved = size - index - 1;
		if (numMoved > 0) {
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		}
		elementData[--size] = null;
	}

	private void rangeCheck(int index) {
		// if (index < 0 || index >= size) {
		if (index >= size) {
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void remove(Object obj) {
		for (int i = 0; i < size; i++) {
			if (get(i).equals(obj)) {// 注意：底层用的是equals， 而不是==
				remove(i);
			}
		}
	}

	public Object set(int index, Object obj) { // 替换index的值
		rangeCheck(index);
		Object oldValue = elementData[index];
		elementData[index] = obj;
		return oldValue;
	}

	public void add(int index, Object obj) {

		rangeCheck(index);
		// Increment Capacity 数组扩容+数据拷贝
		ensureCapacity();

		System.arraycopy(elementData, index, elementData, index + 1, size - index);
		elementData[index] = obj;
		size++;
	}

	private void ensureCapacity() {
		// Increment Capacity 数组扩容+数据拷贝
		if (size + 1 > elementData.length) {
			Object[] newArray = new Object[size * 2 + 1];
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			;
//							for (int i = 0; i < elementData.length; i++) {
//								newArray[i]=elementData[i];
//							}
			elementData = newArray;
		}
	}

	public static void main(String[] args) {
		MyArrayList list = new MyArrayList(3);
		list.add(323);
		list.add(323);
		list.add("erre");
		list.add("reda");

		System.out.println(list.size());
		System.out.println(list.get(3));
		System.out.println(list.get(2));
	}
}
