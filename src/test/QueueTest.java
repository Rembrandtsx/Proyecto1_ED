package test;


import junit.framework.TestCase;
import model.data_structures.LinkedSimpleList;
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
    public void testAgregarLista( )
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
        assertEquals( "El tamaño de la lista no es el correcto", size, cola.getSize() );
    
    }

    /**
     * Prueba delete
     * */
    public void testDelete( )
    {
    	setupEscenario1( );
        size = 11;
        for( int cont = 0; cont < size; cont++ )
        {
            lista.add( "text "+ cont );
        }
        // Agrega los pacientes y verifica que se hayan agregado correctamente

        lista.delete("text 4");
        lista.delete("text 7");
            // Verifica que la informaci�n sea correcta
            assertTrue( "No se borro correctamente", lista.get("text 4")!=null);
            assertTrue( "No se borro correctamente", lista.get("text 7")!=null);
            assertTrue( "No se borro correctamente", lista.delete("text 4"));
            assertTrue( "No se borro correctamente", lista.delete("text 7"));
            
            // Verifica que el tamaño
            assertEquals( "El tamaño de la lista no es el correcto", size-2, lista.size( ) );
         

    }

    /**
     * Prueba get
     * 
    */
    public void testGetPorPosicion( )
    {
    	setupEscenario1( );
        size = 11;
        for( int cont = 0; cont < size; cont++ )
        {
            lista.add( "text "+ cont );
        }
        // Agrega los pacientes y verifica que se hayan agregado correctamente

        
            // Verifica que la informaci�n sea correcta
        	assertEquals(  "No se obtuvo el elemento indicado", lista.get(4), "text 3");
        	assertEquals(  "No se obtuvo el elemento indicado", lista.get(10), "text 9");
            
            
            // Verifica que el tamaño
            assertEquals( "El tamaño de la lista no es el correcto", size, lista.size( ) );
         

   
    }
    /**
     * Prueba get
     * 
    */
    public void testGetPorElemento( )
    {
    	setupEscenario1( );
        size = 11;
        for( int cont = 0; cont < size; cont++ )
        {
            lista.add( "text "+ cont );
        }
        // Agrega los pacientes y verifica que se hayan agregado correctamente

        
            // Verifica que la informaci�n sea correcta
            assertTrue( "No se obtuvo el elemento indicado", lista.get("text 4")!=null);
            assertTrue( "No se obtuvo el elemento indicado", lista.get(5)!=null);
        
            
            
            // Verifica que el tamaño
            assertEquals( "El tamaño de la lista no es el correcto", size, lista.size( ) );
         

   
    }
    /**
     * Prueba size
     * 
     * */
    public void testAgregarPacienteAntesDeError( )
    {
        setupEscenario2( );
        lista.add( "text 2");
        size=11;
        
     // Verifica que el tamaño
        assertEquals( "El tamaño de la lista no es el correcto", size, lista.size( ) );
     
        lista.delete("text 2");
     // Verifica que el tamaño
        assertEquals( "El tamaño de la lista no es el correcto", size-1, lista.size( )-1 );
      
    }

    /**
     * Prueba listing
     * 
     * */
    public void testListing( )
    {
        setupEscenario2( );
        size = 11;
        String[] listaElementos= new String[lista.size()];
		lista.listing(listaElementos);
		
		
		for (String lista : listaElementos) {
	        assertEquals( "La información de los elementos esta mal", lista, "text 1" );
		}
		// Verifica que el tamaño
        assertEquals( "El tamaño de la lista no es el correcto", size-1, lista.size( )-1 );
     
    }
}
