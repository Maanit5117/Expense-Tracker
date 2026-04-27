package com.example.expensetracker.ui.HomeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetracker.R

@Composable
fun TransactionList(modifier : Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Recent Transactions",
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = "See All",
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.align(Alignment.CenterEnd)
            )
        }

        TransactionItem(
            Title = "Groceries",
            amount = "$200.00",
            date = "Today",
            color = Color.Red,
            icon = R.drawable.groceries
        )

        TransactionItem(
            Title = "Subscriptions",
            amount = "$50.00",
            date = "Today",
            color = Color.Red,
            icon = R.drawable.subscriptions
        )

        TransactionItem(
            Title = "Part time job",
            amount = "$100.00",
            date = "Today",
            color = Color.Green,
            icon = R.drawable.job
        )

    }
}