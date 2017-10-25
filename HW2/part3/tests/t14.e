# test parser -- this is another valid program

@ a, b, another, i, k, s
a = 44
b = 0-a a = 888-999 another = a - 999
!a !b !another
# how's precedence, associativity?
! 3+2*4		! (8 - 7 - 6)		! (8-(7-6))	!((8-7)-6)

i = 1
<i-10:!i i=i+1>

s=0k=10
<0-k:!k s=s+k k = k-1>
!k !s
