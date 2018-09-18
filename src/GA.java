import java.util.Random;
import java.util.Scanner;
public class GA {

	 public static void main(String args[]){
		 @SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		 System.out.println("Type one positive number");
		 int number = keyboard.nextInt();
		 System.out.println("The generated population is:");
		 String[] randomArray=binaryArray(number);
		 boolean end1=true;
		 Integer[] functionArray=new Integer[number];
		 functionArray=functionF(randomArray);
		 for(int i=0;i<number;i++)
		 {
			 if(functionArray[i]==7)
			 {end1=false;
			 break;
			 }
		 }
		int[] parentsArray=new int[2];
		String[] children=new String[2];		 
		while(end1){   //if end1 false, problem solved
		System.out.println("The algorithm implements partial replacement of the population(50%):");
		int update=number*50/100;
		if(update<=0){update=1;}
  		String[] temp=binaryArray(update);
		functionArray=functionF(randomArray);
		for(int i=0;i<update;i++){   // at 50%
				Random rd = new Random();
				int m1 = rd.nextInt(number);	   
				randomArray[m1]=temp[i];
		}
	   parentsArray=parents(randomArray,functionArray);
	   children=reproduce(randomArray[parentsArray[0]],randomArray[parentsArray[1]]);
	   randomArray[parentsArray[0]]=children[0];
	   randomArray[parentsArray[1]]=children[1];
	   functionArray=functionF(randomArray);   
	   for(int j=0;j<update;j++)//terminate program, if problem solved
	   {
		   if(functionArray[j]==7)
		   {end1=false;
		   	break;}
	   }
	   if (end1==false){break; }
	   int update2=number*10/100;
	   if(update2<=0){update2=1;}
	   for(int r=0;r<update2;r++){
		   Random rg = new Random();
		   int m = rg.nextInt(number);	   
		   String mut=mutation(randomArray[m]);           //mutation
		   randomArray[m]=mut;
		   System.out.println("The algorithm implements mutation (10%)" +mut);

		   functionArray=functionF(randomArray);		
		   for(int j=0;j<number;j++)
		   {
				 if(functionArray[j]==7)
				 {end1=false;
				 break;}
		   }
		   }
			 //}
		}//end while
	 }
	
	private static String[] reproduce(String father,String mother)
	{
		String[] child=new String[2];
		Random rg = new Random();
		int zeros = rg.nextInt(7);  
		child[0]=father.substring(0,zeros);
		child[0]=child[0]+mother.substring(zeros,6);
		child[1]=mother.substring(0,zeros);
		child[1]=child[1]+father.substring(zeros,6);
		return child;
	}
	private static String mutation(String child1)
	{
		String child2;
		Random rg = new Random();
		int i = rg.nextInt(6);  //mutation
		String c1=child1.substring(0,i);
		String c2=child1.substring(i,i+1);
		String c3=child1.substring(i+1,6);
		if(c2=="0")
		{
			child2=c1+"1"+c3;
		}
		else
		{
			child2=c1+"0"+c3;
		}
	return child2;
	}

	private static int[] parents(String[] binArray,Integer[] fun)    //proportional suitability technique
	 {	  
		 int[] parents_return=new int[2];
	 	 parents_return[0]=0;
		 double[] p=new double[fun.length];  //possibility of choice
	 	 double max=0;
		 Integer sum=0;
		 for(int i=0;i<fun.length;i++)  //overall suitability
		 {	 if(fun[i] == null){fun[i]=0;}
			 sum=fun[i]+sum; }
		 if(sum==0){sum=1;}
		 for(int i=0;i<fun.length;i++)
		 {
			if(sum==0){sum=1;}
			 if(fun[i]>7)   //ERROR
			 {System.out.println("ERROR"+binArray[i]);
			  break;
			  }
		 	p[i]=fun[i]*1000/sum;
			 if(p[i]>max)
			 {
				 parents_return[1]=parents_return[0] ;  //temp
				 max=p[i];    
				 parents_return[0]=i;  
			 }
		 }//end for
		 return parents_return;
	 }
		
