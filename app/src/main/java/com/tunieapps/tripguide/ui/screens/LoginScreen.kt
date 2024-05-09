import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tunieapps.tripguide.DMSansFamily
import com.tunieapps.tripguide.R
import com.tunieapps.tripguide.ui.theme.TripGuideTheme

@Composable
fun LoginScreen() {


    Column(modifier = Modifier.padding(15.dp)) {

        Text(
            text = "Login",
            fontSize = 30.sp,
            lineHeight = 35.sp,
            color = Color(0xFF101018),
            fontFamily = DMSansFamily,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Left,
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(vertical = 10.dp))
        )
        Text(
            "Welcome! Please enter your Name, email and password to create your account.",
            fontSize = 14.sp,
            fontFamily = DMSansFamily,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Left,
            color = Color(0xFF828F9C),
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(vertical = 0.dp))
        )

        OutlinedTextField(
            value = "Email Address",
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(vertical = 10.dp)),
            textStyle = TextStyle(
                fontSize = 15.sp,
                fontFamily = DMSansFamily,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Left,
                color = Color(0xFF828F9C),
            ), onValueChange = {

            },
            shape = RoundedCornerShape(CornerSize(30.dp)),
            colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = Color(0xFFE7E7EF))
        )

        OutlinedTextField(
            value = "Your Password",
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(vertical = 10.dp)),
            textStyle = TextStyle(
                fontSize = 15.sp,
                fontFamily = DMSansFamily,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Left,
                color = Color(0xFF828F9C),
            ), onValueChange = {

            },
            shape = RoundedCornerShape(CornerSize(30.dp)),
            colors = OutlinedTextFieldDefaults.colors(unfocusedBorderColor = Color(0xFFE7E7EF))
        )



        Button(
            onClick = { /*TODO*/ },
            Modifier
                .fillMaxWidth()
                .padding(PaddingValues(vertical = 10.dp)),
            colors = ButtonDefaults.buttonColors(
                Color(0xFFDE7254),
                Color(0xFFFFFFFF),
                Color(0xC9DE7254),
                Color(0xC9FFFFFF),
            )
        ) {

            Text(
                "Login", fontSize = 16.sp,
                fontFamily = DMSansFamily,
                fontWeight = FontWeight.Bold
            )
        }

        OutlinedButton(onClick = { /*TODO*/ },
            Modifier.padding(top = 10.dp)
                .fillMaxWidth()
                ,
            border = BorderStroke(1.dp,Color(0xFFE7E7EF)),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xff000000))
        ) {
            Image(painter = painterResource(id = R.drawable.flat_color_icons_google), contentDescription = "google logo",
                modifier = Modifier.align(Alignment.CenterVertically).padding(vertical = 5.dp)
            )
            Text(
                "Login with google", fontSize = 16.sp,
                fontFamily = DMSansFamily,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
                    .padding(start = 10.dp )
            )
        }
    }

}

@Composable
@Preview(showBackground = true)
fun LoginPreview() {
    TripGuideTheme {
        LoginScreen()
    }
}