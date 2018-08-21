package dvt.com.apps

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dvt.com.mlkit.LivePreviewActivity
import dvt.com.mlkit.R
import dvt.com.mlkit.databinding.ActivityMainBinding
import dvt.com.tflite.CameraActivity
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding.root.tvTFlite.setOnClickListener {
            startActivity(Intent(this, CameraActivity::class.java))
        }

        binding.root.tvMLKit.setOnClickListener {
            startActivity(Intent(this, LivePreviewActivity::class.java))
        }
    }

}
