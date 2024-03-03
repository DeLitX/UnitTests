package com.example.banks.datasource.network.dto

import com.example.banks.model.Bank

data class BankList(
    val results: Collection<Bank>
)
