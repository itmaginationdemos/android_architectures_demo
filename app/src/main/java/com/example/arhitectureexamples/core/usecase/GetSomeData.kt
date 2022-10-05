package com.example.arhitectureexamples.core.usecase

import com.example.arhitectureexamples.core.repo.DataRepository

class GetSomeData(
    private val repo: DataRepository
) {

    suspend operator fun invoke(): String {
        return repo.getData()
    }
}
