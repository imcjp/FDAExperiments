package com.cjp.util;

/**
 * <p>�ļ����ƣ�LapNoise.java</p>
 * <p>�ļ�����������������˹�ֲ�</p>
 * <p>��Ȩ���У� ��Ȩ����(C)2013-2099</p>
 * <p>ѧУ�����ݴ�ѧ </p>
 * <p>���ߣ��̽�ƽ </p>
 * <p>����ժҪ�� </p>
 * <p>����˵���� </p>
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
