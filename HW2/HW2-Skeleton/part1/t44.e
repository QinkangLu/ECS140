# test scoping. i.e., that correct a is used.
@ a
a = 999
!a+a
[a:!1111
 % @a
   a=8888
   !a
   ~a = 11
   ~0a = a + 10000
   ~1a = ~1a+1
   !a !~a !~0a !~1a
]
!a
!~a
!~0a
