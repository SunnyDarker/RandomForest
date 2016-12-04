package com.rf.real;

import java.util.ArrayList;

public class MainRun {
	@SuppressWarnings("static-access")
	public static void main(String args[]){

		String traindata="D:\\我的Java\\RandomForest\\Data.txt";
		String testdata="D:\\我的Java\\RandomForest\\Test.txt";
		//树的数量
		int N = 100;
		int numTrees=N;
		
		DescribeTrees DT = new DescribeTrees(traindata);
		ArrayList<int[]> Input=DT.CreateInput(traindata);int categ=0;
		
		DescribeTrees DTT = new DescribeTrees(traindata);
		ArrayList<int[]> Test=DTT.CreateInput(testdata);
		
		//输入？
		for(int k=0;k<Input.size();k++){if(Input.get(k)[Input.get(k).length-1]<categ)continue;else{categ=Input.get(k)[Input.get(k).length-1];}}
		
		RandomForest RaF =new RandomForest(numTrees, Input, Test);
		RaF.C=categ;
		RaF.M=Input.get(0).length-1;
		RaF.Ms=(int)Math.round(Math.log(RaF.M)/Math.log(2)+1);
		RaF.Start();

	}
}
