# check that look only in exact level vs. starting to search there.
@bbbb
bbbb=23
[bbbb:!bbbb
 %
  @ k
  k = 999
  !k+k
  [k:!1111
   % @bbbb
     bbbb=8888
     ~2bbbb = 44
     !bbbb
     ~bbbb = 11
     ~0bbbb = bbbb + 10000
     <~bbbb-22: @bbbb bbbb = 77 !~bbbb !bbbb ~bbbb = ~bbbb+1 !k>
     k = k+1
     ~2bbbb = ~2bbbb+100
     !bbbb !~bbbb !~2bbbb !~1bbbb !k # compile time error for !~1bbbb 
  ]
  !k
  !~bbbb
  !~0k
  !~1bbbb
]
!bbbb
!~bbbb
!~0bbbb
