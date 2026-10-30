package com.sakume.personalfinance.data

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "accounts")
data class AccountEntity(
    @PrimaryKey val id: String,
    val name: String,
    val type: String = "Cash",
    val balance: Long = 0,
    /** Saldo awal yang menjadi titik dasar perhitungan ulang. */
    val openingBalance: Long = 0,
    val sortOrder: Int = 0
)

@Serializable
@Entity(
    tableName = "transactions",
    indices = [Index("accountId"), Index("transferGroupId"), Index("investmentAssetId")]
)
data class TransactionEntity(
    @PrimaryKey val id: String,
    val type: String,
    val amount: Long,
    val category: String,
    val accountId: String,
    val dateMillis: Long,
    val note: String = "",
    val investmentAssetId: String? = null,
    val transferGroupId: String? = null
)

@Serializable
@Entity(tableName = "bills")
data class BillEntity(
    @PrimaryKey val id: String,
    val provider: String,
    val itemName: String,
    val amount: Long,
    val dueDateMillis: Long,
    val tenorMonths: Int = 1,
    val installmentIndex: Int = 1,
    val isPaid: Boolean = false,
    val paidAccountId: String? = null,
    val parentBillId: String? = null,
    val paidAtMillis: Long? = null,
    /** Transaksi expense yang dibuat saat bayar (untuk unpay yang akurat). */
    val paymentTransactionId: String? = null
)

@Serializable
@Entity(tableName = "investments")
data class InvestmentEntity(
    @PrimaryKey val id: String,
    val name: String,
    val target: Long? = null,
    val value: Long = 0,
    val archived: Boolean = false
)

@Serializable
@Entity(
    tableName = "investment_contributions",
    indices = [Index("assetId"), Index("accountId"), Index("transactionId")]
)
data class InvestmentContributionEntity(
    @PrimaryKey val id: String,
    val assetId: String,
    val accountId: String,
    val amount: Long,
    val transactionId: String,
    val createdAtMillis: Long
)

@Serializable
@Entity(tableName = "debts")
data class DebtEntity(
    @PrimaryKey val id: String,
    val type: String,
    val person: String,
    val description: String,
    val amount: Long,
    val isPaid: Boolean = false,
    val createdAtMillis: Long,
    val paidAtMillis: Long? = null,
    /** Rekening yang dipakai saat menandai lunas (untuk update saldo). */
    val paidAccountId: String? = null,
    /** Transaksi yang dibuat saat mark paid — untuk reverse yang akurat. */
    val paymentTransactionId: String? = null
)

@Serializable
@Entity(
    tableName = "scheduled_investments",
    indices = [Index("assetId"), Index("accountId")]
)
data class ScheduledInvestmentEntity(
    @PrimaryKey val id: String,
    val assetId: String,
    val accountId: String,
    val amount: Long,
    /** Calendar.DAY_OF_WEEK: 1=Minggu … 7=Sabtu */
    val dayOfWeek: Int,
    val enabled: Boolean = true,
    val lastRunMillis: Long? = null,
    val createdAtMillis: Long = 0
)

@Serializable
@Entity(
    tableName = "salary_schedules",
    indices = [Index("accountId")]
)
data class SalaryScheduleEntity(
    @PrimaryKey val id: String,
    val accountId: String,
    val amount: Long,
    /** daily | biweekly | monthly */
    val frequency: String,
    val enabled: Boolean = true,
    val lastRunMillis: Long? = null,
    val note: String = "Gaji",
    val createdAtMillis: Long = 0,
    /** Jam masuk gaji 0–23 */
    val hourOfDay: Int = 9
)
