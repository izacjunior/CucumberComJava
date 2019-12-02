#language: pt
@funcionais
Funcionalidade: Cadastro de contas
Como um usuario 
Gostaria de cadastrar contas
Para que eu possa distribuir meu dinheiro de uma forma mais organizada

#como se fosse pré condicao, roda em todos os ccenários ex:@Before
Contexto:
Dado que desejo adicionar um conta

Esquema do Cenario: Deve validar regras cadastro contas
Quando informo a conta "<conta>"
Entao recebo a mensagem "<mensagem>"

Exemplos:
|conta					 |		mensagem											|
|Conta de Teste  |Conta adicionada com sucesso!     |
|								 |Informe o nome da conta 			    |
|Conta mesmo nome|Ja existe uma conta com esse nome!|




#Cenario: Deve inserir uma conta com sucesso 
#E informo a conta "Conta de Teste1"
#E seleciono Salvar
#Entao a conta e inserida com sucesso

#Cenario: Nao deve inserir uma conta sem nome
#E informo a conta " "
#E seleciono Salvar
#Entao sou notificado que o nome da conta e obrigatorio

#Cenario: Nao deve inserir uma conta com nome ja existente
#E informo a conta "Conta mesmo nome"
#E seleciono Salvar
#Entao sou notificado que ja existe uma conta com esse nome

