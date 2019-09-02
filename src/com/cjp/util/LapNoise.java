package com.cjp.util;

/**
 * <p>文件名称：LapNoise.java</p>
 * <p>文件描述：生成拉普拉斯分布</p>
 * <p>版权所有： 版权所有(C)2013-2099</p>
 * <p>学校：福州大学 </p>
 * <p>作者：蔡剑平 </p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 *
 * @version 1.0
 * @author <a> href="http://user.qzone.qq.com/1107066941/infocenter?ptsig=s0MHdzF3EC30jzseitTN63FJ1KrFjLRWNDYCux9Bu8o_">caijianping</a>
 */
public class LapNoise {

	/**
	 * @param args
	 */
	public static double getLap(double u,double b) {
		double x=Math.random();
		if (x<0.5) {
			return b*Math.log(2*x)+u;
		}else{
			return u-b*Math.log(2-2*x);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getLap(0, 1));
	}

}
