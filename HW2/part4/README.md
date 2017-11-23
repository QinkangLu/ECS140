# Part 4: Generating Code
Modify your parser so that it outputs appropriate C code. For example, for the E program:
```
@i
i =1
<i-10 : ! i #this is a comment
i=i+1>
```

your translator might produce something like:
```
main(){
  int x_i;
  x_i = 1;
  while( (x_i-10) <= 0 ){
    printf("%d\n",x_i);
    x_i = x_i+1;
  }
}
```
Note that since the scanner discards whitespace and comments, the output is not as neatly formatted as the E program. In fact, the actual output from your translator will probably be less formatted than shown
above; e.g., it is fine (and simpler) to output a single C token per line. Also note that the translator has prepended each E variable name with x to avoid conflicts with C reserved words. (Hint: You might want to further “munge” identifiers for implementing levels for the ’˜’ operator.)

To test your translator, examine its C output (the GC). Then, compile the GC and execute the resulting program. Verify that it does indeed execute as the source E program specifies
