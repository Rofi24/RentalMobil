package com.example.rentalmobil.data


import android.content.ContentValues
import android.util.Log
import com.example.rentalmobil.model.Mobil
import com.example.rentalmobil.model.Penyewa
import com.example.rentalmobil.ui.detail.DetailDestinationPenyewa.penyewaId
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

interface MobilRepository {
    fun getAll(): Flow<List<Mobil>>
    suspend fun save(mobil: Mobil): String
    suspend fun update(mobil: Mobil)
    suspend fun delete(mobilId: String)
    fun getMobilById(mobilId: String): Flow<Mobil>
}

class MobilRepositoryImpl(private val firestore: FirebaseFirestore) : MobilRepository {
    override fun getAll(): Flow<List<Mobil>> = flow {
        val snapshot = firestore.collection("Mobil")
            .orderBy("merk", Query.Direction.ASCENDING)
            .get()
            .await()
        val mobil = snapshot.toObjects(Mobil::class.java)
        emit(mobil)
    }.flowOn(Dispatchers.IO)


    override suspend fun save(mobil: Mobil): String {
        return try {
            val documentReference = firestore.collection("Mobil").add(mobil).await()
            // Update the Mobil with the Firestore-generated DocumentReference
            firestore.collection("Mobil").document(documentReference.id)
                .set(mobil.copy(id = documentReference.id))
            "Berhasil + ${documentReference.id}"
        } catch (e: Exception) {
            Log.w(ContentValues.TAG, "Error adding document", e)
            "Gagal $e"
        }
    }

    override suspend fun update(mobil: Mobil) {
        firestore.collection("Mobil").document(mobil.id).set(mobil).await()
    }

    override suspend fun delete(mobilId: String) {
        firestore.collection("Mobil").document(mobilId).delete().await()
    }

    override fun getMobilById(mobilId: String): Flow<Mobil> {
        return flow {
            val snapshot = firestore.collection("Mobil").document(mobilId).get().await()
            val mobil = snapshot.toObject(Mobil::class.java)
            emit(mobil!!)
        }.flowOn(Dispatchers.IO)
    }
}

interface PenyewaRepository {
    fun getAll(): Flow<List<Penyewa>>
    suspend fun save(penyewa: Penyewa): String
    suspend fun update(penyewa: Penyewa)
    suspend fun delete(penyewa: String)
    fun getPenyewaById(penyewaId: String): Flow<Penyewa>
}

class PenyewaRepositoryImpl(private val firestore: FirebaseFirestore) : PenyewaRepository {
    override fun getAll(): Flow<List<Penyewa>> = flow {
        val snapshot = firestore.collection("Penyewa")
            .orderBy("nama", Query.Direction.ASCENDING)
            .get()
            .await()
        val penyewa = snapshot.toObjects(Penyewa::class.java)
        emit(penyewa)
    }.flowOn(Dispatchers.IO)

    override suspend fun save(penyewa: Penyewa): String {
        return try {
            val documentReference = firestore.collection("Penyewa").add(penyewa).await()
            firestore.collection("Penyewa").document(documentReference.id)
                .set(penyewa.copy(id = documentReference.id))
            "Berhasil + ${documentReference.id}"
        } catch (e: Exception) {
            Log.w(ContentValues.TAG, "Error adding document", e)
            "Gagal $e"
        }
    }

    override suspend fun update(penyewa: Penyewa) {
        firestore.collection("Penyewa").document(penyewa.id).set(penyewa).await()
    }

    override suspend fun delete(penyewaId: String) {
        firestore.collection("Penyewa").document(penyewaId).delete().await()
    }

    override fun getPenyewaById(penyewaId: String): Flow<Penyewa> {
        return flow {
            val snapshot = firestore.collection("Penyewa").document(penyewaId).get().await()
            val penyewa = snapshot.toObject(Penyewa::class.java)
            emit(penyewa!!)
        }.flowOn(Dispatchers.IO)
    }
}