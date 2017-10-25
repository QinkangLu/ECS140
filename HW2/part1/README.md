#Part 1: The Scanner
A scanner is sometimes called a lexer — since it does lexical analysis — or a tokenizer — since it breaks up its input into tokens. For example, the GetToken procedure described in Louden is a scanner.

You will be provided with a nearly complete scanner. You need to provide a few omitted tokens (in Scan.java and TK.java). This part is simple, but look at the scanner code to see how it works and use the
provided test scripts. In fact, use the provided test scripts before you make any changes; from their output, it should be pretty clear what tokens are missing.

For simplicity, the scanner imposes a limit on the length of tokens. If the scanner encounters a token whose length exceeds that limit, it prints an appropriate error message and ignores the extra characters. Also, if the scanner encounters a character that is not in E’s character set, it prints an appropriate error message, ignores the unknown character, and continues by examining the next character in the input. Finally, the scanner simply discards whitespace and comments.
