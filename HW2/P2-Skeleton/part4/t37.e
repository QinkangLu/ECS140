# should print 1, 2, 3, 4, 3, 2, 1
@a
a = 1
!a
[0-1:
    @a
    a = 2
    !a
    [0-1:
       @a
       a = 3
       !a
       [0-1:
           @a
           a = 4
           !a
       ]
       !a
    ]
    !a
]
!a


