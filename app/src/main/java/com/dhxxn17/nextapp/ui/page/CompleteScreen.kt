package com.dhxxn17.nextapp.ui.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dhxxn17.nextapp.R
import com.dhxxn17.nextapp.data.ICE_AMOUNT
import com.dhxxn17.nextapp.data.IS_DECAFFEIN
import com.dhxxn17.nextapp.data.IS_HOT
import com.dhxxn17.nextapp.data.MenuData
import com.dhxxn17.nextapp.ui.navigation.Screens
import com.dhxxn17.nextapp.ui.theme.BaseButton
import com.dhxxn17.nextapp.ui.theme.MainGray
import com.dhxxn17.nextapp.util.transPriceFormat

@Composable
fun CompleteScreen(
    navController: NavController,
    menu: MenuData
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(horizontal = 10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "뒤로가기 버튼",
                modifier = Modifier
                    .padding(top = 20.dp, start = 10.dp)
                    .size(20.dp)
                    .clickable {
                        navController.popBackStack()
                    }
            )

            Text(
                text = "주문 완료!",
                fontSize = 25.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp, top = 20.dp)
            )

            Row(
                modifier = Modifier.padding(top = 30.dp, start = 10.dp)
            ) {
                Column(

                ) {
                    Text(
                        text = menu.name,
                        fontWeight = FontWeight.Bold,
                        color = MainGray,
                        fontSize = 18.sp
                    )

                    Text(
                        text = (if (menu.isHot != IS_HOT.CANT_CHOOSE && menu.isHot != IS_HOT.NONE) "${menu.isHot.name}/" else "") +
                                (if(menu.isDecaffein != IS_DECAFFEIN.CANT_CHOOSE && menu.isDecaffein != IS_DECAFFEIN.NONE) menu.isDecaffein.title else "") +
                                if (menu.iceAmount != ICE_AMOUNT.CANT_CHOOSE && menu.iceAmount != ICE_AMOUNT.NONE) "/얼음(${menu.iceAmount.title})" else "",
                        fontSize = 16.sp,
                        color = MainGray,
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }

                Text(
                    text = transPriceFormat(menu.price),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = MainGray,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                )
            }
        }

        BaseButton(
            onClick = {
                navController.navigate(
                    Screens.IntroScreen.route
                ) {
                    popUpTo(navController.graph.id) {
                        inclusive = true
                    }
                }
            },
            buttonTitle = "닫기",
            modifier = Modifier.align(Alignment.BottomCenter)
        )
    }
}