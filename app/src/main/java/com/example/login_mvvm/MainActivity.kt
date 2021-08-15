package com.example.login_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mainModel: MainActivityModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainModel = ViewModelProvider(this).get(MainActivityModel::class.java)
        mainModel.textWelcomeProvider.observe(this, {
            textWelcome.text = it
        })
        mainModel.haveNameProvider.observe(this, {
            //estamos usando aplicationContext,porque o this pode gerar problema
            //no contexto do observe
            if (it == true) {
                Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Precisa colcoar o nome", Toast.LENGTH_SHORT)
                    .show()
            }
        })
        buttonProceed.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id;
        val name = textName.text.toString();
        if (id == R.id.buttonProceed) {
            mainModel.login(name)
        }
    }

}