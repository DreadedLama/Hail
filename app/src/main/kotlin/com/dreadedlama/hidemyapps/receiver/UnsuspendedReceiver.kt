package com.dreadedlama.hidemyapps.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.dreadedlama.hidemyapps.HailApp.Companion.app
import com.dreadedlama.hidemyapps.utils.HShizuku.setAppRestricted
import com.dreadedlama.hidemyapps.utils.HTarget

class UnsuspendedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == ACTION_PACKAGE_UNSUSPENDED_MANUALLY) runCatching {
            if (HTarget.P) setAppRestricted(
                intent.getStringExtra(Intent.EXTRA_PACKAGE_NAME)!!,
                false
            )
            app.setAutoFreezeService()
        }
    }

    companion object {
        private const val ACTION_PACKAGE_UNSUSPENDED_MANUALLY =
            "android.intent.action.PACKAGE_UNSUSPENDED_MANUALLY"
    }
}