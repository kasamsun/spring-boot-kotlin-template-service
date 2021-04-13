package com.navat.harborland.memberservice.domain.implementation

import com.navat.harborland.memberservice.domain.RetrieveActiveCompaniesUseCase
import com.navat.harborland.memberservice.repository.MemberDatabase
import javax.inject.Named

@Named
class RetrieveActiveCompaniesImpl(private val memberDatabase: MemberDatabase): RetrieveActiveCompaniesUseCase {
    //Do use case specific logic
    override fun execute(): List<Any> {
        //query
        return memberDatabase.findAllCompany()
    }
}