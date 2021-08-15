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

    override fun onClick(view: View) {
        val id = view.id
        val name = editName.text.toString();
        if (id == R.id.buttonProceed) {
            mainModel.logIn(name)
        }
    }


}