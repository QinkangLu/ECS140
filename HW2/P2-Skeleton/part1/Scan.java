/* *** This file is given as part of the programming assignment. *** */

import java.io.*;

// Note this code is written to aid the student in learning Java.
// A Java expert could certainly improve the efficiency, conciseness, and
// style of this code.

public class Scan {

    // default max length of identifiers; truncate extra.
    public static final int MAXLEN_ID = 12;

    public Scan() {     // the constructor -- here initializes variables...
        // initially, we pretend that we just read a newline.
        // hence linenumber is initialized to 0.
	isr = new InputStreamReader(System.in);
        c = '\n';
        linenumber = 0;
        putback = true;
	got_eof = false;
    }

    // internal state of scanner
    private InputStreamReader isr; // input stream
    private String token;    // the token as a string
    private TK tkrep;        // the kind of token
    private int linenumber;  // line number

    private boolean got_eof; // true iff have seen EOF
    private boolean putback; // true iff put a char back
    private int c;           // current or putback char
                             // (int rather than char to handle EOF)
    private static final int EOF = -1;

    // call to advance token stream.
    // acts as a generator (iterator) over input.
    // returns Token
    public Token scan() {
	if( got_eof ) {
	    System.err.println("scan: oops -- called after eof.");
	    return new Token(TK.ERROR, "called after eof", linenumber);
	}

	while(true) {
	    if( putback) {
		putback = false;
	    }
	    else {
		c = getchar();
	    }
	    if ( myisalpha((char) c) ) {
		/* identifier. */
		return new Token(TK.ID, buildID(), linenumber);
	    }
	    else if ( myisdigit((char) c) ) {
		/* number. */
		return new Token(TK.NUM, buildNUM(), linenumber);
	    }
	    else {
		switch( c ) {
		    case '@':
			return ccase1('@',TK.DECLARE);
		    case '!':
			return ccase1('!',TK.PRINT);
		    case ',':
			return ccase1(',',TK.COMMA);
		    case '(':
			return ccase1('(',TK.LPAREN);
		    case ')':
			return ccase1(')',TK.RPAREN);
		    case '+':
			return ccase1('+',TK.PLUS);
		    case '-':
			return ccase1('-',TK.MINUS);
		    case '*':
			return ccase1('*',TK.TIMES);
		    case '/':
			return ccase1('/',TK.DIVIDE);
		    case '[':
			return ccase1('[',TK.IF);
		    case ':':
			return ccase1(':',TK.THEN);
		    case '|':
			return ccase1('|',TK.ELSEIF);
		    case '%':
			return ccase1('%',TK.ELSE);
		    case ']':
			return ccase1(']',TK.ENDIF);
		    case '<':
			return ccase1('<',TK.DO);
		    case EOF:
			got_eof = true;
			return new Token(TK.EOF,
					 new String("*EOF*"),
					 linenumber);
		    case '\n':
			linenumber++;
			break;
		    case ' ':
		    case '\t':
		    case '\r': // for Windows (lines end in \r\n)
			break; // whitespace is easy to ignore
		    case '#': // gobble comments
			do {
			    c = getchar();
			} while( c != '\n' && c != EOF );
			putback = true;
			break;
		    default:
			System.err.println(
					   "scan: line "+linenumber+
					   " bad char (ASCII " + c
					   + ")");
			break;
		}
	    }
	}
    }


    private int getchar() {
	int c = EOF;
	try {
	    c = isr.read();
	} catch (java.io.IOException e) {
	    System.err.println("oops ");
	    e.printStackTrace();
	}
	return c;
    }

    private Token ccase1(char c, TK r) {
	return new Token(r, new String(String.valueOf(c)), linenumber);
    }

    // not used in this scanner
    private Token ccase1or2(char c1, char c2, TK r1, TK r2) {
	int c = getchar();
	if (c == c2) {
	    return new Token(
		    r2,
		    new String(String.valueOf(c1)+String.valueOf(c2)),
		    linenumber);
	}
	else {
	    putback = true;
	    return new Token(r1, new String(String.valueOf(c1)), linenumber);
	}
    }

    // not used in this scanner
    private Token ccase2(char c1, char c2, TK r) {
	int c = getchar();
	if (c == c2) {
	    return new Token(
		     r, String.valueOf(c1)+String.valueOf(c2),
		     linenumber);
	}
	else {
	    System.err.println("scan: got got " + c1 +
			       " missing " + c2 +
			       " (got ASCII " + c + ")");
	    return new Token(TK.ERROR, "bad ccase2", linenumber);
	}
    }

    // rather than duplicating code, as done below,
    // could use method "pointer" technique for these build methods.

    // build up an ID token
    // (could use StringBuffer to make this more efficient...)
    private String buildID() {
	int k = 0;
	String str = "";
	do {
	    str += (char) c;
	    k++;
	    c = getchar();
	} while( myisalpha((char) c) && k < MAXLEN_ID );
	putback = true;
	if( myisalpha((char) c) && k == MAXLEN_ID ) {
	    do { c = getchar(); } while(myisalpha((char) c));
	    System.err.println("scan: identifier too long -- truncated to "
			       + str);
	}
	return str;
    }

    // build up a NUM str
    // (could use StringBuffer to make this more efficient...)
    private String buildNUM() {
	int k = 0;
	String str = "";
	do {
	    str += (char) c;
	    k++;
	    c = getchar();
	} while( myisdigit((char) c) && k < MAXLEN_ID );
	putback = true;
	if( myisdigit((char) c) && k == MAXLEN_ID ) {
	    do { c = getchar(); } while(myisdigit((char) c));
	    System.err.println("scan: number too long -- truncated to "
			       + str);
	}
	return str;
    }


    // E's idea of what can form an identifier
    // (could instead directly call Character.isLetter)
    private static boolean myisalpha(char c) {
	return Character.isLetter(c);
    }

    // E's idea of what can form a number
    // (could instead directly call Character.isDigit)
    private static boolean myisdigit(char c) {
	return Character.isDigit(c);
    }

}
