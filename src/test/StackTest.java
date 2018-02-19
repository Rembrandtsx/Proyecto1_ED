package test;

import junit.framework.TestCase;
import model.data_structures.Queue;
import model.data_structures.Stack;

public class StackTest extends TestCase{
	

	private Stack<String> pila;

    
    private int size;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Construye una pila  vacia
     * 
     */
    private void setupEscenario1( )
    {
        pila = new Stack<String>();
        size = 0;

    }

    /**
     * Construye una nueva pila con 10 elementos
     * 
     */
    private void setupEscenario2( )
    {
        pila = new Stack<String>();
        size = 10;
        for( int cont = 0; cont < size; cont++ )
        {
            pila.enqueue("text "+ cont);;
        }
    }

   

    /**
     * Prueba add
     * 
     **/
    public void testAgregarCola( )
    {
        setupEscenario1( );
        size = 11;
        
        for( int cont = 0; cont < size; cont++ )
        {
            cola.enqueue("text " + cont);;
        }
        // Verifica que la informaci�n sea correcta
        assertEquals( "La adici�n no se realiz� correctamente", cola.dequeue(), "text 0" );
        

        // Verifica que el tamaño
        assertEquals( "El tamaño de la lista no es el correcto", size-1, cola.getSize() );
    
    }

    /**
     * Prueba Enqueue
     * */
    public void testEnqueue( )
    {
    	setupEscenario1( );
        size = 14;
        for( int cont = 0; cont < size; cont++ )
        {
            cola.enqueue("text "+ cont);
        }
        
        // Verifica que la informaci�n sea correcta
        	assertEquals( "No se borro correctamente", cola.dequeue(), "text 0");
        	assertEquals( "No se borro correctamente", cola.dequeue(), "text 1");
        	assertEquals( "No se borro correctamente", cola.dequeue(), "text 2");
        	assertEquals( "No se borro correctamente", cola.dequeue(), "text 3");
            
            // Verifica que el tamaño
            assertEquals( "El tamaño de la cola no es el correcto", size-4, cola.getSize() );
         

    }

    /**
     * Prueba Dequeue
     * 
    */
    public void testDequeue( )
    {
    	setupEscenario2( );
        size=10;
        // Agrega los pacientes y verifica que se hayan agregado correctamente

    	
    		assertEquals( "El tamaño de la lista no es el correcto", size, cola.getSize() );
        
            // Verifica que la informaci�n sea correcta
        	assertEquals(  "No se obtuvo el elemento indicado", cola.dequeue(), "text 0");
        	assertEquals(  "No se obtuvo el elemento indicado", cola.dequeue(), "text 1");
            
            
            // Verifica que el tamaño
            assertEquals( "El tamaño de la lista no es el correcto", size-2, cola.getSize() );
         

   
    }
    

}
