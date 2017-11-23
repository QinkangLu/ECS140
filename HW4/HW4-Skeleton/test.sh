#!/bin/sh 

SOLUTION=hw4.l  # only need to configure this if necessary
TESTFILE=test.l 
TMPFILE=check.l 
REFOUT=Output.correct
TMPOUT=Output.your

cat > $TMPFILE <<EOF
(load "$SOLUTION")
(load "$TESTFILE") 
(test) 
EOF

# cleanup 
echo "(1) remove existing output file" 
rm -f $TMPOUT

# run 
echo "(2) load your solution and test" 
clisp $TMPFILE > $TMPOUT

# diff 
echo "(3) check for differences" 
diff $TMPOUT $REFOUT

