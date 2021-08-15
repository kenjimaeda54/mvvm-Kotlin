# mvvm-Kotlin

Arquitetura MVVM </br>

Projeto simples para entender o principio da arquitetura MVVM(Model-View-ViewModel)</br>
E um padrão de design de arquitetura com principio desacoplamento das interfaces e codigos, que nao sao da interface do usuario


## Tabelas de conteúdos

- Visão geral
  - <a href='#Desafio' > Desafio </a>
  - <a href='#o-que-eu-aprendi' > Aprendizado </a>
  - <a href='#Feature' > Feature </a>

## Visão Geral

## Desafio

- Enteder e praticar os conceitos da arquitetura MVVM 


## O que eu aprendei

Aprendi a usar o principio da arquitetura MVVM,fortaleci alguns conceitos 


Kotlin tem um recurso interesante que e conhecido em algumas lingaugens como expresao auto-invocadora</br>
Principio seria iniciar algo sem precisar instanciar ou ser invocada,no exemplo usamos o init, todo escopo dentro do init e invocado assim que a classe e iniciada


```kotlin
     init {
        mTextName.value = "Seja Bem vindo"
    }
 
```

Para instanciar uma classe no topo da aplicaao que precisa do contexto voce normalmente utliza lateinit e depois realmetne instancia ela,porque no ciclo do android
context oso existe dentro do onCreate. Utilizando MVVM preicisamos instanciar diferente de outras classes que precisam de contexto. Fica evidente na insancia em 
mainModel = ViewModelProvider </br>
Outro ponto interesante e o metodo observe,eles sao responsaveis para atualizar os dados que sofrem alteracao nas view que abstrai esse metodo

```kotlin
   class MainActivity : AppCompatActivity(), View.OnClickListener {
        private lateinit var mainModel: MainActivityModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonProceed.setOnClickListener(this)
        mainModel = ViewModelProvider(this).get(MainActivityModel::class.java)
        mainModel.textNameModel.observe(this, {
            textWelcome.text = it
        })
        mainModel.mHaveNameModel.observe(this, {
            //estamos usando aplicationContext,porque o this pode gerar problema
            //no contexto do observe
            if (it) {
                Toast.makeText(this, "Sucesso", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Precisa colcocar o nome", Toast.LENGTH_LONG).show()
            }
        })

    }
  }  
```
Ciclo de vida do Android esta logo abaixo, onCreate,onStart,onResume,onStop,onDestroy. MOtivo que nao conseguimos contexto quando instaciamos uma classe no topo da hirarquia
e pelo motivo do ciclo de vida do android, inicia no onCreate. Quando deseja eliminar uma activy voce utiliza o metodo onDestroy,apos este metodo ser chamado,
so consegue acessar novamente a view que foi destruido,limpando os storage do celular,porque metodo onDestroy  limpa na meoria a activy e nao so podera ser vista novamente so apos o metodo
onCreate ser chamado. Se nao usar o metodo onDestroy,quando voce sai de uma activy e volta quem inicia aplciacao e o metodo onStart.

```kotlin

[ciclo de vida](https://developer.android.com/images/topic/libraries/architecture/viewmodel-lifecycle.png?hl=pt-br)


```





 

# Feature

- XML
- Funcoes
- Controle de fluxos
- Shared Preferences
- Navegacao
