# test scoping. i.e., that correct a is used.
@ a
a = 999
!a+a
[a:!1111 % @a a=8888 !a]
!a

[ a:!1111
  % !2222
    !a
    [0-2: @a a = 3 !a]
    !a
]
!a

[ a:!1111
  % @a a = 4
    !5
    !a
    [0: @a a = 6 !a]
    !a
]
!a
