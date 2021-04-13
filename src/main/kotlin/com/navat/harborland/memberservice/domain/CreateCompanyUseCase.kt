package com.navat.harborland.memberservice.domain

import com.navat.harborland.memberservice.domain.entity.Company

interface CreateCompanyUseCase {
    fun execute(request: Company): Company
}