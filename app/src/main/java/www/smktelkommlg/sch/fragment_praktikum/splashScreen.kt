package www.smktelkommlg.sch.fragment_praktikum

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import www.smktelkommlg.sch.fragment_praktikum.databinding.SplashScreenBinding

class splashScreen {
    private fun splash(){
        val splashTime: Long = 3000 // lama splashscreen berjalan

        Handler().postDelayed({
            val intent = Intent(this@splashScreen,Fragment1::class.java)
            startActivity(intent)
            finish()
        }, splashTime)
    }
}