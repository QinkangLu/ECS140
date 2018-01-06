%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% You can run all tests using "ty." 
% Or you can run tests for individual parts, e.g., "test_fc_course."
%
% Make sure that you have ``consulted'' all files you need to run 
% a particular test or tests. Remember to consult this file too.
%
% Use this to test everything and create Output.your, then exit from gprolog.
% Do a "diff Output.correct Output.your". The files should be identical
% except for some differences in the order of output for latter parts.
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% mynot(A) succeeds if A fails
mynot(A):- A,!,fail.
mynot(_).

%%%%%%

ty :-
	tell('Output.your'), test, told.

% test everything
test :-
	test_fc_course,
	test_prereq,
	test_ecs140as,
	test_instructorn,
	test_students,
	test_allprereq,
	test_alllen,
	test_eqab,
	test_swapps,
        test_palin,
        test_good,
        test_puzzle.

test_fc_course :-
	nl, printstring("TESTING C_s"), nl, nl,
	all1o(  fc_course, C, "Course").
test_prereq :-
	nl, printstring("TESTING P_s"), nl, nl,
	all1o(  prereq_110, P, "Prerequisites").


test_ecs140as :-
	nl, printstring("TESTING ECS140AS"), nl, nl,
	all1o( ecs140a_students, S, "Students").
test_instructorn :-
	nl, printstring("TESTING INSTRUCTOR"), nl, nl,
	all1o( instructor_names, I, "Instructor" ).

test_students :-
	nl, printstring("TESTING STUDENTS"), nl, nl,
	all1o( students, S, "STUDENTS").
test_allprereq :-
	nl, printstring("TESTING ALL_PREREQ"), nl, nl,
	all2io( allprereq, ecs140a, A, "All_Pre"),
	all2io( allprereq, m16a, A, "All_Pre"),
	all2io( allprereq, ecs110, A, "All_Pre"),
	all2io( allprereq, ecs50, A, "All_Pre").
test_alllen :-
	nl, printstring("TESTING ALL_LEN"), nl, nl,
	all2io( all_length, [], L, "All_Len"),
	all2io( all_length, [a,b,c,d], L, "All_Len"),
	all2io( all_length, [a,b,[c],d], L, "All_Len"),
	all2io( all_length, [a,b,[c,d],e], L, "All_Len"),
	all2io( all_length, [[[[[]]]]], L, "All_Len"),
	all2io( all_length, [[a,b],[],d], L, "All_Len"),
	all2io( all_length, [a,[b,[c,[d,e],f],g],h], L, "All_Len"),
	all2io( all_length, [[a,b,[],d],[[]],d], L, "All_Len"),
	all2io( all_length, [[a,b,[[[[e,e]]]],d],[[]],d], L, "All_Len"),
	all2io( all_length, [[a,b,[[[a],b]],d],[[],[],[[[]]]],d], L,
		 "All_Len").
test_eqab :-
	nl, printstring("TESTING EQ_A_B"), nl, nl,
	all1i( equal_a_b, [a,b]),
	all1i( equal_a_b, [a,a,b]),
	all1i( equal_a_b, [b,a]),
	all1i( equal_a_b, [a,b]),
	all1i( equal_a_b, []),
	all1i( equal_a_b, [a,b,a,a,b,c,d,b,f]),
	all1i( equal_a_b, [a,b,a,a,b,c,d,b,f,b]),
	all1i( equal_a_b, [aa, bbb, aaa]),
	all1i( equal_a_b, [aa, bbb, aaa, a]),
	all1i( equal_a_b, [aa, b, bbb, aaa, a]),
	all1i( equal_a_b, [a,a,a,a,a,a,b,b,b,b,b,b]),
	all1i( equal_a_b, [a,a,a,a,a,a,d,b,b,b,b,b,b,b]),
	all1i( equal_a_b, [b,a,b,a,b,a,b,a,b,a,b,a,b,a,b,a]),
	all1i( equal_a_b, [a,b,a,b,a,b,a,b,a,b,a,b,a,b,a,b,a]).
test_swapps :-
	nl, printstring("TESTING SWAP"), nl, nl,
	all3iio( swap_prefix_suffix, [], [], R, "SWAP"),
	all3iio( swap_prefix_suffix, [], [a,b], R, "SWAP"),
	all3iio( swap_prefix_suffix, [a], [a,b], R, "SWAP"),
	all3iio( swap_prefix_suffix, [a], [a], R, "SWAP"),
	all3iio( swap_prefix_suffix, [a], [], R, "SWAP"),
	all3iio( swap_prefix_suffix, [c,d], [a,b,c,d,e,f], R, "SWAP"),
	all3iio( swap_prefix_suffix, [a,b,c], [a,b,d,e,a,b,c,a,b], R,
		"SWAP"),
	all3oii( swap_prefix_suffix, K, [a,b,c,d,e], [b,c,d,e,a], "SWAP"),
	all3ooi( swap_prefix_suffix, [a,X,b,Y], [a,a,Y,Z,X,Y,X], 
		[b,a,b,b,a,a,a], "SWAP"),
	all3ooi( swap_prefix_suffix, [X,Y,Z,c],[Y,Z,X,X,Y,Z,X,X,Y,Z],
		[c,a,b,c,a,b,c,a,b,c], "SWAP").
