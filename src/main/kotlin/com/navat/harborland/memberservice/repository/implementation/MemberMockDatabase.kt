package com.navat.harborland.memberservice.repository.implementation

import com.navat.harborland.memberservice.domain.entity.Company
import com.navat.harborland.memberservice.repository.MemberDatabase
import org.springframework.context.annotation.Primary
import javax.inject.Named

@Primary
@Named
class MemberMockDatabase: MemberDatabase {
    private val dataStore: MutableMap<String, Company> = mutableMapOf()

    override fun findAllCompany(): List<Company> = dataStore.values.toList()

    override fun insertCompany(company: Company) {
        dataStore[company.id!!] = company
    }
}