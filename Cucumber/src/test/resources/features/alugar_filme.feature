# language: pt

Funcionalidade: Alugar Filme
	Como usuario 
	Eu quero cadastrar alugueis de filmes
	Para controlar preços e datas de entrega
	
	Cenario: Deve alugar um filme com sucesso
		Dado um filme com estoque 2 unidades
		E que o preco do aluguel seja R$ 3
		Quando alugar
		Entao o preco do aluguel sera R$ 3
		E a data de entrega sera no dia seguinte 
		E o estoque do filme sera 1 unidade
		
		Cenario: Nao deve alugar um filme sem sucesso
		Dado um filme com estoque 0 unidades
		Quando alugar
		Entao nao sera possivel por falta de estoque
		E o estoque do filme sera 0 unidade
		
		Esquema do Cenario: Deve dar condicoes tipo de aluguel
		Dado um filme com estoque de 2 unidades
		E que o preco do aluguel seja R$ <preco>
		E que o tipo do aluguel seja <tipo>
		Quando alugar
		Entao o preco do aluguel sera R$ <valor>
		E a data de entrega sera em <qtdDias> dias
		E a pontuacao sera de <pontuacao> pontos
		
		Exemplos:
		|preco| 	tipo   | valor| qtDias| pontuacao|
		| 4 	|entrendido|	8		|	3			|		2			 |
		| 3 	|comum		 |	5		|	3			|		2			 |
		| 5 	|entrendido|	4		|	3			|		2			 |
		