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