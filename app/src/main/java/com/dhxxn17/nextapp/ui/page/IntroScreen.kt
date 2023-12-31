package com.dhxxn17.nextapp.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dhxxn17.nextapp.ui.navigation.Screens
import com.dhxxn17.nextapp.ui.theme.BaseButton
import com.dhxxn17.nextapp.ui.theme.MainGray

@Composable
fun IntroScreen(
    navController: NavController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = "반가워요\n주문을 시작할게요",
            fontSize = 27.sp,
            color = MainGray,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 50.dp, start = 20.dp),
            lineHeight = 33.sp
        )

        BaseButton(
            onClick = {
                navController.navigate(
                    Screens.ListScreen.route
                )
            },
            buttonTitle = "다음",
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}