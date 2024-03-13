import java.lang.*;
class LinkedList1
{
    private class Node
    {
        String value;
        Node next;
        
        Node(String val, Node n)
        {
            value = val;
            next = n;
        }
    
        Node(String val)
        {
            this(val, null);
        }
    }
    private Node first;
    private Node last;
    
    public LinkedList1()
    {
            first = null;
            last = null;
    }
    
    public boolean isEmpty()
    {
        return first == null;
    }
    
    public int size()
    {
        int count = 0;
        Node p = first;
        while(p != null)
        {
            count++;
            p=p.next;
        }
        return count;
    }
    
    public void add(String e)
    {
        if(isEmpty())
        {
            first = new Node(e);
            last = first;
        }
        else
        {
            last.next = new Node(e);
            last = last.next;
        }
    }
    
    public void add(int index, String e)
    {
        if(index < 0 || index > size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }
        
        if(index == 0)
        {
            first = new Node(e, first);
            if(last == null)last = first;
            return;
        }
        
        Node pred = first;
        for(int k=1; k<= index-1; ++k)
        {
            pred = pred.next;
        }
        
        pred.next = new Node(e, pred.next);
        
        if(pred.next.next == null) last = pred.next;
    }
    
    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder();
        
        Node p = first;
        while(p != null)
        {
            strBuilder.append(p.value+"\n");
            p = p.next;
        }
        
        return strBuilder.toString();
    }
    
    public String remove(int index)
    {
        if(index < 0 || index > size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }
        
        String element;
        if(index == 0)
        {
            element = first.value;
            first = first.next;
            if(first == null)last = null;
        }
        else
        {
            Node pred = first;
            for(int k=1; k<= index-1; ++k)
                pred = pred.next;
                
            element = pred.next.value;
            
            pred.next = pred.next.next;
            
            if(pred.next == null)
                last = pred;
            
        }
        
        return element;
    }

    public boolean remove(String element)
    {
        if(isEmpty())
            return false;
            
        if(element.equals(first.value))
        {
            first = first.next;
            if(first == null)
                last = null;
                
            return true;
        }
        
        Node pred = first;
        while(pred.next != null && !pred.next.value.equals(element))
        {
            pred = pred.next;
        }
        
        if(pred.next == null)
            return false;
        
        pred.next = pred.next.next;
        
        if(pred.next == null)
            last = pred;
        
        return true;
        
        
    }
    
    public Node getNode(int index)
    {
        if(index == 0)return first;
        else if(index == size()-1)return last;
        
        Node curr = first;
        
        for(int idx=0; idx<index; ++idx) curr = curr.next;
        
        return curr;
        
    }
    
    // driver function for the recursive sort function
    public void sort()
    {
        recurrSort(this.size());
    }
    
    // sort on the basis of string length of Node->value
    public void recurrSort(int n)
    {
        // Base case
        if (n == 1)
            return;
      
        for (int i=0; i<n-1; i++)
            if (getNode(i).value.length() < getNode(i+1).value.length())
            {
                String temp = getNode(i).value;
                getNode(i).value = getNode(i+1).value;
                getNode(i+1).value = temp;
            }
      
        recurrSort(n-1);
    }
    
    // driver function for the recurrsive reverse function
    public void reverse()
    {
        this.last = this.first;
        recurrRev(this.first);
    }
    
    // reverse the linked list
    public void recurrRev(Node curr)
    {
        if(curr.next == null)
        {
            this.first = curr;
            return;
        }
        
        recurrRev(curr.next);
        
        Node prev = curr.next;
        prev.next = curr;
        curr.next = null;
        
    }
    
    public static void main(String [] args)
    {
        LinkedList1 ll = new LinkedList1();
        ll.add("Aay");
        ll.add("Bob");
        ll.add(0,"Al");
        ll.add("Qwertyuiop");
        ll.add("Beth");
        ll.add("Carlo");
        
        System.out.println("The members of list are:");
        System.out.println(ll);
        
        System.out.println("The members of list After sort:");
        ll.sort();
        System.out.println(ll);
        
        System.out.println("The members of list Reverse:");
        ll.reverse();
        System.out.println(ll);
        
        
        
        
    }
    
}


















