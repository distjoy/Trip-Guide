import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tunieapps.tripguide.DMSansFamily
import com.tunieapps.tripguide.R

@Composable
fun LandingScreen(){

    // Row
        // Image - Banner
        // Page Title
        // Page Body
        // Page Button, Login
        // Page Button, Sign up

    Column {
        Image(bitmap = ImageBitmap.Companion.imageResource(id = R.mipmap.onboarding_banner), contentDescription = "Discover places banner",
            Modifier.fillMaxWidth().height(400.dp))
        Text(text = "Discover best places to go to vacation \uD83D\uDE0D",
            fontSize = 30.sp,
            lineHeight = 35.sp,
            color = Color(0xFF101018),
            fontFamily = DMSansFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(PaddingValues(horizontal = 20.dp, vertical = 10.dp)))
        Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vitae sapien viverra laoreet fusce cras nibh. ",
              fontSize = 14.sp,
            fontFamily = DMSansFamily,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            color = Color(0xFF828F9C),
            modifier = Modifier.fillMaxWidth().padding(PaddingValues(horizontal = 20.dp, vertical = 0.dp))
        )
        Button(onClick = { /*TODO*/ },
            Modifier.fillMaxWidth().padding(PaddingValues(horizontal = 20.dp, vertical = 10.dp))) {
            Text("Login")
        }
        OutlinedButton(onClick = { /*TODO*/ },
            Modifier.fillMaxWidth().padding(PaddingValues(horizontal = 20.dp, vertical = 0.dp)) ) {
            Text("Sign Up")
        }
    }

}