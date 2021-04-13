package com.navat.harborland.memberservice.repository.implementation

import com.navat.harborland.memberservice.domain.entity.Company
import com.navat.harborland.memberservice.domain.entity.CompanyRegistration
import com.navat.harborland.memberservice.repository.MemberDatabase
import com.navat.harborland.memberservice.repository.model.MongoCompany
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Primary
import java.util.*
import javax.inject.Named

//@Primary
@Named
class MemberMongoDatabase(private val companyRepository: MongoCompanyRepository): MemberDatabase {

    var log: Logger = LoggerFactory.getLogger(MemberMongoDatabase::class.java)

    override fun findAllCompany(): List<Company> {
        return companyRepository.findAll().map {
            Company(
                id = it.id.toString(),
                name = it.name,
                link = it.link,
                missionStatement = it.missionStatement,
                logo = it.logo,
                registration = CompanyRegistration(
                    status = it.registration.status!!,
                    date = it.registration.date!!
                )
            )
        }
    }

    override fun insertCompany(company: Company) {
        val mongoCompany = MongoCompany()
        mongoCompany.id = UUID.fromString(company.id)
        mongoCompany.name = company.name
        mongoCompany.link = company.link
        mongoCompany.missionStatement = company.missionStatement
        mongoCompany.logo = company.logo
        mongoCompany.registration.date = company.registration!!.date
        mongoCompany.registration.status = company.registration!!.status

        companyRepository.save(mongoCompany)
    }
}