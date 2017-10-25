/* *** This file is given as part of the programming assignment. *** */

public class Parser {


    // tok is global to all these parsing methods;
    // scan just calls the scanner's scan method and saves the result in tok.
    private Token tok; // the current token
    private Scan scanner;
    
    private void scan() {
        tok = scanner.scan();  //takes in the next token
    }
    
    Parser(Scan scanner) {
        this.scanner = scanner;
        scan();
        program();
        if( tok.kind != TK.EOF )
            parse_error("junk after logical end of program");
    }

/***************** Help Methods *******************/
    // is current token what we want?
    private boolean is(TK tk) {
        return tk == tok.kind;
    }

    // ensure current token is tk and skip over it.
    private void mustbe(TK tk) {
        if( tok.kind != tk ) {
            System.err.println( "mustbe: want " + tk + ", got " +
                        tok);
            parse_error( "missing token (mustbe)" );
        }
        scan();
    }

    private void parse_error(String msg) {
        System.err.println( "can't parse: line "
                    + tok.lineNumber + " " + msg );
        System.exit(1);
    }
    
    /******** Newly Added Methods ********/
    private boolean isStatement(){
        if(is(TK.TILDE) | is(TK.ID) | is(TK.PRINT) | is(TK.DO) | is(TK.IF)){
            return true;
        }
        return false;
    }
    
    // check if the token is PLUS or MINUS
    private boolean isAddop(){
        if( is(TK.PLUS) ){
            return true;
        } else if (is(TK.MINUS) ) {
            return true;
        }
        /*else {
            parse_error("Here should be addop but it is not");
        }*/
        
        return false;
    }
    
    // check if the token is TIMES or DIVIDE
    private boolean isMultop(){
        if( is(TK.TIMES) ){
            return true;
        } else if( is(TK.DIVIDE) ){
            return true;
        }
        /*else {
            parse_error("Here should be multop but it is not");
        }*/
        return false;
    }
    
/**************************************************/
    
    
/**************** Parsing Methods *****************/
    private void program() {
        block();
    }
    
    private void block(){
        declaration_list();
        statement_list();
    }
    
    /* below checks whether tok is in first set of declaration.
     * here, that's easy since there's only one token kind in the set.
     * in other places, though, there might be more.
     * so, you might want to write a general function to handle that. */
    private void declaration_list() {
        while( is(TK.DECLARE) ) {
            declaration();
        }
    }
    
    private void declaration() {
        mustbe(TK.DECLARE);
        mustbe(TK.ID);
        while( is(TK.COMMA) ) {
            scan();
            mustbe(TK.ID);
        }
    }
    
    /******** Newly Added Methods ********/
    private void statement_list() {
        while( isStatement() ){
            statement();
        }
    }
    
    private void statement(){
        if( is(TK.TILDE) | is(TK.ID) ){ //because FIRST(assignment) = ref_id
            assignment();
        } else if( is(TK.PRINT) ) {  //is print
            print();
        } else if( is(TK.DO) ) {  //is doStatement
            doStatement();
        } else if( is(TK.IF) ){
            ifStatement();
        }
    }
    
    private void assignment(){
        ref_id();
        mustbe(TK.ASSIGN);
        expr();
        tok.toString(); //delete later
    }
    
    private void ref_id(){
        if( is(TK.TILDE) ){
            scan();
            if(is(TK.NUM)){
                scan();
            }
        }
        mustbe(TK.ID);
    }
    
    private void print(){
        mustbe(TK.PRINT);
        expr();
    }
    
    private void doStatement(){
        mustbe(TK.DO);
        guarded_command();
        mustbe(TK.ENDDO);
    }
    
    /* if ::= '[' guarded_command { '|' guarded_command } [ '%' block ] ']' */
    private void ifStatement(){
        mustbe(TK.IF);
        guarded_command();
        while( is(TK.ELSEIF) ){
            scan();
            guarded_command();
        }
        
        if( is(TK.ELSE) ){
            scan();
            block();
        }
        
        mustbe(TK.ENDIF);
    }
    
    /* guarded_command ::= expr ':' block */
    private void guarded_command(){
        expr();
        mustbe(TK.THEN);
        block();
    }
    
    /* expr ::= term { addop term } */
    private void expr(){
        term();
        while( isAddop() ){
            addop();
            term();
        }
    }
    
    private void term(){
        factor();
        while( isMultop() ){
            multop();
            factor();
        }
    }
    
    /* factor ::= '(' expr ')' | ref_id | number */
    private void factor(){
        if( is(TK.LPAREN) ){
            scan();
            expr();
            mustbe(TK.RPAREN);
        } else if( is(TK.TILDE) | is(TK.ID) ){
            ref_id();  //ref_id does the scan() so we don't need to do it again.
        } else if( is(TK.NUM) ){
            scan();
        } else {
            System.out.println(tok.toString());
            parse_error("Expected a correct factor here");
        }
    }
    
    private void addop(){
        if( isAddop() ){
            scan();
        }
    }
    
    private void multop(){
        if( isMultop() ){
            scan();
        }
    }
    /*************************************/
    
    
/**************************************************/
}
