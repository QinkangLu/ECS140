course(m16a, [], 3).
course(m21c, [], 3).
course(m22a, [], 3).
course(ecs10, [], 4).
course(ecs15, [], 4).
course(ecs30, [m16a], 4).
course(ecs35, [m16a], 4).
course(ecs40, [ecs30], 4).
course(ecs50, [ecs40], 4).
course(ecs100, [m21c], 3).
course(ecs110, [ecs40], 4).
/*course(ecs120, [ecs100, ecs110], 3).*/
course(ecs122a, [ecs100, ecs110], 3).
course(ecs122b, [ecs122a], 3).
course(ecs140a, [ecs110], 4).
course(ecs140b, [ecs140a], 4).
course(ecs142, [ecs140a, ecs120], 4).
course(ecs150, [ecs40, ecs154a, ecs154b], 4).
course(ecs151a, [ecs154a], 4).
course(ecs151b, [ecs151a], 3).
course(ecs152, [ecs154a], 3).
course(ecs153, [ecs150], 3).
course(ecs154a, [ecs50, ecs110], 4).
course(ecs154b, [ecs154a, ecs110], 4).
course(ecs158, [ecs154b, ecs150], 3).
course(ecs160, [ecs140a], 4).
course(ecs163, [ecs100, ecs110], 3).
course(ecs165a, [ecs110], 4).
course(ecs165b, [ecs165a], 4).
course(ecs170, [ecs140a], 4).
course(ecs172, [ecs110, m22a], 4).

	
student(amber, [ecs10, ecs15, ecs35]).
student(brad, [ecs140a, ecs165a, ecs151a, ecs158]).
student(cindi, [ecs140b, ecs152, ecs170, ecs172]).
student(dan, [ecs35, ecs110, ecs50]).
student(john, [ecs140a, ecs150, ecs154a, ecs163]).
student(ian, [ecs154a, ecs160, ecs163, ecs165a, ecs170]).
student(karl, [ecs10, ecs50, ecs100, ecs110]).
student(lam, [ecs142, ecs150, ecs160, ecs170, ecs172]).
student(nancy, [ecs140a, ecs150, ecs163]).
student(pam, [ecs10, ecs15, ecs30, ecs35]).

instructor(adam, [ecs50, ecs100, ecs10, ecs154a]).
instructor(ben, [ecs50, ecs15, ecs110, ecs172]).
instructor(charles, [ecs30, ecs15, ecs140a, ecs170, ecs165b]).
instructor(cindi, [ecs140a, ecs152, ecs154a, ecs179]).
instructor(davis, [ecs40, ecs122a, ecs163, ecs165a]).
instructor(diane, [ecs150, ecs151a, ecs154b, ecs158, m21c, ecs140b,  ecs142]).
instructor(eugene, [ecs122b, ecs50, ecs140b, ecs153, ecs158, ecs160]).
instructor(fox, [ecs122b, ecs50, ecs140b, ecs153, ecs158, ecs160]).
instructor(george, [ecs142, ecs50, ecs172, ecs153, ecs100, ecs20]).
instructor(ian, [ecs50, ecs165a, ecs165b, ecs122b, ecs151b]).
instructor(jim, [ecs100, ecs110, ecs160, ecs163]).



