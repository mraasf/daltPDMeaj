package geo.myapp.daltPDMEaj

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import geo.myapp.daltPDMEaj.databinding.ActivityMainTesteBinding

class MainActivityTeste : AppCompatActivity() {
    lateinit var binding:ActivityMainTesteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_teste)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_teste)

        val param = Bundle()
        val i = Intent(this, MainActivity::class.java)
        binding.apply {
            var teste = intent.getStringExtra("teste")
            when(teste) {
                "teste1" -> {
                    imageView.setImageResource(R.drawable.teste1)
                }
                "teste2" -> {
                    imageView.setImageResource(R.drawable.teste2)
                }
                else -> {
                    imageView.setImageResource(R.drawable.teste3)
                }
            }
            ok.setOnClickListener {
                if(!resp.text.isEmpty()){
                    param.putString("resposta", resp.text.toString())
                    i.putExtras(param)
                    setResult(Activity.RESULT_OK, i)
                    finish()
                }else{
                    Toast.makeText(applicationContext, "Campo resposta vazio!", Toast.LENGTH_SHORT).show()
                }
            }
            cancelar.setOnClickListener {
                setResult(Activity.RESULT_CANCELED)
                finish()
            }
        }
        //Log.i("POM","Tela 2");
        //Toast.makeText(, "", Toast.LENGTH_SHORT).show()
    }
}