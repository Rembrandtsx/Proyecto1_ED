package model.logic.utils;

import model.data_structures.SimpleNode;

public class Ordenamiento <T extends Comparable<T>>{

	
	     
	   
	 
	    public SimpleNode<T> mergeSort(SimpleNode<T> pNodo) 
	    {
	        SimpleNode<T> sortedlist = null;
	        return sortedlist;
	    }
	 
	    public SimpleNode<T> getMiddle(SimpleNode<T> pNodo) 
	    {
	        
	        SimpleNode<T>  slowptr = null;
	         
	        
	        return slowptr;
	    }
	    public SimpleNode<T> sortedMerge(SimpleNode<T> primero, SimpleNode<T> segundo) 
	    {
	    	SimpleNode<T> result = null;

	    	if (primero == null)
	            return segundo;
	        if (segundo == null)
	            return primero;
	 
	        if (primero.getElement().compareTo(segundo.getElement()) ==-1) 
	        {
	            result = primero;
	            result.modifyNext(sortedMerge(primero.getNext(), segundo));
	        } 
	        else
	        {
	            result = segundo;
	            result.modifyNext(sortedMerge(primero, segundo.getNext()));
	        }
	        return result;
	 
	    }
	 
	 
	    
	
}
