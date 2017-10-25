#E to C Tanslator

This is a Java program that translates E programs to their semantically equivalent C programs. That is, the input to your program (henceforth, the translator) is an E program; the output from
your program is a C program.

This program helps you to reinforce the understanding of lexical, syntatical, and semantical analysis.

##The E Language
The following grammar partially describes the E language. In the EBNF below, nonterminals are in lowercase; terminal symbols are enclosed in single quotes to avoid potential confusion in the use of characters that are both meta-symbols in the grammar and terminals in E, e.g., “[”.

```
program ::= block
block ::= declaration_list statement_list
declaration_list ::= {declaration}
statement_list ::= {statement}
declaration ::= ’@’ id { ’,’ id }
statement ::= assignment | print | do | if
print ::= ’!’ expr
assignment ::= ref_id ’=’ expr
ref_id ::= [ ’˜’ [ number ] ] id
do ::= ’<’ guarded_command ’>’
if ::= ’[’ guarded_command { ’|’ guarded_command } [ ’%’ block ] ’]’
guarded_command ::= expr ’:’ block
expr ::= term { addop term }
term ::= factor { multop factor }
factor ::= ’(’ expr ’)’ | ref_id | number
addop ::= ’+’ | ’-’
multop ::= ’*’ | ’/’
```

##The following rules complete the syntactic definition of E:
* An E program is followed by an end-of-file indicator; extra text is not legal.

* The nonterminal id represents a nonempty sequence of letters. Similarly, the nonterminal number represents a non-empty sequence of digits.

* Special characters (e.g., ’[’ and ’!’) serve the role of keywords. Hence there are no reserved words.

* As is the case in most languages, tokens are formed by taking the longest possible sequences of constituent characters. For example, the input “abcd” represents a single identifier, not several identifiers. Whitespace consists of one or more blanks, tabs, or newlines. 

For example, “x:10” and “x : 10” are equivalent. Note that whitespace delimits tokens; e.g., “abc” is one
token whereas “a bc” is two.

* A comment in E begins with a “#” and consists of all characters up to, but not including, a newline or end-of-file. 

##E’s semantics follow C’s semantics for the most part, but there are significant differences. The important semantic points are:
* E has only one type of variable: integer; as with local variables in C, the initial value of E variables is not defined.

* As in C, variables must be declared before use, redeclaration of a variable (in the same block) is an error, and the declaration of a variable in an inner block hides the declaration of variable(s) of the same name declared in outer blocks. Thus, this part of E’s scoping rules are just like C’s. Unlike C, though, E provides
the scoping operator ’˜’. Its meaning is as follows:

  ˜0 x: the variable x that is declared in the current block.
  ˜1 x: the variable x that is declared in the immediately enclosing block (i.e., 1 level up).
  ˜2 x: the variable x that is declared in the enclosing block 2 levels up
  ...: etc.
  ˜x: the variable x that is declared at the global level.
  ˜N x is an error if N is greater than the current depth of nesting. Note that ˜x acts like C++’s scope resolution operator, i.e., ::x.

* An expression in a guard—i.e., as the expr before the ’:’ in a guarded command—is considered true if non-positive and false if positive. For example,
```
i = 1
<i-10: !i i=i+1>
```
is a loop that prints out the first 10 positive integers. (The value of i is 11 after the loop.)

* As in most languages, the if statement tests its guards in lexical order, until it finds one that is true; the corresponding block is then executed. If no guard is found true, the else block (if any) is executed. If no else is present, then the if has no effect.

####Note:
To Test this program, go to each part and copy the all the *.e and *.correct files from tests and all the files from execution folder to the *.java files. Then use make to compile and run with ./runall.
