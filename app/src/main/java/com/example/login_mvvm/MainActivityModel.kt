package com.example.login_mvvm


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityModel : ViewModel() {

    private val mData = Data()

    //    private var mText = MutableLiveData<String>().apply { value = "Meu mundo" }
    //    outra maneira de atluzar o valor do meu textWelcome
    private val mTextName = MutableLiveData<String>()
    var textNameModel = mTextName
    private val mHaveName = MutableLiveData<Boolean>()
    var mHaveNameModel = mHaveName;

    // ideia do init e que ela e instanciada assim que inicia classe,
    //seria uma funcao auto chamada
    init {
        mTextName.value = "Seja Bem vindo"
    }

    fun logIn(name: String) {
        val response = mData.statusLogin(name)
        mHaveName.value = response

    }


}