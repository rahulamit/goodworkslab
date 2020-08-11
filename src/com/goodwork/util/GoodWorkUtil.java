package com.goodwork.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class GoodWorkUtil {
	
	public static void main(String[] args) {
		String tags[]=getHashTags("How the Avocado Became the Fruit of the Global Trade");
		for(String tag:tags) {
			System.out.println(tag);
		}
		System.out.println(palindromedescendant(11211230));
	}
	
	public static String[] getHashTags(String headline){
		String tags[]=new String[3];
		String arr[]=headline.split(" ");
		LinkedHashMap<String, Integer> map=new LinkedHashMap<String, Integer>();
		for(String word:arr) {
			map.put(word, word.length());
		}
		map=map.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(oldValue,newValue)->oldValue,LinkedHashMap::new));
		Set<String> keys=map.keySet();
		int count=0;
		for(String word:keys) {
			if(count==3) {
				break;
			}else {
				tags[count]=word;
				count++;
			}
		}
		return tags;
	}
	
	public static boolean palindromedescendant(int number) {
		boolean isPenlindrom=false;
		
		while(!isPenlindrom) {
			if(number>9) {
				isPenlindrom=checkPelindrom(number);
				if(!isPenlindrom) {
					number=findDirectChild(number);
				}
			}else {
				break;
			}
		}
		return isPenlindrom;
	}
	
	
	
	public static boolean checkPelindrom(int number) {
		int remainder,sum=0,temp;
		temp=number;
		while(number>0) {
			remainder=number%10;
			sum=(sum*10)+remainder;
			number=number/10;
		}
		if(temp==sum) {
			return true;
		}
		else {
			return false;
		}
	}
	public static int findDirectChild(Integer number) {
		String child="";
		while(number>10) {
			int count=number%10+(number/10)%10;
			child=child+count;
			number=number/100;
		}
		return Integer.parseInt(child);
	}
}
