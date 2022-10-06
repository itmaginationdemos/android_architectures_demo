package com.example.arhitectureexamples.core.usecase

import com.example.arhitectureexamples.core.repo.DataRepositoryImpl

class GetSomeDataImpl(
    private val repo: DataRepositoryImpl
) : GetSomeData {

    override suspend operator fun invoke(): String {
        return repo.getData()
    }
}
