#!/bin/sh 

SOLUTION=hw5.pl   # only need to configure this if necessary 
QUERY1='ty'
QUERY2='halt'
REFOUT=Output.correct 
TMPOUT=Output.your

# cleanup 
echo "(1) remove existing output"
rm -f $TMPOUT

# run 
echo "(2) consult your solution and query" 
gprolog --consult-file part1.facts.pl --consult-file $SOLUTION --consult-file test.pl --query-goal $QUERY1 --query-goal $QUERY2 &> /dev/null

# diff 
echo "(3) check for differences" 
diff $TMPOUT $REFOUT
