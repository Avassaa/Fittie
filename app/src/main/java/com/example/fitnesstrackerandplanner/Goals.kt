package com.example.fitnesstrackerandplanner
import Exercise
import FirebaseHelper
import SubExercise
import android.icu.util.Calendar
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.test.core.app.ActivityScenario.launch
import com.example.fitnesstrackerandplanner.ui.theme.CharcoalGray
import com.example.fitnesstrackerandplanner.ui.theme.DarkRecyclerPurple
import com.example.fitnesstrackerandplanner.ui.theme.DeepNavyBlue
import com.example.fitnesstrackerandplanner.ui.theme.SurfaceGreen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext


@Composable
fun Goals(navController: NavHostController, exList: List<Exercise>) {
    val hour by lazy { Calendar.getInstance().get(Calendar.HOUR_OF_DAY) }
    val context = LocalContext.current
    val sharedPrefManager = SharedPrefManager(context)
    val userName = sharedPrefManager.getCurrentUsername()
    val isDayTime: Boolean = hour in 6..18
    val greeting: String = if (isDayTime) "Good Morning, $userName!" else "Good Evening, $userName!"
    val icon = if (isDayTime) painterResource(id = R.drawable.icons8_sunny_48)
    else painterResource(id = R.drawable.icons8_moon_48)

    val firebaseHelper = FirebaseHelper()

    // State to hold the final list of exercises
    var finalList by remember { mutableStateOf(exList.toMutableList()) }

    // Fetch data if exList is empty
    if (exList.isEmpty()) {

        LaunchedEffect(Unit) {
            val fetchedExercises = withContext(Dispatchers.IO) {
                firebaseHelper.initializeExercises()
            }
            finalList = fetchedExercises.toMutableList()
        }
    } else {
        finalList = exList.toMutableList()
    }

    Surface(color = DeepNavyBlue, modifier = Modifier.fillMaxSize()) {
        ExerciseRecyclerView(
            finalList,
            greetingMessage = greeting,
            icon = icon,
            subTitle = "Exercise Type",
            shape = RoundedCornerShape(15.dp),
            color = CharcoalGray,
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = listOf(Color.Magenta, Color.Cyan)
                )
            ),
            navController = navController
        )
    }
}








