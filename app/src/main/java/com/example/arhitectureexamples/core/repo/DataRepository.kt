package com.example.arhitectureexamples.core.repo

interface DataRepository {

    suspend fun getData(): String
}
