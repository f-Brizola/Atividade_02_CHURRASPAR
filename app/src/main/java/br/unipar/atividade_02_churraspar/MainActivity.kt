package br.unipar.atividade_02_churraspar

import android.icu.text.DecimalFormat
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val numeroHomens = findViewById<EditText>(R.id.edHomens)
        val numeroMulheres = findViewById<EditText>(R.id.edMulheres)
        val numeroCrincas = findViewById<EditText>(R.id.edCriancas)
        val botaoCalcular = findViewById<Button>(R.id.btnCalcular)
        val numeroPessoas = findViewById<TextView>(R.id.txtNumeroPessoas)
        val quantidadeCarne = findViewById<TextView>(R.id.txtQuatCarne)
        val quantidadeAperitivo = findViewById<TextView>(R.id.txtQuantAperitivo)
        val totalCarne = findViewById<TextView>(R.id.txtTotalCarne)
        val quantidadeCerveja = findViewById<TextView>(R.id.txtQuantCerveja)
        val quantidadeAgua = findViewById<TextView>(R.id.txtQuantAgua)
        val quantidadeRefri = findViewById<TextView>(R.id.txtQuantRefri)
        val totalLitroBebidas = findViewById<TextView>(R.id.txtTotalLitros)
        val botaoLimparTela = findViewById<Button>(R.id.btnLimpar)


        numeroHomens.setText("0")
        numeroMulheres.setText("0")
        numeroCrincas.setText("0")


        val bebida = DecimalFormat("0.0")


        botaoCalcular.setOnClickListener {

            val numHomen = numeroHomens.text.toString()
            val numMulher = numeroMulheres.text.toString()
            val numCrianca = numeroCrincas.text.toString()

            if (numHomen.isNotEmpty() || numMulher.isNotEmpty() || numCrianca.isNotEmpty()){

                val homens = numHomen.toInt()
                val mulher = numMulher.toInt()
                val cria = numCrianca.toInt()

                // Numero de Pessoas

                var numPessoa = homens + mulher + cria
                numeroPessoas.setText("Realizamos o cauculo para $numPessoa participantes")


                //-----------COMIDA------------//

                // Quantidade de Carne

                var carneHo = homens * 400
                var carneMu = mulher * 300
                var carneCri = cria * 200
                var carneTotal = carneHo + carneMu + carneCri
                var carneExtra = carneTotal * 0.10
                var carneTotalComExtra = carneTotal + carneExtra
                quantidadeCarne.setText("${carneTotal}g Carne   ${carneExtra}g Extra")


                // Quantidade de Aperitivo

                var aperiHo = homens * 150
                var aperiMu = mulher * 100
                var apericri = cria * 50
                var aperiTotal = aperiHo + aperiMu + apericri
                var aperiExtra = aperiTotal * 0.10
                var aperiTotalComExtra = aperiTotal + aperiExtra
                quantidadeAperitivo.setText("${aperiTotal}g Aperitovo   ${aperiExtra}g Extra")

                // Total Carne

                var totalCarneComAperi = carneTotalComExtra + aperiTotalComExtra
                totalCarne.setText("${totalCarneComAperi}g TOTAL")


                //-----------BEBIDA---------//

                // Cerveja

                var cevejaHo = homens * 4
                var cevejaMu = mulher * 2
                var cervejaTota = cevejaHo + cevejaMu
                var cervejaExtra = cervejaTota * 0.10
                var cervejaExtraformatado = cervejaTota * 100
                var cerevejaTotalComExtra = cervejaTota + cervejaExtra
                quantidadeCerveja.setText("${cervejaTota}L Cerveja  ${cervejaExtraformatado}ml Extra")


                // Agua

                var aguaMu = mulher * 2
                var aguacri = cria * 2
                var aguaTotal = aguaMu + aguacri
                var aguaExtra = aguaTotal * 0.10
                var aguaExtraFormatada = aguaTotal * 100
                var aguaTotalComExtra = aguaTotal + aguaExtra
                quantidadeAgua.setText("${aguaTotal}L Água  ${aguaExtraFormatada}ml Extra")


                // Refrigerante

                var refriMu = mulher * 1.5
                var refricri = cria * 1.5
                var refriTota = refriMu + refricri
                var refriExtra = refriTota * 0.10
                var refriExtraFormatado = refriTota * 100
                var refriTotalComExtra = refriTota + refriExtra
                quantidadeRefri.setText("${refriTota}L Refrigerante ${refriExtraFormatado}ml Extra")


                // Total Bebida

                var totalBebidas = cerevejaTotalComExtra + aguaTotalComExtra + refriTotalComExtra
                totalLitroBebidas.setText("${bebida.format(totalBebidas)}Litros TOTAL")

            }

        }


        botaoLimparTela.setOnClickListener {

            numeroHomens.setText("0")
            numeroMulheres.setText("0")
            numeroCrincas.setText("0")
            numeroPessoas.setText("Numero de Participantes")
            quantidadeCarne.setText("Carne")
            quantidadeAperitivo.setText("Aperitivo")
            totalCarne.setText("TOTAL")
            quantidadeCerveja.setText("Cerveja")
            quantidadeAgua.setText("Água")
            quantidadeRefri.setText("Refrigerante")
            totalLitroBebidas.setText("Total em Litros")
        }

    }
}