package com.yanblog.base.utils;

import java.util.Random;
import java.util.UUID;

public class RandomGUIDUtil {

	public static void main(String[] args) throws Exception {

		for (int i = 0; i < 100; i++) {
			System.out.println(createRandomGUID());
		}
		//System.out.println(createRandomGUID());
	}
	
	public static String createRandomGUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	}

	/**
	 * 创建指定数量的随机字符串
	 * 
	 * @param numberFlag
	 *            是否是数字
	 * @param length
	 * @return
	 */
	public static String createRandom(boolean numberFlag, int length) {
		String retStr = "";
		String strTable = numberFlag ? "1234567890"
				: "1234567890abcdefghijkmnpqrstuvwxyz";
		int len = strTable.length();
		boolean bDone = true;
		do {
			retStr = "";
			int count = 0;
			for (int i = 0; i < length; i++) {
				double dblR = Math.random() * len;
				int intR = (int) Math.floor(dblR);
				char c = strTable.charAt(intR);
				if (('0' <= c) && (c <= '9')) {
					count++;
				}
				retStr += strTable.charAt(intR);
			}
			if (count >= 2) {
				bDone = false;
			}
		} while (bDone);

		return retStr;
	}
	
	
	 public static String getRandomString(int length){
	        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	        Random random = new Random();
	        StringBuffer sb = new StringBuffer();
	          
	        for(int i = 0 ; i < length; ++i){  
	            int number = random.nextInt(62);//[0,62)  
	              
	            sb.append(str.charAt(number));  
	        }  
	        return sb.toString();  
	    }  
	

}
