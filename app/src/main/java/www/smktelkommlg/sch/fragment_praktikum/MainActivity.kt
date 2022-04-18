package www.smktelkommlg.sch.fragment_praktikum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import android.os.Handler
import www.smktelkommlg.sch.fragment_praktikum.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Communicator {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Replace Main Activity content with the Fragment1 content
        val fragment1 = Fragment1()
        supportFragmentManager.beginTransaction().replace(R.id.content_id, fragment1).commit()

        val splashTime: Long = 3000 // lama splashscreen berjalan

        Handler().postDelayed({
            val intent = Intent(this, Fragment1::class.java)
            startActivity(intent)
            finish()
        }, splashTime)
    }
    override fun passDataCom(editTextInput: String) {
        val bundle = Bundle()
        bundle.putString("input_txt", editTextInput)

        val transaction = this.supportFragmentManager.beginTransaction()
        val frag2 = Fragment2()
        frag2.arguments = bundle

        transaction.replace(R.id.content_id, frag2)
        transaction.addToBackStack(null)
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction.commit()
    }
}