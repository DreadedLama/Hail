package com.dreadedlama.hidemyapps.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.dreadedlama.hidemyapps.work.HWork

class ScreenOffReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_SCREEN_OFF) {
            HWork.setAutoFreeze(true)
        }
    }
}