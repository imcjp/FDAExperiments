package com.cjp.btadp;
/**
 * <p>文件名称：MakeCoefficient.java</p>
 * <p>文件描述：计算树状数组系数</p>
 * <p>版权所有： 版权所有(C)2013-2099</p>
 * <p>学校：福州大学 </p>
 * <p>作者：蔡剑平 </p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 *
 * @version 1.0
 * @author <a> href="http://user.qzone.qq.com/1107066941/infocenter?ptsig=s0MHdzF3EC30jzseitTN63FJ1KrFjLRWNDYCux9Bu8o_">caijianping</a>
 */
public class MakeCoefficient {
	//表示数据总量为2^m的系数类
//	double an[];
	private double res[];
	private double mf[];
	private int m;
	public MakeCoefficient(int m) {
		// TODO Auto-generated constructor stub
		setM(m);
	}
	public int getM() {
		return m;
	}
	public void setM(int m) {
		this.m = m;
		int n=(int)Math.pow(2, m);
		res=new double[m+1];
		mf=new double[m+1];
//		an=new double[n];
		res[1]=1;
		double l=1;
		for (int i = 2; i < res.length; i++) {
			l=l*2;
			double a=Math.pow(res[i-1],1/3.0);
			double b=Math.pow(l,1/3.0);
			res[i]=(a+b)*(a+b)*(a+b)+res[i-1];
//			System.out.println(res[i]/(l*2-1)/i/i/i);
		}
		int len=1;
//		an[1]=1;
		mf[1]=0;
		for (int i = 2; i < res.length; i++) {
			len=len*2;
//			for (int j = 1; j < len; j++) {
//				an[len+j]=an[j];
//			}
			double a=Math.pow(res[i-1],1/3.0)/(Math.pow(res[i-1],1/3.0)+Math.pow(len,1/3.0));
			mf[i]=a;
//			for (int j = 1; j < len; j++) {
//				an[j]*=a;
//			}
//			an[len]=1-a;
		}
//		for (int i = 0; i < res.length; i++) {
//			System.out.println(res[i]+" ");
//		}
//		System.out.println();
//		for (int i = 0; i < mf.length; i++) {
//			System.out.println(mf[i]+" ");
//		}
//		System.out.println();
	}
	public double getCof(int k) {
		int n=(int)Math.pow(2, m);
		if (k<1||k>=n) {
			return 0;
		}
//		int kt=k;
		double ans=1;
		int i=m;
		while (i>0) {
			if (k<n/2) {
				ans*=mf[i];
			}else if (k==n/2) {
				ans*=(1-mf[i]);
				break;
			}else {
				k-=n/2;
			}
			i--;
			n=n/2;
		}
		return ans;
	}
	public double getErr() {
		return res[m];
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int m=3;
		MakeCoefficient coefficient=new MakeCoefficient(m);
		int n=(int)Math.pow(2, m);
		for (int i = 1; i < n; i++) {
			System.out.println(coefficient.getCof(i));
		}
//		System.out.println();
		System.out.println(coefficient.getErr());
	}

}
