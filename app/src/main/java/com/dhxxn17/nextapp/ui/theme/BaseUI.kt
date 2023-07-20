package com.dhxxn17.nextapp.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BaseButton(
    onClick: () -> Unit,
    buttonTitle: String,
    modifier: Modifier
) {
    Box(
        modifier = modifier.padding(20.dp)
            .fillMaxWidth()
            .background(MainBlue, shape = RoundedCornerShape(10.dp))
            .clickable {
                onClick.invoke()
            }
            .padding(15.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = buttonTitle,
            fontSize = 17.sp,
            color = Color.White
        )
    }
}