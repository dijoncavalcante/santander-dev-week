package com.dijon.santanderdevweek.data.local

import com.dijon.santanderdevweek.data.Cartao
import com.dijon.santanderdevweek.data.Cliente
import com.dijon.santanderdevweek.data.Conta

class FakeData {

    fun getLocalData(): Conta {
        val cliente = Cliente("Dijon Braga")
        val cartao = Cartao("542542542")
        return Conta(
            "733333-5",
            "6553-6",
            "R$ 5.555,90",
            "R$ 4.345,00",
            cliente,
            cartao
        )
    }
}