# nesting of do-in-if-in-do
@i, k
i = 25
< 10-i:
[20-i:
	k = 20 - i
	< k: !k k=k+1 >
|15-i:
	k = 15 - i
	< k: @long long = 10 * k !long k=k+1 >
%
	k = 10 - i
	< k: !k k=k+1 >
]
i = i - 1>
!i

