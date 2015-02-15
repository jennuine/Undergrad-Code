package database;

import database.values.Value;
import one.AllExceptions;

import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTree<T extends Value> implements Iterable<T> {
	private Node<T> root;
	
	public BinarySearchTree()
	{
		root = null;
	}
	
	public Node<T> select(T searchVal, Node<T> node)
	{
		if (node == null)
			return null;
		else if (searchVal.compareTo(node.data) == 0)
			return node;
		else if (searchVal.compareTo(node.data) > 0)
			return select(searchVal, node.right);
		else
			return select(searchVal, node.left);
	}

	public Node<T> max(Node<T> node)
	{
		if (node.right == null)
			return node;
		
		return max(node.right);
	}
	
	public Node<T> min(Node<T> node)
	{
		if (node.left == null)
			return node;
		
		return min(node.left);
	}
	
	public void inOrderWalk()
	{
		inOrderWalk(root);
	}
	
	public void inOrderWalk(Node<T> node)
	{
		if (node != null)
		{
			inOrderWalk(node.left);
			System.out.println(node);
			inOrderWalk(node.right);
		}	
	}
	
	public void reverseWalk()
	{
		reverseWalk(root);
	}
	
	public void reverseWalk(Node<T> node)
	{
		if (node != null)
		{
			reverseWalk(node.right);
			System.out.println(node);
			reverseWalk(node.left);
		}	
	}
	
	public Node<T> successor(Node<T> node)
	{
		if (node == null)
			return null;

		if (node.right != null)
			return min(node.right);
		
		Node<T> curr = node.parent;
		
		while ((curr != null) && (node == curr.left))
		{
			node = curr;
			curr = curr.parent;
		}
		return curr;
	}

	public Node<T> predecessor(Node<T> node)
	{
		if (node == null)
			return null;
		
		if (node.left != null)
			return max(node.left);
		
		Node<T> curr = node.parent;
		
		while ((curr != null) && (node == curr.left))
		{
			node = curr;
			curr = curr.parent;
		}
		
		return curr;
	}
	
	public void remove(T data) throws AllExceptions
	{
		root = remove(data, root);
	}
	
	public Node<T> remove(T data, Node<T> node) throws AllExceptions
	{
		if (node == null)
			throw new AllExceptions("ERROR: Could not delete because data was not found");
		
		if (data.compareTo(node.data) < 0)
			node.left = remove(data, node.left);
		else if (data.compareTo(node.data) > 0)
			node.right = remove(data, node.right);
		else
		{
			if (node.left == null)
				return node.right;
			else if (node.right == null)
				return node.left;
			else
			{
				while (node.right != null)
					node = node.right;
				
				node.left = remove(node.data, node.left);
			}
		}
		return node;
	}
	
	public void insert(T insertData, long filePos)
	{
		root = insert(insertData, root, filePos);
	}
	
	private Node<T> insert(T insertData, Node<T> node, long filePos)
	{	
		if (node == null)
			return new Node(insertData, filePos);
		
		if (insertData.compareTo(node.data) <= 0) 
		{
			node.left = insert(insertData, node.left, filePos);
			node.left.parent = node;
		}
		else 
		{
			node.right = insert(insertData, node.right, filePos);
			node.right.parent = node;
		}
		return node;
	}
	

	public String toString()
	{
		StringBuffer str = new StringBuffer();
		
		for (T data : this)
			str.append(data.toString());
		
		return str.toString();
	}
	
	public long getFilePos(T val)
	{
		return select(val, root).pos;
	}
	
	public long getParentFilePos(T val)
	{
		Node<T> curr = select(val, root);
		
		if (curr.parent != null)
			return curr.parent.pos;
		
		return 0;
	}
	
	public long getLeft(T val)
	{
		Node<T> curr = select(val, root);
		
		if (curr.left != null)
			return curr.left.pos;
		
		return 0;
	}
	
	public long getRight(T val)
	{
		Node<T> curr = select(val, root);
		
		if (curr.right != null)
			return curr.right.pos;
		
		return 0;
	}
	
	public Node<T> get(T val)
	{
		return select(val, root);
	}
	
	public void set(T val, long currFilePos, long filePos)
	{
		Node<T> node = get(val);
		
		if (currFilePos == 0)
			node.pos = filePos;
		else if (currFilePos < 16)
			node.parent.pos = filePos;
		else if (currFilePos < 24)
			node.left.pos = filePos;
		else if (currFilePos < 32)
			node.right.pos = filePos;
	}
	
	private class Node<T>
	{
		private T data;
		private Node<T> parent;
		private Node<T> left;
		private Node<T> right;
		private long pos;
		
		public Node(T data, Node<T> parent, Node<T> left, Node<T> right, long pos)
		{
			this.data = data;
			this.parent = parent;
			this.left = left;
			this.right = right;
			this.pos = pos;
		}
		
		public Node(T data, long filePos)
		{
			this(data, null, null, null, filePos);
		}
		
		public String toString()
		{
			return data.toString();
		}
	}
	
	@Override
	public Iterator<T> iterator() 
	{
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<T> 
	{
		Stack<Node<T>> stack = new Stack<Node<T>>();
		
		public MyIterator()
		{
			if (root != null)
				stack.push(root);
		}
		
		@Override
		public boolean hasNext() 
		{
			return !stack.isEmpty();
		}

		@Override
		public T next() 
		{
			Node<T> curr = stack.peek();
			
			if (curr.left != null)
				stack.push(curr.left);
			else
			{
				Node<T> temp = stack.pop();
				
				while(temp.right == null)
				{
					if (stack.isEmpty())
						return curr.data;
					
					temp = stack.pop();
				}
				stack.push(temp.right);
			}
			
			return curr.data;
		}
	
		@Override
		public void remove() 
		{
			// TODO Auto-generated method stub
			
		}
	
	}
}
