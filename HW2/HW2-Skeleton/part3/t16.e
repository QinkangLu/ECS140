# make sure complain about:
#	using undeclared identifiers
#	redeclaring identifier
# here, though, test only the latter.
@ a,a,a,a,a
a = 999
!a+a
[a-9:!1111 | a-99:!2222 | a-999:!3333 % !4444]
a = 99
[a-9:!1111 | a-99:!2222 | a-999:!3333 % !4444]
a = 8888
[a-9:!1111 | a-99:!2222 | a-999:!3333 % !4444]
a = 7777
[a-9:!1111 | a-99:!2222 | a-999:!3333]
!a
