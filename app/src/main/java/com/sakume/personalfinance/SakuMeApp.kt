package com.sakume.personalfinance

import android.app.Application
import com.sakume.personalfinance.data.ScheduleWorker
import com.sakume.personalfinance.ui.Notify

class SakuMeApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Notify.ensureChannel(this)
        // Jadwalkan worker periodik untuk proses gaji & setor investasi otomatis
        ScheduleWorker.enqueue(this)
    }
}
