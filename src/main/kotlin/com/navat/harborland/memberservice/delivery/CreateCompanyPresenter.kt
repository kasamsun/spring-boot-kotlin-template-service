package com.navat.harborland.memberservice.delivery

import com.navat.harborland.memberservice.delivery.model.CreateCompanyRequest
import com.navat.harborland.memberservice.delivery.model.CreateCompanyResponse

interface CreateCompanyPresenter {
    fun present(companyRequest: CreateCompanyRequest): CreateCompanyResponse
}
