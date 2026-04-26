package com.example.expensetracker.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.expensetracker.ui.theme.zinc

@Composable
fun CardItem(
    modifier: Modifier,
    isBalanceVisible: Boolean,
    onToggleVisibility: () -> Unit
) {
    Box (
        modifier = modifier  // USE THE PASSED MODIFIER HERE
            .clip(RoundedCornerShape(16.dp))
            .height(200.dp)
            .background(zinc)
            .padding(16.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Total Balance",
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = if (isBalanceVisible) "$100" else "••••••",
                        fontSize = 24.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )


                }
                IconButton(onClick = onToggleVisibility) {
                    Icon(
                        imageVector = if (isBalanceVisible)
                            Icons.Default.Visibility
                        else
                            Icons.Default.VisibilityOff,
                        contentDescription = "Toggle balance visibility",
                        tint = Color.White,
                        modifier = Modifier.size(32.dp)
                    )
                }

            }

            Spacer(modifier = Modifier.height(60.dp))

            Box(
                modifier = Modifier.fillMaxWidth(),
            ) {
              CardRowItem(
                    modifier = Modifier.align(Alignment.CenterStart),
                    title = "Income",
                    amount = "    $ 1349",
                  icon = Icons.Default.ArrowDownward
                )

                CardRowItem(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    title = "Expense",
                    amount = "    $ 1349",
                    icon = Icons.Default.ArrowUpward
                )

            }

        }
    }
}