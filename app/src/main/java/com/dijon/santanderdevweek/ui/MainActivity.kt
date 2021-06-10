package com.dijon.santanderdevweek.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dijon.santanderdevweek.R
import com.dijon.santanderdevweek.data.Conta


class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.main_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()
    }

    private fun buscarContaCliente() {
        mainViewModel.buscarContaCliente().observe(
            this,
            Observer { result ->
                bindOnView(result)
            }
        )
    }

    private fun bindOnView(result: Conta) {
        findViewById<TextView>(R.id.tv_agencia).text = result.agencia
        findViewById<TextView>(R.id.tv_conta_corrente).text = result.numero
        findViewById<TextView>(R.id.tv_saldo).text = result.saldo
        findViewById<TextView>(R.id.tv_limite).text = result.limite
        findViewById<TextView>(R.id.tv_usuario).text = result.cliente.nome
        findViewById<TextView>(R.id.tv_cartao_final_value).text = result.cartao.numeroCartao
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_1 -> {
                Log.d(TAG, "click item 1");
                true
            }
            R.id.item_2 -> {
                Log.d(TAG, "click item 2");
                true
            }
            R.id.item_3 -> {
                Log.d(TAG, "click item 3");
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}