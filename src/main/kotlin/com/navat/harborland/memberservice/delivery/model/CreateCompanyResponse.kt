package com.navat.harborland.memberservice.delivery.model

import com.navat.harborland.memberservice.domain.entity.CompanyRegistration
import java.util.*

class CreateCompanyResponse {
    var id: UUID? = null
    var name: String? = null
    var link: String? = null
    var missionStatement: String? = null
    var logo: String? = null
    var registration: CompanyRegistration? = null
}