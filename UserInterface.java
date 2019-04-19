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
				"4- Subtract two polynomials\n"+
				"5- Multiply two polynomials\r\n" + 
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
				scan.nextLine();
				if((64<(int)poly)&&((int)poly<68))
				{
					System.out.println("Insert the polynomial terms in the form:\r\n" + 
							"(coeff1, exponent1), (coeff2, exponent2), ..");
					
					String x=scan.nextLine();
					int counter=0;
					for (int i=0;i<x.length();i++) {
						if (Character.isDigit(x.charAt(i))) {
							counter++;
						}
					}
					
					int rows=counter/2;
					int [][]terms =new int [rows][2];
					for (int i=0;i<rows;i++)
					{
						for (int j=0;j<2;j++)
						{
							for (int k=0;k<x.length();k++)
							{
								if (Character.isDigit(x.charAt(k)))
								{
									terms[i][j]= x.charAt(k) - '0';
									x = x.substring(k+1, x.length());
											break;
							   }
							}
							
						}
					}
	                unit_exam.setPolynomial(poly, terms);
	                System.out.println("Polynomial "+ poly+" is set");
				}
				
			}
			

			else if(num_of_operation==2)
			{
				System.out.println("Insert the variable name: A, B, C or R");
				char poly=scan.next().charAt(0);
				if(((64<(int)poly)&&((int)poly<68))||((int)poly==82))
				{
					System.out.println("Value in"+" "+poly+":"+unit_exam.print(poly));
				}
			}
			else if(num_of_operation==3)
			{
				System.out.println("Insert first operand variable name: A, B or C");
				char poly1=scan.next().charAt(0);
				
				while(unit_exam.print(poly1)=="")
				{
					System.out.println("Variable not set");
					System.out.println("Insert first operand variable name: A, B or C");
				    poly1=scan.next().charAt(0);
				}
				System.out.println("Insert second operand variable name: A, B or C");
				char poly2=scan.next().charAt(0);
				while(unit_exam.print(poly1)=="")
				{
					System.out.println("Variable not set");
					System.out.println("Insert second operand variable name: A, B or C");
				    poly2=scan.next().charAt(0);
				}
				
				int [][]temp=unit_exam.add(poly1, poly2);
				unit_exam.setPolynomial('R', temp);
				System.out.println("Result set in R: ");
				for(int i=0;i<temp.length;i++)
				{
					System.out.print("("+temp[i][0]+", "+temp[i][0]+")");
				}
				System.out.println();
			}
			else if(num_of_operation==6)
			{
				System.out.println("Insert the variable name: A, B, C or R");
				char poly=scan.next().charAt(0);
				while(unit_exam.print(poly)=="")
				{
					System.out.println("Variable not set");
					System.out.println("Insert first operand variable name: A, B or C");
				    poly=scan.next().charAt(0);
				}
				System.out.println("Insert the  float value");
				float value=scan.nextFloat();
				float x=unit_exam.evaluatePolynomial(poly, value);
				System.out.println("Result set in "+poly+"="+x);
			}
			else if(num_of_operation==7)
			{
				System.out.println("Insert the variable name: A, B, C or R");
				
			}
			System.out.println("====================================================================");
			System.out.println("Please choose an action\r\n" + 
					"1- Set a polynomial variable, ... etc\r\n" + 
					"====================================================================");
			num_of_operation=scan.nextInt();
		}
		
			
			
		
	}

}
