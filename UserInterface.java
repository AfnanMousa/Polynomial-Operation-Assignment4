package eg.edu.alexu.csd.datastructure.linkedList.cs15_cs36;

import java.util.Scanner;

public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please choose an action");
		System.out.println("-----------------------");
		System.out.println("1- Set a polynomial variable\r\n" + 
				"2- Print the value of a polynomial variable\r\n" + 
				"3- Add two polynomials\r\n" + 
				"4- Subtract two polynomials"+"5- Multiply two polynomials\r\n" + 
						"6- Evaluate a polynomial at some point\r\n" + 
						"7- Clear a polynomial variable");
		System.out.println("====================================================================");
		Scanner scan=new Scanner(System.in);
		int num_of_operation=scan.nextInt();
		while((0<num_of_operation)&&(num_of_operation<8))
		{
			IPolynomialSolver unit_exam=new OperationOnPolynomial();	
			if(num_of_operation==1)
			{
				System.out.println("Insert the variable name: A, B or C");
				char poly=scan.next().charAt(0);
				if((64<(int)poly)&&((int)poly<68))
				{
					System.out.println("Insert the polynomial terms in the form:\r\n" + 
							"(coeff1, exponent1), (coeff2, exponent2), ..");
					String x=scan.next();
					String[] prime=x.split("),");
					int [][]terms=new int [prime.length][2];
	                for(int i=0;i<prime.length-1;i++)
	                {
	                	String temp=prime[i].replace('(', ' ');
	                	String temp2=prime[i+1].replace(')', ' ');
	                	char []help2=temp2.toCharArray();
	                	char []help=temp.toCharArray();
	                	//int result = Integer.parseInt(help[1]);	
	                	terms[i][0] = Integer.valueOf(help[1]);	
	                	terms[i+1][1] = Integer.valueOf(help2[0]);
	                	
	                }
	                unit_exam.setPolynomial(poly, terms);
	                System.out.println("Polynomial"+ poly+"is set");
				}
				
			}
		}
		
			
			
		//
	    // int[][] terms={{1,0}};
	     //int[][] terms2={{1,3},{7,4},{5,5},{9,1},{2,0}};
	 	//u.setPolynomial('A',terms );
	 	//u.setPolynomial('B',terms2);
	}

}
