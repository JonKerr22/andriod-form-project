package com.example.form_to_qr

import android.graphics.BitmapFactory
import android.graphics.BitmapFactory.decodeStream
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL
import java.util.Base64
import org.apache.commons.mail.*


class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
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
            val encodedFormString = Base64.getEncoder().encodeToString(formJsonString.toByteArray())

            val newImgUrl = "https://api.qrserver.com/v1/create-qr-code/?size=150x150&data="
            val newImgSrc = newImgUrl + encodedFormString
            val testImgLink = newImgUrl + formJsonString

            try{

                //it just crashes idk why, fucking shit
                SimpleEmail().apply {
                    hostName = "smtp.googlemail.com"
                    setSmtpPort(465)
                    setAuthenticator(DefaultAuthenticator("jrkerr22@gmail.com", "wownerd2"))
                    isSSLOnConnect = true
                    setFrom("jrkerr22@gmail.com")
                    subject = "test subject"
                    setMsg(testImgLink)
                    addTo("jon@homefieldcannabis.com")
                }.send() // will throw email-exception if something is wrong

                val success = true
                /*HtmlEmail().apply{
                    hostName = "smtp.office365.com"
                    setSmtpPort(587)
                    setAuthenticator(DefaultAuthenticator("jon@homefieldcannabis.com", "KyrAD70g3V3Cw10"))
                    //isSSLOnConnect = true
                    setFrom("jon@homefieldcannabis.com")
                    subject = "test send"
                    setHtmlMsg(testImgLink)
                    addTo("jrkerr22@gmail.com")
                }.send()*/
            }
            catch (e: Exception){
                var bkpnttt = true
            }



            //THESE WERE the attempt to replace the imageview placeholder, am skipping for now tho
            //Picasso.get().load("https://api.qrserver.com/v1/create-qr-code/?size=50x50&amp;data=rjsgnurnguiregh45nujnfun43onfs").resize(50,50).into(qrimgplace)

            //var imgURI = Uri.parse(newImgSrc)
            //var url = URL(newImgSrc)
            //var inStream = url.openStream()
            //val bmp = decodeStream(inStream)
            //var urlTest = URL
            //imgURI.in
            //var test = BitmapFactory.
            //val bmp = BitmapFactory.decodeStream(imgURI.)
            //qrimgplace.setImageBitmap(bmp)
            //qrimgplace.setImageURI(imgURI)

            val bkpnt = true
        }

22
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
