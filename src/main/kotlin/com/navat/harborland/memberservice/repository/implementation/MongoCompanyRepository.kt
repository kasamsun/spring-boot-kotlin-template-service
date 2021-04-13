package com.navat.harborland.memberservice.repository.implementation

import com.navat.harborland.memberservice.repository.model.MongoCompany
import org.springframework.data.mongodb.repository.MongoRepository

interface MongoCompanyRepository: MongoRepository<MongoCompany, String> {
}