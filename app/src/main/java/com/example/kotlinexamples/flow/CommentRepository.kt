package com.example.kotlinexamples.flow

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher

class CommentRepository(val apiServices: ApiServices) {
    suspend fun getComments(id: Int): Flow<APIResults<Comment>>{
        return flow {
            val comment = apiServices.getComments(id)

            emit(APIResults(status = Status.SUCCESS, comment, null))
        }.flowOn(Dispatchers.IO)
    }
}