package com.example.form_to_qr

import java.util.Date

class EntryForm {
    private var entryDate : String? = null
    private var entryNotes: String? = null


    fun setDate(date: String){ this.entryDate = date }
    fun getDate(): String? { return  this.entryDate }
    fun setNotes(notes: String) { this.entryNotes = notes }
    fun getNotes(): String? { return this.entryNotes }
}

