# test scoping. i.e., that correct a is used.
@ a
a = 999
!a+a
[a:!1111 % @a a=8888 !a !~a !~0a !~1a !~2a] # compile time error for ~2
!a
!~a
!~0a
