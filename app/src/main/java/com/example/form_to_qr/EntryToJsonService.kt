package com.example.form_to_qr

import com.google.gson.Gson


class EntryToJsonService {

    fun EntryToJson(entry: EntryForm): String{
        return Gson().toJson(entry)
    }

    //TODO - turn a string into a hash/256bit thingy, idk what its called
}