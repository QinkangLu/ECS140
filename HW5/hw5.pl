/*******************************************/
/**    Your solution goes in this file    **/ 
/*******************************************/

/*
 * find all the courses that has 3 or 4 credits
 */
fc_course(X) :- 
	course(X,_,N),
	N >= 3,
	N =< 4.

/*
 * find all the prerequisite classes of ecs110
 */
prereq_110(X) :- 
	course(X, Y, _), 
	member(ecs110, Y).


/*
 * find the students who is taking ecs140a
 */
ecs140a_students(X) :- 
	student(X, Y), 
	member(ecs140a, Y).


/*
 * Find the names of the instructor who
 * is teaching the classes john is taking
 */
instructor_names(I) :- 
	student(john, Classes),
	instructor(I, Courses),
	instructor_help(Classes, Courses).

instructor_help([H | T], Courses) :- 
	member(H, Courses), !; 
	instructor_help(T, Courses).

/*
 * Find the students who is taking
 * jim's classes.
 */
students(X) :- 
	instructor(jim, Courses), 
	student(X, C),
	student_help(Courses, C).

student_help([H | T], C) :- 
	member(H, C),!; 
	student_help(T, C).


/*
 * Find all the prerequisite of a course, also 
 * involing the prereq of the prereq.
 */
allprereq(C, ALL_Pre) :-
	course(C, [H|T], _),
	allprereq(H, Pre), !,
	append(Pre, [H] , ALL_Pre).

allprereq(C, ALL_Pre) :-
	course(H, [], _), !,
	ALL_Pre = [].
	


/*
 * Find the length of the list including any
 * length of the inner list.
 */
all_length([], 0).

all_length([H|T], N) :-
	length_help(H, N1),
	all_length(T, N2),
	N is N1 + N2.

length_help(H, N) :-
	atom(H), !,
	N = 1.

length_help(H, N) :-
	all_length(H, N).


/*
 * returns True if L contains an equal number of a and b terms.
 */
equal_a_b([]), !.
equal_a_b(L) :-
	num_ab(L, Na, Nb) ,!,
	Na = Nb.

num_ab([], Na, Nb) :-
	Na = 0,
	Nb = 0.

num_ab([H|T], Na, Nb) :-
	H = a,
	num_ab(T, N1, N2),
	Na is N1 + 1,
	Nb is N2 + 0.

num_ab([H|T], Na, Nb) :-
	H = b,
	num_ab(T, N1, N2),
	Na is N1 + 0,
	Nb is N2 + 1.

num_ab([H|T], Na, Nb) :-
	num_ab(T, Na, Nb).
/*
 * why is this working when I put Na but not working when I use N1
 * but in the above cases, I need to used a different variable than Na.
 */


/*
 * swap prefix and suffix
 * K is a sub-list of L
 * S is the list obtained by appending the suffix 
 * of L following an occurance of K in L, with K
 * and the prefix that preceds the same occurance of K in L.
 */
swap_prefix_suffix(K, L, S) :-
	swap_help(K, L, [], S).

swap_help(K, L, Prefix, Swapped) :-
	append(K, Suffix, L),
	append(K, Prefix, Temp),
	append(Suffix, Temp, Swapped).

swap_help(K, [P|T], PA, Swapped) :-
	append(PA, [P], PRE),
	swap_help(K, T, PRE, Swapped).



/*
 * Palindrome, that is it reads the same backwards as forwards.
 */
palin(A) :-
	reverse(A, B),
	A = B.

reverse([], []).
reverse([H|T], B) :-
	reverse(T, B1),
	append(B1, [H], B). /* Note: you need to put H into a list to append it */


/*
 * A good sequence consists either of the single number 0,
 * or of the number 1 followed by two other good sequences:
 * thus, [1, 0, 1, 0, 0] is a good sequence, but [1, 1, 0, 0]
 * is not.
 */

good([0]).
good([H|T]) :-
	H = 1,
	append(L1,L2,T),
	good(L1),
	good(L2).