package model.data_structures;



public class LinkedSimpleList<T extends Comparable<T>> implements LinkedList<T>{

	private SimpleNode<T> first;
	private SimpleNode<T> actual;
	private int size;
	
	public LinkedSimpleList() {
		// TODO Auto-generated constructor stub
		first=null;
		actual=null;
		size=0;
	}
	
	@Override
	public void add(T element) {
		// TODO Auto-generated method stub
		
		
		if(element==null){
			throw new NullPointerException();
		}
		boolean respuesta=false;
		if(first!=null){
			actual=first;
			while(actual!=null&&respuesta==false){
				
				if(actual.getNext()==null){
					actual.modifyNext(new SimpleNode<T>(element));
					respuesta=true;
					size++;
				}
				this.next();
				
			}
		}
		else{
			first= new SimpleNode<T>(element);
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

}