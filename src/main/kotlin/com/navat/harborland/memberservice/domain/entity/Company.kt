package com.navat.harborland.memberservice.domain.entity

data class Company(
    var id: String?,
    var name: String?,
    var link: String?,
    var missionStatement: String?,
    var logo: String?,
    var registration: CompanyRegistration?
)