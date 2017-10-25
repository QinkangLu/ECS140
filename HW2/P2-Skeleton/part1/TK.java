/* *** This file is given as part of the programming assignment. *** */

// Token Kind (internal representations of tokens)

public class TK {
    private final String name;

    // declaring constructor as private prevents outsiders
    // from creating new tokens;
    // and so can test equality using ==.
    private TK(String name) {
	this.name = name;
    }
    public String toString() { // make it printable for debugging
	return name;
    }

    // each token has a TK object.

    public static final TK DECLARE = new TK("TK.DECLARE"); // @
    public static final TK PRINT   = new TK("TK.PRINT");   // !
    public static final TK IF      = new TK("TK.IF");	   // [
    public static final TK THEN    = new TK("TK.THEN");	   // :
    public static final TK ELSEIF  = new TK("TK.ELSEIF");  // |
    public static final TK ELSE    = new TK("TK.ELSE");    // %
    public static final TK ENDIF   = new TK("TK.ENDIF");   // ]
    public static final TK DO      = new TK("TK.DO");      // <
  
    public static final TK COMMA  = new TK("TK.COMMA");    // ,
    public static final TK LPAREN = new TK("TK.LPAREN");   // (
    public static final TK RPAREN = new TK("TK.RPAREN");   // )
    public static final TK PLUS   = new TK("TK.PLUS");     // +
    public static final TK MINUS  = new TK("TK.MINUS");    // -
    public static final TK TIMES  = new TK("TK.TIMES");    // *
    public static final TK DIVIDE = new TK("TK.DIVIDE");   // /

    public static final TK ID     = new TK("TK.ID");	   // identifier

    public static final TK NUM    = new TK("TK.NUM");	   // number

    public static final TK EOF    = new TK("TK.EOF");	   // end of file

    // TK.ERROR special error token kind (for scanner to return to parser)
    public static final TK ERROR  = new TK("TK.ERROR");
    // TK.none marks end of each first set in parsing.
    // you might not need this.
    public static final TK none   = new TK("TK.none");
}
