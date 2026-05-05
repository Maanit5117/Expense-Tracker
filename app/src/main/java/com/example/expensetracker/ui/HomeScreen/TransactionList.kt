package com.example.expensetracker.ui.HomeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetracker.Data.Model.ExpenseEntity
import com.example.expensetracker.R
import com.example.expensetracker.ui.AddNewExpense.utlis
import com.example.expensetracker.viewModel.HomeViewModel

@Composable
fun TransactionList(modifier : Modifier, list: List<ExpenseEntity>, isBalanceVisible: Boolean, title : String = "Recent Transactions", ) {
    LazyColumn(modifier = modifier.padding(16.dp)) {
        item {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = title,
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold
                )

                if (title == "Recent Transactions") {
                    Text(
                        text = "See All",
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.align(Alignment.CenterEnd)
                    )
                }
            }
        }

        items(list) { expense ->
            TransactionItem(
                Title = expense.title,
                amount = expense.amount.toString(),
                icon = utlis.getItemIcon(expense),
                date = utlis.formatDateToHumanReadableForm(expense.date),
                color = if (expense.type == "Income") Color.Green else Color.Red,
                isBalanceVisible = isBalanceVisible
            )
        }




     }
}