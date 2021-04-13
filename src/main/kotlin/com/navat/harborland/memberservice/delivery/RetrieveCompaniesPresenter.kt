package com.navat.harborland.memberservice.delivery

import com.navat.harborland.memberservice.delivery.model.RetrieveCompanyResponse

interface RetrieveCompaniesPresenter {
    fun present(): List<RetrieveCompanyResponse>
}