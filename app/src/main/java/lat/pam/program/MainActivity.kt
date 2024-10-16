package lat.pam.program

import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import lat.pam.program.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val viewModel: ScoreViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi Data Binding
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this  // Agar data binding dapat mengamati LiveData

        // Deklarasi tombol dan animasi di dalam onCreate
        val button = findViewById<Button>(R.id.button_add)
        val anim = AnimationUtils.loadAnimation(this, R.anim.button_animation)

        // Set onClickListener dengan binding.buttonAdd
        binding.buttonAdd.setOnClickListener {
            it.startAnimation(anim) // Start animasi pada tombol
            viewModel.incrementScore() // Tambah skor
        }
    }
}
