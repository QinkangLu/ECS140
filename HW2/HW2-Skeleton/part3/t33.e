
@a, aone
a = 1
aone = 11
!a
[0-1:
    @a, atwo
    a = 2
    atwo = 22
    !a
    [0-1:
       @a, athree
       a = 3
       athree = 33
       !a
       [0-1:
           @a, afour
           a = 4
           afour = 44
           !a
       ]
       !a
      # !afour  # should produce error
    ]
    !a
   # !athree  # should produce error
]
!a
!atwo # should produce error


