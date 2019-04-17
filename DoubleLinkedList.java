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
 public void add(Object element)
 {
	   
     DoubleNode n=new DoubleNode(element,null,null);
     DoubleNode help=head ;
        if (head==null)
        {
            head=n;
            head.previous=null;
            head.next=null;
        }
        else
        {
         while (help.next!=null)
         {
            help=help.next;
         }
         help.next=n;
         n.previous=help;
         n.next=null;
       }
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
public void set(int index, Object element)
{
     
     DoubleNode i=head ;
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
 
 public  DoubleLinkedList sublist(int fromIndex, int toIndex) 
 {
     DoubleLinkedList sub=new DoubleLinkedList();
     DoubleLinkedList list2=new DoubleLinkedList() ;
     int counter=0,i=0;
     Object [] list =new Object [size()];
     DoubleNode help=head;
     DoubleNode temp=head;
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
     DoubleNode help=head;
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
