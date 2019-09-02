package com.cjp.btadp;
/**
 * <p>文件名称：DpBta.java</p>
 * <p>文件描述：树状数组实现差分隐私动态发布</p>
 * <p>版权所有： 版权所有(C)2013-2099</p>
 * <p>学校：福州大学 </p>
 * <p>作者：蔡剑平 </p>
 * <p>内容摘要： </p>
 * <p>其他说明： </p>
 *
 * @version 1.0
 * @author <a> href="http://user.qzone.qq.com/1107066941/infocenter?ptsig=s0MHdzF3EC30jzseitTN63FJ1KrFjLRWNDYCux9Bu8o_">caijianping</a>
 */
import java.util.Scanner;

import com.cjp.util.LapNoise;

public class DpBta {
	private double an[];
	private double cn[];
	private double NoiCn[];
	private int maxM;
	private int p,n;
	private MakeCoefficient coefficient;
	private double e;
	private static int lowBit(int x) {
		return x&(-x);
	}
	public int getP() {
		return p;
	}
	
	public DpBta(int maxM,double e) {
		// TODO Auto-generated constructor stub
		setMaxM(maxM);
		this.e=e;
	}
	public int getMaxM() {
		return maxM;
	}
	public void setMaxM(int maxM) {
		this.maxM = maxM;
		n=(int)Math.pow(2, maxM);
		an=new double[n+1];
		cn=new double[n+1];
		NoiCn=new double[n+1];
		p=0;
		coefficient=new MakeCoefficient(maxM);		
	}
	public void addVal(double x){
		if (p>=n-1) {
			System.out.println("达到容量上界，不能再添加");
			return ;
		}
		p++;
		an[p]=x;
		int pt=p;
		while (pt<n) {
			cn[pt]+=x;
			pt+=lowBit(pt);
		}
		NoiCn[p]=coefficient.getCof(p)*cn[p]+LapNoise.getLap(0, e);
	}
	public double getReal(){
		int pt=p;
		if (p==0) {
			return 0;
		}
		double ans=0;
		while (pt>0) {
			ans+=cn[pt];
			pt-=lowBit(pt);
		}
		return ans;

	}
	public double query() {
		int pt=p;
		if (p==0) {
			return 0;
		}
		double ans=0;
		while (pt>0) {
			ans+=NoiCn[pt]/coefficient.getCof(pt);
			pt-=lowBit(pt);
		}
		return ans;
	}
	public static void main(String[] args) {
		System.out.println("请输入数据容量参数k(容量为2^k-1):");
		Scanner cin=new Scanner(System.in);
		int n=cin.nextInt();
		System.out.println("请输入隐私参数e:");
		double e=cin.nextDouble();
		DpBta bta=new DpBta(n,e);
		System.out.println("请输入要添加的数据:");
		while (cin.hasNext()) {
			int x=cin.nextInt();
			bta.addVal(x);
			System.out.println("第"+bta.getP()+"次添加数据后，结果是"+bta.query()+"，真实值为"+bta.getReal());
		}
	}
}
