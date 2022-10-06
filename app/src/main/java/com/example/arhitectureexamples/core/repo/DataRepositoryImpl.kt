package com.example.arhitectureexamples.core.repo

import kotlinx.coroutines.delay

class DataRepositoryImpl : DataRepository {

    override suspend fun getData(): String {
        delay(2000)
        return "data"
    }
}
