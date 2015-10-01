package pessoal.meuPacote;
 class Derived extends Base {
    public Derived( String s ) {
        // passa o controle para o construtor de Base na linha 2  
        super( s );
    }
    
    public Derived( int i ) {
        // passa o controle para o construtor de Base na  linha 5
             super( i );
         }
 }
