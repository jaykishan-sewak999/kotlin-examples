package com.example.kotlinexamples.flow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class FlowViewModel : ViewModel() {
    private val commentRepository = CommentRepository(APIConfig.ApiService())

    val apiResults = MutableStateFlow(APIResults(Status.NONE, Comment(), ""))
    fun getComments(id: Int){
        viewModelScope.launch {
            apiResults.value = APIResults.loading()
            commentRepository.getComments(id).catch {
                apiResults.value = APIResults.error(it.message)
            }.collect{
                apiResults.value = APIResults.success(it.data)
            }
        }
    }
}