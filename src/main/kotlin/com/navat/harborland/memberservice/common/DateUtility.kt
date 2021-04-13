package com.navat.harborland.memberservice.common

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DateUtility {
    companion object {
        fun getStringFromDateTime(date: LocalDateTime, format: String? = "yyyy-MM-dd HH:mm:ss"): String {
            val formatter = DateTimeFormatter.ofPattern(format)
            return date.format(formatter)
        }

        @Suppress("UNUSED")
        fun getDateTimeFromString(date: String, format: String? = "yyyy-MM-dd"): LocalDateTime {
            val formatter = DateTimeFormatter.ofPattern(format)
            return LocalDateTime.parse(date, formatter)
        }
    }
}