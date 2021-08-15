package com.example.login_mvvm


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityModel : ViewModel() {

    val mData = Data()
    
    //    private var mText = MutableLiveData<String>().apply { value = "Meu mundo" }
    //    outra maneira de atluzar o valor do meu textWelcome
    private var mTextWelcome = MutableLiveData<String>()
    var textWelcomeProvider = mTextWelcome
    private var mHaveName = MutableLiveData<Boolean>()
    var haveNameProvider = mHaveName

    // ideia do init e que ela e instanciada assim que inicia classe,
    //seria uma funcao auto chamada
    init {
        mTextWelcome.value = "Bem vindo"
    }

    fun login(name: String) {
        val response = mData.status(name)
        mHaveName.value = response

    }


}