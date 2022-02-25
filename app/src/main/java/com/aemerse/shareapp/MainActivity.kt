package com.aemerse.shareapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.aemerse.share.SharableItem
import com.aemerse.share.Share
import com.aemerse.shareapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.share.setOnClickListener {
            Share.with(context = this)
                .item(SharableItem(
                    pictureUrl = null,
                    data = binding.textView.text.toString(),
                    shareAppLink = true,
                    downloadOurAppMessage = "Download our app"
                ),
                    onStart = {
                        Log.d(TAG, "onStart Sharing")
                    },
                    onFinish = { isSuccessful: Boolean, errorMessage: String ->
                        // if isSuccessful you will see an intent chooser else check the error message
                        when {
                            isSuccessful -> {
                                Log.e(TAG, "Successfully shared")
                            }
                            else -> {
                                Log.e(TAG, "error happened : $errorMessage")
                            }
                        }
                    }
                )
        }
    }
}