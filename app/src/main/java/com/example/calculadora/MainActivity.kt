package com.example.calculadora
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.vista_simple.*
import org.w3c.dom.Text
import java.lang.Double
import kotlin.math.log
import kotlin.text.StringBuilder

class MainActivity : AppCompatActivity() {

    var nuevoOp = true
    lateinit var numeroViejo: String
    var operator = "+"
    var vistaOp = ""
    var botonPulsado = ""
    var resultado = 0.0
    var sb = StringBuilder()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vista_simple)



    }

    fun pulsaBoton(v: View){

        if(nuevoOp)
            textView.setText("")
        else {
            nuevoOp = false
            botonPulsado = textView.text.toString()
            var botonSeleccionado = v as Button
            when (botonSeleccionado.id) {
                btn0.id -> {
                    botonPulsado += btn0.text
                }
                btn1.id -> {
                    botonPulsado += btn1.text
                }
                btn2.id -> {
                    botonPulsado += btn2.text
                }
                btn3.id -> {
                    botonPulsado += btn3.text
                }
                btn4.id -> {
                    botonPulsado += btn4.text
                }
                btn5.id -> {
                    botonPulsado += btn5.text
                }
                btn6.id -> {
                    botonPulsado += btn6.text
                }
                btn7.id -> {
                    botonPulsado += btn7.text
                }
                btn8.id -> {
                    botonPulsado += btn8.text
                }
                btn9.id -> {
                    botonPulsado += btn9.text
                }
                button18.id -> {
                    botonPulsado += button18.text
                }
                button16.id -> {
                    botonPulsado += button16.text
                }
                btn0Binario.id -> {
                    botonPulsado += btn0Binario.text
                }
                btn1Binario.id -> {
                    botonPulsado += btn1Binario.text
                }
                btnA.id -> {
                    botonPulsado += btnA.text
                }
                btnB.id -> {
                    botonPulsado += btnB.text
                }
                btnC.id -> {
                    botonPulsado += btnC.text
                }
                btnD.id -> {
                    botonPulsado += btnD.text
                }
                btnE.id -> {
                    botonPulsado += btnE.text
                }
                btnF.id -> {
                    botonPulsado += btnF.text
                }

            }
        }
        textView.setText(botonPulsado)

    }




    fun pulsaOperador(v: View){

        numeroViejo = textView.text.toString()
        println("Numero Viejo: "+numeroViejo)
        //textView.setText("")
        var botonSeleccionado = v as Button
        when(botonSeleccionado.id){
            btnDividir.id -> {
                operator = "/"
                vistaOp = "/"
            }
            btnMas.id -> {operator = "+"
            vistaOp="+"}
            btnMenos.id -> {operator = "-"
            vistaOp="-"}
            btnPor.id -> {operator = "*"
            vistaOp="*"}
        }
        //textView.setText(numeroViejo.toString() + vistaOp.toString())
        textView.setText("")
    }
    fun pulsaBorrar(v: View){

        textView.setText("")
    }


    fun pulsaBinario(v:View){
        nuevoOp = true

        var cadena = textView.text.toString()//10+01 = 11


        //var nuevoNumero = obtenerNumeros(cadena)
        var nuevoNumero = textView.text.toString()
        //var nuevoNumero = "01"
        //numeroViejo = "10"
        var nuevoResultado = ""
        println(nuevoNumero)
        var viejoBinario = Integer.parseInt(numeroViejo, 2)
        var nuevoBinario = Integer.parseInt(nuevoNumero, 2)
        val valor = viejoBinario + nuevoBinario
        when(operator){
            "+" ->{//nuevoResultado = viejoBinario.toString() + nuevoBinario.toString()
                nuevoResultado = Integer.toBinaryString(valor)
            }
            "-" ->{nuevoResultado = Integer.toBinaryString(valor)}
            "*" ->{nuevoResultado = Integer.toBinaryString(valor)}
            "/" ->{nuevoResultado = Integer.toBinaryString(valor)}

        }
        //textView.setText(Integer.toBinaryString(Integer.parseInt(nuevoResultado)))
          textView.setText(nuevoResultado.toString())

    }
    fun pulsaHexa(v:View){
        nuevoOp = true
        var cadena = textView.text.toString()//10+01 = 11


        //var nuevoNumero = obtenerNumeros(cadena)
        var nuevoNumero = textView.text.toString()
        //var nuevoNumero = "01"
        //numeroViejo = "10"
        var nuevoResultado = ""
        println(nuevoNumero)
        var viejoBinario = Integer.parseInt(numeroViejo, 16)
        var nuevoBinario = Integer.parseInt(nuevoNumero, 16)
        val valor = viejoBinario + nuevoBinario
        when(operator){
            "+" ->{//nuevoResultado = viejoBinario.toString() + nuevoBinario.toString()
                nuevoResultado = Integer.toHexString(valor)
            }
            "-" ->{nuevoResultado = Integer.toHexString(valor)}
            "*" ->{nuevoResultado = Integer.toHexString(valor)}
            "/" ->{nuevoResultado = Integer.toHexString(valor)}

        }
        //textView.setText(Integer.toBinaryString(Integer.parseInt(nuevoResultado)))
        textView.setText(nuevoResultado.toString())

    }

    fun pulsaIgual(v:View){
        println("Hola")
        nuevoOp = true
       // var cadena = textView.text.toString()
        var numeroNuevo = textView.text.toString()
        println(numeroNuevo)
        //var numeroNuevo = obtenerNumeros(cadena)
        println(numeroNuevo.toString())//el problema esta en que al coger el numero ultimo me coge toda la linea y pues me da error, tengo que conseguir coger solo a partir del operator

        when(operator){
            "+" -> {resultado = numeroViejo.toDouble() + numeroNuevo.toDouble()}
            "-" -> {resultado = numeroViejo.toDouble() - numeroNuevo.toDouble()}
            "*" -> {resultado = numeroViejo.toDouble() * numeroNuevo.toDouble()}
            "/" -> {resultado = numeroViejo.toDouble() / numeroNuevo.toDouble()}

        }
        textView.setText(resultado.toString())
    }
    //arreglar esta funcion!!!!
    fun obtenerNumeros(s:String): String{
        //sb = StringBuilder()
        var op = false
        for (i in s.indices){
            println("DENTRO DEL FOR")
            var numero = true
            try{
                val num = Double.parseDouble(s[i].toString())
            }catch(e: NumberFormatException){
                numero = false
            }
            if(numero && op){
                sb.append(s[i].toString())
            }else{
                op = true
            }

        }
        println(sb.toString())
        return sb.toString()
    }
}