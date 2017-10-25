#Part 3: The Symbol Table
Up to this point, we have dealt with syntax. Now, we need to enforce the semantic constraints that deals with variables: We must detect undeclared and redeclared variables.

A table of variables in the current scope needs to be maintained. Each time a variable is declared, the table is checked. If the variable is already in the table entries for the current block, then it is being redeclared.

Otherwise, the variable is added to the table. Each time a variable is referenced, the table is checked to ensure that the variable has been declared.

Here is one implementation approach. Use a stack of lists of variable names. When a new block is entered, a new list of variable names is created to hold the variables in this new block. Each (legal) variable
declaration adds to the list for the current block. When a block is exited, the list for that block is popped from
the stack.

An undeclared variable, then, is one that does not appear anywhere in the entire stack of lists. (Thus, the stack is used in an “impure” sense. It provides more than pop and push operations; it also provides search.) In a real compiler, the symbol table would be searched beginning with the newest block to locate the most recent
symbol table entry with the given name; the symbol table entry would contain additional information such as the variable’s type. Given that E’s scoping rules are like C’s, then variables should generally be located in that fashion too. However, E (unlike C) provides the scoping operator ’˜’, whose use will affect how you represent levels and how you search in the symbol table. The numeric argument to ’˜’ specifies the exact scoping level in which to find the given variable; it is an error if the variable is not found within that level, even if the variable is currently in scope (i.e., appears at a different level in the symbol table).

For a redeclared variable, give an appropriate error message, and then continue by ignoring the redeclaration. For an undeclared variable (including a bad ’˜’ reference), give an appropriate error message via
“System.err.println” and then stop your program via “System.exit(1)”.

Since the number of variables in the program is neither known in advance nor bounded, your program must use a dynamically allocated data structure for the symbol table. Break this part into subparts. First, get everything working without handling the scoping operator. Then, handle the scoping operator.