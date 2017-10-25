SHELL  = /bin/sh

# pretty minimal makefile
e2c:
	javac *.java

# invoke via "make clean".
# WARNING: make sure you know what this is going to do before you invoke it!!!
# (N.B., in this part it removes .c files too!)
clean:
	/bin/rm -f *.class *~ core* *.output a.out *.c *.o

# just do `make remake' instead of `make clean; make'
remake: clean e2c
