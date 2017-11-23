# Part 2: The Parser
First, rewrite the grammar using syntax graphs. Then, determine the first sets; this should be straightforward because the grammar is simple. Finally, translate the syntax graph into a parser. See the textbook for details.

If an error, e.g., missing “=” in an assignment statement — is encountered in parsing, give an appropriate
error message via “System.err.println” and then stop your program via “System.exit(1)”.

Test your parser to see that it recognizes syntactically legal E programs and complains about syntactically
illegal programs.

You will be provided with a small part of the parser and the main program. You will need to copy from
the previous part the Java code files (but not e2c.java) you used for your scanner.
