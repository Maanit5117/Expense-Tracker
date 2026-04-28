package com.example.expensetracker.Data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.expensetracker.Data.Dao.ExpenseDao
import com.example.expensetracker.Data.Model.ExpenseEntity

@Database(entities = [ExpenseEntity::class], version = 1)
abstract class ExpenseDataBase : RoomDatabase(){

    abstract fun expenseDao() : ExpenseDao

    companion object{
        const val DATABASE_NAME = "expense_db"

        @JvmStatic
        fun getDatabase(context: Context): ExpenseDataBase {
            return Room.databaseBuilder(
                context.applicationContext,
                ExpenseDataBase::class.java,
                DATABASE_NAME
            ).build()
        }
    }

}