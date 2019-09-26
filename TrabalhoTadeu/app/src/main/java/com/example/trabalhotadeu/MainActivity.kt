package com.example.trabalhotadeu
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun marcar(view: View){
        val buttonClicked = view as Button
        var idCell = 0

        when(buttonClicked.id){
            R.id.bt_1 -> idCell = 1
            R.id.bt_2 -> idCell = 2
            R.id.bt_3 -> idCell = 3
            R.id.bt_4 -> idCell = 4
            R.id.bt_5 -> idCell = 5
            R.id.bt_6-> idCell = 6
            R.id.bt_7 -> idCell = 7
            R.id.bt_8 -> idCell = 8
            R.id.bt_9 -> idCell = 9
        }
        //Toast.makeText(this, ("Id da celula: " + idCell), Toast.LENGTH_LONG).show()
        game(idCell, buttonClicked)



    }
    var playerAtivo = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var winner = 0
    var checked = 0



    private fun game(id:Int, v:Button ){

        var selectBt = v

        if(playerAtivo == 1){
            selectBt.setBackgroundResource(R.color.colorPrimary)
            selectBt.setText("X")
            player1.add(id)
            checkWinner()
            if(winner == 0) {
                playerAtivo = 2

            }else{
                return
            }

        }else{
            selectBt.setBackgroundResource(R.color.red)
            selectBt.setText("O")
            player2.add(id)
            checkWinner()
            if(winner == 0) {
                playerAtivo = 1
            }else{
                return
            }

        }
        v.isEnabled = false
    }

    private fun checkWinner(){

        checked++

         if(winner == 0) {
            if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
                winner = 1
            }
            if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
                winner = 1
            }
            if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
                winner = 1
            }

            if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
                winner = 1
            }
            if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
                winner = 1
            }
            if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
                winner = 1
            }

            if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
                winner = 1
            }
            if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
                winner = 1
            }
         }
        if(winner == 0) {
            if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
         }
            if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
         }
         if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
          }

            if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
         }
         if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
         }
            if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
             winner = 2
          }

        if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2
        }
        if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2
        }
    }

        if(winner != 0){
            Toast.makeText(this, "O vencendor foi o jogador $winner º", Toast.LENGTH_SHORT).show()

            disableAll()

    }else if(checked==9){
            Toast.makeText(this, "Deu velha", Toast.LENGTH_SHORT).show()
            disableAll()
        }



     if(winner == 0) {
    if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
        winner = 2
    }
    if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
        winner = 2
    }
    if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
        winner = 2
    }

    if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
        winner = 2
    }
    if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
        winner = 2
    }
    if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
        winner = 2
    }

    if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
        winner = 2
    }
    if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
        winner = 2
    }
}

if(winner != 0){
    Toast.makeText(this, "O vencendor foi o jogador $winner º", Toast.LENGTH_SHORT).show()
    disableAll()
}else if(checked==9){
            Toast.makeText(this, "Deu velha", Toast.LENGTH_SHORT).show()
            disableAll()
        }

}

    private fun disableAll() {
        bt_1.isEnabled = false
        bt_2.isEnabled = false
        bt_3.isEnabled = false
        bt_4.isEnabled = false
        bt_5.isEnabled = false
        bt_6.isEnabled = false
        bt_7.isEnabled = false
        bt_8.isEnabled = false
        bt_9.isEnabled = false


    }


    fun restart(view: View){
        val buttonClicked = view as Button
        when(buttonClicked.id) {
            R.id.bt_restart -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }


}
