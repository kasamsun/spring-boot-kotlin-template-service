package com.navat.harborland.memberservice.repository

import com.navat.harborland.memberservice.domain.entity.Company

interface MemberDatabase {
    fun insertCompany(company: Company)
    fun findAllCompany(): List<Company>
}