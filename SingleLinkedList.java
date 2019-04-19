package eg.edu.alexu.csd.datastructure.linkedList.cs15_cs36;

public class SingleLinkedList implements ILinkedList{
	
 Node head;
 
 public SingleLinkedList(Node head)
 {
	 this.head=head;
 }
 public SingleLinkedList()
 {
	 
 }
 public int size()
 {
	 Node help=head;
	 int count=0;
	 while(help!=null)
	 {
		 help=help.next;
		 count++;
	 }
	 return count;
 }
 
 public void add(Object element)
 {
		Node n=new Node(element,null);
		Node help=head ;
		if (head==null)
		{
			head=n;
		}
		else
		{
		  while (help.next!=null)
		  {
			help=help.next;
		  }
		   help.next=n;
		}
 }
 
 public void add(int index, Object element)
 {
	 Node help=head;
	 int count=0;
	 if(index==0)
	 {
		 Node New_Node=new Node();
		 New_Node.value=element;
		 New_Node.next=head;
		 head= New_Node;
	 }
	 else if(index==(size()))
	 {
		 add(element);
	 }
	 else if((help!=null)&&(index<size()))
	 {
		 while((help!=null)&&(count<index-1))
		 {
			 help=help.next;
			 count++;
		 }
		 Node New_Node=new Node();
		 New_Node.value=element;
		 New_Node.next=help.next;
		 help.next= New_Node; 
	 }
 }
 
 public Object get(int index)
 {
	 Node help=head;
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
 public void set(int index, Object element)
 {
	Node i=head ;
	int counter=0;
	while (i!=null)
	{
	  if (counter==index)
	  {
		i.value=element;
	  }
		i=i.next;
		counter++;
	}
}
 public void clear()
 {
	 if (size()!=0)
	 {
		 head.next=null;
		head=null; 
	 }
	
	//head.value=null;
	 
 }
 public boolean isEmpty()
 {
	boolean check=false;	
	if (head==null&&size()==0)
	{
	  check=true;
	}	
	return check;
}
 public void remove(int index)
 {
	 Node help=head;
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
			 help.next=help.next.next;
		 } 
	 } 
 }
 
 public SingleLinkedList sublist(int fromIndex, int toIndex)
 {
	SingleLinkedList sub=new SingleLinkedList() ;
	SingleLinkedList list2=new SingleLinkedList() ;
	int counter=0,i=0;
	Object [] list =new Object [size()];
	Node help=head;
	Node temp=head;
	int size= size();
	while(temp!=null) 
	{
	   list[i]=temp.value;
       temp=temp.next;
	   i++;
	}
		
	if (fromIndex==toIndex) 
	{
		return sub;
	}
	while (help!=null)
	{
	  if (fromIndex==counter)
	  {
		sub.head=help;
		break;
	  }
		counter++;
		help=help.next;
	}
	int size2=sub.size();
	for(i=0;i<size-toIndex-1;i++)
	{
		sub.remove(size2-1);
		size2=size2-1;
	}
		
	for (i=0;i<list.length;i++)
	{
		list2.add(list[i]);
	}
	head=list2.head;
	return sub;
}
 
 public boolean contains(Object o)
  {
	boolean check=false;
	Node help=head;
	while (help!=null)
	{
	   if(help.value==o)
	   {
 		 check=true;
 		 break;
	   }
	   help=help.next;
	 }
	return check;
 }
 
}
