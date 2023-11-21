package uz.itschool.mathkidsnew.screens.questionscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.mariuszgromada.math.mxparser.Expression
import uz.itschool.mathkidsnew.R
import kotlin.random.Random

val SIGNS = listOf('+', '-', '*', '/')

@Composable
fun QuestionScreen(navController: NavController) {
    val equation = remember { generateEquation() }
    val answer = remember { equation.calculate() }
    var userGuess by remember { mutableStateOf("") }
    var resultMessage by remember { mutableStateOf("") }
    Box(
        modifier = with(Modifier) {
            fillMaxSize()
                .paint(
                    painterResource(id = R.drawable.questions_img),
                    contentScale = ContentScale.Crop
                )

        })
    {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "$equation", color = Color.White, fontSize = 45.sp)
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.plus_btn), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable {
                            navController.navigate("question_screen")
                            userGuess = "+"
                        }
                        .height(80.dp)
                        .width(80.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.minus_btn), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable {
                            navController.navigate("question_screen")
                            userGuess = "-"
                        }
                        .height(80.dp)
                        .width(80.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.multi_btn), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable {
                            navController.navigate("question_screen")
                            userGuess = "*"
                        }
                        .height(80.dp)
                        .width(80.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.div_btn), contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable {
                            navController.navigate("question_screen")
                            userGuess = "/"
                            resultMessage = evaluateAndDisplayResult(userGuess, answer)
                        }
                        .height(80.dp)
                        .width(80.dp)
                )
            }
        }
    }

}
fun evaluateAndDisplayResult(userGuess: String, answer: Double): String {
    if (userGuess in SIGNS) {
        val expression = Expression(equation.replace(" ", userGuess))
        if (expression.calculate() == answer) {
            return "Correct!"
        } else {
            return "Incorrect."
        }
    } else {
        return "Invalid input."
    }
}
fun generateEquation(): Expression {
    val a = (1..9).random()
    val b = (1..9).random()
    return Expression("$a + $b")
}
