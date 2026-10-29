package com.finora.personalfinance

import android.app.Application
import com.finora.personalfinance.data.ScheduleWorker
import com.finora.personalfinance.ui.Notify

class DompetKuApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Notify.ensureChannel(this)
        // Jadwalkan worker periodik untuk proses gaji & setor investasi otomatis
        ScheduleWorker.enqueue(this)
    }
}
