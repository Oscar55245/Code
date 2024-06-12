padre(juan, maria).
padre(juan, jose).
padre(pedro, juan).
padre(pedro, carlos).
padre(carlos, ana).
padre(carlos, luis).
madre(ana, juan).
madre(ana, carlos).
madre(maria, marcos).
madre(maria, elena).
madre(laura, ana).
abuelo(X, Y) :- padre(X, Z), padre(Z, Y).
abuela(X, Y) :- madre(X, Z), madre(Z, Y).
hermano(X, Y) :- padre(Z, X), padre(Z, Y), X \= Y.
hermana(X, Y) :- madre(Z, X), madre(Z, Y), X \= Y.
tio(X, Y) :- hermano(X, Z), padre(Z, Y).
tia(X, Y) :- hermana(X, Z), madre(Z, Y).
es_padre(X, Y) :-
    padre(X, Y). 
es_madre(X, Y) :-
    madre(X, Y).
padre_de(X, Y, Texto) :-
    es_padre(X, Y),
    format(atom(Texto),'~w es el padre de ~w.', [X, Y]).
madre_de(X, Y, Texto) :-
    es_madre(X, Y),
    format(atom(Texto), '~w es la madre de ~w.', [X, Y]).