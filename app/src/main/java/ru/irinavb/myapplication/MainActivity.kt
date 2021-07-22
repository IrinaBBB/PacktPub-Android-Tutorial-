package ru.irinavb.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate")
        Log.v(TAG, "onCreate")
        Log.i(TAG, "onCreate")
        Log.w(TAG, "onCreate")
        Log.e(TAG, "onCreate")
        Log.wtf(TAG, "onCreate")
    }

    companion object {
        private const val TAG = "Main Activity"
    }
}