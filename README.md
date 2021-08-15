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


Kotlin tem um recurso interessante que e conhecido em algumas linguagens como expresso auto-invocadora</br>
Principio seria iniciar algo sem precisar instanciar ou ser invocada, no exemplo usamos o init, todo escopo dentro do init e invocado assim que a classe e iniciada


```kotlin
     init {
        mTextName.value = "Seja Bem vindo"
    }
 
```

Para instanciar uma classe no topo da aplicação que precisa do contexto você normalmente utiliza  lateinit e depois realmente instancia ela, porque no ciclo do android
contexto  só existe dentro do onCreate. Utilizando MVVM precisamos instanciar diferente de outras classes que precisam de contexto. Fica evidente na instancia em
mainModel = ViewModelProvider </br>
Outro ponto interessante e o método observe, eles são responsáveis para atualizar os dados que sofrem alteração nas view que abstrai esse método

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
Ciclo de vida do Android esta logo abaixo, onCreate,onStart,onResume,onStop,onDestroy. Motivo que não conseguimos contexto quando instanciamos uma classe no topo da hierarquia
e pelo motivo do ciclo de vida do android, inicia no onCreate. Quando deseja eliminar uma activy  você utiliza o método onDestroy, apos este método ser chamado,
SO consegue acessar novamente a view que foi destruído, limpando os storage do celular, porque método onDestroy  limpa na memória a activy e não só poderá ser vista novamente só apos o método
onCreate ser chamado. Se não usar o método onDestroy, quando você sai de uma activy e volta quem inicia aplciacao e o metodo onStart.



![ciclo de vida](https://developer.android.com/images/topic/libraries/architecture/viewmodel-lifecycle.png?hl=pt-br)



# Feature

- XML
- Funcoes
- Controle de fluxos
- MVVM
