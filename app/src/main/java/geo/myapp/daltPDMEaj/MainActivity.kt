package geo.myapp.daltPDMEaj

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import geo.myapp.daltPDMEaj.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var t1 = "0"
    var t2 = "0"
    var t3 = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        val i = Intent(this, MainActivityTeste::class.java)
        var bundle = Bundle()
        binding.apply {
            teste1.setOnClickListener {
                i.putExtra("teste", "teste1")
                val requestcode = 1
                //t1 = resTeste1.text.toString()
                startActivityForResult (i, requestcode)
            }

            teste2.setOnClickListener {
                i.putExtra("teste", "teste2")
                val requestcode = 2
                //t2 = resTeste2.text.toString()
                startActivityForResult (i, requestcode)
            }

            teste3.setOnClickListener {
                i.putExtra("teste", "teste3")
                val requestcode = 3
                //t3 = resTeste3.text.toString()
                startActivityForResult (i, requestcode)
            }

            result.setOnClickListener {
                if(t1=="0"||t2=="0"||t3=="0"){
                    Toast.makeText(applicationContext, "Necessario mais testes!", Toast.LENGTH_SHORT).show()
                }else if(t1=="29"&&t2=="74"&&t3=="2"){
                    resultTeste.text = "Visão Normal"
                    binding.invalidateAll()
                }else{
                    resultTeste.text = "Daltônico, Procure um médico"
                    binding.invalidateAll()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(resultCode){
            Activity.RESULT_OK -> {
                when(requestCode){
                    1 -> {
                        t1 = data?.extras?.getString("resposta").toString()
                    }2 -> {
                        t2 = data?.extras?.getString("resposta").toString()
                    }3 -> {
                        t3 = data?.extras?.getString("resposta").toString()
                    }
                }
                binding.resTeste1.text = t1
                binding.resTeste2.text = t2
                binding.resTeste3.text = t3
            }
            Activity.RESULT_CANCELED -> {
                Toast.makeText(applicationContext, "Você cancelou o teste!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}