	 private static int xor(int a, int b) {
		    int nota,notb,l;
		    if (a==0){nota=1;}
		    else{nota=0;}
		    if (b==0){notb=1;}
		    else{notb=0;}
		    l=(a*notb)+(nota*b);
		    return l;
	}
	   
	   private static String[] binaryArray(int num) {
		   String[] binary=new String[64];
		   binary[0] = "000000";
		   binary[1]=  "000001";
		   binary[2] = "000010";
		   binary[3]=  "000011";
		   binary[4] = "000100";
		   binary[5]=  "000101";
		   binary[6] = "000110";
		   binary[7]=  "000111";
		   binary[8] = "001000";
		   binary[9]=  "001001";
		   binary[10] ="001010";
		   binary[11]=  "001011";
		   binary[12] = "001100";
		   binary[13]= "001101";
		   binary[14]= "001110"; 
		   binary[15]= "001111";
		   binary[16] ="010000";
		   binary[17]= "010001";
		   binary[18] ="010010";
		   binary[19]= "010011";
		   binary[20] ="010100";
		   binary[21]= "010101";
		   binary[22] ="010110";
		   binary[23]=  "010111";
		   binary[24] ="011000";
		   binary[25]= "011001";
		   binary[26] = "011010";
		   binary[27]=  "011011";
		   binary[28] ="011100";
		   binary[29]= "011101";
		   binary[30]= "011110";
		   binary[31]= "011111";		   
		   binary[32] = "100000";
		   binary[33]= "100001";
		   binary[34] = "100010";
		   binary[35]=  "100011";
		   binary[36] = "100100";
		   binary[37]=  "100101";
		   binary[38] = "100110";
		   binary[39]= "100111";
		   binary[40] ="101000";
		   binary[41]= "101001";
		   binary[42] = "101010";
		   binary[43]=  "101011";
		   binary[44] = "101100";
		   binary[45]=  "101101";
		   binary[46]=  "101110"; 
		   binary[47]=  "101111";
		   binary[48] = "110000";
		   binary[49]= "110001";
		   binary[50] ="110010";
		   binary[51]="110011";
		   binary[52]="110100";
		   binary[53]= "110101";
		   binary[54] ="110110";
		   binary[55]="110111";
		   binary[56] ="111000";
		   binary[57]= "111001";
		   binary[58] = "111010";
		   binary[59]="111011";
		   binary[60] ="111100";
		   binary[61]= "111101";
		   binary[62]= "111110";
		   binary[63]= "111111";
		   Random rg = new Random();
		   String binArray[] = new String[num];
		   for(int j=0;j<num;j++){
		    int n = rg.nextInt(64);
		    String x=binary[n];
		    if(x.length()<=5){
		    String y="0";
		    int length=x.length();  
		    while(length<5)
		    {y=y+"0";
		    length++;
		    }
		    x=y+x;
		    }
		    binArray[j] = x;
		    System.out.print(binArray[j]+" , ");
	      }
	      return binArray;
	   }
	   private static Integer[] functionF(String[] binArray){
		   Integer fun[]=new Integer[binArray.length];
		   int[] L=new int[6];
		   for(int i=0;i<binArray.length;i++){
			   int kl=0;
			   String x=binArray[i];   
			   for(int j=0;j<=5;j++)
			   {
				   if(x.substring(j,j+1).equals("0"))
			   		{L[j]=0;}
			       else {L[j]=1;} 
			   }
			   kl=xor(L[0],L[1])+xor(L[1],L[2])+xor(L[2],L[3])+xor(L[3],L[4])+xor(L[4],L[5])+xor(L[5],L[0])+xor(L[1],L[4]);
			   fun[i]=kl;  
			   if(fun[i]==7)   //problem can be solved
			   {
				   System.out.println("Solution: "+binArray[i]);
				   break;
			   }
			   if(fun[i]==null){fun[i]=0;}
			 }
		     return fun;
	   }
}//end of class