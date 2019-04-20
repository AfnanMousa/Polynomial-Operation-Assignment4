package eg.edu.alexu.csd.datastructure.linkedList.cs15_cs36;

public class OperationOnPolynomial implements IPolynomialSolver {
public static int zerozero=0;
public static SingleLinkedList A=new SingleLinkedList();
public static SingleLinkedList B=new SingleLinkedList();
public static SingleLinkedList C=new SingleLinkedList();
public static SingleLinkedList R=new SingleLinkedList();
public  void setPolynomial(char poly, int[][] terms)
{
    int found=0;
    int [] temp=new int[2];
    for (int i=1;i<terms.length;i++)
    {
        for (int j=0;j<terms.length;j++)
        {
            if (terms[i][1]>terms[j][1])
            {
                temp=terms[i];
                terms[i]=terms[j];
                terms[j]=temp;
            }
        }
    }
    SingleLinkedList polyL=new SingleLinkedList();
    if (poly=='A')
    {
        found=1;   
    }
    else if (poly=='B')
    {
        found=2;
    }
    else if (poly=='C')
    {
        found=3;
    }
    else if (poly=='R')
    {
        found=4;
    }
    if (terms.length==1&&terms[0][0]==0&&terms[0][1]==0) {
        polyL.add(terms[0]);
        zerozero=1;
    }
    for (int i=0;i<terms.length;i++)
    {
        if (terms [i][0]!=0)
        {
         polyL.add(terms[i]);
        }
    }
    if (found==1)
    {
        A=polyL;
    }
    else if (found==2)
    {
        B=polyL;
    }
    else if(found==3)
    {
        C=polyL;
    }
    else if(found==4)
    {
        R=polyL;
    }
}
public  String print(char poly)
{
	int found=0;
	SingleLinkedList help=new SingleLinkedList();
	if((poly=='A')||(poly=='B')||(poly=='C')||(poly=='R'))
	{
		if(poly=='A')
		{
			help=A;
		}
		else if(poly=='B')
		{
			help=B;
		}
		else if(poly=='C')
		{
			help=C;
		}
		else
		{
			help=R;
		}
	}
	String equation="";
	if(!help.isEmpty())
	{
		for(int i=0;i<help.size();i++)
		{
			int[] temp=(int[]) help.get(i);
			if(temp[1]!=0)
			{
				String be=Integer.toString(temp[0])+"X^"+Integer.toString(temp[1]);
				equation=equation+be+'+';
			}
			else
			{
				String be=Integer.toString(temp[0]);	
				equation=equation+be;
				found=1;
			}
			
		}
		if (found==0) {
			equation = equation.substring(0, equation.length() - 1);
		}
	}
	else {
		equation="Variable not set";
	}
	if(equation.equals("0"))
	{
		equation="";
	}
	return equation;
}
public  void clearPolynomial(char poly) 
{
	SingleLinkedList polyL=new SingleLinkedList();
	int found=0;
	if (poly=='A') 
	{
		polyL=A;
		found=1;
		
	}
	else if (poly=='B')
	{
		polyL=B;
		found=2;
	}
	else if (poly=='C')
	{
		polyL=C;
		found=3;
	}
	polyL.clear();
	if (found==1) 
	{
		A=polyL;
	}
	else if (found==2)
	{
		B=polyL;
	}
	else if(found==3) 
	{
		C=polyL;
	}
}
 public  float evaluatePolynomial(char poly, float value)
{
	 SingleLinkedList help=new SingleLinkedList();
	 if((poly=='A')||(poly=='B')||(poly=='C')||(poly=='R'))
		{
			if(poly=='A')
			{
				help=A;
			}
			else if(poly=='B')
			{
				help=B;
			}
			else if(poly=='C') 
			{
				help=C;
			}
			else
			{
				help=R;
			}
		}
	 float result=0;
	 if(!help.isEmpty())
	 {
		 for(int i=0;i<help.size();i++)
		 {
			 int[]temp=(int[]) help.get(i);
			 result=(float) (result+(temp[0]*(Math.pow(value, temp[1]))));
		 }
	 }
	 else
	 {
		 System.out.println("Variable not set"); 
	 }
	 return result;
}
 public int[][] subtract(char poly1, char poly2)
 {
	 SingleLinkedList help1=new SingleLinkedList();
	 SingleLinkedList help2=new SingleLinkedList();
		if((poly1=='A')||(poly1=='B')||(poly1=='C'))
		{
			if(poly1=='A')
			{
				help1=A;
			}
			else if(poly1=='B')
			{
				help1=B;
			}
			else 
			{
				help1=C;
			}	
		}
		if((poly2=='A')||(poly2=='B')||(poly2=='C'))
		{
			if(poly2=='A')
			{
				help2=A;
			}
			else if(poly2=='B')
			{
				help2=B;
			}
			else 
			{
				help2=C;
			}	
		}
		SingleLinkedList exponents=new SingleLinkedList();
		SingleLinkedList coefficients=new SingleLinkedList();
		SingleLinkedList final_terms=new SingleLinkedList();
		if((help1.size()!=0)&&((help2.size()!=0)||(help2.size()==0)))
		{
			for(int i=0;i<help1.size();i++)
			{
				int found=0;
				int []temp=(int[]) help1.get(i);
				for(int j=0;j<help2.size();j++)
				{
					int []help_temp=(int[]) help2.get(j);
					if(temp[1]==help_temp[1])
					{
						found=1;
						int sub=temp[0]-help_temp[0];
						if(sub!=0)
						{
							int [] help_to_sub={sub,temp[1]};
							coefficients.add(help_to_sub);	
						}
						exponents.add(help2.get(j));
						break;
					}
				}
				if(found==0)
				{
					if(temp[0]!=0)
					{
						coefficients.add(temp);
					}
						 
				}
			}		
			for(int z=0;z<help2.size();z++)
			{
				int count=0;
				for(int r=0;r<exponents.size();r++)
				{
					int []please_help=(int[]) help2.get(z);
					int []please_help1=(int[])exponents.get(r);
					if((please_help[0]!=please_help1[0])&&(please_help[1]!=please_help1[1]))
					{
						count++;
					}
				}
				if(count==exponents.size())
				{
					int []please_help=(int[]) help2.get(z);
					if(please_help[0]!=0)
					{
						final_terms.add(help2.get(z));
					}
				}
			}
		}
		int [][] sub_result1=new int [help2.size()][2];
		if((help1.size()==0))
		{
			for(int u=0;u<help2.size();u++)
			{
				int[] s=(int[]) help2.get(u);
				sub_result1[u][0]=-s[0];
				sub_result1[u][1]=s[1];
			}
			return sub_result1;	
		}
		/*if(coefficients.size()==0)
		{
			int [][] sub_result2= {{0,0}};
			return sub_result2 ;
		}*/
		if((final_terms.size()==0)&&(coefficients.size()==0))
		{
			int[][]term={{0,0}};
			return term;
		}
		 int [][] sub_result=new int [final_terms.size()+coefficients.size()][2];
		  for(int t=0;t<coefficients.size();t++)
		  {
			  int[] s=(int[]) coefficients.get(t);
			  
			  sub_result[t][0]=s[0];
			  sub_result[t][1]=s[1]; 
		  }
		  for(int t=0;t<Math.abs(final_terms.size());t++)
		  {
			  int[] s=(int[]) final_terms.get(t);
			  sub_result[coefficients.size()+t][0]=-s[0];
			  sub_result[coefficients.size()+t][1]=s[1];  
			 
		  }
		  int [] temp=new int[2];
		  for (int i=1;i<sub_result.length;i++)
			{
				for (int j=0;j<sub_result.length;j++)
				{
					if (sub_result[i][1]>=sub_result[j][1])
					{
						temp=sub_result[i];
						sub_result[i]=sub_result[j];
						sub_result[j]=temp;
					}
				}
			}
		  return sub_result;
		
 }
 public int[][] add(char poly1, char poly2){
	 int found =0;
	 SingleLinkedList help=new SingleLinkedList();
	 SingleLinkedList help1=new SingleLinkedList();
	 SingleLinkedList help2=new SingleLinkedList();
	 if (poly1=='A') {
		 help1=A;
	 }if (poly1=='B') {
		 help1=B;
	 }if (poly1=='C') {
		 help1=C;
	 }
	 if (poly2=='A') {
		 help2=A;
	 }if (poly2=='B') {
		 help2=B;
	 }if (poly2=='C') {
		 help2=C;
	 }
	 
	 int size=help1.size()+help2.size();
	 int count=0;
	 int k=0;
	 int p1 [][]=new int [help1.size()][2];
	 int p2 [][]=new int[help2.size()][2];
	 
	 for (int i=0;i<help1.size();i++) {
		  p1[i]=(int[]) help1.get(i);
	 }
	 for (int i=0;i<help2.size();i++) {
		  p2[i]=(int[]) help2.get(i);
	 }
	 int sum [][]=new int[size][2];
	 for (int i=0,j=0;i<size&&j<size;i++,j++) {
		 if (i<help1.size()&&j<help2.size()){ 
		 if (p1[i][1]==p2[j][1]) {
			 sum [k][0]=p1[i][0]+p2[j][0];
			 sum [k][1]=p1 [i][1];
			 k++;
		 }else {
			 if (p1[i][1]>=p2[j][1]) {
			 sum [k][0]=p1[i][0];
			 sum [k][1]=p1 [i][1];
			 j--;
			 k++;
			 }
			 else if (p1[i][1]<p2[j][1]) {
				 sum [k][0]=p2[j][0];
				 sum [k][1]=p2 [j][1];
				 i--;
				 k++;
			 }
		 }}
		 else if (i>=help1.size()&&j<help2.size()) {
			 sum [k][0]=p2[j][0];
			 sum [k][1]=p2[j][1];
			 k++;
		 }else if (i<help1.size()&&j>=help2.size()) {
			 sum [k][0]=p1[i][0];
			 sum [k][1]=p1[i][1];
			 k++;
		 }else {
			 break;
		 }
	 }	 
	 for (int i=0;i<sum.length;i++) {
		 if (sum[i][0]!=0) {
		 help.add(sum[i]);}
	 }
	 int sumf [][]=new int[help.size()][2];
	 for (int i=0;i<help.size();i++) {
		 sumf[i]=(int[])help.get(i);
	 }
	 return sumf;
 }
 public static int max (int Parr[][]) {
     int m=-1000000000;
     for (int i=0;i<Parr.length;i++) {
         if (Parr[i][1]>m) {
             m=Parr[i][1];
         }
     }
     return m;
 }
 public  int[][] multiply(char poly1, char poly2){ 
     
     SingleLinkedList help1=new SingleLinkedList();
     SingleLinkedList help2=new SingleLinkedList();
     if (poly1=='A') {
         help1=A;
     }if (poly1=='B') {
         help1=B;
     }if (poly1=='C') {
         help1=C;
     }
     if (poly2=='A') {
         help2=A;
     }if (poly2=='B') {
         help2=B;
     }if (poly2=='C') {
         help2=C;
     }
     int zero[][]=new int[1][2];
     if (zerozero==1) {
         return zero;    
     }
     int p1 [][]=new int [help1.size()][2];
     int p2 [][]=new int[help2.size()][2];
     for (int i=0;i<help1.size();i++) {
          p1[i]=(int[]) help1.get(i);
     }
     
     for (int i=0;i<help2.size();i++) {
          p2[i]=(int[]) help2.get(i);
     }
     int max=max(p1)+max(p2);
     int []power=new int [max+1];
     int index;
     for (int i=0;i<help1.size();i++) {
         for (int j=0;j<help2.size();j++) {
             index= p1[i][1]+p2[j][1];
             power[index]=power[index]+p1[i][0]*p2[j][0];            
         }   
     }
     int [][]product =new int [max+1][2];
     for (int i=0,j=max;i<max+1&&j>-1;i++,j--) {
         if (power[j]!=0) {
             product[i][0]=power[j];
             product[i][1]=j;
         }
     }
     SingleLinkedList help=new SingleLinkedList();
     for (int i=0;i<product.length;i++) {
         if (product[i][0]!=0) {
             help.add(product[i]);
         }
     }
     int [][]productf =new int [help.size()][2];
     for (int i=0;i<help.size();i++) {
         productf[i]=(int[])help.get(i);
     }
     return productf;
 }
}
