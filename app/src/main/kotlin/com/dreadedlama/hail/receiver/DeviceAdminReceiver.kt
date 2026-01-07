package com.dreadedlama.hail.receiver

import android.app.admin.DeviceAdminReceiver
import android.content.Context
import android.content.Intent
import com.dreadedlama.hail.R
import com.dreadedlama.hail.utils.HPolicy

class DeviceAdminReceiver : DeviceAdminReceiver() {
    override fun onEnabled(context: Context, intent: Intent) {
        super.onEnabled(context, intent)
        HPolicy.enableBackupService()
        HPolicy.setOrganizationName(context.getString(R.string.app_name))
    }
}