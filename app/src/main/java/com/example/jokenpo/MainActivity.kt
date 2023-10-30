package com.example.jokenpo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.ImageButton
import android.widget.Toast
import com.example.jokenpo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {
    lateinit var binding: ActivityMainBinding
    lateinit var listarBotoes: List<ImageButton>

    var pointsCpu:Int = 0
    var pointsUser:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        list_of_buttons()
    }

    override fun onClick(button: View?) {
        when(button?.id){
            binding.tesourabtn.id -> {
                binding.minhaEscolha.setText("Sua Escolha: TESOURA")
                choicePlayer("Tesoura")
            }
            binding.papelbtn.id -> {
                binding.minhaEscolha.setText("Sua Escolha: PAPEL")
                choicePlayer("Papel")
            }
            binding.pedrabtn.id -> {
                binding.minhaEscolha.setText("Sua Escolha: PEDRA")
                choicePlayer("Pedra")
            }
            binding.novaPartidabtn.id -> {
                binding.minhaEscolha.setText("Sua Escolha: ")
                binding.escolhaCpu.setText("Escolha da CPU: ")
                binding.placar.setText("0 x 0")
            }
        }
    }

    private fun list_of_buttons(){
        listarBotoes = listOf(binding.tesourabtn, binding.papelbtn, binding.pedrabtn)
        listarBotoes.forEach { botao ->
            botao.setOnClickListener(this)
        }
        binding.novaPartidabtn.setOnClickListener(this)
    }
    private fun generateChoiceCpu(): String {
        val options = arrayOf("Pedra", "Papel", "Tesoura")
        val random = (0..2).random()
        return options[random]
    }

    private fun choicePlayer(minhaEscolha: String){
        val escolhaCpu = generateChoiceCpu()
        binding.escolhaCpu.setText("Escolha da CPU: ${escolhaCpu.uppercase()}")

        if (escolhaCpu.equals(minhaEscolha, true)){
            Toast.makeText(this, "Empate", Toast.LENGTH_SHORT).show()
        }else if(escolhaCpu == "Tesoura" && minhaEscolha == "Papel"){
            pointsCpu++
            binding.placar.setText("$pointsUser x $pointsCpu")
        }else if(escolhaCpu == "Papel" && minhaEscolha == "Pedra") {
            pointsCpu++
            binding.placar.setText("$pointsUser x $pointsCpu")
        }else if(escolhaCpu == "Pedra" && minhaEscolha == "Tesoura") {
            pointsCpu++
            binding.placar.setText("$pointsUser x $pointsCpu")
        }else if(escolhaCpu == "Papel" && minhaEscolha == "Tesoura") {
            pointsUser++
            binding.placar.setText("$pointsUser x $pointsCpu")
        }else if (escolhaCpu == "Pedra" && minhaEscolha == "Papel") {
            pointsUser++
            binding.placar.setText("$pointsUser x $pointsCpu")
        }else if (escolhaCpu == "Tesoura" && minhaEscolha == "Pedra") {
            pointsUser++
            binding.placar.setText("$pointsUser x $pointsCpu")
        }
    }
}