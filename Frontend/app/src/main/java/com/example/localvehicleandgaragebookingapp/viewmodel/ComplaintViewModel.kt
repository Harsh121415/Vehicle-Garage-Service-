package com.example.localvehicleandgaragebookingapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.localvehicleandgaragebookingapp.data.model.Complaint
import com.example.localvehicleandgaragebookingapp.repository.MainRepository

class ComplaintViewModel : ViewModel() {

    private val repository = MainRepository()


    private val _complaints = MutableStateFlow<List<Complaint>>(emptyList())
    val complaints: StateFlow<List<Complaint>> = _complaints

    init {
        loadComplaints()
    }

    private fun loadComplaints() {
        _complaints.value = repository.getComplaints()
    }

    fun addComplaint(title: String, description: String) {
        val complaint = Complaint(title, description)
        repository.addComplaint(complaint)
        loadComplaints() // 🔥 refresh
    }

    fun deleteComplaint(complaint: Complaint) {
        repository.deleteComplaint(complaint)
        loadComplaints() // 🔥 refresh
    }
}