# Part 5: E Language Changes: Design and Implementation
Add a definite iteration statement (e.g., like for in C or C++) to the language definition and your translator.

###BNF:
```
program ::= block
block ::= declaration_list statement_list
declaration_list ::= {declaration}
statement_list ::= {statement}
declaration ::= ’@’ id { ’,’ id }
statement ::= assignment | print | do | if | for
print ::= ’!’ expr
assignment ::= ref_id ’=’ expr
ref_id ::= [ ’ ̃’ [ number ] ] id
do ::= ’<’ guarded_command ’>’
if ::= ’[’ guarded_command { ’|’ guarded_command } [ ’%’ block ] ’]’
for ::= ‘{’ [declaration] ‘;’ assignment ‘;’ expr ‘;’ assignment ‘:’ block ’}’
guarded_command ::= expr ’:’ block
expr ::= term { addop term }
term ::= factor { multop factor }
factor ::= ’(’ expr ’)’ | ref_id | number
addop ::= ’+’ | ’-’
multop ::= ’*’ | ’/’
```

###Description:
“for” is declared as:
```
for ::= ‘{’ [declaration] ‘;’ assignment ‘;’ expr ‘;’ assignment ‘:’ block ’}’
```

The usual format for for_loop is “for(int i=0; i<5; i++){}”,
then we break the for_loop into three parts, 
       1)initialization (declaration and assignment);
       2)condition (expression);
       3)increment/decrement (assignment);
       4)body of loop (block);
note: declaration can be optional inside the loop since you can declare it outside and initialize it inside the loop


‘{’ : TK.FOR
‘}’ : TK.ENDFOR
‘;’ : TK.NEXT
':' : TK.THEN

Parsing Function will look like:
```
private void for_loop(){
	mustbe(TK.FOR);

	if(is(TK.DECLARE)){
		declaration();
	}
	mustbe(TK.NEXT); //read in ';'
	assignment();    //initialization

	mustbe(TK.NEXT);
	expr();          //condition

	assignment();    //increment/decrement

	mustbe(TK.THEN);
	block();
}

```

Parsing Function with Translation to C:
```
private void for_loop(){
	mustbe(TK.FOR);

	/****translation to C****/
	System.out.println("for (");
	/************************/
	
	if(is(TK.DECLARE)){
		declaration();
	}
	mustbe(TK.NEXT); //read in ';'
	assignment();    //initialization

	/****translation to C****/
	System.out.println(";");
	/************************/

	mustbe(TK.NEXT);
	expr();          //condition

	/****translation to C****/
	System.out.println(";");
	/************************/

	assignment();    //increment/decrement

	/****translation to C****/
	System.out.println(")");
	System.out.println("{");
	/************************/

	mustbe(TK.THEN);
	block();

	/****translation to C****/
	System.out.println("}");
	/************************/
}
