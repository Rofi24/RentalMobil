package com.example.rentalmobil.data


import com.example.rentalmobil.model.Mobil
import kotlinx.coroutines.flow.Flow
interface MobilRepository {
    fun getAll(): Flow<List<Mobil>>
    suspend fun save(mobil: Mobil): String
    suspend fun update(mobil: Mobil)
    suspend fun delete(mobilId: String)
    fun getMobilById(mobilId: String): Flow<Mobil>
}
