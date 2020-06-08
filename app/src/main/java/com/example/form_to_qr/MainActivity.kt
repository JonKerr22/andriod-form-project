package com.example.form_to_qr

import android.media.Image
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.sql.Date

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)



        val entry_date = findViewById<EditText>(R.id.entry_date)
        val entry_notes = findViewById<EditText>(R.id.entry_notes)
        val getqrbtn = findViewById<Button>(R.id.generate_qr_btn)
        val qrimgplace = findViewById<ImageView>(R.id.qr_placeholder)


        getqrbtn.setOnClickListener{
            var entryFromObj = EntryForm()
            var formConverter = EntryToJsonService()

            entryFromObj.setDate(entry_date.text.toString())
            entryFromObj.setNotes(entry_notes.text.toString())

            val formJsonString = formConverter.EntryToJson(entryFromObj)

            Toast.makeText(this@MainActivity, formJsonString, Toast.LENGTH_SHORT).show()
            val bkpnt = true;
        }


        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
