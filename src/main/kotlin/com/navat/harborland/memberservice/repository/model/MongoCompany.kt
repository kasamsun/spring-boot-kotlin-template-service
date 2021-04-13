package com.navat.harborland.memberservice.repository.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "company")
class MongoCompany {
    @Id
    var id: UUID? = null
    var name: String? = null
    var link: String? = null
    var missionStatement: String? = null
    var logo: String? = null
    var registration: MongoCompanyRegistration = MongoCompanyRegistration()
}