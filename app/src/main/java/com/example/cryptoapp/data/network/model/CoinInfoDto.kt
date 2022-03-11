package com.example.cryptoapp.data.network.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "full_price_list")
data class CoinInfoDto(
    @SerializedName("TYPE")
    val type: String?,
    @SerializedName("MARKET")
    val market: String?,
    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    val fromSymbol: String,
    @SerializedName("TOSYMBOL")
    val toSymbol: String?,
    @SerializedName("FLAGS")
    val flags: String?,
    @SerializedName("PRICE")
    val price: String?,
    @SerializedName("LASTUPDATE")
    val lastUpdate: Long?,
    @SerializedName("LASTVOLUME")
    val lastVolume: String?,
    @SerializedName("LASTVOLUMETO")
    val lastVolumeTo: String?,
    @SerializedName("LASTTRADEID")
    val lastTradeId: String?,
    @SerializedName("VOLUMEDAY")
    val volumeDay: String?,
    @SerializedName("VOLUMEDAYTO")
    val volumeDayTo: String?,
    @SerializedName("VOLUME24HOUR")
    val volume24Hour: String?,
    @SerializedName("VOLUME24HOURTO")
    val volume24HourTo: String?,
    @SerializedName("OPENDAY")
    val openDay: String?,
    @SerializedName("HIGHDAY")
    val highDay: String?,
    @SerializedName("LOWDAY")
    val lowDay: String?,
    @SerializedName("OPEN24HOUR")
    val open24Hour: String?,
    @SerializedName("HIGH24HOUR")
    val high24Hour: String?,
    @SerializedName("LOW24HOUR")
    val low24Hour: String?,
    @SerializedName("LASTMARKET")
    val lastMarket: String?,
    @SerializedName("VOLUMEHOUR")
    val volumeHour: String?,
    @SerializedName("VOLUMEHOURTO")
    val volumeHourTo: String?,
    @SerializedName("OPENHOUR")
    val openHour: String?,
    @SerializedName("HIGHHOUR")
    val highHour: String?,
    @SerializedName("LOWHOUR")
    val lowHour: String?,
    @SerializedName("TOPTIERVOLUME24HOUR")
    val topTierVolume24Hour: String?,
    @SerializedName("TOPTIERVOLUME24HOURTO")
    val topTierVolume24HourTo: String?,
    @SerializedName("CHANGE24HOUR")
    val change24Hour: String?,
    @SerializedName("CHANGEPCT24HOUR")
    val changePCT24Hour: String?,
    @SerializedName("CHANGEDAY")
    val changeDay: String?,
    @SerializedName("CHANGEPCTDAY")
    val changePCTDay: String?,
    @SerializedName("SUPPLY")
    val supply: String?,
    @SerializedName("MKTCAP")
    val mktCap: String?,
    @SerializedName("TOTALVOLUME24H")
    val totalVolume24Hour: String?,
    @SerializedName("TOTALVOLUME24HTO")
    val totalVolume24HourTo: String?,
    @SerializedName("TOTALTOPTIERVOLUME24H")
    val totalTopTierVolume24Hour: String?,
    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    val totalTopTierVolume24HourTo: String?,
    @SerializedName("IMAGEURL")
    val imageUrl: String?
)