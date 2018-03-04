package model.data_structures;



public class LinkedSimpleList<T extends Comparable<T>> implements LinkedList<T>{

	private SimpleNode<T> first;
	private SimpleNode<T> actual;
	private SimpleNode<T> lastNode;
	private int size;
	
	public LinkedSimpleList() {
		// TODO Auto-generated constructor stub
		first=null;
		actual=null;
		lastNode=null;
		size=0;
	}
	
	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		
		
		if(element==null){
			throw new NullPointerException();
		}
		
		if(first==null){
			first= new SimpleNode<T>(element);
			lastNode= first;
			size++;
			
		}
		else{
			lastNode.modifyNext(new SimpleNode<T>(element));
			lastNode= lastNode.getNext();
			size++;
			
		}
		
	}

	@Override
	public boolean delete(T element) {
		// TODO Auto-generated method stub
		
		
		if(first!=null&&first.getElement()!=null&&first.getElement().compareTo(element)==0){
			
			if(first.getNext()!=null){
				SimpleNode<T> next=first.getNext();
				first=next;
			}
			else{
				first=null;
			}
			this.size--;
			
				return true;
		}
		else{
			
			actual=first;
			
			while(actual!=null){
				
					if(actual.getNext()!=null&&actual.getNext().getElement().compareTo(element)==0){
						
						SimpleNode<T> next= actual.getNext();
						actual.modifyNext(next);
						this.size--;
						return true;
					}
					
				else{
					next();
				}
				
			}
			return false;
		}
		
	}

	@Override
	public T get(T element) {
		// TODO Auto-generated method stub
		if(first!=null){
			
			actual=first;
			while(actual!=null){
				if(actual.getElement()!=null&&actual.getElement().compareTo(element)==0){
					return actual.getElement();
				}
				next();
			}
		}
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public T get(int position) {
		// TODO Auto-generated method stub
		int count=0;
		if(first!=null){
			
			actual=first;
			while(actual!=null){
				if(count==position){
					return actual.getElement();
				}
				else{
					count++;
					next();
				}
			}
		}
		
		return null;
	}
	public void addAList(LinkedSimpleList<T> list){
			
		if(list.size()==0) {return;}else {
		this.getCurrentNode().modifyNext(list.getFirst());
		lastNode = list.getCurrentNode();
		}
		
		
		
	}
	

	@Override
	public T[] listing(T[] list) {
		// TODO Auto-generated method stub
		int count=0;
		actual=first;
		
		while(actual!=null){
			list[count]=this.actual.getElement();
			count++;
			this.next();
			System.out.println(count);
		}
			return list;
			
	}
	public SimpleNode<T> getCurrentNode() {
		// TODO Auto-generated method stub
		if(actual!=null){
		return actual;}
		else{
			return null;
		}
	}
	public SimpleNode<T> getFirst(){
		return first;
	}

	@Override
	public T getCurrent() {
		// TODO Auto-generated method stub
		if(actual!=null){
		return this.actual.getElement();}
		else{
			return null;
		}
	}


	@Override
	public T next() {
		// TODO Auto-generated method stub
		actual= actual.getNext();
		
		if(actual!=null){
			return actual.getElement();
		}
		else
			return null;
	}
	

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(actual==null){
			
			return false;
		}
		else{
			boolean rta=false;
			if(actual.getNext()!=null){
				rta=false;
			}
			return rta;
		}
	}
	public void setFirst(SimpleNode<T> pfirst)
	{
		first= pfirst;
	}
	public void setSize(int pSize)
	{
		size=pSize;
	}
	
	public void setLast(SimpleNode<T> pLast)
	{
		lastNode= pLast;
	}
	
	public SimpleNode<T> removeFirst()
	{
		SimpleNode<T> oldFirst=first;
		first=first.getNext();
		oldFirst.modifyNext(null);
		return oldFirst;
	}
	public SimpleNode<T> getNode(int pos){
		int count=0;
		if(first!=null){
			
			actual=first;
			while(actual!=null){
				if(count==pos){
					return actual;
				}
				else{
					count++;
					next();
				}
			}
		}
		
		return null;
		
	}
	
	public LinkedSimpleList<T> mergesort(LinkedSimpleList<T> lista)
	{
		int low=0;
		int high= lista.size()-1;
		LinkedSimpleList<T> left;
		LinkedSimpleList<T> right = new LinkedSimpleList<T>();
		LinkedSimpleList<T> result= new LinkedSimpleList<T>();
		int middle= lista.size()/2;
		SimpleNode<T> NodeMiddle = (SimpleNode<T>) lista.getNode(middle);
		SimpleNode<T> NodeMiddleP1 = (SimpleNode<T>) lista.getNode(middle+1);
		if(lista.size()<=1)
		{
			return lista;
		}
		else 
		{
			right=new LinkedSimpleList<T>();
			right.setFirst(NodeMiddleP1);
			right.setLast(lista.getLast());
			NodeMiddle.modifyNext(null);
			left=lista;
			left.setLast(NodeMiddle);
			right.setSize(lista.size()-middle);
			left.setSize(middle);
			left= mergesort(left);
			right= mergesort(right);
			SimpleNode<T> n = merge(left,right);
			result.setFirst(n);
			return result;
		}
			
			
		
	}

	private SimpleNode<T> getLast() {
		// TODO Auto-generated method stub
		return lastNode;
	}

	public SimpleNode<T> merge(LinkedSimpleList<T> left, LinkedSimpleList<T> right)
	{
		LinkedSimpleList<T> result = new LinkedSimpleList<T>();
		while(left.size()>0 && right.size()>0)
		{
			if (left.getFirst().getElement().compareTo(right.getFirst().getElement())==-1||left.getFirst().getElement().compareTo(right.getFirst().getElement())==0)
			{
				result.add(left.removeFirst().getElement());
			}
			else
				result.add(right.removeFirst().getElement());
		}
		return result.getFirst();
	}
	

	

}
