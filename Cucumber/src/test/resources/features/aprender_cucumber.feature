# language: pt

Funcionalidade: aprender Cucumber
  Como aluno 
  Eu quero aprender 
  Para que possa automatizar

  Cenario: Deve executar especificacao
    Dado que criei o arquivo correntamente
    Quando executar
    Entao a especificacao deve finalizar
    
    Cenario: Deve incrementar contador
    Dado que o valor do contador e 15
    Quando eu incrementar em 3
    Entao o valor do contador sera 18
    
    Cenario: Deve incrementar contador
    Dado que o valor do contador e 123
    Quando eu incrementar em 35
    Entao o valor do contador sera 158
    
    
    Cenario: Deve calcular atraso na entrega
    Dado que a entrega e dia 05/04/2018
    Quando a entrega atrasar em 2 dias 
    Entao a entrega sera efetuada em 07/04/2018

	Cenario: Deve calcular atraso na entregada China
    Dado que a entrega e dia 05/04/2018
    Quando a entrega atrasar em 2 meses 
    Entao a entrega sera efetuada em 05/06/2018




#	Cenario: Deve criar steps genericos para estes passos
 #  Dado que o ticket e AF345
 #  E que o valor da passagem e 230,45
  # E que o nome do passageiro e "Fulano da Silva"
   #E que o telefone do passageiro e 9999-9999
  # Quando criar os steps
   #Entao o teste vai funcionar

	#Cenario: Deve reaproveitar os steps "Dado" do cenário anterior
  #  Dado que o ticket é AB167
 # Dado que o ticket especial é AB167
 # Dado que o valor da passagem é R$ 1120,23
 # Dado que o nome do passageiro é "Cicrano de Oliveira"
 #   Dado que o telefone do passageiro é 9888-8888

 #	Cenario: Deve negar todos os steps "Dado" dos cenários anteriores
 #  * que o ticket é CD123
 #  * que o ticket é AG1234
 #  * que o valor da passagem é R$ 1.1345,56
 # * que o nome do passageiro é "Beltrano Souza Matos de Alcântara Azevedo"
 # * que o telefone do passageiro é 1234-5678
 # * que o telefone do passageiro é 999-2223 

    
    
    
    
   