test_palin :- 
	nl, printstring("TESTING palin"), nl, nl,
	all1i( palin, [a, b, c, d]),
	all1i( palin, [a, b, b, a]),
	all1i( palin, [a, b, a]),
	all1i( palin, [a, a, a, a]),
	all1i( palin, []),
	all1i( palin, [b, a, a, a, a, a, a, a, a, a, a, a, b]),
	all1i( palin, [b, a, b, a, b, a, b, a, b, a, b]).

test_good :-  nl, printstring("TESTING good"), nl, nl,
	all1i( good, [0]),
	all1i( good, [0, 1, 0]),
	all1i( good, [1, 1, 0]),
	all1i( good, [1, 0, 1, 0, 0]),
	all1i( good, [1, 0, 1, 1, 1, 1, 1, 0, 1]).

test_puzzle :-  nl, printstring("TESTING puzzle"), nl, nl,
        solve, nl, nl,
        fail; true. 

/* semi-general tester.
 * run Predicate on A1, A2, A3
 * assume output goes only to A3, whose name is in the string SA3.
 */
all3iio(Predicate,A1,A2,A3,SA3) :-
	printstring("testing: "), write(Predicate),
	printstring("("), write(A1),
	printstring(","), write(A2),
	printstring(","), printstring(SA3),
	printstring(")"), nl,
	T =..[Predicate,A1,A2,A3], call(T),
	printstring(SA3), printstring(" = "),
	write(A3), nl, nl,
	fail; true.

/* semi-general tester.
 * run Predicate on A1, A2, A3
 * assume output goes only to A1, whose name is in the string SA1.
 */
all3oii(Predicate,A1,A2,A3,SA1) :-
	printstring("testing: "), write(Predicate),
	printstring("("), printstring(SA1),
	printstring(","), write(A2),
	printstring(","), write(A3),
	printstring(")"), nl,
	T =..[Predicate,A1,A2,A3], call(T),
	printstring(SA1), printstring(" = "),
	write(A1), nl, nl,
	fail; true.

all3ooi(Predicate,A1,A2,A3,SA1) :-
        printstring("testing: "), write(Predicate),
        printstring("("), printstring(SA1),
        write(A3),
        printstring(")"), nl,
        T =..[Predicate,A1,A2,A3], call(T),
        printstring(SA1), printstring(" = "),
        write(A1), nl,
	write(A2), nl, nl,   
        fail; true.



/* semi-general tester.
 * run Predicate on A1, A2, A3
 * assume output goes only to A2, whose name is in the string SA2.
 */
all3ioi(Predicate,A1,A2,A3,SA2) :-
	printstring("testing: "), write(Predicate),
	printstring("("), write(A1),
	printstring(","), printstring(SA2),
	printstring(","), write(A3),
	printstring(")"), nl,
	T =..[Predicate,A1,A2,A3], call(T),
	printstring(SA2), printstring(" = "),
	write(A2), nl, nl,
	fail; true.

/* semi-general tester.
 * run Predicate on A1, A2
 * assume output goes to A2, whose name is in the string SA2.
 */
all2io(Predicate,A1,A2,SA2) :-
	printstring("testing: "), write(Predicate),
	printstring("("), write(A1),
	printstring(","), printstring(SA2),
	printstring(")"), nl,
	T =..[Predicate,A1,A2], call(T),
	printstring(SA2), printstring(" = "),
	write(A2), nl, nl,
	fail; true.
	
/* semi-general tester.
 * run Predicate on A1, A2
 * assume output goes to A1, whose name is in the string SA1.
 */
all2oi(Predicate,A1,A2,SA1) :-
	printstring("testing: "), write(Predicate),
	printstring("("), printstring(SA1),
	printstring(","), write(A2),
	printstring(")"), nl,
	T =..[Predicate,A1,A2], call(T),
	printstring(SA1), printstring(" = "),
	write(A1), nl, nl,
	fail; true.
	
all1i(Predicate,A1) :-
	printstring("testing: "), write(Predicate),
	printstring("("), write(A1),
	printstring(")"), nl,
	T =..[Predicate,A1],
	((call(T),printstring("yes"));(mynot(T),printstring("no"))),
	nl, nl,
	fail; true.
	
/* semi-general tester.
 * run Predicate on A1
 * assume output goes only to A1, whose name is in the string SA1.
 */
all1o(Predicate,A1,SA1) :-
	printstring("testing: "), write(Predicate),
	printstring("("), printstring(SA1),
	printstring(")"), nl,
	T =..[Predicate,A1], call(T),
	printstring(SA1), printstring(" = "),
	write(A1), nl, nl,
	fail; true.

/* a way to output strings. */
printstring([]).
printstring([H|T]) :- put(H), printstring(T).


