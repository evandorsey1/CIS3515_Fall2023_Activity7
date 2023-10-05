package edu.temple.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


const val REQUEST_CODE_TEXT_SIZE = 1
class DisplayActivity : AppCompatActivity() {

    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value



    // TODO Step 3: Use returned value for lyricsDisplayTextView text size

    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        findViewById<Button>(R.id.textSizeSelectorButton).setOnClickListener{
            val launchIntent = Intent(this@DisplayActivity, TextSizeActivity::class.java)
            startActivityForResult(launchIntent, REQUEST_CODE_TEXT_SIZE)

        }
    }

    override fun onActivityResult(requestCode: Int, returnCode: Int, data : Intent?) {
        super.onActivityResult(requestCode, returnCode, data)
        if (requestCode == REQUEST_CODE_TEXT_SIZE && returnCode == Activity.RESULT_OK){
            val selectedTextSize = data?.getIntExtra("selectedTextSize", 16) ?: 16
            lyricsDisplayTextView.textSize =selectedTextSize.toFloat()
        }
    }


    }


