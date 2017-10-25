# nesting of do-in-if-in-do
# contains several undeclared variables,
# the first of which should be flagged as an error
# and the translation terminated.
@i, k
i = 25
< 10-i:
[20-i:
	k = 20 - i
	h = 77
	hh = hhh
	< k: !k k=k+1 >
|15-i:
	k = 15 - i
	< k: @long long = 10 * k !long k=k+1 >
	!long
%
	k = 10 - i
	< k: !k k=k+1 >
]
i = i - 1>
!i
!k

