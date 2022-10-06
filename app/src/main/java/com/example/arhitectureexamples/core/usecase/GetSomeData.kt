package com.example.arhitectureexamples.core.usecase

interface GetSomeData {
    suspend operator fun invoke(): String
}
