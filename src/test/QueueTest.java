package test;


import junit.framework.TestCase;
import model.data_structures.Queue;



public class QueueTest extends TestCase{

	
	private Queue<String> cola;

    
    private int size;

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Construye una cola  vacia
     * 
     */
    private void setupEscenario1( )
    {
        cola = new Queue<String>();
        size = 0;

    }

    /**
     * Construye una nueva cola con 10 elementos
     * 
     */
    private void setupEscenario2( )
    {
        cola = new Queue<String>();
        size = 10;
        for( int cont = 0; cont < size; cont++ )
        {
            cola.enqueue("text "+ cont);;
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
        	assertEquals( "No se obtuvo correctamente", cola.dequeue(), "text 0");
        	assertEquals( "No se obtuvo correctamente", cola.dequeue(), "text 1");
        	assertEquals( "No se obtuvo correctamente", cola.dequeue(), "text 2");
        	assertEquals( "No se obtuvo correctamente", cola.dequeue(), "text 3");
            
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
    public void testIsEmpty( )
    {
    	setupEscenario1( );
       assertTrue( "Incorrecto la lista debe estar vacia", cola.isEmpty());
        
      assertEquals( "El tamaño de la lista no es el correcto", size, cola.getSize() );
         

   
    }
    
}
