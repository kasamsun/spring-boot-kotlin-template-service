package com.navat.harborland.memberservice.repository.model

import com.navat.harborland.memberservice.domain.entity.RegistrationStatus

class MongoCompanyRegistration {
    var status: RegistrationStatus? = null
    var date: String? = null
}