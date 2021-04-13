package com.navat.harborland.memberservice.domain.implementation

import com.navat.harborland.memberservice.common.DateUtility
import com.navat.harborland.memberservice.domain.CreateCompanyUseCase
import com.navat.harborland.memberservice.domain.entity.Company
import com.navat.harborland.memberservice.domain.entity.CompanyRegistration
import com.navat.harborland.memberservice.domain.entity.RegistrationStatus
import com.navat.harborland.memberservice.repository.MemberDatabase
import java.time.LocalDateTime
import java.util.*
import javax.inject.Named

@Named
class CreateCompanyImpl(private val memberDatabase: MemberDatabase): CreateCompanyUseCase {
    //Do usecase specific logic
    override fun execute(request: Company): Company {
        val registrationDateString = DateUtility.getStringFromDateTime(LocalDateTime.now())
        request.id = UUID.randomUUID().toString()
        request.registration = CompanyRegistration(registrationDateString, RegistrationStatus.ACCEPTED)

        //persist
        memberDatabase.insertCompany(request)

        return request
    }
}