package com.example.xofome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.example.xfome.databinding.ActivityCadastroBinding

class CadastroActivity : AppCompatActivity() {
    lateinit var binding: ActivityCadastroBinding
    lateinit var dbRef: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var edNomeLocal = binding.edLocal
        var edBairro = binding.edBairro
        var edDescricao = binding.edDescricao
        var bt = binding.botao

        dbRef = FirebaseDatabase.getInstance().getReference("Lugar")

        bt.setOnClickListener {
            val empNomeLocal = edNomeLocal.text.toString()
            val empBairro = edBairro.text.toString()
            val empDescricao = edDescricao.text.toString()

            if(empNomeLocal.isEmpty()){
                edNomeLocal.error = "Insira o nome do local"
            }
            if(empBairro.isEmpty()){
                edBairro.error = "Insira o nome do bairro"
            }
            if(empDescricao.isEmpty()){
                edDescricao.error = "Insira uma descrição"
            }
            if((!empBairro.isEmpty())&&(!empNomeLocal.isEmpty())&&(!empDescricao.isEmpty())){
                val empId = dbRef.push().key!!
                val lugar = LugarModelo(empId,empNomeLocal,empBairro,empDescricao)
                dbRef.child(empId).setValue(lugar)
                    .addOnCompleteListener{
                        Toast.makeText(this, "Cadastro completo",Toast.LENGTH_SHORT).show()

                        edNomeLocal.text.clear()
                        edBairro.text.clear()
                        edDescricao.text.clear()
                    }.addOnFailureListener {err->
                        Toast.makeText(this,"Error ${err.message}",Toast.LENGTH_SHORT).show()
                    }
            }
        }

    }
}