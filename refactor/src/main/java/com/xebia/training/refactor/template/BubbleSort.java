package com.xebia.training.refactor.template;


public class BubbleSort {
	
	public Integer[] sort(Integer[] list){
		for(int i=0;i<list.length;i++){
			for (int j = i; j < list.length; j++) {
				if(list[i] > list[j]){
					swap(list,i,j);
				}
			}
		}
		return list;
	}

	private void swap(Integer[] list, int i, int j) {
		Integer temp=list[j];
		list[j]=list[i];
		list[i]=temp;
	}

}
