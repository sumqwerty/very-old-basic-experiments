/**
 * 
 * Assessment: Lab 3 Implementing a Deque using LinkedList
 */
package datastructure.deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListDeque<E> extends AbstractDeque<E> {
	
	//declaration of node for head, tail and size
	private Node head;
	private Node tail;
	private int size;
	
	
	private class Node {
		private E value;
		private Node next;
		private Node prev;
		
		private Node(E value) {
			this.value = value;
		}
		
		private Node(Node next, Node prev) {
			this.next = next;
			this.prev = prev;
		}
		
		private Node(E value, Node next, Node prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
		
		@Override
		public String toString() {	
			return String.valueOf(value);
		}
	}

	@Override
	public boolean offerFirst(E e) {
		//TODO IMPLEMENT THE METHOD

	@Override
	public boolean offerLast(E e) {
		//TODO IMPLEMENT THE METHOD
	}

	@Override
	public E pollFirst() {	
		//TODO IMPLEMENT THE METHOD
	}

	@Override
	public E pollLast() {
		//TODO IMPLEMENT THE METHOD	
	}

	@Override
	public E peekFirst() {
		//TODO IMPLEMENT THE METHOD
	}

	@Override
	public E peekLast() {
		//TODO IMPLEMENT THE METHOD
	}

	@Override
	public boolean removeFirstOccurrence(Object o) {	
        Node currentNode = head; 
        if (isEmpty()) {	//If list is empty, return false
            return false;
        }
        while(currentNode!= null && !currentNode.value.equals(o)){ //While currentNode is not null and value does not match Object o
            currentNode = currentNode.next;	//currentNode go to next
        }
        if(currentNode == null) {	//If the currentNode is null, it returns false
        	return false;
        }
        else if(currentNode.value.equals(o)){	//If the currentNode value matches Object o
        	removeGivenNode(currentNode);	//Remove the current node
        	size--; //Decrease size
            return true;
        }
        return false;
    }
	
	@Override
	public boolean removeLastOccurrence(Object o) {
        Node currentNode = tail;    
		if (isEmpty()) {	//If list is empty, return false
            return false;
        }
        while(currentNode!= null && !currentNode.value.equals(o)){ //While currentNode is not null and value does not match Object o
            currentNode = currentNode.prev; //currentNode go to previous
        }
        if(currentNode == null){	//If the currentNode is null, it returns false
            return false;
        }
        else if(currentNode.value.equals(o)){	//If the currentNode value matches Object o    
        	removeGivenNode(currentNode); 	//Remove the current node
            size--; //Decrease size
            return true;
        }
        return false;    
	}

	@Override
	public boolean contains(Object o) {
		Node currentNode = head;
		if(isEmpty()) {		//If list is empty, return false
			return false;
		}
		while(currentNode != null && !currentNode.value.equals(o)) { //While currentNode is not null and value does not match Object o
			currentNode = currentNode.next;	//currentNode go to next
		}
		if(currentNode.value.equals(o)) {	//If the currentNode value match Object o
            return true;	//Return true
		}
		return false;
	}

	@Override
	public int size() {
		//TODO IMPLEMENT THE METHOD
	}

	@Override
	public boolean isEmpty() {
		//TODO IMPLEMENT THE METHOD
	}

	@Override
	public void clear() {
		//TODO IMPLEMENT THE METHOD
	}
	
	
	
	private void removeGivenNode(Node node) {
		if(head == node) {		//If the node is the head, head becomes next node
			head = node.next;
		}
		if(tail == node) {		//If the node is the tail, tail becomes previous node
			tail = node.prev;
		}
		if(node.next != null) {		//If next node is not null, next previous node becomes previous node
			node.next.prev = node.prev;
		}
		if(node.prev != null) {		//If previous node is not null, previous next node becomes next node
			node.prev.next = node.next;
		}
	}
	

    }





