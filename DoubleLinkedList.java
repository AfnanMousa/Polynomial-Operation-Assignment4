package eg.edu.alexu.csd.datastructure.linkedList.cs15_cs36;

public class DoubleLinkedList {
	DoubleNode head;
 public DoubleLinkedList (DoubleNode head)
 {
	 this.head=head;
 }
 public DoubleLinkedList ()
 {
	 
 }
 public int size()
 {
	 DoubleNode help=head;
	 int count=0;
	 while(help!=null)
	 {
		 help=help.next;
		 count++;
	 }
	 return count;
 }
 public void add(int index, Object element)
 {
	 DoubleNode help=head;
	 int count=0;
	 if(index==0)
	 {
		 DoubleNode New_Node=new DoubleNode();
		 New_Node.value=element;
		 New_Node.next=head;
		 head= New_Node;
	 }
	/* else if(index==(size()))
	 {
		 add(element);
	 }*/
	 else if((help!=null)&&(index<size()))
	 {
		 while((help!=null)&&(count<index-1))
		 {
			 help=help.next;
			 count++;
		 }
		 DoubleNode New_Node=new DoubleNode();
		 DoubleNode temp=new DoubleNode();
		 temp=help.next;
		 New_Node.value=element;  
		 New_Node.previous=help;
		 help.next=New_Node;
		 New_Node.next=temp;
		 temp.previous=New_Node;
		 
		 
		
	 }
 }
 public Object get(int index)
 {
	 DoubleNode help=head;
	 int count=0;
	 while((index<size())&&(help!=null))
	 {
		 if(count==index)
		 {
			break;
		 }
		 else
		 {
			 help=help.next;
			 count++;
		 }
		
	 }
	 return help.value;
 }
 public void remove(int index)
 {
	 DoubleNode help=head;
	 int count=0;
	 int found=0;
	 if((size()==1)||(index==0))
	 {
		 head=head.next;
	 }
	 else
	 {
		 while((index<size())&&(help.next!=null))
		 {
			 if(count==(index-1))
			 {
				 found=1;
				 break;
			 }
			 else
			 {
				 help=help.next;
				 count++;
			 }
		 }
		 if(found==1)
		 {
			 DoubleNode temp=help.next.next;
			 help.next=temp;
			 
		 } 
	 } 
 }
 
 public void clear()
 {
	head.next=null;
	head=null;
	//head.value=null;
	 
 }
}
