package uz.umarxon.superscriptsubscripttextjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.umarxon.superscriptsubscripttextjetpackcompose.ui.theme.SuperScriptSubscriptTextJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperScriptSubscriptTextJetpackComposeTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.primaryVariant)
                ) {
                    Text(
                        text = "Super And Sub Script Text",
                        fontSize = 25.sp,
                        fontStyle = FontStyle.Italic,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colors.primary)
                            .padding(20.dp),
                        color = Color.White
                    )
                    SuperScriptText(
                        normalText = "This is a superscript:  X",
                        normalText2 = "This is a subscript:  X",
                        superText = "Super",
                        subText = "Sub"
                    )
                }
            }
        }
    }
}

@Composable
fun SuperScriptText(
    normalText: String,
    normalText2: String,
    superText: String,
    subText: String,
    normalFontSize: TextUnit = 20.sp,
    superTextFontSize: TextUnit = 20.sp,
    subTextFontSize: TextUnit = 20.sp,
    superTextFontWeight: FontWeight = FontWeight.Normal,
    subTextFontWeight: FontWeight = FontWeight.Normal
) {

    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = normalFontSize
                )
            ) {
                append(normalText)
            }
            withStyle(
                style = SpanStyle(
                    fontSize = superTextFontSize,
                    fontWeight = superTextFontWeight,
                    baselineShift = BaselineShift.Superscript
                )
            ) {
                append(superText)
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        color = Color.White
    )

    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = normalFontSize
                )
            ) {
                append("\n" + normalText2)
            }
            withStyle(
                style = SpanStyle(
                    fontSize = subTextFontSize,
                    fontWeight = subTextFontWeight,
                    baselineShift = BaselineShift.Subscript
                )
            ) {
                append(subText)
            }

        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        color = Color.White
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperScriptSubscriptTextJetpackComposeTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.primaryVariant)
        ) {
            Text(
                text = "Super And Sub Script Text",
                fontSize = 25.sp,
                fontStyle = FontStyle.Italic,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colors.primary)
                    .padding(20.dp),
                color = Color.White
            )
            SuperScriptText(
                normalText = "This is a superscript:  X",
                normalText2 = "This is a subscript:  X",
                superText = "Super",
                subText = "Sub"
            )
        }
    }
}