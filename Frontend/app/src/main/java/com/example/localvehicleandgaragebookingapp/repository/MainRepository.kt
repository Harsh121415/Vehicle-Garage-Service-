package com.example.localvehicleandgaragebookingapp.repository

import com.example.localvehicleandgaragebookingapp.data.model.Complaint
import com.example.localvehicleandgaragebookingapp.data.model.ComplaintStorage

class MainRepository {
    fun getComplaints(): List<Complaint> {
        return ComplaintStorage.complaintList
    }
    fun addComplaint(complaint: Complaint) {
        ComplaintStorage.complaintList.add(complaint)
    }
    fun deleteComplaint(complaint: Complaint) {
        ComplaintStorage.complaintList.remove(complaint)
    }
}
