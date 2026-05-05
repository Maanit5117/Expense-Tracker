package com.example.expensetracker.Data.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.expensetracker.Data.Model.ExpenseEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ExpenseDao {

    @Query("SELECT * FROM expenses_table")
    fun getAllExpenses(): Flow<List<ExpenseEntity>>

    @Query("SELECT * FROM expenses_table WHERE type= 'Expense' ORDER BY amount DESC LIMIT 5")
    fun getTopExpenses(): Flow<List<ExpenseEntity>>

    @Query("SELECT type, date , SUM(amount) AS total_amount FROM expenses_table where type = :type GROUP BY type, date ORDER BY date ")
    fun getExpensesByDate(type: String = "Expense"): Flow<List<ExpenseByDate>>

    @Insert
    suspend fun insertExpense(expense: ExpenseEntity)

    @Delete
    suspend fun deleteExpense(expense: ExpenseEntity)

    @Update
    suspend fun updateExpense(expense: ExpenseEntity)

}