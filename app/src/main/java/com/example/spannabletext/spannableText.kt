package com.example.spannabletext

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SpannableTextLayout() {
    val context = LocalContext.current


    val text1= buildAnnotatedString {
        withStyle(style = SpanStyle(
            color = Color.Red,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )){
             append("H")
        }
       append("ello")
    }

    val text2 = buildAnnotatedString {
        append("Please Accept the ")
        pushStringAnnotation("terms", "terms")
        pushStyle(
            style = SpanStyle(
                color = Color.Red,
                textDecoration = TextDecoration.Underline
            )
        )
        /*pushStyle(ParagraphStyle(

        ))*/
        append("Terms")
        pop()

/*
        withStyle(style = SpanStyle(color = Color.Red,
        textDecoration = TextDecoration.Underline)){
            append("Terms")
        }*/

        append(" and ")

        pushStringAnnotation("privacy", "privacy")
        pushStyle(
            style = SpanStyle(
                color = Color.Red,
                textDecoration = TextDecoration.Underline
            )
        )
        append("Privacy policy")
        pop()


       /* withStyle(style = SpanStyle(color = Color.Red,
            textDecoration = TextDecoration.Underline)){
            append("Privacy Policy")
        }*/

    }

    Column(modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center)
    {
        Text(text = text1)
        Spacer(modifier = Modifier.height(20.dp))
        ClickableText(text = text2, onClick = {offset->
            text2.getStringAnnotations("terms",offset,offset).firstOrNull()?.let {
                it.item
                Toast.makeText(context,"Clicked on Terms", Toast.LENGTH_SHORT).show()

            }
            text2.getStringAnnotations("privacy",offset,offset).firstOrNull()?.let {
                it.item
                Toast.makeText(context,"Clicked on Privacy Policy", Toast.LENGTH_SHORT).show()

            }

        } )
    }

}