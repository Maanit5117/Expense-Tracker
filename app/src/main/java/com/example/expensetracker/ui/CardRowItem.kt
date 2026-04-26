package com.example.expensetracker.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable

fun CardRowItem(title: String, amount: String, modifier: Modifier,icon: ImageVector){
    Column(modifier= modifier) {
        Row {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = Color.White
            )

            Spacer(modifier = Modifier.size(4.dp))

            Text(text = title, fontSize = 22.sp, color = Color.White, fontWeight = FontWeight.SemiBold)

        }
        Spacer(modifier = Modifier.size(4.dp))
        Text(text = amount, fontSize = 20.sp, color = Color.White)
    }
}